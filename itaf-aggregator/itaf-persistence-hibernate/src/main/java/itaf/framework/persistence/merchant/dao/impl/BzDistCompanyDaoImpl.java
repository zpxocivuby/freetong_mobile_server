package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzDistCompanyDao;

import org.springframework.stereotype.Repository;

@Repository("bzDistCompanyDaoImpl")
public class BzDistCompanyDaoImpl extends BaseDaoImpl<BzDistCompany> implements
		IBzDistCompanyDao {

}