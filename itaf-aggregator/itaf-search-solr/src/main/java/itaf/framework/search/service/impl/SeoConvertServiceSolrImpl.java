package itaf.framework.search.service.impl;

import itaf.framework.core.util.DateHelper;
import itaf.framework.search.service.AbstractSeoConvertService;

import java.util.Calendar;

import org.springframework.stereotype.Service;

/**
 * @author zhangkd
 * 
 */
@Service("seoConvertServiceSolrImpl")
public class SeoConvertServiceSolrImpl extends AbstractSeoConvertService {

	public String filterSolrField(String fieldName) {
		String solrFieldName = "";
		if (fieldName == null) {
			return solrFieldName;
		}
		if ("RELEVANCE".equals(fieldName)) {
			solrFieldName = "score";
		} else {
			solrFieldName = fieldName;
		}
		return solrFieldName;
	}

	public String filterSolrDate(String dateString) {
		if (dateString == null) {
			return "*";
		}
		return DateHelper.formatDate(DateHelper.add(
				DateHelper.parse(dateString, "yyyy-MM-dd HH:mm:ss"),
				Calendar.HOUR_OF_DAY, -8), "yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

}
