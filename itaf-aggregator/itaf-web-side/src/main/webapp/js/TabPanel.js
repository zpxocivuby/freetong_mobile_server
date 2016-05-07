Itaf = {
	version : '1.0',
	description : 'ITAF Javascript Library'
};
/**
 * Special parameter for config's items:
 * 
 * @param url
 *            the url to make a iframe
 * @param frameid
 *            the id for the frame
 */
Itaf.TabPanel = function(config) {
	var height = document.documentElement.clientHeight;

	var defaultConfig = {
		id :'tab',
		renderTo :'tabs',
		width :'100%',
		activeTab :0,
		plain :true,
		border :false,
		height :height,
		defaults : {
			autoScroll :true
		}
	};
	
	config = Ext.applyIf(config, defaultConfig);

	var items = config.items;
	if (items) {
		for ( var i = 0; i < items.length; i++) {
			var item = items[i];
			if (item.url) {
				if (item.frameid) {
					item.html = "<iframe name=" + item.frameid + " id="
							+ item.frameid + " src=" + item.url
							+ " width=100% height=100% frameBorder=0 />";
					delete item.frameid;
				} else {
					item.html = "<iframe src=" + item.url
							+ " width=100% height=100% frameBorder=0 />";
				}
				delete item.url;
			}
		}

	}

	return new Ext.TabPanel(config);
};
