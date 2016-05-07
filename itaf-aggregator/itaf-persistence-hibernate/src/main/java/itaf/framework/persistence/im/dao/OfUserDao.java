package itaf.framework.persistence.im.dao;

import itaf.framework.domain.im.OfUser;

import java.util.List;

public interface OfUserDao {
	
	List<OfUser> findByUsername(final String username);

	int changPassword(final String username, final String newPassword);
}
