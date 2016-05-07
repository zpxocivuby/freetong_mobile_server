package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysResourceService;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.persistence.platform.dao.ISysResourceDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能说明：资源服务实现类 典型用法：N/A 特殊用法：N/A
 * 
 * @author
 * 
 * @Date 2014年7月16日
 */
@Service("sysResourceServiceImpl")
public class SysResourceServiceImpl extends BaseServiceImpl implements
		ISysResourceService {

	@Autowired
	private ISysResourceDao sysResourceDao = null;

	public SysResource doSaveOrUpdate(SysResource sysResource) {
		// 屏蔽不同JDK版本的bug
		if (sysResource.getId() == null || sysResource.getId() <= 0) {
			sysResource.setId(null);
			// 当前节点的isLeaf设置为TRUE
			sysResource.setIsLeaf(true);
		}
		sysResourceDao.saveOrUpdate(sysResource);
		// 当前节点父节点的isLeaf设置为FALSE
		SysResource parentObj = sysResourceDao.findById(sysResource.getParentId());
		parentObj.setIsLeaf(false);
		// 如果非按钮，设置父为分类
		if (!CodeListConstant.ITAF_MENU_ACTION.equals(sysResource.getType())) {
			parentObj.setType(CodeListConstant.ITAF_MENU_CATEGORY);
		}
		sysResourceDao.saveOrUpdate(parentObj);
		return sysResource;
	}

	public void doDeleteById(Long resourceID) {
		SysResource sysResource = findById(resourceID);
		SysResource parentObj = sysResource.getParent();
		// 根节点不允许删除
		if (parentObj == null) {
			return;
		}
		// 先从Children删除该节点
		parentObj.getChildren().remove(sysResource);
		// 当前节点父节点的isLeaf设置为该父节点的子节点数目是否为空
		parentObj.setIsLeaf(true);
		boolean isNeedChangeType = true;
		if (parentObj.getChildren() != null
				&& parentObj.getChildren().size() > 0) {
			parentObj.setIsLeaf(false);
			for (SysResource resource : parentObj.getChildren()) {
				// 如果子节点有一个为非OOMS_MENU_ACTION就表示不用修改类型
				if (!CodeListConstant.ITAF_MENU_ACTION.equals(resource
						.getType())) {
					isNeedChangeType = false;
					break;
				}
			}
		}
		if (isNeedChangeType) {
			parentObj.setType(CodeListConstant.ITAF_MENU_ITEM);
		}
		sysResourceDao.saveOrUpdate(parentObj);
		sysResourceDao.remove(sysResource);
	}

	public SysResource findById(Long resourceId) {
		return sysResourceDao.findById(resourceId);
	}

	public List<SysResource> findAll() {
		return sysResourceDao.query("from SysResource"
				+ " order by parentId asc, orderNo asc", null);
	}

	public List<SysResource> findByType(String... resTypes) {
		String hql = "from SysResource where type in (:type)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("type", resTypes);
		return sysResourceDao.query(hql, params);
	}

	public List<SysResource> findByUserIdAndType(Long userId,
			String... resourceType) {
		String hql = "select distinct r from SysUser user join user.sysRoles role join role.sysResources r "
				+ " where user.id=:userId and r.type in (:resourceType)"
				+ " order by r.parentId asc, r.orderNo asc"; // 依次按父节点，顺序号排序
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("resourceType", resourceType);

		return sysResourceDao.query(hql, params);
	}

	/**
	 * 根据用户编号查询系统菜单
	 * 
	 * @param userId
	 *            用户Id
	 * @return List<SysResource>
	 */
	public List<SysResource> findByUserId(Long userId) {
		String hql = "select r from SysUser user join user.sysRoles role join role.sysResources r "
				+ " where user.id=:userId "
				+ " order by r.parentId asc, r.orderNo asc"; // 依次按父节点，顺序号排序
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return sysResourceDao.query(hql, params);
	}

	public boolean isHasButtonAuth(Long userId, Long resourceId) {
		String hql = "select r from SysUser user join user.sysRoles role join role.sysResources r "
				+ " where user.id=:userId and r.id=:resourceId"
				+ " order by r.parentId asc, r.orderNo asc"; // 依次按父节点，顺序号排序

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("resourceId", resourceId);

		List<SysResource> resources = sysResourceDao.query(hql, params);
		if (resources != null && resources.size() > 0) {
			return true;
		}
		return false;
	}

}
