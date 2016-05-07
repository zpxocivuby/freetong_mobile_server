package itaf.framework.core.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xiaoly
 * 
 */
public class PageResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8395715650407353583L;
	/**
	 * 当前记录索引
	 */
	private int currentIndex = 0;

	/**
	 * 总记录数
	 */
	private int totalCount = 0;

	/**
	 * 当前页面
	 */
	private int currentPage = 1;

	/**
	 * 总记录的页面数
	 */
	private int totalPage = 0;

	/**
	 * 每页显示的记录数，默认为20条记录 如果要显示全部记录数，可以设定每页记录数为 0
	 */
	private int pageSize = 20;

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Collection<T> getContent() {
		return content;
	}

	public void setContent(Collection<T> content) {
		this.content = content;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public long getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(long queryTime) {
		this.queryTime = queryTime;
	}

	/**
	 * 返回的数据库记录列表
	 */
	private Collection<T> content = new ArrayList<T>(0);

	/**
	 * 查询表达式
	 */
	private String queryString;

	/**
	 * 查询时间
	 */
	private long queryTime;

}
