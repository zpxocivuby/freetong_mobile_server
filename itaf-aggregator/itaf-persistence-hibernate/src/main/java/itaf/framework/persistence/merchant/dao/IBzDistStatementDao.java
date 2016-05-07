package itaf.framework.persistence.merchant.dao;

import itaf.framework.domain.merchant.BzDistStatement;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IBzDistStatementDao extends IBaseDao<BzDistStatement> {

	List<BzDistStatement> findByIds(List<Long> bzDistStatementIds);

	BigDecimal sum(final String hql, final Map<String, Object> params);

}
