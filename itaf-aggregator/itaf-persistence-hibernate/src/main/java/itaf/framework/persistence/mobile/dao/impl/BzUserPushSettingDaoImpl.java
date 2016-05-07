package itaf.framework.persistence.mobile.dao.impl;

import itaf.framework.domain.mobile.BzUserPushSetting;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.mobile.dao.IBzUserPushSettingDao;

import org.springframework.stereotype.Repository;

@Repository("bzUserPushSettingDaoImpl")
public class BzUserPushSettingDaoImpl extends BaseDaoImpl<BzUserPushSetting>
		implements IBzUserPushSettingDao {

}