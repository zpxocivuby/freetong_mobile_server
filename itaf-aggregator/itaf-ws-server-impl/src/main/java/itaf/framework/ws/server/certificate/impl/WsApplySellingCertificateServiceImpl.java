package itaf.framework.ws.server.certificate.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.certificate.service.IBzApplySellingCertificateService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.certificate.dto.BzApplySellingCertificateDto;
import itaf.framework.common.dto.BzAttachmentDto;
import itaf.framework.domain.certificate.BzApplySellingCertificate;
import itaf.framework.workflow.dto.BzApprovalInfoDto;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.certificate.WsApplySellingCertificateService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsApplySellingCertificateServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.certificate.WsApplySellingCertificateService", serviceName = "WsApplySellingCertificateService")
public class WsApplySellingCertificateServiceImpl extends
		WsBaseImpl<BzApplySellingCertificateDto> implements
		WsApplySellingCertificateService {

	@Autowired
	private IBzApplySellingCertificateService bzApplySellingCertificateService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ApprovalInfoService approvalInfoService;

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzApplySellingCertificateDto dto = (BzApplySellingCertificateDto) decodeBase64(dtoString);
			BzApplySellingCertificate bzApplySellingCertificate = new BzApplySellingCertificate();
			bzApplySellingCertificate.setSysUserId(dto.getSysUserDto().getId());
			bzApplySellingCertificate
					.setBzAttachmentId(dto.getBzAttachmentId());
			bzApplySellingCertificate.setCompanyName(dto.getCompanyName());
			bzApplySellingCertificate
					.setCompanyAddress(dto.getCompanyAddress());
			bzApplySellingCertificate.setServiceType(dto.getServiceType());
			bzApplySellingCertificate.setServiceCoverage(dto
					.getServiceCoverage());
			bzApplySellingCertificate.setApprovalStatus(1L);
			bzApplySellingCertificate.setApprovalState(1L);
			bzApplySellingCertificateService
					.doSubmitApply(bzApplySellingCertificate);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzApplySellingCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId) {
		WsPageResult<BzApplySellingCertificateDto> pr = new WsPageResult<BzApplySellingCertificateDto>();
		try {
			// List<BzApprovalInfoDto> result = new
			// ArrayList<BzApprovalInfoDto>();
			BzApplySellingCertificate bzApplySellingCertificate = bzApplySellingCertificateService
					.getByBzConsumerId(bzConsumerId);
			// List<BzApprovalInfo> bzApprovalInfoList = approvalInfoService
			// .findByProcessInstanceId(bzApplySellingCertificate
			// .getProcessInstanceId());

			BzApplySellingCertificateDto bzApplySellingCertificateDto = new BzApplySellingCertificateDto();
			bzApplySellingCertificateDto = CopyPropertiesCglibHelper
					.copyProperties(BzApplySellingCertificateDto.class,
							bzApplySellingCertificate);
			bzApplySellingCertificateDto
					.setBzAttachmentDto(CopyPropertiesCglibHelper
							.copyProperties(BzAttachmentDto.class,
									bzApplySellingCertificate.getBzAttachment()));

			// if (bzApprovalInfoList != null && bzApprovalInfoList.size() > 0)
			// {
			// for (BzApprovalInfo approvalInfo : bzApprovalInfoList) {
			// BzApprovalInfoDto bzApprovalInfoDto = new BzApprovalInfoDto();
			// BeanUtils.copyProperties(bzApprovalInfoDto, approvalInfo);
			// result.add(bzApprovalInfoDto);
			// }
			// }
			// bzSellingServiceApplyDto.setBzApprovalInfos(result);

			// TODO
			List<BzApprovalInfoDto> bzApprovalInfos = new ArrayList<BzApprovalInfoDto>();
			BzApprovalInfoDto bzApprovalInfoDto1 = new BzApprovalInfoDto();
			bzApprovalInfoDto1.setProcessInstanceId("processInstanceId1");
			bzApprovalInfoDto1.setTaskId("taskId1");
			bzApprovalInfoDto1.setBussinessKey("bussinessKey1");
			bzApprovalInfoDto1.setActivityName("activityName1");
			bzApprovalInfoDto1.setApprovalName("approvalName1");
			bzApprovalInfoDto1.setApprovalState("3");
			bzApprovalInfoDto1.setApprovalInfo("approvalInfo1");
			bzApprovalInfoDto1.setApprovalTime(new Date());
			bzApprovalInfoDto1.setState("2");
			bzApprovalInfos.add(bzApprovalInfoDto1);
			BzApprovalInfoDto bzApprovalInfoDto2 = new BzApprovalInfoDto();
			bzApprovalInfoDto2.setProcessInstanceId("processInstanceId2");
			bzApprovalInfoDto2.setTaskId("taskId2");
			bzApprovalInfoDto2.setBussinessKey("bussinessKey");
			bzApprovalInfoDto2.setActivityName("activityName2");
			bzApprovalInfoDto2.setApprovalName("approvalName2");
			bzApprovalInfoDto2.setApprovalState("3");
			bzApprovalInfoDto2.setApprovalInfo("approvalInfo2");
			bzApprovalInfoDto2.setApprovalTime(new Date());
			bzApprovalInfoDto2.setState("2");
			bzApprovalInfos.add(bzApprovalInfoDto2);
			bzApplySellingCertificateDto.setBzApprovalInfos(bzApprovalInfos);

			pr.getContent().add(bzApplySellingCertificateDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzApplySellingCertificateDto getObject() {
		return new BzApplySellingCertificateDto();
	}

}
