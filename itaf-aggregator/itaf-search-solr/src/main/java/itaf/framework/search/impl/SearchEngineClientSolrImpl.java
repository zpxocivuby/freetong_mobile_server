/**
 * 
 */
package itaf.framework.search.impl;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.util.DateHelper;
import itaf.framework.exception.bean.AppException;
import itaf.framework.search.SearchEngineClient;
import itaf.framework.search.bean.SearchEngineObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.stereotype.Service;

/**
 * @author zhangkd
 * 
 */
@Service("searchEngineClientSolrImpl")
public class SearchEngineClientSolrImpl implements SearchEngineClient {

	private static final String[] SOLR_KEYWORDS = { "\\\\", "\\+", "-", "&",
			"\\|", "!", "\\(", "\\)", "\\{", "\\}", "\\[", "\\]", "\\^", "\"",
			"~", ":" };

	/** log instance. */
	protected final Log log = LogFactory.getLog(getClass());

	private HttpSolrServer httpSolrServer;
	private String seServerBaseUrl = "http://192.168.0.203:18080/solr";

	public static String filterSolrKeywords(String valueString) {
		if (valueString == null) {
			return "*";
		}
		for (String keyword : SOLR_KEYWORDS) {
			valueString = valueString.replaceAll(keyword, "\\\\" + keyword);
		}
		return valueString;
	}

