package itaf.framework.cache.business.service;

import itaf.framework.domain.platform.SysCodeList;

import java.util.List;

/**
 * 
 *
 *
 * @author XINXIN
 *
 * @UpdateDate 2014年8月6日
 */
public interface ICacheCodeListService {

	List<SysCodeList> getCacheListByType(String codeType);

	SysCodeList getCacheByTypeAndValue(String typeAndValue);

}
