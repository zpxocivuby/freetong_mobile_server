package itaf.framework.ws.server.certificate.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.certificate.service.IBzApplyDistCertificateService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.certificate.dto.BzApplyDistCertificateDto;
import itaf.framework.common.dto.BzAttachmentDto;
import itaf.framework.domain.certificate.BzApplyDistCertificate;
import itaf.framework.workflow.dto.BzApprovalInfoDto;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.certificate.WsApplyDistCertificateService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsApplyDistCertificateServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.certificate.WsApplyDistCertificateService", serviceName = "WsApplyDistCertificateService")
public class WsApplyDistCertificateServiceImpl extends
		WsBaseImpl<BzApplyDistCertificateDto> implements
		WsApplyDistCertificateService {

	@Autowired
	private IBzApplyDistCertificateService bzApplyDistCertificateService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private ApprovalInfoService approvalInfoService;

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzApplyDistCertificateDto dto = (BzApplyDistCertificateDto) decodeBase64(dtoString);
			BzApplyDistCertificate bzApplyDistCertificate = new BzApplyDistCertificate();
			bzApplyDistCertificate.setSysUserId(dto.getSysUserDto().getId());
			bzApplyDistCertificate.setBzAttachmentId(dto.getBzAttachmentId());
			bzApplyDistCertificate.setCompanyName(dto.getCompanyName());
			bzApplyDistCertificate.setCompanyAddress(dto.getCompanyAddress());
			bzApplyDistCertificate.setServiceType(dto.getServiceType());
			bzApplyDistCertificate.setServiceCoverage(dto.getServiceCoverage());
			bzApplyDistCertificate.setApprovalStatus(1L);
			bzApplyDistCertificate.setApprovalState(1L);
			bzApplyDistCertificateService.doSubmitApply(bzApplyDistCertificate);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzApplyDistCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId) {
		WsPageResult<BzApplyDistCertificateDto> pr = new WsPageResult<BzApplyDistCertificateDto>();
		try {
			// List<BzApprovalInfoDto> result = new
			// ArrayList<BzApprovalInfoDto>();
			BzApplyDistCertificate bzApplyDistCertificate = bzApplyDistCertificateService
					.getByBzConsumerId(bzConsumerId);
			// List<BzApprovalInfo> bzApprovalInfoList = approvalInfoService
			// .findByProcessInstanceId(bzApplyDistCertificate
			// .getProcessInstanceId());

			BzApplyDistCertificateDto bzApplyDistCertificateDto = new BzApplyDistCertificateDto();
			bzApplyDistCertificateDto = CopyPropertiesCglibHelper
					.copyProperties(BzApplyDistCertificateDto.class,
							bzApplyDistCertificate);
			bzApplyDistCertificateDto
					.setBzAttachmentDto(CopyPropertiesCglibHelper
							.copyProperties(BzAttachmentDto.class,
									bzApplyDistCertificate.getBzAttachment()));

			// if (bzApprovalInfoList != null && bzApprovalInfoList.size() > 0)
			// {
			// for (BzApprovalInfo approvalInfo : bzApprovalInfoList) {
			// BzApprovalInfoDto bzApprovalInfoDto = new BzApprovalInfoDto();
			// BeanUtils.copyProperties(bzApprovalInfoDto, approvalInfo);
			// result.add(bzApprovalInfoDto);
			// }
			// }
			// bzDistServiceApplyDto.setBzApprovalInfos(result);

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
			bzApplyDistCertificateDto.setBzApprovalInfos(bzApprovalInfos);

			pr.getContent().add(bzApplyDistCertificateDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzApplyDistCertificateDto getObject() {
		return new BzApplyDistCertificateDto();
	}

}
