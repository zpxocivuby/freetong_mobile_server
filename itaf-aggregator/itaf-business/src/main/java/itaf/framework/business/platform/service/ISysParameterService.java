package itaf.framework.business.platform.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysParameter;

import java.util.List;

/**
 * 该类定义访问系统参数数据的Service接口。
 * 
 * @author Danne
 * 
 */
public interface ISysParameterService {

	/**
	 * 非外部接口 创建并保存系统参数数据记录。
	 * 
	 * @param tsParameter
	 *            系统参数数据
	 */
	SysParameter doCreate(SysParameter tsParameter);

	/**
	 * 非外部接口 删除指定的系统参数数据记录。
	 * 
	 * @param tsParameter
	 *            系统参数数据
	 */
	void doDelete(SysParameter tsParameter);

	/**
	 * 根据系统参数ID查找对应的系统参数数据记录，无对应记录时抛出异常。
	 * 
	 * @param id
	 *            系统参数ID
	 * @return 系统参数数据记录
	 */
	SysParameter findById(Long id);

	/**
	 * 分页查询系统参数表
	 * 
	 * @param criteria
	 *            查询条件
	 * @return
	 */
	PageResult<SysParameter> findByCriteria(QueryCriteria criteria);

	/**
	 * 根据类型获取参数信息
	 * 
	 * @param type
	 *            匹配的类型
	 * @return SysParameter
	 */
	SysParameter findByType(String type);

	/**
	 * 查找全部
	 * 
	 * @return List<SysParameter>
	 */
	List<SysParameter> findAll();

	/**
	 * 
	 * @return
	 */
	int findClobCutLength();

}
