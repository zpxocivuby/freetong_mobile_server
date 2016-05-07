package itaf.framework.business.platform.service;

import itaf.framework.domain.platform.SysResource;

import java.util.List;

/**
 * 该类定义访问系统资源数据的Service接口。
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月24日
 */
public interface ISysResourceService {

	/**
	 * 创建一个新资源
	 * 
	 * @param sysResource
	 *            新资源
	 * @return 创建后的资源
	 */
	public SysResource doSaveOrUpdate(SysResource sysResource);

	/**
	 * 删除指定资源
	 * 
	 * @param resourceId
	 *            资源的数据库Id
	 */
	public void doDeleteById(Long resourceId);

	/**
	 * 查找所有的资源
	 * 
	 * @return 所有资源的集合
	 */
	public List<SysResource> findAll();

	/**
	 * 查找指定ID的资源
	 * 
	 * @param resourceId
	 *            资源的数据库Id
	 * @return 指定的资源
	 */
	public SysResource findById(Long resourceId);

	/**
	 * 根据资源类型RESTYPE查找资源，请参见
	 * <code>itaf.framework.constant.CodeListConstant</code>
	 * 
	 * @param resTypes
	 *            资源类型的常量定义字符串
	 * @return 符合条件的资源集合
	 */
	public List<SysResource> findByType(String... resTypes);

	/**
	 * 根据指定用户ID与资源类型找到符合条件的资源集合
	 * 
	 * @param userId
	 *            用户的数据库ID
	 * @param resourceType
	 *            资源类型，参见<code>itaf.framework.constant.CodeListConstant</code>
	 * @return 符合条件的资源集合
	 */
	public List<SysResource> findByUserIdAndType(Long userId,
			String... resourceType);

	/**
	 * 判断用户是否是ADMIN类型用户，如果是，左侧分类树应该是系统分类树
	 * 
	 * @param userId
	 *            用户Id
	 * @return List<SysResource>
	 */
	public List<SysResource> findByUserId(Long userId);

	/**
	 * 判断用户是否具有功能按钮的权限
	 * 
	 * @param userId
	 *            用户Id
	 * @param resourceId
	 *            资源Id
	 * @return boolean
	 */
	public boolean isHasButtonAuth(Long userId, Long resourceId);

}
