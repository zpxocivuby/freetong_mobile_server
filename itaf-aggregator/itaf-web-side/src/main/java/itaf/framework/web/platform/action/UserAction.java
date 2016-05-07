package itaf.framework.web.platform.action;

import itaf.framework.business.consumer.service.IBzConsumerService;
import itaf.framework.business.merchant.service.IBzDistCompanyService;
import itaf.framework.business.merchant.service.IBzMerchantService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.core.util.EncryptUtil;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.merchant.BzDistCompany;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.CodeListHelper;
import itaf.framework.web.util.DataProcessHelper;
import itaf.framework.web.util.ProcessQueryUtil;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

/**
 * @author wzs user新增改查功能
 */
@ManagedBean(name = "userAction")
@ViewScoped
public class UserAction extends BaseRichFacesDataGridAction<SysUser> {

	private static final long serialVersionUID = 1L;

	private static final String METHOD_RESET_PASSWORD = "METHOD_";

	@ManagedProperty(value = "#{sysUserServiceImpl}")
	private ISysUserService userService;

	@ManagedProperty(value = "#{bzConsumerServiceImpl}")
	private IBzConsumerService consumerService;

	@ManagedProperty(value = "#{bzMerchantServiceImpl}")
	private IBzMerchantService bzMerchantService;

	@ManagedProperty(value = "#{bzDistCompanyServiceImpl}")
	private IBzDistCompanyService bzDistCompanyService;

	private Long userId;

	private SysUser sysUser;

	private BzConsumer bzConsumer;

	private BzMerchant bzMerchant;

	private BzDistCompany bzDistCompany;

	private String relName = "";

	private String shortRelName = "";

	private List<SelectItem> selectType;
	
	private List<SelectItem> selectSex;
	
	private List<SelectItem> selectIdType;

	private Long type;

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public void setBzConsumer(BzConsumer bzConsumer) {
		this.bzConsumer = bzConsumer;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
	}

	public void setBzDistCompany(BzDistCompany bzDistCompany) {
		this.bzDistCompany = bzDistCompany;
	}

	public IBzMerchantService getBzMerchantService() {
		return bzMerchantService;
	}

	public void setBzMerchantService(IBzMerchantService bzMerchantService) {
		this.bzMerchantService = bzMerchantService;
	}

	public IBzDistCompanyService getBzDistCompanyService() {
		return bzDistCompanyService;
	}

	public void setBzDistCompanyService(
			IBzDistCompanyService bzDistCompanyService) {
		this.bzDistCompanyService = bzDistCompanyService;
	}
	
	public List<SelectItem> getSelectIdType() {
		this.selectIdType = CodeListHelper
				.initCheckBox(CodeListConstant.SIDE_SYS_USER_IDTYPE);
		return selectIdType;
	}

	public void setSelectIdType(List<SelectItem> selectIdType) {
		this.selectIdType = selectIdType;
	}

	public List<SelectItem> getSelectSex() {
		this.selectSex = CodeListHelper
				.initCheckBox(CodeListConstant.SIDE_SYS_USER_SEX);
		return selectSex;
	}

	public void setSelectSex(List<SelectItem> selectSex) {
		this.selectSex = selectSex;
	}

	public List<SelectItem> getSelectType() {
		this.selectType = CodeListHelper
				.initCheckBox(CodeListConstant.SIDE_SYS_USER_TYPE);
		return selectType;
	}

	public void setSelectType(List<SelectItem> selectType) {
		this.selectType = selectType;
	}

	public IBzConsumerService getConsumerService() {
		return consumerService;
	}

	public void setConsumerService(IBzConsumerService consumerService) {
		this.consumerService = consumerService;
	}

	@Override
	protected PageResult<SysUser> getPageContent() {
		processQueryCondiction();
		return userService.findByCriteria(queryCriteria);
	}

	@Override
	protected void execute() {
		if (METHOD_SAVE.equals(this.getMethodType())) {
			this.save();
		} else if (METHOD_DELETE.equals(this.getMethodType())) {
			this.delete();
		} else if (METHOD_RESET_PASSWORD.equals(this.getMethodType())) {
			this.resetPassword();
		} else if ("saveBzConsumer".equals(this.getMethodType())) {
			this.saveBzConsumer();
		} else if ("saveBzMerchant".equals(this.getMethodType())) {
			this.saveBzMerchant();
		} else if ("saveBzDistCompany".equals(this.getMethodType())) {
			this.saveBzDistCompany();
		} else if ("saveBzDistMerchantCompany".equals(this.getMethodType())) {
			this.saveBzDistMerchantCompany();
		}

	}

