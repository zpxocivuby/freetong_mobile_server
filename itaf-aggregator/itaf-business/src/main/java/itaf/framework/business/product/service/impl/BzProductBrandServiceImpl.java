package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.product.service.IBzProductBrandService;
import itaf.framework.domain.product.BzProductBrand;
import itaf.framework.persistence.product.dao.IBzProductBrandDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzProductBrandServiceImpl")
public class BzProductBrandServiceImpl extends BaseServiceImpl implements
		IBzProductBrandService {
	@Autowired
	private IBzProductBrandDao bzProductBrandDao;
	
	public BzProductBrand getById(Long id){
		return bzProductBrandDao.findById(id);
	}
}