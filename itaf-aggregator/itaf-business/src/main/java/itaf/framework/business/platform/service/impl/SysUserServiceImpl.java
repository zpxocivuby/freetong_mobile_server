package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.EncryptUtil;
import itaf.framework.domain.platform.SysRole;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.exception.bean.BusinessException;
import itaf.framework.persistence.platform.dao.ISysUserDao;
import itaf.framework.persistence.util.HqlUtils;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service("sysUserServiceImpl")
public class SysUserServiceImpl extends BaseServiceImpl implements
		ISysUserService {

	@Autowired
	private ISysUserDao userDao;

	public void doAddRolesToUser(Long userId, Collection<SysRole> sysRoles) {
		Assert.notNull(userId);
		SysUser user = userDao.findById(userId);
		if (user == null) {
			return;
		}
		Set<SysRole> roles = user.getSysRoles();
		roles.addAll(sysRoles);
		user.setSysRoles(roles);
		doUpdate(user);
	}

	public void doChangePassword(Long userId, String newPassword) {
		Assert.notNull(userId);
		String hql = "update SysUser set password=:password where id=:id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("password", EncryptUtil.encodePassword(newPassword));
		params.put("id", userId);
		userDao.hqlExecute(hql, params);

	}

	public SysUser doCreate(SysUser sysUser) {
		Assert.notNull(sysUser);
		userDao.saveOrUpdate(sysUser);
		return sysUser;
	}

	public void doDelete(SysUser sysUser) {
		Assert.notNull(sysUser);
		userDao.remove(sysUser);
	}

	public List<SysUser> findAll() {
		return userDao.findAll();
	}

	public SysUser findById(Long id) {
		Assert.notNull(id);
		return userDao.findById(id);
	}

	public SysUser findByUsername(String username) {
		Assert.notNull(username);
		String hql = "from SysUser where username=:username and markForDelete=:markForDelete";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		params.put("markForDelete", false);
		List<SysUser> result = userDao.query(hql, params);
		if (result != null && result.size() > 0)
			return result.get(0);
		return null;
	}

	public PageResult<SysUser> findByCriteria(QueryCriteria criteria) {
		String queryEntry = "select user";
		String[] whereBodies = new String[] {
				"user.type = :type",
				"user.username like :usernameLike",
				"user.realnameEn like :realnameEnLike",
				"user.realnameZh like :realnameZhLike",
				"user.mobile like :mobileLike", "user.email like :emailLike",
				"user.tsDepartmentId=:tsDepartmentId",
				"user.markForDelete=:markForDelete", "role.id=:roleId" };
		String fromJoinSubClause = "from SysUser user";
		if (criteria.getQueryCondition().get("roleId") != null) {
			fromJoinSubClause += " left join user.sysRoles role";
		}
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysUser> result = userDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public void doRemoveRolesFromUser(Long userId, Collection<SysRole> sysRoles) {
		Assert.notNull(userId);
		SysUser user = findById(userId);
		if (user == null) {
			return;
		}
		Set<SysRole> temp = new HashSet<SysRole>();
		temp.addAll(sysRoles);
		Set<SysRole> users = user.getSysRoles();
		users.removeAll(temp);
		user.setSysRoles(users);
		doUpdate(user);

	}

	public void doUpdate(SysUser sysUser) {
		userDao.saveOrUpdate(sysUser);
	}

	public void doUpdateDelete(List<SysUser> users) {
		for (int i = 0; i < users.size(); i++) {
			SysUser sysUser = findById(users.get(i).getId());
			sysUser.setMarkForDelete(true);
			userDao.saveOrUpdate(sysUser);
		}
	}

	public void doUpdateById(String id, String password) {
		SysUser sysUser = findById(Long.valueOf(id));
		sysUser.setPassword(EncryptUtil.encodePassword(password));
		userDao.saveOrUpdate(sysUser);
	}

	public PageResult<SysUser> findByCriteriaUserName(QueryCriteria criteria) {
		String queryEntry = "select user";
		String[] whereBodies = new String[] { "user.username like:username",
				"user.markForDelete=:markForDelete" };
		String fromJoinSubClause = "from SysUser user";
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysUser> result = (PageResult<SysUser>) userDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public PageResult<SysUser> findByCriteriaRoleId(QueryCriteria criteria) {
		String queryEntry = "select user";
		String[] whereBodies = new String[] { "role.roleId =:roleId",
				"user.username=:username", "user.email=:email",
				"user.realnameEn=:realnameEn", "user.telephone=:telephone",
				"user.realnameZh=:realnameZh", "user.tsDepartmentId=:deptNo" };
		String fromJoinSubClause = "from SysUser user ";
		if (criteria.getQueryCondition().get("roleId") != null) {
			fromJoinSubClause += " left join user.sysRoles role";
		}
		Map<String, Object> params = criteria.getQueryCondition();
		String orderField = criteria.getOrderField();
		String orderDirection = criteria.getOrderDirection();
		String hql = HqlUtils.generateHql(queryEntry, fromJoinSubClause,
				whereBodies, orderField, orderDirection, params);
		int pageSize = criteria.getPageSize();
		int startIndex = criteria.getStartIndex();
		PageResult<SysUser> result = (PageResult<SysUser>) userDao.query(hql,
				HqlUtils.generateCountHql(hql, null), params, startIndex,
				pageSize);
		return result;
	}

	public List<SysUser> findLikeName(String userName, Long createUserId) {
		if (StringUtils.isEmpty(userName)) {
			return null;
		}
		return userDao.findLikeName(userName, createUserId);
	}

	private SysUser recoverSysUser(SysUser user) {
		// 新增的用户名原来存在,但是deleteFlag已经设定为已删除
		SysUser result = findByUsername(user.getUsername());
		// 利用原用户的ID，将这次新增的用户信息更新进去。
		result.setMarkForDelete(false);
		return result;
	}

	public List<SysUser> findAllOrderByUsername() {
		return userDao.findAllOrderByUsername();
	}

	public void doSoftDeleteByIds(List<Long> userIds) {
		if (userIds == null || userIds.size() < 0) {
			log.error("没有找到要删除的用户！");
			throw new BusinessException("BE0011");
		}
		for (Long userId : userIds) {
			SysUser sysUser = findById(userId);
			sysUser.setMarkForDelete(true);
			userDao.saveOrUpdate(sysUser);
		}
	}

	public String doSaveOrRecover(SysUser user) {
		if (user == null) {
			log.error("用户信息不能为null！");
			throw new BusinessException("BE0010");
		}
		String message = "success";
		if (user.getId() == null || user.getId() <= 0) {
			SysUser sysUser = this.findByUsername(user.getUsername());
			if (sysUser != null) {
				if (sysUser.getMarkForDelete()) {
					user = this.recoverSysUser(user);
					message = "recover";
				} else {
					return "exists";
				}
			}
			user.setId(null);
			//user.setType(1l);
			user.setPassword(EncryptUtil.encodePassword("1234"));
			this.doCreate(user);
		} else {
			this.doUpdate(user);
		}
		return message;
	}

	public SysUser getById(Long userId) {
		return userDao.getById(userId);
	}

	public void doUpdatePageSize(Long userId, Long newPageSize) {
		SysUser user = this.findById(userId);
		this.doUpdate(user);
	}

	public List<SysUser> findByIds(List<Long> userIds) {
		return userDao.findByIds(userIds);
	}

	public PageResult<SysUser> findByUpdateTime(Date date, int currentIndex,
			int pageSize, Long currentId) {
		PageResult<SysUser> sysUserPr = null;
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select tu from SysUser tu where tu.markForDelete = 0 ";
		if (date != null) {
			hql += " and tu.updatedDate>=:date ";
			params.put("date", date);
		}
		hql += " order by tu.updatedDate asc,tu.id asc ";
		sysUserPr = userDao.query(hql,
				HqlUtils.generateCountHql(hql.toString(), null), params,
				currentIndex, pageSize);
		return sysUserPr;
	}

	public void doUpdatePassword(SysUser user, String password) {
		user.setPassword(EncryptUtil.encodePassword(password));
		this.userDao.saveOrUpdate(user);
	}

	@Override
	public void doUpdateSessionUser(SysUser toBeUpdated) {
		this.userDao.saveOrUpdate(toBeUpdated);
	}

}
