package itaf.framework.persistence.im.dao.impl;

import itaf.framework.core.common.Blowfish;
import itaf.framework.domain.im.OfUser;
import itaf.framework.persistence.im.dao.OfUserDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("ofUserDaoImpl")
public class OfUserDaoImpl extends HibernateDaoSupport implements OfUserDao {

	@Autowired
	@Qualifier("sessionFactory")
	public void setHibernateSessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public List<OfUser> findByUsername(final String username) {
		List<OfUser> result = getHibernateTemplate().execute(
				new HibernateCallback<List<OfUser>>() {
					@SuppressWarnings("unchecked")
					public List<OfUser> doInHibernate(Session session)
							throws SQLException {
						SQLQuery query = session
								.createSQLQuery("select * from ofUser o where o.USERNAME='"
										+ username + "'");
						return query.list();
					}
				});
		return result;
	}

	@SuppressWarnings("rawtypes")
	public int changPassword(final String username, final String newPassword) {
		int count = getHibernateTemplate().execute(
				new HibernateCallback<Integer>() {
					public Integer doInHibernate(Session session)
							throws SQLException {
						SQLQuery queryKey = session
								.createSQLQuery("select t.propvalue from ofproperty t where t.name='passwordKey'");
						List list = queryKey.list();
						Blowfish blowfish = new Blowfish((String) list.get(0));

						SQLQuery query = session
								.createSQLQuery("update OFUSER o set o.ENCRYPTEDPASSWORD='"
										+ blowfish.encryptString(newPassword)
										+ "' where o.USERNAME='"
										+ username
										+ "'");
						return query.executeUpdate();
					}
				});
		return count;
	}

}
