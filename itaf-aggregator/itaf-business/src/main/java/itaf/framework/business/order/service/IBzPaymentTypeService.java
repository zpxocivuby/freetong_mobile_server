package itaf.framework.business.order.service;

import itaf.framework.domain.order.BzPaymentType;

import java.util.List;

public interface IBzPaymentTypeService {

	public List<BzPaymentType> findAll();

	public BzPaymentType getById(Long bzPaymentTypeId);

}
