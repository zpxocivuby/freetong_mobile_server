package itaf.WsSearchService;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import itaf.framework.ws.server.search.impl.WsSearchService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.0.1 2014-09-25T11:50:12.557+08:00
 * Generated source version: 3.0.1
 * 
 */
public final class WsSearchService_WsSearchServiceImplPort_Client {

	private static final QName SERVICE_NAME = new QName(
			"http://impl.search.server.ws.framework.itaf/", "WsSearchService");

	private WsSearchService_WsSearchServiceImplPort_Client() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = WsSearchService.WSDL_LOCATION;
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		WsSearchService ss = new WsSearchService(wsdlURL, SERVICE_NAME);
		itaf.WsSearchService.WsSearchService port = ss
				.getWsSearchServiceImplPort();

		{
			System.out.println("Invoking getBzMerchantDtoObject...");
			itaf.WsSearchService.BzMerchantDto _getBzMerchantDtoObject__return = port
					.getBzMerchantDtoObject();
			System.out.println("getBzMerchantDtoObject.result="
					+ _getBzMerchantDtoObject__return);

		}
		{
			System.out.println("Invoking searchProducts...");
			itaf.WsSearchService.SearchProducts.QueryMap _searchProducts_queryMap = new itaf.WsSearchService.SearchProducts.QueryMap();
			java.util.List<itaf.WsSearchService.SearchProducts.QueryMap.Entry> _searchProducts_queryMapEntry = new java.util.ArrayList<itaf.WsSearchService.SearchProducts.QueryMap.Entry>();
			itaf.WsSearchService.SearchProducts.QueryMap.Entry _searchProducts_queryMapEntryVal1 = new itaf.WsSearchService.SearchProducts.QueryMap.Entry();
			_searchProducts_queryMapEntryVal1.setKey("Key1669813516");
			java.lang.Object _searchProducts_queryMapEntryVal1Value = null;
			_searchProducts_queryMapEntryVal1
					.setValue(_searchProducts_queryMapEntryVal1Value);
			_searchProducts_queryMapEntry
					.add(_searchProducts_queryMapEntryVal1);
			_searchProducts_queryMap.getEntry().addAll(
					_searchProducts_queryMapEntry);
			int _searchProducts_currentIndex = 716310655;
			int _searchProducts_pageSize = 696692585;
			itaf.WsSearchService.WsPageResult _searchProducts__return = port
					.searchProducts(_searchProducts_queryMap,
							_searchProducts_currentIndex,
							_searchProducts_pageSize);
			System.out.println("searchProducts.result="
					+ _searchProducts__return);

		}
		{
			System.out.println("Invoking getBzDistributionCompanyDtoObject...");
			itaf.WsSearchService.BzDistributionCompanyDto _getBzDistributionCompanyDtoObject__return = port
					.getBzDistributionCompanyDtoObject();
			System.out.println("getBzDistributionCompanyDtoObject.result="
					+ _getBzDistributionCompanyDtoObject__return);

		}
		{
			System.out.println("Invoking getBzProductDtoObject...");
			itaf.WsSearchService.BzProductDto _getBzProductDtoObject__return = port
					.getBzProductDtoObject();
			System.out.println("getBzProductDtoObject.result="
					+ _getBzProductDtoObject__return);

		}
		{
			System.out.println("Invoking searchMerchants...");
			itaf.WsSearchService.SearchMerchants.QueryMap _searchMerchants_queryMap = new itaf.WsSearchService.SearchMerchants.QueryMap();
			java.util.List<itaf.WsSearchService.SearchMerchants.QueryMap.Entry> _searchMerchants_queryMapEntry = new java.util.ArrayList<itaf.WsSearchService.SearchMerchants.QueryMap.Entry>();
			itaf.WsSearchService.SearchMerchants.QueryMap.Entry _searchMerchants_queryMapEntryVal1 = new itaf.WsSearchService.SearchMerchants.QueryMap.Entry();
			_searchMerchants_queryMapEntryVal1.setKey("Key1266977824");
			java.lang.Object _searchMerchants_queryMapEntryVal1Value = null;
			_searchMerchants_queryMapEntryVal1
					.setValue(_searchMerchants_queryMapEntryVal1Value);
			_searchMerchants_queryMapEntry
					.add(_searchMerchants_queryMapEntryVal1);
			_searchMerchants_queryMap.getEntry().addAll(
					_searchMerchants_queryMapEntry);
			int _searchMerchants_currentIndex = -1260661219;
			int _searchMerchants_pageSize = 292395770;
			itaf.WsSearchService.WsPageResult _searchMerchants__return = port
					.searchMerchants(_searchMerchants_queryMap,
							_searchMerchants_currentIndex,
							_searchMerchants_pageSize);
			System.out.println("searchMerchants.result="
					+ _searchMerchants__return);

		}
		{
			System.out.println("Invoking searchDistributionCompanys...");
			itaf.WsSearchService.SearchDistributionCompanys.QueryMap _searchDistributionCompanys_queryMap = new itaf.WsSearchService.SearchDistributionCompanys.QueryMap();
			java.util.List<itaf.WsSearchService.SearchDistributionCompanys.QueryMap.Entry> _searchDistributionCompanys_queryMapEntry = new java.util.ArrayList<itaf.WsSearchService.SearchDistributionCompanys.QueryMap.Entry>();
			itaf.WsSearchService.SearchDistributionCompanys.QueryMap.Entry _searchDistributionCompanys_queryMapEntryVal1 = new itaf.WsSearchService.SearchDistributionCompanys.QueryMap.Entry();
			_searchDistributionCompanys_queryMapEntryVal1
					.setKey("Key133803355");
			java.lang.Object _searchDistributionCompanys_queryMapEntryVal1Value = null;
			_searchDistributionCompanys_queryMapEntryVal1
					.setValue(_searchDistributionCompanys_queryMapEntryVal1Value);
			_searchDistributionCompanys_queryMapEntry
					.add(_searchDistributionCompanys_queryMapEntryVal1);
			_searchDistributionCompanys_queryMap.getEntry().addAll(
					_searchDistributionCompanys_queryMapEntry);
			int _searchDistributionCompanys_currentIndex = 319752569;
			int _searchDistributionCompanys_pageSize = 96228454;
			itaf.WsSearchService.WsPageResult _searchDistributionCompanys__return = port
					.searchDistributionCompanys(
							_searchDistributionCompanys_queryMap,
							_searchDistributionCompanys_currentIndex,
							_searchDistributionCompanys_pageSize);
			System.out.println("searchDistributionCompanys.result="
					+ _searchDistributionCompanys__return);

		}

		System.exit(0);
	}

}