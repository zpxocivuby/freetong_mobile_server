package itaf.framework.scheduler.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.scheduler.service.SchedulerTestService;

@Service("schedulerTestServiceImpl")
public class SchedulerTestServiceImpl extends BaseServiceImpl implements
		SchedulerTestService {
	
	@Autowired
	ISysUserService userService = null;
	
	@Override
	public void doTest() {
		List<SysUser> userList = userService.findAll();
		if(userList!=null){
			System.out.println("====================="+userList.size()+"======================");
		}
	}
}