	private HttpSolrServer getHttpSolrServer() throws MalformedURLException {
		/*
		 * HttpSolrServer is thread-safe and if you are using the following
		 * constructor, you *MUST* re-use the same instance for all requests. If
		 * instances are created on the fly, it can cause a connection leak. The
		 * recommended practice is to keep a static instance of HttpSolrServer
		 * per solr server url and share it for all requests. See
		 * https://issues.apache.org/jira/browse/SOLR-861 for more details
		 */
		if (httpSolrServer == null) {

			httpSolrServer = new HttpSolrServer(seServerBaseUrl);

			httpSolrServer.setSoTimeout(1000 * 60 * 2); // socket read timeout
			httpSolrServer.setConnectionTimeout(1000 * 5);
			httpSolrServer.setDefaultMaxConnectionsPerHost(1000);
			httpSolrServer.setMaxTotalConnections(1000);
			httpSolrServer.setFollowRedirects(false); // defaults to false
			// allowCompression defaults to false.
			// Server side must support gzip or deflate for this to have any
			// effect.
			httpSolrServer.setAllowCompression(true);
			httpSolrServer.setMaxRetries(1); // defaults to 0. > 1 not
												// recommended.
			httpSolrServer.setParser(new XMLResponseParser()); // binary parser
																// is used by
																// default
		}

		return httpSolrServer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#classifyQuery(java.lang .String,
	 * java.lang.String, int, int)
	 */
	public PageResult<SearchEngineObject> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("query", classifyTagName + ":"
				+ filterSolrKeywords(classifyTagValue));
		queryMap.put("sort", "CRAWL_TIME desc");
		return fuzzyQuery(queryMap, start, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#classifyQuery(java.lang .String,
	 * java.lang.String, int, int, java.lang.String, java.lang.String)
	 */
	public PageResult<SearchEngineObject> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count, String userIds,
			String roleIds) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("query", classifyTagName + ":"
				+ filterSolrKeywords(classifyTagValue));
		queryMap.put("sort", "CRAWL_TIME desc");
		return fuzzyQuery(queryMap, start, count, userIds, roleIds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#fuzzyQuery(java.util .Map, int, int)
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(
			Map<String, Object> queryMap, int start, int count) {
		return fuzzyQuery(queryMap, start, count, 1, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#fuzzyQuery(java.util .Map, int, int,
	 * java.lang.String, java.lang.String)
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(
			Map<String, Object> queryMap, int start, int count, String userIds,
			String roleIds) {
		return fuzzyQuery(queryMap, start, count, 0, userIds, roleIds);
	}

	private PageResult<SearchEngineObject> fuzzyQuery(
			Map<String, Object> queryMap, int start, int count, int authType,
			String userIds, String roleIds) {
		String queryString = (String) queryMap.get("query");
		String sortString = (String) queryMap.get("sort");
		if (queryString == null || queryString.trim().length() == 0) {
			queryString = "*:*";
		}
		log.debug("fuzzyQuery queryString:" + queryString + ", sortString:"
				+ sortString + ", start:" + start + ", count:" + count);
		PageResult<SearchEngineObject> pageResult = new PageResult<SearchEngineObject>();
		pageResult.setCurrentIndex(start);
		pageResult.setPageSize(count);
		HttpSolrServer server;
		try {
			server = this.getHttpSolrServer();

			ModifiableSolrParams params = new ModifiableSolrParams();
			// params.set("qt", "/spellCheckCompRH");
			params.set("q", queryString);
			// outline
			String fl = "ID,TITLE,CRAWL_TIME,SOURCE,RELEASE_TIME,FIRST_NUM,PRIMARY,REPRINT_NUM,SUMMARY,score";
			// detail
			if (queryMap.get("fl") != null) {
				fl = "*,score";
			}
			params.set("fl", fl);
			params.set("sort", sortString);
			params.set("start", start);
			params.set("rows", count);

			// params.set("spellcheck", "on");
			// params.set("spellcheck.build", "true");

			// SolrQuery query = new SolrQuery();
			// query.setHighlight(true);
			// query.addHighlightField("TEXT");
			// query.addHighlightField("TITLE");
			// query.setHighlightSimplePre("<font color=\"#FF0000\">");
			// query.setHighlightSimplePost("</font>");
			// params.add(query);

			QueryResponse response = null;
			try {
				response = server.query(params);
				log.debug(response);
				pageResult.setQueryTime(response.getQTime());
				SolrDocumentList solrDocumentList = response.getResults();
				if (solrDocumentList == null || solrDocumentList.size() == 0)
					return pageResult;
				pageResult.setTotalCount((int) solrDocumentList.getNumFound());
				pageResult
						.setTotalPage(((pageResult.getTotalCount() + count) - 1)
								/ count);
				pageResult.setCurrentPage((start + count) / count);
				Map<String, Map<String, List<String>>> responseHighlighting = response
						.getHighlighting();
				for (int i = 0; i < solrDocumentList.size(); i++) {
					SolrDocument solrDocument = solrDocumentList.get(i);
					SearchEngineObject searchEngineObject = new SearchEngineObject();
					Collection<String> fieldNames = solrDocument
							.getFieldNames();
					for (String fileName : fieldNames) {
						searchEngineObject.addField(fileName,
								solrDocument.getFieldValue(fileName));
					}
					Object solrDocumentId = solrDocument.get("ID");
					if (responseHighlighting != null
							&& responseHighlighting.containsKey(solrDocumentId)) {
						Map<String, List<String>> solrDocumentHighlighting = responseHighlighting
								.get(solrDocumentId);
						for (Iterator<String> iter = solrDocumentHighlighting
								.keySet().iterator(); iter.hasNext();) {
							String key = iter.next();
							searchEngineObject.setField(key,
									solrDocumentHighlighting.get(key));
						}
					}
					pageResult.getContent().add(searchEngineObject);
				}
			} catch (SolrServerException e) {
				log.error("查询数据, 传输数据时发生异常!", e);
				throw new AppException("查询数据, 传输数据时发生异常!");
			}
		} catch (MalformedURLException e) {
			log.error("查询数据, 传输数据时发生异常!", e);
			throw new AppException("查询数据, 传输数据时发生异常!");
		}
		return pageResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#fuzzyQuery(java.lang .String, int, int)
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(String queryString,
			int start, int count) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("query", filterSolrKeywords(queryString));
		return fuzzyQuery(queryMap, start, count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#fuzzyQuery(java.lang .String, int, int,
	 * java.lang.String, java.lang.String)
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(String queryString,
			int start, int count, String userIds, String roleIds) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("query", filterSolrKeywords(queryString));
		return fuzzyQuery(queryMap, start, count, userIds, roleIds);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#insert(com.cctv.ngp.
	 * seoclient.po.SearchEngineObject)
	 */
	public boolean insert(SearchEngineObject searchEngineObject) {
		log.debug("insert searchEngineObject:" + searchEngineObject);
		HttpSolrServer server;
		try {
			server = this.getHttpSolrServer();
			server.add(createSolrInputDocument(searchEngineObject));
			server.commit(false, false);
		} catch (MalformedURLException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		} catch (SolrServerException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		} catch (IOException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#insert(java.util.List)
	 */
	public boolean insert(List<SearchEngineObject> listSearchEngineObject) {
		log.debug("insert listSearchEngineObject:" + listSearchEngineObject);
		HttpSolrServer server;
		try {
			server = this.getHttpSolrServer();
			Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
			for (SearchEngineObject searchEngineObject : listSearchEngineObject) {
				docs.add(createSolrInputDocument(searchEngineObject));
			}
			server.add(docs);
			server.commit(false, false);
		} catch (MalformedURLException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		} catch (SolrServerException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		} catch (IOException e) {
			log.error("索引数据, 传输数据时发生异常!", e);
			throw new AppException("索引数据, 传输数据时发生异常!");
		}
		return true;
	}

	private SolrInputDocument createSolrInputDocument(SearchEngineObject seo) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("ID", seo.getFieldValueAsString("ID"), 1.0f);
		doc.addField("TEXT", seo.getFieldValueAsString("TEXT"), 1.0f);
		doc.addField("URL", seo.getFieldValueAsString("URL"));
		doc.addField("TITLE", seo.getFieldValueAsString("TITLE"));
		doc.addField("RELEASE_TIME", seo.getFieldValue("RELEASE_TIME"));
		doc.addField("INDEX_TIME", seo.getFieldValue("INDEX_TIME"));
		doc.addField("SUMMARY", seo.getFieldValueAsString("SUMMARY"));
		doc.addField("INDEX_TYPE", seo.getFieldValueAsString("INDEX_TYPE"));
		doc.addField("STATUS", seo.getFieldValueAsString("STATUS"));
		doc.addField("CREATE_DATE", seo.getFieldValue("CREATE_DATE"));
		doc.addField("CREATE_BY", seo.getFieldValueAsString("CREATE_BY"));
		doc.addField("UPDATE_DATE", seo.getFieldValue("UPDATE_DATE"));
		doc.addField("UPDATE_BY", seo.getFieldValueAsString("UPDATE_BY"));
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#update(com.cctv.ngp.
	 * seoclient.po.SearchEngineObject)
	 */
	public boolean update(SearchEngineObject searchEngineObject) {
		log.debug("update searchEngineObject:" + searchEngineObject);
		return insert(searchEngineObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#update(java.util.List)
	 */
	public boolean update(List<SearchEngineObject> listSearchEngineObject) {
		log.debug("update searchEngineObject:" + listSearchEngineObject);
		return insert(listSearchEngineObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#findById(java.lang.String )
	 */
	public SearchEngineObject findById(String docId) {
		log.debug("findById docId:" + docId);
		List<SearchEngineObject> bdcList = findByIds(docId);
		if (bdcList != null && bdcList.size() > 0)
			return bdcList.get(0);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#findByIds(java.lang. String)
	 */
	public List<SearchEngineObject> findByIds(String docIds) {
		log.debug("findByIds docIds:" + docIds);
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("query", assembleOrQueryString("ID", docIds, ","));
		queryMap.put("sort", "");
		queryMap.put("fl", "*,score");
		return (List<SearchEngineObject>) fuzzyQuery(queryMap, 0, 1024)
				.getContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#deleteById(java.lang .String)
	 */
	public boolean deleteById(String docId) {
		log.debug("deleteById docId:" + docId);
		HttpSolrServer server;
		try {
			server = this.getHttpSolrServer();
			server.deleteById(docId);
			server.commit();
		} catch (MalformedURLException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (SolrServerException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (IOException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#deleteByIds(java.lang .String)
	 */
	public boolean deleteByIds(String docIds) {
		log.debug("deleteByIds docIds:" + docIds);
		HttpSolrServer server;
		try {
			String[] arDocIds = docIds.split(",");
			server = this.getHttpSolrServer();
			server.deleteById(Arrays.asList(arDocIds));
			server.commit();
		} catch (MalformedURLException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (SolrServerException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (IOException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		}
		return true;
	}

	private boolean deleteByQuery(String queryString) {
		log.debug("deleteByQuery queryString:" + queryString);
		HttpSolrServer server;
		try {
			server = this.getHttpSolrServer();
			server.deleteByQuery(queryString);
			server.commit();
		} catch (MalformedURLException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (SolrServerException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		} catch (IOException e) {
			log.error("删除数据, 传输数据时发生异常!", e);
			throw new AppException("删除数据, 传输数据时发生异常!");
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchEngineClient#deleteByCrawlTime(java .util.Date,
	 * java.util.Date)
	 */
	public boolean deleteByCrawlTime(Date start, Date end) {
		log.debug("deleteByCrawlTime start:" + start + ", end:" + end);
		String queryString = "CRAWL_TIME:[";
		if (start == null)
			queryString += "*";
		else
			queryString += DateHelper.formatDate(start,
					"yyyy-MM-dd'T'HH:mm:ss'Z'");
		queryString += " TO ";
		if (end == null)
			queryString += "*";
		else
			queryString += DateHelper.formatDate(end, "yyyy-MM-dd'T'HH:mm:ss'Z'");
		queryString += "]";
		return deleteByQuery(queryString);
	}

	private String assembleOrQueryString(String fieldName, String fieldValues,
			String separator) {
		if (fieldValues == null || fieldValues.length() == 0)
			return "";
		String[] arFieldValues = fieldValues.split(separator);
		String queryString = "";
		for (int i = 0; i < arFieldValues.length; i++) {
			if (queryString.length() > 0)
				queryString += " OR ";
			if (arFieldValues[i] == null)
				continue;
			queryString += fieldName + ":" + arFieldValues[i];
		}
		return queryString;
	}

	public String getSeServerBaseUrl() {
		return seServerBaseUrl;
	}

	public void setSeServerBaseUrl(String seServerBaseUrl) {
		this.seServerBaseUrl = seServerBaseUrl;
	}

}
