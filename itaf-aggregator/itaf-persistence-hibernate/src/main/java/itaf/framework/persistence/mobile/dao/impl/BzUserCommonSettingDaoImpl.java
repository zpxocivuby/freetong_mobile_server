package itaf.framework.persistence.mobile.dao.impl;

import itaf.framework.domain.mobile.BzUserCommonSetting;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.mobile.dao.IBzUserCommonSettingDao;

import org.springframework.stereotype.Repository;

@Repository("bzUserCommonSettingDaoImpl")
public class BzUserCommonSettingDaoImpl extends
		BaseDaoImpl<BzUserCommonSetting> implements IBzUserCommonSettingDao {

}