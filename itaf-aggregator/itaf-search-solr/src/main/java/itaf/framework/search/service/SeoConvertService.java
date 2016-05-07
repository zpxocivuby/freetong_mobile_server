package itaf.framework.search.service;

import itaf.framework.domain.search.SearchIndexData;
import itaf.framework.search.bean.SearchEngineObject;

import java.util.List;

public interface SeoConvertService {

	/**
	 * 将CrawlerData转SearchEngineObject对象
	 * 
	 * @param CrawlerData
	 *            CrawlerData对象
	 * @return
	 */
	public SearchEngineObject convertIndexData2Seo(SearchIndexData CrawlerData);

	public List<SearchEngineObject> convertIndexData2Seo(
			List<SearchIndexData> listCrawlerData);

	/**
	 * 将SearchEngineObject转CrawlerData对象
	 * 
	 * @param searchEngineObject
	 *            SearchEngineObject对象
	 * @return
	 */
	public SearchIndexData convertSeo2IndexData(
			SearchEngineObject searchEngineObject);

	public List<SearchIndexData> convertSeo2IndexData(
			List<SearchEngineObject> listSearchEngineObject);

}
