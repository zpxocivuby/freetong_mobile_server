package itaf.framework.web.base.action;

import itaf.framework.core.common.PageResult;

public abstract class BaseRichFacesDataGridAction<T> extends
		BaseDataGridAction<T> {

	private static final long serialVersionUID = -6703020549133625188L;
	protected PagerDataModel<T> pagerDataModel;

	public PagerDataModel<T> getPagerDataModel() {
		if (pagerDataModel == null) {
			pagerDataModel = new PagerDataModel<T>();
		}
		pagerDataModel.setBaseRichFacesDataGridAction(this);
		if (pageResult == null) {
			pageResult = new PageResult<T>();
		}
		pagerDataModel.setPageResult(pageResult);
		return pagerDataModel;
	}

	public void setPagerDataModel(PagerDataModel<T> pagerDataModel) {
		this.pagerDataModel = pagerDataModel;
	}

}
