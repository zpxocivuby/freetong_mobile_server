package itaf.framework.search;

import itaf.framework.core.common.PageResult;
import itaf.framework.search.bean.SearchEngineObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhangkd
 * 
 */
public interface SearchEngineClient {

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
	public PageResult<SearchEngineObject> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count);

	/**
	 * 线索维度查询（包含私有数据，需满足权限）
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
	public PageResult<SearchEngineObject> classifyQuery(String classifyTagName,
			String classifyTagValue, int start, int count, String userIds,
			String roleIds);

	/**
	 * 
	 * @param queryMap
	 *            查询表达式
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(
			Map<String, Object> queryMap, int start, int count);

	/**
	 * 线索板块查询（包含私有数据，需满足权限）
	 * 
	 * @param queryMap
	 *            板块查询条件
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @param userIds
	 *            有权限的用户ID序列
	 * @param roleIds
	 *            有权限的角色ID序列
	 * @return
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(
			Map<String, Object> queryMap, int start, int count, String userIds,
			String roleIds);

	/**
	 * 
	 * @param queryString
	 *            查询表达式
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(String queryString,
			int start, int count);

	/**
	 * 线索关键词查询（包含私有数据，需满足权限）
	 * 
	 * @param queryString
	 *            关键词
	 * @param start
	 *            数据起始偏移位置
	 * @param count
	 *            数据偏移量
	 * @return
	 */
	public PageResult<SearchEngineObject> fuzzyQuery(String queryString,
			int start, int count, String userIds, String roleIds);

	/**
	 * 创建文档索引
	 * 
	 * @param searchEngineObject
	 *            数据对象
	 * @return
	 */
	public boolean insert(SearchEngineObject searchEngineObject);

	/**
	 * 线索创建索引
	 * 
	 * @param listSearchEngineObject
	 *            搜索引擎对象列表
	 * @return
	 */
	public boolean insert(List<SearchEngineObject> listSearchEngineObject);

	/**
	 * 更新线索索引
	 * 
	 * @param searchEngineObject
	 *            数据对象
	 * @return
	 */
	public boolean update(SearchEngineObject searchEngineObject);

	/**
	 * 更新线索索引
	 * 
	 * @param listSearchEngineObject
	 *            搜索引擎对象列表
	 * @return
	 */
	public boolean update(List<SearchEngineObject> listSearchEngineObject);

	/**
	 * 线索关键字查询
	 * 
	 * @param docId
	 *            线索ID
	 * @return
	 */
	public SearchEngineObject findById(String docId);

	/**
	 * 线索关键字序列查询
	 * 
	 * @param docIds
	 *            线索ID序列
	 * @return
	 */
	public List<SearchEngineObject> findByIds(String docIds);

	/**
	 * 删除文档索引，按文档主键
	 * 
	 * @param docId
	 *            文档主键
	 * @return
	 */
	public boolean deleteById(String docId);

	/**
	 * 删除文档索引，按文档主键序列
	 * 
	 * @param docIds
	 *            文档主键序列，以英文逗号分割
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

}