	public SysUser getSysUser() {
		if (sysUser == null) {
			String userIdStr = ProcessQueryUtil.getValueOfForm("userId");
			if (StringUtils.trimToNull(userIdStr) != null) {
				sysUser = userService.findById(Long.parseLong(userIdStr));
			}
		}
		if (sysUser == null) {
			sysUser = new SysUser();
		}
		return sysUser;
	}

	public BzConsumer getBzConsumer() {
		if (bzConsumer == null) {
			String bzConsumerIdStr = ProcessQueryUtil
					.getValueOfForm("bzConsumerId");
			if (StringUtils.trimToNull(bzConsumerIdStr) != null) {
				bzConsumer = consumerService.getById(Long
						.parseLong(bzConsumerIdStr));
			}
		}
		if (bzConsumer == null) {
			bzConsumer = new BzConsumer();
		}
		return bzConsumer;
	}

	public BzMerchant getBzMerchant() {
		if (bzMerchant == null) {
			String bzMerchantStr = ProcessQueryUtil
					.getValueOfForm("bzMerchantId");
			if (StringUtils.trimToNull(bzMerchantStr) != null) {
				bzMerchant = bzMerchantService.getById(Long
						.parseLong(bzMerchantStr));
			}
		}
		if (bzMerchant == null) {
			bzMerchant = new BzMerchant();
		}
		return bzMerchant;
	}

	public BzDistCompany getBzDistCompany() {
		if (bzDistCompany == null) {
			String bzDistCompanyStr = ProcessQueryUtil
					.getValueOfForm("bzDistCompanyId");
			if (StringUtils.trimToNull(bzDistCompanyStr) != null) {
				bzDistCompany = bzDistCompanyService.getById(Long
						.parseLong(bzDistCompanyStr));
			}
		}
		if (bzDistCompany == null) {
			bzDistCompany = new BzDistCompany();
		}
		return bzDistCompany;
	}
	
	
	private void save() {
		SysUser user = this.getSysUser();
		user.setType(1l);
		String message = userService.doSaveOrRecover(user);
		this.setActionMsg(message);
	}

	private void saveBzConsumer() {
		try {
			BzConsumer bzConsumer = this.getBzConsumer();
			if(bzConsumer.getId()==null || bzConsumer.getId()==0){
				consumerService.doSaveBzConsumer(bzConsumer);
			}else{
				consumerService.doUpdateBzConsumer(bzConsumer);
			}
			this.setActionMsg("success");
		} catch (Exception e) {
			this.setActionMsg("failure");
		}
	}

	private void saveBzMerchant() {
		try {
			BzMerchant bzMerchant = this.getBzMerchant();
			if(bzMerchant.getId()==null || bzMerchant.getId()==0){
				bzMerchantService.doSaveBzMerchant(bzMerchant);
			}else{
				bzMerchantService.doUpdateBzMerchant(bzMerchant);
			}
			
			this.setActionMsg("success");
		} catch (Exception e) {
			this.setActionMsg("failure");
		}
		
	}

	private void saveBzDistCompany() {
		try {
			BzDistCompany bzDistCompany = this.getBzDistCompany();
			if(bzDistCompany.getId()==null || bzDistCompany.getId()==0){
				bzDistCompanyService.doSaveBzDistCompany(bzDistCompany);
			}else{
				bzDistCompanyService.doUpdateBzDistCompany(bzDistCompany);
			}
			this.setActionMsg("success");
		} catch (Exception e) {
			this.setActionMsg("failure");
		}
	}
	
