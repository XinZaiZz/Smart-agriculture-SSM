/**
 * [选项列表组件] jhtml-tabs.js
 * 
 * Licensed under the GPL: http://www.it2000.com.cn/licenses.txt
 * 
 * Copyright 2010 liyong [ 343639986@qq.com ]
 * 
 * ----------------------------------------------------------------------------
 * 参考资料：
 * 
 */
(function($) {

	"use strict";

	/** --------------------------------系统组件内部方法---------------------------------- */
	function setSize(element, param) {
		var opts = $.data(element, "tabs").options;
	};

	function init(element) {
		var opts = $.data(element, "tabs").options;
		var cc = $(element).addClass("jhtml-tabs");
		$("<ul class='nav nav-tabs'>"+
				"<li class='tab-arrow pull-left'><a class='tab-icon-left' href='#' title=''><i class='fa icon-chevron-left'></i></a></li>"+
				"<li class='tab-arrow pull-right'><a class='tab-icon-right' href='#' title=''><i class='fa icon-chevron-right'></i></a></li>"+
		  "</ul>").appendTo(cc);
		$("<div class='tab-content'></div>").appendTo(cc);
		return cc;
	};

	function add(element, item) {
		var content = $("div.tab-content", element);
		var exist = content.find("#"+ item.text).length;
		if (!exist) {
			loadData(element, $.makeArray(item));
		}
		select(element, item);
		bindEvents(element);
	}
	
	function defaultSelect(element) {
		var opts = $.data(element, "tabs").options;
		var first = $("ul.nav-tabs li:not(.tab-arrow):eq("+ opts.selected +")", element);
		if (first.length > 0) {
			var items = $.data(element, "tabs").items;
			var id = first.attr("id"), item = items[id];
			select(element, item);
		}
	}
	
	function select(element, item) {
		var navTabs = $("ul.nav-tabs", element);
		if (item) {
			navTabs.children("li.active").removeClass("active");
			var nava = navTabs.find("a[href=#"+ item.text +"]");
			nava.parent().addClass("active");
			var content = $("div.tab-content", element);
			content.children("div.active").removeClass("active");
			var tabContent = content.find("#"+ item.text);
			tabContent.addClass("active");
			var loaded = tabContent.data("loaded");
			if (item.url) {			    
			    if (!loaded || item.flush) {			       
					request(element, item);
				}
			} else {
				tabContent.html(item.html);
			}
		}
	}
	
	function loadData(element, data) {
		var opts = $.data(element, "tabs").options;
		var items = $.data(element, "tabs").items;
		var navTabs = $("ul.nav-tabs", element), content = $("div.tab-content", element);
		var cc = [], dd = [];
		for (var i = 0; i < data.length; i++) {
			var sid = (new Date().getTime()) + i;
			var item = data[i]; items[item[opts.id] || sid] = item;
			if (!item[opts.id] || item[opts.id] == "") {
				item[opts.id] = sid;
			}
			// ul.nav-tabs>li
			cc.push("<li id='"+ item[opts.id] +"'>");
			cc.push("<a class='tab-text' data-toggle='tab' href='#"+ item.text +"' title=''>");
			if (item.iconCls) {
				cc.push("<i class='"+ item.iconCls +"'></i>");
			}
			cc.push(" "+ item.text +" ");
			cc.push("</a>");
			if (item.close) {
				cc.push("<span class='tab-close' title=''><i class='fa icon-times-circle'></i></span>");
			}
			cc.push("</li>");
			// div.tab-content>p
			dd.push("<div id='"+ item.text +"' class='tab-pane'></div>");
		};
		
		if (navTabs.children().not('.tab-arrow').length == 0) {
			$(cc.join("")).insertAfter(navTabs.children('li:eq(0)'));
		} else {
			$(cc.join("")).insertAfter(navTabs.children('li:eq(1)'));
		}
		$(content).append(dd.join(""));
		
		var dropmenu = $(".tabdrop>ul.dropdown-menu", element);
		$(dropmenu).append(cc.join(""));
		opts.onLoadSuccess.call(element, data);
	};
	
	function request(element, item) {
	    var opts = $.extend($.data(element, "tabs").options, item);
		if (opts.url) {
			var content = $("div.tab-content", element);
			var tabContent = content.find("#"+ item.text, element);
			$.ajax({url:opts.url, data:opts.params, dataType:"html", 
				success:function(data) {
					tabContent.data("loaded", true);
					tabContent.html(data);
					if(item.onAfterLoad){item.onAfterLoad(data);}
				}, error:function(data) {
					$(tabContent).html($(data.responseText));
				}
			});
		}
	}
	
	function bindEvents(element) {
		var items = $.data(element, "tabs").items;
		$("ul.nav-tabs>li:not(.tabdrop)", element).off("click.tabs").on("click.tabs", function(e) {
			var id = $(this).attr("id"), item = items[id];
			select(element, item);
		});
		$("ul.nav-tabs li span.tab-close", element).off("click.tabs").on("click.tabs", function(e) {
		    var items = $.data(element, "tabs").items;
			// get target prev li.
			var target = $(this).parent(), prev = target.prev("li");
			var text = $(this).prev(".tab-text").attr("href");
			var content = $("div.tab-content", element);
			content.find(text).remove();
			if (target.hasClass("active")) {
				var id = prev.attr("id"), item = items[id];
				select(element, item);
			}
			target.remove();
		});
		/*$(window).resize(function(e) {
			//setSize(element);
			e.stopPropagation();
		});*/
	};

	function remove(element, item) {
		var navTabs = $("ul.nav-tabs", element);
		if (item) {
			var $this = navTabs.find("a[href=#"+ item.text +"]");
			var items = $.data(element, "tabs").items;
			var target = $this.parent(), prev = target.prev("li");
			var content = $("div.tab-content", element);
		    content.find(item.text).remove();
		    if (target.hasClass("active")) {
		        var id = prev.attr("id"), item = items[id];
		        select(element, item);
		    }
		    target.remove();
		}
	}
	
	/*function remove(element, item) {
	    var $this = $("a[href=" + params.text + "]", element);
	    var items = $.data(element, "tabs").items;
	    // get target prev li.
	    var target = $this.parent(), prev = target.prev("li");
	    //var text = .prev(".tab-text").attr("href");
	    var content = $("div.tab-content", element);
	    content.find(params.text).remove();
	    if (target.hasClass("active")) {
	        var id = prev.attr("id"), item = items[id];
	        select(element, item);
	    }
	    target.remove();
	}*/

	/** --------------------------------系统组件核心方法---------------------------------- */
	$.fn.tabs = function(options, param) {
		if (typeof options == "string") {
			return $.fn.tabs.methods[options](this, param);
		}
		var opts = options || {};
		return this.each(function() {
			var state = $.data(this, "tabs");
			if (state) {
				$.extend(state.opts, opts);
			} else {
				opts = $.extend({}, $.fn.tabs.defaults, $.fn.tabs.parseOptions(this), opts);
				$.data(this, "tabs", {
					options : opts, items : {}
				});
				init(this);
			}
			if (opts.data) {
				loadData(this, $.extend(true, [], opts.data));
			}
			
			defaultSelect(this);
			
			/*setSize(this);*/
			
			bindEvents(this);
			
		});
	};

	/** --------------------------------系统组件业务方法---------------------------------- */
	$.fn.tabs.methods = {
		add : function(jq, options) {
			return jq.each(function() {
				add(this, options);
			});
		},
		select : function(jq, options) {
			return jq.each(function() {
				select(this, options);
			});
		},
		remove : function(jq, which) {
			return jq.each(function() {
				remove(this, which);
			});
		}
	};

	/** --------------------------------系统配置参数---------------------------------- */
	$.fn.tabs.parseOptions = function(target) {
		return $.extend({}, $.parser.parseOptions(target, [ "title" ]));
	};

	/** --------------------------------系统默认参数---------------------------------- */
	$.fn.tabs.defaults = $.extend({}, $.fn.observe.defaults, {
		selected: 0
	});

})(jQuery);
