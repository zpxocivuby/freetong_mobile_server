package itaf.framework.business.platform.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.platform.SysClientPublish;

public interface ISysClientPublishService {

	PageResult<SysClientPublish> findByCriteria(QueryCriteria criteria);

	SysClientPublish findById(Long id);

	void doSaveOrUpdate(SysClientPublish clientPublicOpInfo);

	void doPublish(SysClientPublish clientPublicOpInfo);

	void doAbandon(SysClientPublish clientPublicOpInfo);

}