	private void saveBzDistMerchantCompany(){
		try {
			BzMerchant bzMerchant = this.getBzMerchant();
			if(bzMerchant.getId()==null || bzMerchant.getId()==0){
				bzMerchantService.doSaveDistMerchant(bzMerchant);
			}else{
				bzMerchantService.doUpdateDistMerchant(bzMerchant);
			}
			
			this.setActionMsg("success");
		} catch (Exception e) {
			this.setActionMsg("failure");
		}
	}
	public String modiyfyPassword() {
		String userIdStr = ProcessQueryUtil.getValueOfForm("userId");
		String oldPassword = ProcessQueryUtil.getValueOfForm("oldPassword");
		String newPassword = ProcessQueryUtil.getValueOfForm("newPassword");
		String confirmNewPassword = ProcessQueryUtil
				.getValueOfForm("confirmNewPassword");
		if (StringUtils.isNotEmpty(userIdStr)) {
			SysUser userInfo = userService.findById(Long.valueOf(userIdStr));
			if (userInfo != null
					&& userInfo.getPassword() != null
					&& userInfo.getPassword().equals(
							EncryptUtil.encodePassword(oldPassword))) {
				if (StringUtils.isNotEmpty(newPassword)
						&& newPassword.equals(confirmNewPassword)) {
					userService.doUpdateById(userIdStr, newPassword);
					this.setActionMsg("success");
				} else {
					this.setActionMsg("twoPasswordNotEquals");
				}
			} else {
				this.setActionMsg("oldPasswordError");
			}
		}
		return null;
	}

	private void resetPassword() {
		String userIdStr = ProcessQueryUtil.getValueOfForm("userId");
		String newPassword = ProcessQueryUtil.getValueOfForm("newPassword");
		String confirmNewPassword = ProcessQueryUtil
				.getValueOfForm("confirmNewPassword");
		if (StringUtils.isNotEmpty(userIdStr)) {
			SysUser userInfo = userService.findById(Long.valueOf(userIdStr));
			if (userInfo != null) {
				if (StringUtils.isNotEmpty(newPassword)
						&& newPassword.equals(confirmNewPassword)) {
					userService.doUpdateById(userIdStr, newPassword);
				} else {
					this.setActionMsg("Two Password Not Equals");
				}
			}
		}
	}

	private void delete() {
		List<Long> userIds = ProcessQueryUtil.getIdsOfForm("userIds", ",");
		userService.doSoftDeleteByIds(userIds);
		this.setActionMsg("success");
	}

	private void processQueryCondiction() {
		queryCriteria.setOrderDirection("desc");
		queryCriteria.setOrderField("user.updatedDate desc, user.id");
		String idStr = ProcessQueryUtil
				.processString(queryCriteria, "treename");
		Long departId = null;
		if (StringUtils.trimToNull(idStr) != null) {
			int position = idStr.indexOf("-", 1);
			if (position != -1) {
				departId = Long.valueOf(idStr.substring(0, position));
			}
		}
		queryCriteria.addQueryCondition("tsDepartmentId", departId);
		queryCriteria.addQueryCondition("usernameLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "username", 3));
		queryCriteria.addQueryCondition("realnameZhLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "realnameZh", 3));
		queryCriteria.addQueryCondition("realnameEnLike", ProcessQueryUtil
				.processStirngLike(queryCriteria, "realnameEn", 3));
		queryCriteria.addQueryCondition("mobileLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "mobile", 3));
		queryCriteria.addQueryCondition("emailLike",
				ProcessQueryUtil.processStirngLike(queryCriteria, "email", 3));
		if (type != null && type > 0l) {
			queryCriteria.addQueryCondition("type", type);
		} else {
			queryCriteria.addQueryCondition("type", null);
		}
		queryCriteria.addQueryCondition("markForDelete", false);// 线索采集接口状态
	}

	public String getRelName() {
		SysUser user = userService.findById(getCurrUserId());
		relName = user.getUsername();
		return relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getShortRelName() {
		String name = getRelName();
		if (StringUtils.trimToNull(name) != null && name.getBytes().length > 18) {
			shortRelName = DataProcessHelper.truncateWhenUTF8(name, 18);
			shortRelName += "...";
		} else {
			shortRelName = name;
		}
		return shortRelName;
	}

	public void setShortRelName(String shortRelName) {
		this.shortRelName = shortRelName;
	}

	public Long getUserId() {
		userId = this.getCurrUserId();
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ISysUserService getUserService() {
		return userService;
	}

	public void setUserService(ISysUserService userService) {
		this.userService = userService;
	}

}
