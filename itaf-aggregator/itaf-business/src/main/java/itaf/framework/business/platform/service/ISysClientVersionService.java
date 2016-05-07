package itaf.framework.business.platform.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysClientVersion;

import java.util.List;

public interface ISysClientVersionService {

	PageResult<SysClientVersion> findByCriteria(QueryCriteria criteria);

	public SysClientVersion getNewVesion(String type);

	void doSaveOrUpdate(SysClientVersion clientPublicVersion);

	SysClientVersion findById(Long id);

	List<SysClientVersion> findByStatus(String status);

}
