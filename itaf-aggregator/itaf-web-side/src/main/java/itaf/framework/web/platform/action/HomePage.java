package itaf.framework.web.platform.action;

import itaf.framework.web.base.action.AbstractPageAction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * 首页
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月7日
 */
@ManagedBean(name = "homePage")
@ViewScoped
public class HomePage extends AbstractPageAction {

	public static final int PAGE_SIZE = 8;

	private static final long serialVersionUID = 1L;

}
