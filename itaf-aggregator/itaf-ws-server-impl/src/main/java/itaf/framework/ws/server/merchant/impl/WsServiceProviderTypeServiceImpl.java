package itaf.framework.ws.server.merchant.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.merchant.service.IBzServiceProviderTypeService;
import itaf.framework.domain.merchant.BzServiceProviderType;
import itaf.framework.merchant.dto.BzServiceProviderTypeDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.merchant.WsServiceProviderTypeService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsServiceProviderTypeServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.merchant.WsServiceProviderTypeService", serviceName = "WsServiceProviderTypeService")
public class WsServiceProviderTypeServiceImpl extends
		WsBaseImpl<BzServiceProviderTypeDto> implements
		WsServiceProviderTypeService {

	@Autowired
	private IBzServiceProviderTypeService bzServiceProviderTypeService;

	public WsPageResult<BzServiceProviderTypeDto> syncToClient(
			@WebParam(name = "updateTime") String updateTime) {
		WsPageResult<BzServiceProviderTypeDto> pr = new WsPageResult<BzServiceProviderTypeDto>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
		Date upTime = null;
		try {
			if (updateTime != null && !updateTime.equals("")) {
				upTime = sdf.parse(updateTime);
			}
			List<BzServiceProviderType> bzServiceProviderTypeList = bzServiceProviderTypeService
					.findByUpdateTime(upTime);

			List<BzServiceProviderTypeDto> bzServiceProviderTypeDtoList = new ArrayList<BzServiceProviderTypeDto>();
			for (int i = 0; i < bzServiceProviderTypeList.size(); i++) {
				BzServiceProviderTypeDto bzServiceProviderTypeDto = new BzServiceProviderTypeDto();
				BzServiceProviderType bzServiceProviderType = bzServiceProviderTypeList
						.get(i);
				bzServiceProviderTypeDto = CopyPropertiesCglibHelper
						.copyProperties(BzServiceProviderTypeDto.class,
								bzServiceProviderType);
				bzServiceProviderTypeDtoList.add(bzServiceProviderTypeDto);
			}
			pr.setContent(bzServiceProviderTypeDtoList);
			if (bzServiceProviderTypeDtoList != null
					&& bzServiceProviderTypeDtoList.size() > 0) {
				pr.setTotalCount(bzServiceProviderTypeDtoList.size());
			} else {
				pr.setTotalCount(0);
			}
			pr.setStatus("1");
		} catch (Exception e) {
			log.debug(e.toString());
			pr.setStatus("0");
			pr.setStatusCode(e.toString());
		}
		return pr;
	}

	@Override
	public BzServiceProviderTypeDto getObject() {
		return new BzServiceProviderTypeDto();
	}
}
