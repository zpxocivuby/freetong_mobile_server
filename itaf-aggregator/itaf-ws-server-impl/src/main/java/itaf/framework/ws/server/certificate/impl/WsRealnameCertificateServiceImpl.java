package itaf.framework.ws.server.certificate.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.certificate.service.IBzApplyRealnameCertificateService;
import itaf.framework.business.certificate.service.IBzRealnameCertificateService;
import itaf.framework.certificate.dto.BzApplyRealnameCertificateDto;
import itaf.framework.certificate.dto.BzRealnameCertificateDto;
import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.workflow.dto.BzApprovalInfoDto;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.certificate.WsRealnameCertificateService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsRealnameCertificateServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.certificate.WsRealnameCertificateService", serviceName = "WsRealnameCertificateService")
public class WsRealnameCertificateServiceImpl extends
		WsBaseImpl<BzRealnameCertificateDto> implements
		WsRealnameCertificateService {

	@Autowired
	private IBzRealnameCertificateService bzRealnameCertificateService;

	@Autowired
	private IBzApplyRealnameCertificateService bzRealnameCertificateApplyService;

	@Autowired
	private ApprovalInfoService approvalInfoService;

	public WsPageResult<BzApplyRealnameCertificateDto> findCertificating(
			@WebParam(name = "userId") Long userId) {
		WsPageResult<BzApplyRealnameCertificateDto> pr = new WsPageResult<BzApplyRealnameCertificateDto>();
		try {
			List<BzApprovalInfoDto> result = new ArrayList<BzApprovalInfoDto>();
			BzApplyRealnameCertificate bzRealnameCertificateApply = bzRealnameCertificateApplyService
					.getByBzConsumerId(userId);
			List<BzApprovalInfo> bzApprovalInfoList = approvalInfoService
					.findByProcessInstanceId(bzRealnameCertificateApply
							.getProcessInstanceId());

			BzApplyRealnameCertificateDto bzRealnameCertificateApplyDto = new BzApplyRealnameCertificateDto();
			bzRealnameCertificateApplyDto = CopyPropertiesCglibHelper
					.copyProperties(BzApplyRealnameCertificateDto.class,
							bzRealnameCertificateApply);

			if (bzApprovalInfoList != null && bzApprovalInfoList.size() > 0) {
				for (BzApprovalInfo approvalInfo : bzApprovalInfoList) {
					BzApprovalInfoDto bzApprovalInfoDto = new BzApprovalInfoDto();
					BeanUtils.copyProperties(bzApprovalInfoDto, approvalInfo);
					result.add(bzApprovalInfoDto);
				}
			}
			bzRealnameCertificateApplyDto.setBzApprovalInfos(result);

			List<BzApplyRealnameCertificateDto> bzRealnameCertificateApplyDtoList = new ArrayList<BzApplyRealnameCertificateDto>();
			bzRealnameCertificateApplyDtoList
					.add(bzRealnameCertificateApplyDto);
			pr.setContent(bzRealnameCertificateApplyDtoList);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzApplyRealnameCertificateDto> findCertificated(
			@WebParam(name = "userId") Long userId) {
		WsPageResult<BzApplyRealnameCertificateDto> pr = new WsPageResult<BzApplyRealnameCertificateDto>();
		try {
			BzApplyRealnameCertificate bzRealnameCertificateApply = bzRealnameCertificateApplyService
					.getByBzConsumerId(userId);
			List<BzApplyRealnameCertificateDto> bzRealnameCertificateApplyDtoList = new ArrayList<BzApplyRealnameCertificateDto>();
			if (bzRealnameCertificateApply != null) {
				BzApplyRealnameCertificateDto BzRealnameCertificateApplyDto = CopyPropertiesCglibHelper
						.copyProperties(BzApplyRealnameCertificateDto.class,
								bzRealnameCertificateApply);
				bzRealnameCertificateApplyDtoList
						.add(BzRealnameCertificateApplyDto);
			}
			pr.setContent(bzRealnameCertificateApplyDtoList);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzRealnameCertificateDto getObject() {
		return new BzRealnameCertificateDto();
	}
}
