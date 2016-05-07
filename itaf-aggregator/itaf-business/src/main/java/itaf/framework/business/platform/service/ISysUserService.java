package itaf.framework.business.platform.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 该类定义访问用户数据的Service接口。
 * 
 * @author  
 * 
 */
public interface ISysUserService {

	/**
	 * 添加用户角色关联关系到指定用户。
	 * 
	 * @param userId
	 *            指定用户ID
	 * @param sysRoles
	 *            角色数据列表
	 */
	void doAddRolesToUser(Long userId, Collection<SysRole> sysRoles);

	/**
	 * 更改指定用户的登录密码。
	 * 
	 * @param userId
	 *            指定用户ID
	 * @param newPassword
	 *            新密码
	 */
	void doChangePassword(Long userId, String newPassword);

	/**
	 * 创建用户数据记录。
	 * 
	 * @param sysUser
	 *            用户数据
	 * @return 创建成功后用户数据，用户ID已被设置。
	 */
	SysUser doCreate(SysUser sysUser);

	/**
	 * 删除指定的用户数据记录。
	 * 
	 * @param sysUser
	 *            用户数据
	 */
	void doDelete(SysUser sysUser);

	/**
	 * 检索所有用户数据记录。
	 * 
	 * @return
	 */
	List<SysUser> findAll();

	/**
	 * 根据查询约束条件返回用户数据的查询结果（分页处理），结果集合在{@link PageResult}中。
	 * 
	 * @param criteria
	 *            查询约束条件
	 * @return 以页结果返回。
	 * @see QueryCriteria;
	 * @see PageResult;
	 */
	PageResult<SysUser> findByCriteria(QueryCriteria criteria);

	/**
	 * 根据查询约束条件返回用户数据的查询结果（分页处理），结果集合在{@link PageResult}中。
	 * 
	 * @param criteria
	 *            查询约束条件 用户姓名
	 * @return 以页结果返回。
	 * @see QueryCriteria;
	 * @see PageResult;
	 */
	PageResult<SysUser> findByCriteriaUserName(QueryCriteria criteria);

	/**
	 * 根据用户ID查找对应的用户数据记录，无对应数据记录时抛出异常。
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户ID对应的用户数据记录。
	 */
	SysUser findById(Long id);

	/**
	 * 根据用户登录名称查找对应的用户数据记录，无对应数据记录时抛出异常。
	 * 
	 * @param username
	 *            用户登录名称
	 * @return 用户登录名称对应的用户数据记录
	 */
	SysUser findByUsername(String username);

	/**
	 * 根据用户ID及角色列表，从用户-角色映射关系中删除指定的角色关联关系。
	 * 
	 * @param userId
	 *            用户ID
	 * @param sysRoles
	 *            需要删除关联关系的角色列表
	 */
	void doRemoveRolesFromUser(Long userId, Collection<SysRole> sysRoles);

	/**
	 * 保存用户数据。
	 * 
	 * @param sysUser
	 *            需要保存的用户数据
	 */
	void doUpdate(SysUser sysUser);

	/**
	 * 根据角色表的序号id，查找用户数据表
	 * 
	 * @param criteria
	 *            分页查询
	 * @return 检索成功的数据
	 */
	PageResult<SysUser> findByCriteriaRoleId(QueryCriteria criteria);

	/**
	 * 根据Id更新用户数据。
	 * 
	 * @param sysUser
	 *            需要保存的用户数据
	 */
	void doUpdateById(String id, String password);

	/**
	 * 根据Id更新用户数据。
	 * 
	 * @param sysUser
	 *            需要保存的用户数据
	 */
	void doUpdateDelete(List<SysUser> users);

	/**
	 * 根据用户输入分别模糊匹配realnameZh or realnameEn or username,并且排除创建人
	 * 
	 * @param userName
	 *            用户输入
	 * @param createUserId创建人Id
	 * @return if userName is null return null
	 */
	List<SysUser> findLikeName(String userName, Long createUserId);

	/**
	 * 检索所有用户数据记录并根据用户名排序。
	 * 
	 * @return List<SysUser>
	 */
	List<SysUser> findAllOrderByUsername();

	/**
	 * 通过用户Id更新删除标志位
	 * 
	 * @param userIds
	 *            需要删除用户Id列表
	 */
	void doSoftDeleteByIds(List<Long> userIds);

	/**
	 * 根据Id判断是否添加或者更新用户信息，根据username判断是否恢复某个用户
	 * 
	 * @param user
	 */
	String doSaveOrRecover(SysUser user);

	SysUser getById(Long userId);

	List<SysUser> findByIds(List<Long> userIds);

	/**
	 * 更新每页的条数
	 */
	void doUpdatePageSize(Long userId, Long newPageSize);

	PageResult<SysUser> findByUpdateTime(Date date, int currentIndex,
			int pageSize, Long currentId);

	public void doUpdatePassword(SysUser user, String password);

	void doUpdateSessionUser(SysUser toBeUpdated);
}
