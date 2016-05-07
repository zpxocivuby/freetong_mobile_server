package itaf.framework.persistence.mobile.dao.impl;

import itaf.framework.domain.mobile.BzUserSyncSetting;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.mobile.dao.IBzUserSyncSettingDao;

import org.springframework.stereotype.Repository;

@Repository("bzUserSyncSettingDaoImpl")
public class BzUserSyncSettingDaoImpl extends BaseDaoImpl<BzUserSyncSetting>
		implements IBzUserSyncSettingDao {

}