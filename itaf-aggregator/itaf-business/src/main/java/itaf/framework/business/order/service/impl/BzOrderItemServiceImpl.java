package itaf.framework.business.order.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.order.service.IBzOrderItemService;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.persistence.order.dao.IBzOrderItemDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzOrderItemServiceImpl")
public class BzOrderItemServiceImpl extends BaseServiceImpl implements
		IBzOrderItemService {

	@Autowired
	private IBzOrderItemDao bzOrderItemDao;

	public List<BzOrderItem> findByIds(String bzOrderItemIds) {
		return bzOrderItemDao.findByIds(StringHelper
				.stringToLongList(bzOrderItemIds));
	}

}