package itaf.framework.business.platform.service;

public interface ISysBlackWhiteListService {

	public void checkUser(String username, String telephone,
			String whiteBlackType);
}
