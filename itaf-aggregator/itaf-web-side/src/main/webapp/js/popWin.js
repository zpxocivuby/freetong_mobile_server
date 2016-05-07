/**
 * PopUP window
 */

// create namespace
Ext.namespace('popWindowBase');

// create application
popWindowBase.app = function() {
	// do NOT access DOM from here; elements don't exist yet

	// private variables
	var dg;
	var tb;
	var windows;
	// to manage the windows
	var selectedWin = new Ext.Window();
	var wins = new Array();
	var refreshBtns = new Array();
	var totalWins = 0;

	var refreshButton;

	var winButtons = new Array();

	function winButton(key, win, button) {
		this.key = key;
		this.win = win;
		this.button = button;
	}
	;
	function putWinButton(key, win, button) {
		// winButtons[key] = new winButton(key, win, button);
		// alert(winButtons.length);
		// winButtons[winButton.length] = new winButton(key, win, button);
		winButtons.push(new winButton(key, win, button));
		// alert(winButtons.length);

	}
	;
	function removeWinButton() {

		/**
		 * var selected = winButtons[key]; if(selected) {
		 * winButtons.remove(selected); } return selected;
		 */
		// var selected = winButtons[winButtons.length-1];
		var selected = winButtons.pop();
		// alert("Remove " + winButtons.length);
		// winButtons.push(new winButton(key, win, button));
		/**
		 * if(selected) { winButtons.remove(selected); }
		 */
		return selected;

	}
	;
	function getWinButton() {
		/**
		 * var selected = winButtons[key]; return selected;
		 */
		// alert("Get " + winButtons.length);
		var selected = winButtons[winButtons.length - 1];
		// alert(" After Get " + winButtons.length);
		return selected;

	}
	;
	function closeWin(url) {
		var success = false;
		var page = url.substring(url.indexOf('//') + 2);
		page = page.substring(page.indexOf('/'));
		var selected = removeWinButton(page);
		if (selected) {
			if (selected.win) {
				selected.win.close();
				selectedWin = null;
				success = true;
			}
			if (selected.button) {
				selected.button.click();
				refreshButton = null;
				success = true;
			}
		}
		selected = null;
		return success;

		/**
		 * if(selectedWin) selectedWin.close();
		 * //alert('parent.window.frames["center"].location.href: ' +
		 * parent.window.frames["main"].location.href);
		 * 
		 * //parent.window.frames["main"].location.reload(); if (refreshButton)
		 * refreshButton.click();
		 */

	}
	;

	// private functions
	function idGen(title) {
		var id = '';
		var repeatTimes = 0;
		for (var i = 0, len = wins.length; i < len; i++) {
			if (wins[i].title == title) {
				repeatTimes++;
			}
		}
		if (repeatTimes != 0) {
			repeatTimes++;
			return title + '[' + repeatTimes + ']';
		} else {
			return title;
		}

	}
	;
	// public space
	return {
		// public properties, e.g. strings to translate

		// public methods
		init : function() {
			/*
			 * windows=new Ext.WindowGroup(); tb= new Ext.Toolbar();
			 * tb.render('taskbar');
			 * 
			 * tb.add({ text:'' });
			 */
		},
		popWindow : function(obj) {
			// var href=obj.href;
			// obj.href='#';
			// popWindowBase.app.init();
			// popWindowBase.app.showDetail(obj,'View Detail',false,800,600,
			// document.getElementById("#{formId}:pageRefresh"));
			popWindowBase.app.popWindow2(obj, null);
		},
		popWindow2 : function(obj, refreshBtn, popupWindowTitle,
				popupShowWidth, popupShowHeight, max) {
			// var href=obj.href;
			// obj.href='#';
			popWindowBase.app.init();
			// alert("popupShowHeight"+popupShowHeight);
			var showHeight = popupShowHeight;
			if (showHeight == null || showHeight == '') {
				showHeight = document.documentElement.clientHeight * 4 / 5;
			}
			var showWidth = popupShowWidth;
			if (showWidth == null || showWidth == '') {
				showWidth = document.documentElement.clientWidth * 3 / 4;
			}

			var tmppopupWindowTitle = popupWindowTitle;
			if (tmppopupWindowTitle == null || tmppopupWindowTitle == '') {
				tmppopupWindowTitle = 'CCTV OOMS Management';
			}
			if (refreshBtn)
				popWindowBase.app.showDetail(obj, tmppopupWindowTitle, false,
						showWidth, showHeight, refreshBtn, max);
			else
				popWindowBase.app.showDetail(obj, tmppopupWindowTitle, false,
						showWidth, showHeight, null, max);
		},
		popAssisWin : function(page, title) {
			var win;

			// create the window on the first click and reuse on subsequent
			// clicks
			if (!win) {

				win = new Ext.Window({
					layout : 'fit',
					// width: popWinWidth,
					// height: popWinHeight,
					closable : true,
					// closeAction: 'hide',
					animateTarget : this,
					width : 580,
					height : 340,
					closeAction : 'close',

					// minimizable:true,
					modal : true,
					// resizable :false,
					hideBorders : true,
					// manager:windows,
					title : title
				});
				win.on('close', function() {
					win.destroy();
				});
			}
			return win;
		},
		showDetail : function(page, title, modal, width, height, button, max) {
			var win;
			var winWid = width;
			var winHeight = height;

			// create the window on the first click and reuse on subsequent
			// clicks
			if (!win) {
				win = new Ext.Window(
						{
							layout : 'border',
							width : winWid,
							height : winHeight,
							closable : true,
							animateTarget : this,
							closeAction : 'close',
							maximizable : max == true ? true : false,
							// minimizable:true,
							// resizable :false,
							modal : true,
							hideBorders : true,
							title : title,
							items : [ {
								region : 'center',
								html : '<iframe name="popIframe" frameBorder="0" width=100% height=100% src='
										+ page + '></iframe>',
								hideBorders : true
							} ]
						});
				title = idGen(title);
				// selectedWin = win;
				// wins.push(win);
				// refreshBtns.push(button);
				// refreshButton = button;
				/**
				 * selectedWin = win;//make win as the currently selected Window
				 * var btn=new Ext.Toolbar.Button({text:title,
				 * handler:function(){ win.show(); selectedWin = win;//make win
				 * as the currently selected Window when focus on it } });
				 */
			}
			// win.on('minimize',function(){this.hide();selectedWin = null;});
			win.on('minimize', function() {
				this.close();
			});
			win.on('close', function() {
				// btn.destroy();
				// if (refreshButton)
				// refreshButton.onclick();
				var selected = removeWinButton();
				if (selected.button)
					selected.button.onclick();
				// refreshBtns.remove(refreshButton);
				// refreshButton=refreshBtns[refreshBtns.length-1];
				// wins.remove(win);//remove the window instance from the
				// windowArrays
				/**
				 * if (wins.length>0){ selectedWin=wins[wins.length-1]; } else
				 * selectedWin = null;//remove the current selected window
				 */
				button = null;
				selected = null;
				win.destroy();

			});

			putWinButton(page, win, button);

			// win.on('focus',function(){selectedWin = win;});
			win.show();
			// tb.add(btn);
		},
		showDetailMax : function(page, title, modal, max) {
			var screenHeight = screen.height * 2 / 3;
			var screenWidth = screen.width - 20;
			this.showDetail(page, title, modal, screenWidth, screenHeight, max);
		},

		exitWindow : function() {

			/**
			 * var url = curwin.location.href; if(!closeWin(url)) { url=
			 * curwin.parent.location.href; closeWin(url); }
			 */
			var selected = getWinButton();
			if (selected) {
				if (selected.win) {
					// selected.win.close();
					// selected.win.hide();
					selected.win.close();
					// 增加了判断
					if (selected.button) {
						var tmpform = selected.button.ownerDocument.forms["searchForm"];
						if (tmpform) {
							var elements = tmpform.elements;
							for (var i = 0; i < elements.length; i++) {
								if (elements[i].type == 'text'
										&& !elements[i].readOnly
										&& !elements[i].className == 'cell-input-date') {
									elements[i].focus();
									break;
								}
							}
						}
					}
				}

			}
			// selected = null;

		},
		exitTreeWindow : function(value) {

			/**
			 * var url = curwin.location.href; if(!closeWin(url)) { url=
			 * curwin.parent.location.href; closeWin(url); }
			 */

			var selected = getWinButton();
			if (selected) {
				if (selected.win) {
					// selected.win.close();
					// selected.win.hide();

					selected.win.close();
					// 增加了判断
					if (selected.button) {
						var tmpform = selected.button.ownerDocument.forms["searchForm"];
						if (tmpform) {
							var elements = tmpform.elements;
							for (i = 0; i < elements.length; i++) {
								if (elements[i].type == 'text'
										&& !elements[i].readOnly
										&& !elements[i].className == 'cell-input-date') {
									elements[i].focus();
									break;
								}
							}
						}
					}
				}

			}
			// selected = null;

		},
		refreshWindow : function() {

			/**
			 * var url = curwin.location.href; var page =
			 * url.substring(url.indexOf('//') + 2); page =
			 * page.substring(page.indexOf('/'));
			 */
			var selected = getWinButton();
			if (selected) {
				if (selected.button) {
					selected.button.click();
					// refreshButton = null;
				}
			}

		},
		/***********************************************************************
		 * exitWindow : function(){
		 * 
		 * if(selectedWin) selectedWin.close();
		 * //alert('parent.window.frames["center"].location.href: ' +
		 * parent.window.frames["main"].location.href);
		 * 
		 * //parent.window.frames["main"].location.reload(); if (refreshButton)
		 * refreshButton.click();
		 * 
		 *  },
		 **********************************************************************/
		resize : function(width, height) {
			if (selectedWin) {
				selectedWin.setWidth(width);
				selectedWin.setHeight(height);
			} else {
				alert('getInnerHeight: ' + selectedWin.getInnerHeight());
				alert('getInnerWidth: ' + selectedWin.getInnerWidth());
			}
		},
		rename : function(newTitle) {
			if (selectedWin) {
				selectedWin.setTitle(newTitle);
			}

		}
	};
}();
