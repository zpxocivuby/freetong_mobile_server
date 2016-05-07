package itaf.framework.business.platform.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 该类定义访问角色数据的Service接口。
 * 
 * @author
 * 
 */
public interface ISysRoleService {

	/**
	 * 根据指定的角色ID，将传入的系统资源列表与对应的角色建立映射关系。
	 * 
	 * @param roleId
	 *            角色ID
	 * @param sysResources
	 *            系统资源列表
	 */
	void doAddResourcesToRole(Long roleId, Collection<SysResource> sysResources);

	/**
	 * 根据指定的角色ID，将传入的用户列表与对应的角色建立映射关系。
	 * 
	 * @param roleId
	 *            角色ID
	 * @param sysUsers
	 *            用户列表
	 */
	void doAddUsersToRole(Long roleId, Collection<SysUser> sysUsers);

	/**
	 * 创建角色数据记录。
	 * 
	 * @param sysRole
	 *            角色数据
	 * @return 创建成功则返回对应记录，失败则抛出异常。
	 */
	SysRole doCreate(SysRole sysRole);

	/**
	 * 删除指定的角色数据记录。
	 * 
	 * @param sysRole
	 *            角色数据
	 */
	void doDelete(SysRole sysRole);

	/**
	 * 检索所有角色数据。
	 * 
	 * @return 所有角色数据的集合
	 */
	List<SysRole> findAll();

	/**
	 * 根据相关条件查询相应角色数据。
	 * 
	 * @param nameEn
	 *            角色名称（英文）
	 * @param nameZh
	 *            角色名称（中文）
	 * @param description
	 *            角色描述
	 * @return 对应角色数据集合。
	 */
	List<SysRole> findByCondition(String nameEn, String nameZh,
			String description);

	/**
	 * 根绝角色ID查找角色数据，无对应数据时抛出异常。
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 角色ID对应角色数据
	 */
	SysRole findById(Long roleId);

	/**
	 * 根绝角色ID查找角色数据，无对应数据时返回null
	 * 
	 * @param roleId
	 *            角色ID
	 * @return 角色ID对应角色数据
	 */
	SysRole getById(Long roleId);

	/**
	 * 根据角色名称（英文）查找对应角色数据。
	 * 
	 * @param nameEn
	 *            角色名称（英文）
	 * @return 角色数据
	 */
	SysRole findByNameEn(String nameEn);

	/**
	 * 根据查询条件BO来进行查询操作
	 * 
	 * @param criteria
	 *            查询条件
	 * @return
	 */
	public PageResult<SysRole> findByCriteria(QueryCriteria criteria);

	/**
	 * 根据查询条件BO来进行查询操作
	 * 
	 * @param criteria
	 *            查询条件
	 * @return
	 */
	public PageResult<SysRole> findByCriteriaName(QueryCriteria criteria);

	/**
	 * 从角色资源映射关系中删除传入的角色ID和资源列表对应的映射关系。
	 * 
	 * @param roleId
	 *            角色ID
	 * @param sysResources
	 *            资源集合
	 */
	void doRemoveResourcesFromRole(Long roleId,
			Collection<SysResource> sysResources);

	/**
	 * 从用户角色映射关系中删除传入的角色ID和用户列表对应的映射关系。
	 * 
	 * @param roleId
	 * @param sysUsers
	 */
	void doRemoveUsersFromRole(Long roleId, Collection<SysUser> sysUsers);

	/**
	 * 更新指定的角色数据。
	 * 
	 * @param sysRole
	 *            角色数据。
	 */
	void doUpdate(SysRole sysRole);

	/**
	 * 根据用户输入模糊查询角色nameZh or nameEn列表
	 * 
	 * @param roleName
	 *            用户输入
	 * @return if roleName is null return all
	 */
	List<SysRole> findLikeName(String roleName);

	void doDeleteByIds(List<Long> dataIds);

	/**
	 * 根据指定的角色ID，将传入的用户列表直接设置为角色的对应关系
	 * 
	 * @param roleId
	 *            角色ID
	 * @param sysUsers
	 *            用户列表
	 */
	void doUpdateUsersToRole(Long roleId, Set<SysUser> sysUsers);

	List<SysRole> findByIds(List<Long> roleIds);

	/**
	 * 根据角色Id进行查询列表使用","分割
	 * 
	 * @param roleIds
	 *            使用","分割的角色Id
	 * @return List<SysRole>
	 */
	List<SysRole> getByIds(String roleIds);

}
