package itaf.framework.ws.server.order.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.order.service.IBzPaymentTypeService;
import itaf.framework.domain.order.BzPaymentType;
import itaf.framework.order.dto.BzPaymentTypeDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.order.WsPaymentTypeService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsPaymentTypeServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.order.WsPaymentTypeService", serviceName = "WsPaymentTypeService")
public class WsPaymentTypeServiceImpl extends WsBaseImpl<BzPaymentTypeDto>
		implements WsPaymentTypeService {
	
	@Autowired
	private IBzPaymentTypeService bzPaymentTypeService;
	
	public WsPageResult<BzPaymentTypeDto> findList() {
		WsPageResult<BzPaymentTypeDto> pr = new WsPageResult<BzPaymentTypeDto>();
		try{
			List<BzPaymentType> bzPaymentTypeList = bzPaymentTypeService.findAll();
			List<BzPaymentTypeDto> bzPaymentTypeDtoList = new ArrayList<BzPaymentTypeDto>();
			for(int i=0; i<bzPaymentTypeList.size(); i++){
				BzPaymentType bzPaymentType = bzPaymentTypeList.get(i);
				BzPaymentTypeDto bzPaymentTypeDto = new BzPaymentTypeDto();
				bzPaymentTypeDto = CopyPropertiesCglibHelper.copyProperties(BzPaymentTypeDto.class, bzPaymentType);
				bzPaymentTypeDtoList.add(bzPaymentTypeDto);
			}
			pr.setContent(bzPaymentTypeDtoList);
			pr.setStatus("1");
		}catch(Exception e){
			log.error(e);
			pr.setStatus("0");
			pr.setStatusCode(e.toString());
		}
		return pr;
	}

	@Override
	public BzPaymentTypeDto getObject() {
		return new BzPaymentTypeDto();
	}
}
