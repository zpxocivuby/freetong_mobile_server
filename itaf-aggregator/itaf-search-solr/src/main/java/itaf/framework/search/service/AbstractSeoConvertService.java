package itaf.framework.search.service;

import itaf.framework.domain.search.SearchIndexData;
import itaf.framework.search.bean.SearchEngineObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhangkd
 * 
 */
public abstract class AbstractSeoConvertService implements SeoConvertService {

	public SearchEngineObject convertIndexData2Seo(SearchIndexData target) {
		if (target == null) {
			return null;
		}
		SearchEngineObject result = new SearchEngineObject();
		result.addField("ID", "" + target.getId());
		result.addField("TITLE", target.getTitle());
		result.addField("TEXT", target.getText());
		result.addField("URL", target.getUrl());
		result.addField("RELEASE_TIME", target.getReleaseTime());
		result.addField("INDEX_TIME", target.getIndexTime());
		result.addField("SUMMARY", target.getSummary());
		result.addField("INDEX_TYPE", target.getIndexType());
		if (target.getStatus() != null) {
			result.addField("STATUS", target.getStatus());
		}
		return result;
	}

	public List<SearchEngineObject> convertIndexData2Seo(
			List<SearchIndexData> target) {
		if (target == null) {
			return null;
		}
		List<SearchEngineObject> result = new ArrayList<SearchEngineObject>();
		for (SearchIndexData sid : target) {
			result.add(convertIndexData2Seo(sid));
		}
		return result;
	}

	public SearchIndexData convertSeo2IndexData(SearchEngineObject target) {
		if (target == null) {
			return null;
		}
		SearchIndexData result = new SearchIndexData();
		result.setId(new Long(target.getFieldValueAsString("ID")));
		String title = target.getFieldValueAsString("TITLE");
		if (title != null) {
			title = title.replaceAll("<[^>]+>", "");
		}
		result.setTitle(title);
		result.setText(target.getFieldValueAsString("TEXT"));
		result.setUrl(target.getFieldValueAsString("URL"));
		if (target.getFieldValue("RELEASE_TIME") != null
				&& target.getFieldValue("RELEASE_TIME").toString().indexOf("-") == -1) {
			result.setReleaseTime((Date) target.getFieldValue("RELEASE_TIME"));
		}
		if (target.getFieldValue("INDEX_TIME") != null) {
			result.setIndexTime((Date) target.getFieldValue("INDEX_TIME"));
		}
		result.setSummary(target.getFieldValueAsString("SUMMARY"));
		result.setSummary(target.getFieldValueAsString("INDEX_TYPE"));
		if (target.getFieldValue("STATUS") != null) {
			result.setStatus(new Long(target.getFieldValueAsString("STATUS")));
		}
		return result;
	}

	public List<SearchIndexData> convertSeo2IndexData(
			List<SearchEngineObject> target) {
		if (target == null) {
			return null;
		}
		List<SearchIndexData> result = new ArrayList<SearchIndexData>();
		for (SearchEngineObject seo : target) {
			result.add(convertSeo2IndexData(seo));
		}
		return result;
	}
}
