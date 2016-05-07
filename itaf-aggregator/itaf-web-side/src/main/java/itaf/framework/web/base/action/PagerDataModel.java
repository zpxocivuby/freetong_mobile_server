/**
 * 
 */
package itaf.framework.web.base.action;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.domain.BaseEntity;
import itaf.framework.core.domain.BaseUnionEntity;
import itaf.framework.web.util.ProcessQueryUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ajax4jsf.model.DataVisitor;
import org.ajax4jsf.model.ExtendedDataModel;
import org.ajax4jsf.model.Range;
import org.ajax4jsf.model.SequenceRange;
import org.richfaces.renderkit.ExtendedDataTableRenderer;
import org.springframework.stereotype.Component;

/**
 * @author xiaoly
 * 
 */
@Component("pagerDataModel")
public class PagerDataModel<T> extends ExtendedDataModel<T> implements
		Serializable {

	private static final long serialVersionUID = 6853641919527513673L;

	private PageResult<T> pageResult;
	private BaseRichFacesDataGridAction<T> baseRichFacesDataGridAction;

	private int rowIndex;
	private Long currId;
	private List<Long> wrappedKeys = new ArrayList<Long>();
	private Map<Long, T> wrappedData = new HashMap<Long, T>();

	@Override
	public Object getRowKey() {
		return currId;
	}

	@Override
	public void setRowKey(Object key) {
		if (key != null) {
			this.currId = (Long) key;
		}

	}

	@Override
	public int getRowCount() {
		return pageResult.getTotalCount() == 0 ? 1 : pageResult.getTotalCount();
	}

	@Override
	public int getRowIndex() {
		return rowIndex;
	}

	@Override
	public Object getWrappedData() {
		return wrappedData;
	}

	@Override
	public boolean isRowAvailable() {
		Object currentRowKey = getRowKey();
		long rowIndex = -1;
		if (currentRowKey != null) {
			rowIndex = (Long) currentRowKey;
		}
		if (rowIndex < 0) {
			return false;
		}
		return isRowAvailableById(rowIndex);

	}

	private boolean isRowAvailableById(Long rowIndex) {
		if (pageResult == null || pageResult.getContent() == null
				|| pageResult.getContent().size() <= 0) {
			return false;
		}
		List<T> array = (List<T>) pageResult.getContent();
		for (T object : array) {
			if (object instanceof BaseEntity) {
				BaseEntity entity = (BaseEntity) object;
				if (rowIndex.equals(entity.getId())) {
					return true;
				}
			} else if (object instanceof BaseUnionEntity) {
				// TODO
				return false;
			}
		}
		return false;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	@Override
	public void walk(FacesContext context, DataVisitor visitor, Range range,
			Object argument) {
		if (visitor instanceof ExtendedDataTableRenderer) {
			wrappedKeys.clear();
			wrappedData.clear();
			SequenceRange sequenceRange = (SequenceRange) range;
			baseRichFacesDataGridAction.getQueryCriteria().setStartIndex(
					sequenceRange.getFirstRow());
			String operateType = ProcessQueryUtil.getValueOfForm("operateType");
			// 如果是查询就重置startIndex值
			if ("query".equals(operateType)) {
				baseRichFacesDataGridAction.getQueryCriteria().setStartIndex(0);
			}
			baseRichFacesDataGridAction.getQueryCriteria().setPageSize(
					sequenceRange.getRows());
			pageResult = baseRichFacesDataGridAction.getPageResult();
		}
		if (pageResult != null) {
			List<T> array = (List<T>) pageResult.getContent();
			for (T object : array) {
				if (object instanceof BaseEntity) {
					BaseEntity entity = (BaseEntity) object;
					wrappedKeys.add(entity.getId());
					wrappedData.put(entity.getId(), object);
					visitor.process(context, entity.getId(), argument);
				} else if (object instanceof BaseUnionEntity) {
					throw new UnsupportedOperationException();
				}
			}
		}

	}

	@Override
	public T getRowData() {
		return wrappedData.get(currId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setWrappedData(Object data) {
		this.wrappedData = (Map<Long, T>) data;
	}

	public PageResult<T> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<T> pageResult) {
		this.pageResult = pageResult;
	}

	protected void resetDataProvider() {
		this.pageResult = null;
	}

	public void setBaseRichFacesDataGridAction(
			BaseRichFacesDataGridAction<T> baseRichFacesDataGridAction) {
		this.baseRichFacesDataGridAction = baseRichFacesDataGridAction;
	}

}
