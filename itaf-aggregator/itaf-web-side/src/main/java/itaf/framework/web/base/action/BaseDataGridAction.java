package itaf.framework.web.base.action;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;

/**
 * 分页基础类
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月30日
 */
public abstract class BaseDataGridAction<T> extends BaseAction {

	private static final long serialVersionUID = -2406721215919000467L;

	protected PageResult<T> pageResult = null;

	protected QueryCriteria queryCriteria = new QueryCriteria();

	public PageResult<T> getPageResult() {
		pageResult = getPageContent();
		return pageResult;
	}

	protected abstract PageResult<T> getPageContent();

	public QueryCriteria getQueryCriteria() {
		return queryCriteria;
	}

	public void setQueryCriteria(QueryCriteria queryCriteria) {
		this.queryCriteria = queryCriteria;
	}

}
