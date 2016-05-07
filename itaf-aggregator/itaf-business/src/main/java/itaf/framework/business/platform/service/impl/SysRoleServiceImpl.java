package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.platform.SysResource;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.persistence.platform.dao.ISysRoleDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl extends BaseServiceImpl implements
		ISysRoleService {

	@Autowired
	private ISysRoleDao roleDao = null;

	public void doAddResourcesToRole(Long roleId,
			Collection<SysResource> sysResources) {
		SysRole sysRole = findById(roleId);
		Set<SysResource> resources = sysRole.getSysResources();
		if (resources == null) {
			resources = new HashSet<SysResource>();
			sysRole.setSysResources(resources);
		}
		resources.addAll(sysResources);
		roleDao.saveOrUpdate(sysRole);
	}

	public void doAddUsersToRole(Long roleId, Collection<SysUser> sysUsers) {
		SysRole sysRole = findById(roleId);
		Set<SysUser> users = sysRole.getSysUsers();
		if (users == null) {
			users = new HashSet<SysUser>();
			sysRole.setSysUsers(users);
		}
		users.addAll(sysUsers);
		roleDao.saveOrUpdate(sysRole);
	}

	public SysRole doCreate(SysRole sysRole) {
		roleDao.saveOrUpdate(sysRole);
		return sysRole;
	}

	public void doDelete(SysRole sysRole) {
		roleDao.remove(sysRole);
	}

	public SysRole findById(Long roleId) {
		return roleDao.findById(roleId);
	}

	public SysRole getById(Long roleId) {
		return roleDao.getById(roleId);
	}

	public List<SysRole> findAll() {
		return roleDao.findAll();
	}

	public List<SysRole> findByCondition(String nameEn, String nameZh,
			String description) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringHelper.isEmpty(nameEn))
			params.put("nameEn", "%" + nameEn + "%");
		if (!StringHelper.isEmpty(nameZh))
			params.put("nameZh", "%" + nameZh + "%");
		if (!StringHelper.isEmpty(description))
			params.put("description", "%" + description + "%");
		String hql = HqlUtils.generateHql(null, "from SysRole", new String[] {
				"nameEn like :nameEn", "nameZh like :nameZh",
				"description like :description" }, null, null, params);
		return roleDao.query(hql, params);
	}

	public PageResult<SysRole> findByCriteria(QueryCriteria criteria) {
		String queryEntry = null;
		String[] whereBodies = new String[] { "lower(nameZh) like :nameZhLike",
				"lower(nameEn) like :nameEnLike",
				"lower(description) like :descriptionLike" };
		String fromJoinSubClause = "from SysRole";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysRole> result = (PageResult<SysRole>) roleDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public SysRole findByNameEn(String nameEn) {
		SysRole role = new SysRole();
		role.setNameEn(nameEn);
		List<SysRole> result = roleDao.find(role);
		if (result != null && !result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	public void doRemoveResourcesFromRole(Long roleId,
			Collection<SysResource> sysResources) {
		SysRole sysRole = findById(roleId);
		Set<SysResource> resources = sysRole.getSysResources();
		if (resources != null) {
			resources.removeAll(sysResources);
			roleDao.saveOrUpdate(sysRole);
		}
	}

	public void doRemoveUsersFromRole(Long roleId, Collection<SysUser> sysUsers) {
		SysRole sysRole = findById(roleId);

		Set<SysUser> users = sysRole.getSysUsers();
		if (users != null) {
			System.out.println(sysUsers.iterator().next().getId());
			users.removeAll(sysUsers);
			// try{
			//
			// if (users.size() > sysUsers.size()) {
			// for (Iterator<Object> i = sysUsers.iterator(); i.hasNext(); )
			// System.out.println(users.remove(i.next()));
			// } else {
			// for (Iterator<Object> i = users.iterator(); i.hasNext(); ) {
			// if (sysUsers.contains(i.next())) {
			// System.out.println("sysUsers.contains():");
			// i.remove();
			// }
			// }
			// }
			// }catch(Exception ex){
			// ex.printStackTrace();
			// }
			System.out.println(users.size());
			// System.out.println(flag);
			sysRole.setSysUsers(users);
			roleDao.saveOrUpdate(sysRole);
		}
	}

	public void doUpdate(SysRole sysRole) {
		if (sysRole.getId().equals(0)) {
			sysRole.setId(null);
		}
		roleDao.saveOrUpdate(sysRole);
		// roleDao.flush();
	}

	public PageResult<SysRole> findByCriteriaName(QueryCriteria criteria) {
		String queryEntry = null;
		String[] whereBodies = new String[] { "lower(nameZh) like :nameZh" };
		String fromJoinSubClause = "from SysRole";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysRole> result = (PageResult<SysRole>) roleDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public List<SysRole> findLikeName(String roleName) {
		List<SysRole> sysRoles = new ArrayList<SysRole>();
		if (StringUtils.isEmpty(roleName)) {
			sysRoles = roleDao.findAll();
		}
		if (sysRoles == null || sysRoles.size() <= 0) {
			sysRoles = roleDao.findLikeName(roleName);
		}
		return sysRoles;
	}

	public void doDeleteByIds(List<Long> dataIds) {
		if (dataIds != null && dataIds.size() > 0) {
			for (Long roleId : dataIds) {
				this.doDelete(this.findById(roleId));
			}
		}
	}

	public void doUpdateUsersToRole(Long roleId, Set<SysUser> sysUsers) {
		SysRole sysRole = findById(roleId);
		sysRole.setSysUsers(sysUsers);
		roleDao.saveOrUpdate(sysRole);
	}

	public List<SysRole> findByIds(List<Long> roleIds) {
		return roleDao.findByIds(roleIds);
	}

	@Override
	public List<SysRole> getByIds(String roleIds) {
		List<SysRole> result = new ArrayList<SysRole>();
		for (String roleId : StringUtils.split(roleIds, ",")) {
			result.add(getById(Long.valueOf(roleId)));
		}
		return result;
	}
}