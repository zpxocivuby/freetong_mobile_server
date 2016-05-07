package itaf.framework.ws.server.certificate.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.certificate.service.IBzApplyRealnameCertificateService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.certificate.dto.BzApplyRealnameCertificateDto;
import itaf.framework.common.dto.BzAttachmentDto;
import itaf.framework.domain.certificate.BzApplyRealnameCertificate;
import itaf.framework.platform.dto.SysUserDto;
import itaf.framework.workflow.dto.BzApprovalInfoDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.certificate.WsApplyRealnameCertificateService;
import itaf.framework.ws.server.util.CopyPropertiesCglibHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wsApplyRealnameCertificateServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.certificate.WsApplyRealnameCertificateService", serviceName = "WsApplyRealnameCertificateService")
public class WsApplyRealnameCertificateServiceImpl extends
		WsBaseImpl<BzApplyRealnameCertificateDto> implements
		WsApplyRealnameCertificateService {

	@Autowired
	private IBzApplyRealnameCertificateService bzApplyRealnameCertificateService;
	@Autowired
	private ISysUserService sysUserService;

	public WsPageResult<String> submitApply(
			@WebParam(name = "dtoString") String dtoString) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			BzApplyRealnameCertificateDto dto = (BzApplyRealnameCertificateDto) decodeBase64(dtoString);
			BzApplyRealnameCertificate bzApplyRealnameCertificate = new BzApplyRealnameCertificate();
			bzApplyRealnameCertificate
					.setSysUserId(dto.getSysUserDto().getId());
			bzApplyRealnameCertificate.setBzAttachmentId(dto
					.getBzAttachmentId());
			bzApplyRealnameCertificate.setName(dto.getName());
			bzApplyRealnameCertificate.setSex(dto.getSex());
			bzApplyRealnameCertificate.setBirthdate(dto.getBirthdate());
			bzApplyRealnameCertificate.setMobile(dto.getMobile());
			bzApplyRealnameCertificate.setIdType(dto.getIdType());
			bzApplyRealnameCertificate.setIdNo(dto.getIdNo());
			bzApplyRealnameCertificate.setApprovalState(1L);
			bzApplyRealnameCertificateService
					.doSubmitApply(bzApplyRealnameCertificate);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	public WsPageResult<BzApplyRealnameCertificateDto> getByBzConsumerId(
			@WebParam(name = "bzConsumerId") Long bzConsumerId) {
		WsPageResult<BzApplyRealnameCertificateDto> pr = new WsPageResult<BzApplyRealnameCertificateDto>();
		try {
			BzApplyRealnameCertificate bzApplyRealnameCertificate = bzApplyRealnameCertificateService
					.getByBzConsumerId(bzConsumerId);
			BzApplyRealnameCertificateDto bzApplyRealnameCertificateDto = CopyPropertiesCglibHelper
					.copyProperties(BzApplyRealnameCertificateDto.class,
							bzApplyRealnameCertificate);
			bzApplyRealnameCertificateDto
					.setSysUserDto(CopyPropertiesCglibHelper.copyProperties(
							SysUserDto.class,
							bzApplyRealnameCertificate.getSysUser()));
			bzApplyRealnameCertificateDto
					.setBzAttachmentDto(CopyPropertiesCglibHelper
							.copyProperties(BzAttachmentDto.class,
									bzApplyRealnameCertificate
											.getBzAttachment()));
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
			bzApplyRealnameCertificateDto.setBzApprovalInfos(bzApprovalInfos);

			pr.getContent().add(bzApplyRealnameCertificateDto);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public BzApplyRealnameCertificateDto getObject() {
		return new BzApplyRealnameCertificateDto();
	}

	public BzApprovalInfoDto getBzApprovalInfoDtoObject() {
		return new BzApprovalInfoDto();
	}

}
