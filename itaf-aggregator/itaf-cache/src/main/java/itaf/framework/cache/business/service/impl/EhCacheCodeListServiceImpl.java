package itaf.framework.cache.business.service.impl;

import itaf.framework.business.platform.service.ISysCodeListService;
import itaf.framework.cache.aop.base.ICacheObject;
import itaf.framework.cache.aop.base.IRefreshCacheService;
import itaf.framework.cache.business.service.ICacheCodeListService;
import itaf.framework.domain.platform.SysCodeList;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * 
 * @author XINXIN
 * 
 * @UpdateDate 2014年8月6日
 */
@Service("ehCacheCodeListServiceImpl")
public class EhCacheCodeListServiceImpl implements ICacheCodeListService,
		IRefreshCacheService {

	private static final String CODE_LIST_KEY = "code_list_key_";

	@Autowired(required = false)
	@Qualifier("ehCacheObjectImpl")
	private ICacheObject<SysCodeList> cacheCodeList;

	@Autowired(required = false)
	@Qualifier("ehCacheObjectImpl")
	private ICacheObject<Vector<SysCodeList>> cacheListCodeList;

	@Autowired
	private ISysCodeListService codeListService;

	@Override
	public void refreshCache() {
		cacheCodeList.clearByPrefix(CODE_LIST_KEY);
		List<SysCodeList> codeList = codeListService.findAll();
		for (SysCodeList scl : codeList) {
			String codeType = scl.getSysCodeType().getCodeType();
			cacheCodeList.cacheObject(
					CODE_LIST_KEY + codeType + "," + scl.getCodeValue(), scl);
			if (cacheListCodeList.getByKey(CODE_LIST_KEY + codeType) == null) {
				Vector<SysCodeList> clist = new Vector<SysCodeList>();
				clist.add(scl);
				cacheListCodeList.cacheObject(CODE_LIST_KEY + codeType, clist);
			} else {
				cacheListCodeList.getByKey(CODE_LIST_KEY + codeType).add(scl);
			}
		}
	}

	@Override
	public List<SysCodeList> getCacheListByType(String codeType) {
		return cacheListCodeList.getByKey(CODE_LIST_KEY + codeType);
	}

	@Override
	public SysCodeList getCacheByTypeAndValue(String typeAndValue) {
		return cacheCodeList.getByKey(CODE_LIST_KEY + typeAndValue);
	}

}
