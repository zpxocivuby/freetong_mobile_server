package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysBlackWhiteListService;
import itaf.framework.domain.platform.SysBlacklist;
import itaf.framework.domain.platform.SysWhitelist;
import itaf.framework.exception.bean.AppException;
import itaf.framework.persistence.platform.dao.ISysBlacklistDao;
import itaf.framework.persistence.platform.dao.ISysWhitelistDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysBlackWhiteListServiceImpl")
public class SysBlackWhiteListServiceImpl extends BaseServiceImpl implements
		ISysBlackWhiteListService {

	@Autowired
	private ISysWhitelistDao whiteListDao;

	@Autowired
	private ISysBlacklistDao blackListDao;

	public void checkUser(String username, String telephone,
			String whiteBlackType) {
		if (whiteBlackType.equals("0")) {
			return;
		} else if (whiteBlackType.equals("1")) {// 白名单开启
			List<SysWhitelist> whiteListList = whiteListDao
					.findByLoginName(username);
			if (whiteListList == null || whiteListList.size() == 0) {
				throw new AppException("User \"" + username
						+ "\" can not be found in whiteList, log in failed.");
			}
			SysWhitelist whiteList = whiteListList.get(0);
			if (!whiteList.getMobile().equals(telephone)) {
				throw new AppException(
						"User \""
								+ username
								+ "\" can not be found the telephoneNumber in whiteList, log in failed.");
			}
		} else if (whiteBlackType.equals("2")) {// 黑名单开启
			List<SysBlacklist> blackListList = blackListDao
					.findByLoginName(username);
			if (blackListList != null && blackListList.size() > 0) {
				throw new AppException("User \"" + username
						+ "\"  found in blackList, log in failed.");
			}
		}
	}
}
