//MES Tool Generator at 2009-02-24 20:29:22 package itaf.framework.persistence.platform.dao;import itaf.framework.domain.platform.SysUser;import itaf.framework.persistence.base.dao.IBaseDao;import java.util.List;/** *  * @author XINXIN *  */public interface ISysUserDao extends IBaseDao<SysUser> {	/**	 * 根据用户输入分别模糊匹配realnameZh or realnameEn or username,并且排除创建人	 * 	 * @param userName	 *            用户输入	 * @param createUserId创建人Id	 * @return List<SysUser>	 */	List<SysUser> findLikeName(String userName, Long createUserId);	/**	 * 检索所有用户数据记录并根据用户名排序。	 * 	 * @return List<SysUser>	 */	List<SysUser> findAllOrderByUsername();	SysUser getById(Long userId);	List<SysUser> findByIds(List<Long> userIds);}