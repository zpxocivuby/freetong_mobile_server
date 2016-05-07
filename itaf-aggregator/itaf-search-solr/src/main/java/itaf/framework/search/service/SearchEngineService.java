package itaf.framework.search.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.domain.search.SearchIndexData;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhangkd
 * 
 */
public interface SearchEngineService {

	/**
	 * 线索维度查询
	 * 
	 * @param classifyTagName
	 *            分类字段
	 * @param classifyTagValue
	 *            分类字段值
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count);

	public PageResult<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count, String userIds,
			String roleIds);

	/**
	 * 线索维度查询
	 * 
	 * @param classifyTagName
	 *            分类字段
	 * @param classifyTagValue
	 *            分类字段值
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public List<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int count);

	public List<SearchIndexData> classifyQuery(String classifyTagName,
			String classifyTagValue, int count, String userIds, String roleIds);

	/**
	 * 线索板块查询
	 * 
	 * @param queryMap
	 *            板块查询条件
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int start, int count);

	public PageResult<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int start, int count, String userIds, String roleIds);

	/**
	 * 线索板块查询
	 * 
	 * @param queryMap
	 *            板块查询条件
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public List<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap, int count);

	public List<SearchIndexData> fuzzyQuery(Map<String, Object> queryMap,
			int count, String userIds, String roleIds);

	/**
	 * 线索关键词查询
	 * 
	 * @param queryString
	 *            关键词
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchIndexData> fuzzyQuery(String queryString, int start,
			int count);

	public PageResult<SearchIndexData> fuzzyQuery(String queryString, int start,
			int count, String userIds, String roleIds);

	/**
	 * 线索关键字查询
	 * 
	 * @param docId
	 *            线索ID
	 * @return
	 */
	public SearchIndexData findById(String docId);

	/**
	 * 线索关键字序列查询
	 * 
	 * @param docIds
	 *            线索ID序列
	 * @return
	 */
	public List<SearchIndexData> findByIds(String docIds);

	/**
	 * 线索创建索引
	 * 
	 * @param searchEngineObject
	 *            搜索引擎对象
	 * @return
	 */
	public boolean insert(SearchIndexData searchEngineObject);

	/**
	 * 线索创建索引
	 * 
	 * @param listSearchEngineObject
	 *            搜索引擎对象列表
	 * @return
	 */
	public boolean insert(List<SearchIndexData> listSearchEngineObject);

	/**
	 * 线索更新索引
	 * 
	 * @param searchEngineObject
	 *            搜索引擎对象
	 * @return
	 */
	public boolean update(SearchIndexData searchEngineObject);

	public boolean update(List<SearchIndexData> listSearchEngineObject);

	/**
	 * 线索删除索引
	 * 
	 * @param docId
	 *            线索ID
	 * @return
	 */
	public boolean deleteById(String docId);

	/**
	 * 线索删除索引
	 * 
	 * @param docIds
	 *            线索ID序列
	 * @return
	 */
	public boolean deleteByIds(String docIds);

	/**
	 * 线索删除索引（按索引时间）
	 * 
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 */
	public boolean deleteByCrawlTime(Date start, Date end);

	/**
	 * 关键词的相关词查询
	 * 
	 * @param keyword
	 *            关键词
	 * @return
	 */
	public List<String> relationKeywordQuery(String keyword);

}
