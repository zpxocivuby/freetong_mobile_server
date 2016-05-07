package itaf.framework.ws.server.platform.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.platform.dto.SysAttachmentDto;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.platform.WsSysAttachmentService;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wsSysAttachmentServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.platform.WsSysAttachmentService")
public class WsSysAttachmentServiceImpl extends WsBaseImpl<SysAttachmentDto>
		implements WsSysAttachmentService {

	@Autowired
	private ISysAttachmentService attachmentService;

	public WsPageResult<SysAttachmentDto> findByClueId(
			@WebParam(name = "clueId") Long clueId) {
		// List<SysAttachment> bizAttachmentList = attachmentService
		// .findByClueId(clueId);
		// List<AttachmentDto> attachmentDtoList = new
		// ArrayList<AttachmentDto>();
		// for (int i = 0; i < bizAttachmentList.size(); i++) {
		// AttachmentDto attachmentDto = new AttachmentDto();
		// SysAttachment bizAttachment = bizAttachmentList.get(i);
		// attachmentDto.setId(bizAttachment.getId());
		// attachmentDto.setSrcFileName(bizAttachment.getSrcFileName());
		// attachmentDto.setFileName(bizAttachment.getFileName());
		// attachmentDto.setFileType(bizAttachment.getFileType());
		// attachmentDto.setFileExt(bizAttachment.getFileExt());
		// attachmentDtoList.add(attachmentDto);
		// }
		// TODO
		return new WsPageResult<SysAttachmentDto>();
	}

	@Override
	public SysAttachmentDto getObject() {
		return new SysAttachmentDto();
	}
}
