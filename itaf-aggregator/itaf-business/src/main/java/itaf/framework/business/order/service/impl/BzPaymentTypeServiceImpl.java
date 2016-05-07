package itaf.framework.business.order.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.order.service.IBzPaymentTypeService;
import itaf.framework.domain.order.BzPaymentType;
import itaf.framework.persistence.order.dao.IBzPaymentTypeDao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzPaymentTypeServiceImpl")
public class BzPaymentTypeServiceImpl extends BaseServiceImpl implements
		IBzPaymentTypeService {

	@Autowired
	private IBzPaymentTypeDao bzPaymentTypeDao;

	public List<BzPaymentType> findAll() {
		return bzPaymentTypeDao.query("from BzPaymentType b",
				new HashMap<String, Object>());
	}

	public BzPaymentType getById(Long bzPaymentTypeId) {
		return bzPaymentTypeDao.getById(bzPaymentTypeId);
	}

}