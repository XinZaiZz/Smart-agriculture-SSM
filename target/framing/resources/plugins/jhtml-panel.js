/**
 * [面板组件] jhtml-panel.js
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
		var opts = $.data(element, "panel").options;
		var sm = $("ul.jhtml-panel-menu", element);
		var viewport = opts.viewport();
		var height = viewport.height;
		if ($("body").hasClass("jhtml-header-fixed")) {
			height = height - $(".jhtml-header").outerHeight(true);
		}
		if ($("body").hasClass("jhtml-footer-fixed")) {
			height = height - $(".jhtml-footer").outerHeight(true);
		}
		if (opts.fixed) {
			$(sm).slimScroll({
	      height: height - 70
	    });
		} else {
			sm.css("min-height", height - 70);
		}
	};
	
	function init(element) {
		var cc = $(element);
		cc.addClass("jhtml-panel light");
		return cc;
	};
	
	function loadData(element, data) {
		var opts = $.data(element, "panel").options;
		var cc = [];
		if (opts.title) {
			cc.push("<div class='panel-title tabbable-line'>");
			cc.push("<div class='title'>");
			cc.push("<span class='title-subject'> <i class='fa icon-home'></i> "+ data.text +"</span>");
			cc.push("</div>");
			cc.push("<ul class='nav nav-tabs'>");
			cc.push("<li class='active'><a href='#"+ data[opts.id] +"' data-toggle='tab'>"+ data.text +"</a></li>");
			cc.push("</ul>");
			cc.push("</div>");
		}
		if (data) {
			cc.push("<div class='panel-body'>");
			cc.push("<div class='tab-content'>");
			cc.push("<div class='tab-pane active' id='"+ data[opts.id] +"'>");
			cc.push("</div>");
			cc.push("</div>");
			cc.push("</div>");
		}
		$(element).html("").append(cc.join(""));
		request(element, data);
		opts.onLoadSuccess.call(element, data);
	};
	
	function request(element, param) {
	  $.ajax({
	    type: "GET",
	    url: param.url,
	    dataType: "html",
	    success: function(data) {
	      $("div.tab-pane", element).html(data);
	    },
	    error: function(e) {
	    	$("div.tab-pane", element).html("<h4>Could not load the requested content.</h4>");
	    }
	  });
	}
	
	function bindEvents(element, rows) {
		var opts = $.data(element, "panel").options;
		var sm = $("ul.jhtml-panel-menu", element);
		
		$(element).on("click.panel", "li > a", function(e) {
      var target = $(this), index = target.attr("index");
      var parentUL = target.parent().parent(), nextUL = target.next();
      if (opts.expanded) {
      	parentUL.children("li.open").children("a").children(".arrow").removeClass("open");
      	parentUL.children("li.open").children(".sub-menu").slideUp(opts.speed);
      	parentUL.children("li.open").removeClass("open");
      }
      if (nextUL.is(":visible")) {
      	$(".arrow", $(this)).removeClass("open");
      	$(this).parent().removeClass("open");
      	nextUL.slideUp(opts.speed, function() {
	        $("body").hasClass("jhtml-panel-closed") === false 
	        	&& ($("body").hasClass("jhtml-panel-fixed") ? sm.slimScroll({
	            scrollTo: target.position().top
	        }) : opts.scrollbar(target, -200));
        });
      } else {
      	$(".arrow", $(this)).addClass("open");
      	$(this).parent().addClass("open");
      	nextUL.slideDown(opts.speed, function() {
	        $("body").hasClass("jhtml-panel-closed") === false 
	        	&& ($("body").hasClass("jhtml-panel-fixed") ? sm.slimScroll({
	            scrollTo: target.position().top
	        }) : opts.scrollbar(target, -200));
        });
      }
      setSize(element);
			e.stopPropagation();
		});
		
		$(element).on("click.panel", "li > a.ajaxify", function(e) {
			e.stopPropagation();
			var target = $(this), index = target.attr("index");
			opts.loading();
      if (opts.onClickRow.call(target, rows[index]) == false) {
  			return;
  		}
      setTimeout(function() {
      	opts.loaded();
      }, 1000);
			return false;
		});
		
		$(window).resize(function(e) {
    	setSize(element);
    	e.stopPropagation();
    });
		
	};
	
	/** --------------------------------系统组件核心方法---------------------------------- */
	$.fn.panel = function(options, param) {
		if (typeof opts == "string") {
			return $.fn.panel.methods[options](this, param);
		}
		var opts = options || {};
		return this.each(function() {
			var state = $.data(this, "panel");
			if (state) {
				$.extend(state.opts, opts);
			} else {
				opts = $.extend({}, $.fn.panel.defaults, $.fn.panel.parseOptions(this), opts);
				$.data(this, "panel", {
					options : opts,
					panel : $(this).addClass("jhtml-panel")
				});
				init(this);
			}
			if (opts.data) {
				loadData(this, $.extend(true, [], opts.data));
			}
			if (opts.url) {
				request(this, this);
			}
			/*setSize(this, param);
			bindEvents(this, rows);*/
		});
	};
	
	/** --------------------------------系统组件业务方法---------------------------------- */
	$.fn.panel.methods = {
		add : function(jq, options) {
			return jq.each(function() {
				add(this, options);
			});
		},
		remove : function(jq, which) {
			return jq.each(function() {
				remove(this, which);
			});
		}
	};
	
	/** --------------------------------系统配置参数---------------------------------- */
	$.fn.panel.parseOptions = function(target) {
		return $.extend({}, $.parser.parseOptions(target, ["title"]));
	};

	/** --------------------------------系统默认参数---------------------------------- */
	$.fn.panel.defaults = $.extend({}, $.fn.observe.defaults, {
		title: null,
		showTabs: true
	});

})(jQuery);
