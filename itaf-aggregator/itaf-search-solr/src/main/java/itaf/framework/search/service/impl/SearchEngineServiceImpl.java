/**
 * 
 */
package itaf.framework.search.service.impl;

import itaf.framework.core.common.PageResult;
import itaf.framework.domain.search.SearchIndexData;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.search.SearchEngineClient;
import itaf.framework.search.bean.SearchEngineObject;
import itaf.framework.search.service.SearchEngineService;
import itaf.framework.search.service.SeoConvertService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangkd
 * 
 */
@Service("searchEngineServiceImpl")
public class SearchEngineServiceImpl implements SearchEngineService {

	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private SearchEngineClient searchEngineClient;

	@Autowired
	private SeoConvertService seoConvertService;

	public PageResult<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count) {
		log.debug("classifyQuery classifyTagName:" + classifyTagName
				+ ", classifyTagValue:" + classifyTagValue + ", start:" + start
				+ ", count:" + count);
		if (classifyTagName == null) {
			log.warn("线索维度查询, 传入的分类字段无效!");
			throw new BusinessException("线索维度查询, 传入的分类字段无效!");
		}
		if (classifyTagValue == null) {
			log.warn("线索维度查询, 传入的分类字段值无效!");
			throw new BusinessException("线索维度查询, 传入的分类字段值无效!");
		}
		return convertSearchEngineObjectPageResult(searchEngineClient
				.classifyQuery(classifyTagName, classifyTagValue, start, count));
	}

	public PageResult<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count, String userIds,
			String roleIds) {
		log.debug("classifyQuery classifyTagName:" + classifyTagName
				+ ", classifyTagValue:" + classifyTagValue + ", start:" + start
				+ ", count:" + count);
		if (classifyTagName == null) {
			log.warn("线索维度查询, 传入的分类字段无效!");
			throw new BusinessException("线索维度查询, 传入的分类字段无效!");
		}
		if (classifyTagValue == null) {
			log.warn("线索维度查询, 传入的分类字段值无效!");
			throw new BusinessException("线索维度查询, 传入的分类字段值无效!");
		}
		if (userIds == null) {
			log.warn("线索维度查询, 传入的用户ID序列无效!");
			throw new BusinessException("线索维度查询, 传入的用户ID序列无效!");
		}
		return convertSearchEngineObjectPageResult(searchEngineClient
				.classifyQuery(classifyTagName, classifyTagValue, start, count,
						userIds, roleIds));
	}

	public List<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int count) {
		return (List<SearchIndexData>) classifyQuery(classifyTagName,
				classifyTagValue, 0, count).getContent();
	}

	public List<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int count, String userIds, String roleIds) {
		return (List<SearchIndexData>) classifyQuery(classifyTagName,
				classifyTagValue, 0, count, userIds, roleIds).getContent();
	}

	public PageResult<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int start, int count) {
		log.debug("fuzzyQuery queryMap:" + queryMap + ", start:" + start
				+ ", count:" + count);
		if (queryMap == null) {
			log.warn("线索板块查询, 传入的检索条件无效!");
			throw new BusinessException("线索板块查询, 传入的检索条件无效!");
		}

		return convertSearchEngineObjectPageResult(searchEngineClient
				.fuzzyQuery(queryMap, start, count));
	}

	public PageResult<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int start, int count, String userIds, String roleIds) {
		log.debug("fuzzyQuery queryMap:" + queryMap + ", start:" + start
				+ ", count:" + count);
		if (queryMap == null) {
			log.warn("线索板块查询, 传入的检索条件无效!");
			throw new BusinessException("线索板块查询, 传入的检索条件无效!");
		}
		if (userIds == null) {
			log.warn("线索维度查询, 传入的用户ID序列无效!");
			throw new BusinessException("线索维度查询, 传入的用户ID序列无效!");
		}
		return convertSearchEngineObjectPageResult(searchEngineClient
				.fuzzyQuery(queryMap, start, count, userIds, roleIds));
	}

	public List<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int count) {
		return (List<SearchIndexData>) fuzzyQuery(queryMap, 0, count)
				.getContent();
	}

	public List<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int count, String userIds, String roleIds) {
		return (List<SearchIndexData>) fuzzyQuery(queryMap, 0, count, userIds,
				roleIds).getContent();
	}

	public PageResult<SearchIndexData> fuzzyQuery(String queryString,
			int start, int count) {
		log.debug("fuzzyQuery queryString:" + queryString + ", start:" + start
				+ ", count:" + count);
		if (queryString == null) {
			log.warn("线索关键词查询, 传入的关键词无效!");
			throw new BusinessException("线索关键词查询, 传入的关键词无效!");
		}
		return convertSearchEngineObjectPageResult(searchEngineClient
				.fuzzyQuery(queryString, start, count));
	}

	public PageResult<SearchIndexData> fuzzyQuery(String queryString,
			int start, int count, String userIds, String roleIds) {
		log.debug("fuzzyQuery queryString:" + queryString + ", start:" + start
				+ ", count:" + count);
		if (queryString == null) {
			log.warn("线索关键词查询, 传入的关键词无效!");
			throw new BusinessException("线索关键词查询, 传入的关键词无效!");
		}
		if (userIds == null) {
			log.warn("线索维度查询, 传入的用户ID序列无效!");
			throw new BusinessException("线索维度查询, 传入的用户ID序列无效!");
		}
		return convertSearchEngineObjectPageResult(searchEngineClient
				.fuzzyQuery(queryString, start, count, userIds, roleIds));
	}

	public SearchIndexData findById(String docId) {
		log.debug("findById docId:" + docId);
		if (docId == null || docId.trim().length() == 0) {
			log.warn("线索关键字查询, 传入的关键字无效!");
			throw new BusinessException("线索关键字查询, 传入的关键字无效!");
		}
		return seoConvertService.convertSeo2IndexData(searchEngineClient
				.findById(docId));
	}

	public List<SearchIndexData> findByIds(String docIds) {
		log.debug("findByIds docIds:" + docIds);
		if (docIds == null) {
			log.warn("线索关键字序列查询, 传入的关键字序列无效!");
			throw new BusinessException("线索关键字序列查询, 传入的关键字序列无效!");
		}
		return seoConvertService.convertSeo2IndexData(searchEngineClient
				.findByIds(docIds));
	}

	public boolean insert(SearchIndexData target) {
		log.debug("insert CrawlerData:" + target);
		if (target == null) {
			log.warn("线索创建索引, 传入的线索对象无效!");
			throw new BusinessException("线索创建索引, 传入的线索对象无效!");
		}
		return searchEngineClient.insert(seoConvertService
				.convertIndexData2Seo(target));
	}

	public boolean insert(List<SearchIndexData> listCrawlerData) {
		log.debug("insert listCrawlerData:" + listCrawlerData);
		if (listCrawlerData == null) {
			log.warn("线索创建索引, 传入的线索列表对象无效!");
			throw new BusinessException("线索创建索引, 传入的线索列表对象无效!");
		}
		return searchEngineClient.insert(seoConvertService
				.convertIndexData2Seo(listCrawlerData));
	}

	public boolean update(SearchIndexData CrawlerData) {
		log.debug("update CrawlerData:" + CrawlerData);
		if (CrawlerData == null) {
			log.warn("线索更新索引, 传入的线索对象无效!");
			throw new BusinessException("线索更新索引, 传入的线索对象无效!");
		}
		return searchEngineClient.update(seoConvertService
				.convertIndexData2Seo(CrawlerData));
	}

	public boolean update(List<SearchIndexData> listCrawlerData) {
		log.debug("update listCrawlerData:" + listCrawlerData);
		if (listCrawlerData == null) {
			log.warn("线索更新索引, 传入的线索列表对象无效!");
			throw new BusinessException("线索更新索引, 传入的线索列表对象无效!");
		}
		return searchEngineClient.update(seoConvertService
				.convertIndexData2Seo(listCrawlerData));
	}

	public boolean deleteById(String docId) {
		log.debug("deleteById docId:" + docId);
		if (docId == null || docId.trim().length() == 0) {
			log.warn("线索删除索引, 传入的线索关键字无效!");
			throw new BusinessException("线索删除索引, 传入的线索关键字无效!");
		}
		return searchEngineClient.deleteById(docId);
	}

	public boolean deleteByIds(String docIds) {
		log.debug("deleteByIds docIds:" + docIds);
		if (docIds == null) {
			log.warn("线索删除索引, 传入的线索关键字序列无效!");
			throw new BusinessException("线索删除索引, 传入的线索关键字序列无效!");
		}
		return searchEngineClient.deleteByIds(docIds);
	}

	public boolean deleteByCrawlTime(Date start, Date end) {
		log.debug("deleteByCrawlTime start:" + start + ", end:" + end);
		if (start == null && end == null) {
			log.warn("线索删除索引, 传入的时间无效!");
			throw new BusinessException("线索删除索引, 传入的时间无效!");
		}
		return searchEngineClient.deleteByCrawlTime(start, end);
	}

	public List<String> relationKeywordQuery(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	private PageResult<SearchIndexData> convertSearchEngineObjectPageResult(
			PageResult<SearchEngineObject> seoPr) {
		if (seoPr == null) {
			return null;
		}
		PageResult<SearchIndexData> pageResult = new PageResult<SearchIndexData>();
		pageResult.setQueryString(seoPr.getQueryString());
		pageResult.setQueryTime(seoPr.getQueryTime());
		pageResult.setCurrentIndex(seoPr.getCurrentIndex());
		pageResult.setTotalCount(seoPr.getTotalCount());
		pageResult.setCurrentPage(seoPr.getCurrentPage());
		pageResult.setTotalPage(seoPr.getTotalPage());
		pageResult.setPageSize(seoPr.getPageSize());
		pageResult.setContent(seoConvertService
				.convertSeo2IndexData(new ArrayList<SearchEngineObject>(seoPr
						.getContent())));
		return pageResult;
	}

	public SearchIndexData getClueInfo(Long clueId) {
		return this.findById(clueId.toString());
	}

}
