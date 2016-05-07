package itaf.framework.business.platform.service;import itaf.framework.core.common.PageResult;import itaf.framework.core.common.QueryCriteria;import itaf.framework.domain.platform.SysCodeType;import java.util.List;/** * 该类定义访问编码类型数据的Service接口。 *  * @author XINXIN *  */public interface ISysCodeTypeService {	/**	 * 测试使用 添加是封闭的，在外部是不能够进行添加的，此方法是为程序员添加编码类型使用 新增sysCodeType	 * 	 * @param sysCodeType	 *            sysCodeType	 * @return　sysCodeType	 */	SysCodeType doCreate(SysCodeType sysCodeType);	/**	 * 测试使用 删除操作是封闭的，在外部是不能够进行删除的，此方法是为程序员删除编码类型使用 删除sysCodeType	 * 	 * @param sysCodeType	 *            sysCodeType	 */	void doDelete(SysCodeType sysCodeType);	/**	 * 按主键id查询SysCodeType	 * 	 * @param id	 *            SysCodeType id	 * @return SysCodeType	 */	SysCodeType findById(Long id);	/**	 * 编码类型查询(分页)	 * 	 * @param criteria	 *            查询表达	 * @return PageResult<SysCodeType>	 */	PageResult<SysCodeType> findByCriteria(QueryCriteria criteria);	/**	 * 查询全部	 * 	 * @return List<SysCodeType>	 */	List<SysCodeType> findAll();	/**	 * 根据类型查找SysCodeType	 * 	 * @param codeType	 *            类型	 * @return SysCodeType	 */	SysCodeType findByType(String codeType);}