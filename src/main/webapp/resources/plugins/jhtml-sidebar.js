/**
 * [导航菜单组件] jhtml-sidebar.js
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
		var opts = $.data(element, "sidebar").options;
		var sidebarMenu = $("ul.jhtml-sidebar-menu", element);
		var height = opts.viewport().height;
		if ($("body").hasClass("jhtml-header-fixed")) {
			height = height - $(".jhtml-header").outerHeight(true);
		}
		if ($("body").hasClass("jhtml-footer-fixed")) {
			height = height - $(".jhtml-footer").outerHeight(true);
		}
		if (opts.title) {
			height = height - $(".sidebar-title", element).outerHeight(true);
		}
		
		if (opts.fixed) {
			$(sidebarMenu).slimScroll({
	      height: height - 12
	    });
		} else {
			sidebarMenu.css("min-height", height - 12);
		}
	};
	
	function init(element) {
		var cc = $(element);
		cc.addClass("jhtml-sidebar");
		var opts = $.data(element, "sidebar").options;
		if (opts.title) {
			$("<div class='sidebar-title'></div>").html(opts.title).appendTo(cc);
		}
		if (opts.fixed) {
			$("body").addClass("jhtml-sidebar-fixed");
		}
		var ul = $("<ul></ul>").appendTo(cc);
		ul.addClass("jhtml-sidebar-menu");
		return cc;
	};
	
	function loadData(element, data) {
		var opts = $.data(element, "sidebar").options;
		var sidebarMenu = $("ul.jhtml-sidebar-menu", element);
		var rows = [], index = -1, cc = render(sidebarMenu, data);
		$(sidebarMenu).append(cc.join(""));
		var first = $("li:eq("+ opts.selected +")", sidebarMenu);
		if (first) {
			first.addClass("open");
		}
		function render(sidebarMenu, data) {
			var cc = [];
			for (var i = 0; i < data.length; i++) {
				var sid = (new Date().getTime()) + i;
				var item = data[i]; index++;
				var children = item.children;
				if (!item[opts.id] || item[opts.id] == "") {
					item[opts.id] = sid;
				}
				cc.push("<li class='nav-item'>");
				if (item.url) {
					cc.push("<a id='sidebar-"+ item[opts.id] +"' href='"+ item.url +"' class='nav-link "+ item.mode +"' index='"+ index +"'>");
				} else {
					cc.push("<a id='sidebar-"+ item[opts.id] +"' href='javascript:;' class='nav-link' index='"+ index +"'>");
				}
				if (item.iconCls) {
					cc.push("<i class='"+ item.iconCls +"'></i>");
				}
				cc.push("<span class='title'> " + opts.formatter.call(element, item) + " </span>");
				if (children && children.length) {
					cc.push("<span class='arrow'></span>");
				}
				cc.push("</a>");
				rows.push(item);
				if (children && children.length) {
					var tmp = render(sidebarMenu, children);
					cc.push("<ul class='sub-menu'>");
					cc = cc.concat(tmp);
					cc.push("</ul>");
				}
				cc.push("</li>");
				if (opts.showLine) {
					cc.push("<li class=\"divider\"></li>");
				}
			}
			return cc;
		};
		opts.onLoadSuccess.call(element, data);
		return rows;
	};
	
	function bindEvents(element, rows) {
		var opts = $.data(element, "sidebar").options;
		var sidebarMenu = $("ul.jhtml-sidebar-menu", element);
		
		$(sidebarMenu).on("click.sidebar", "li > a", function(e) {
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
	        $("body").hasClass("jhtml-sidebar-closed") === false 
	        	&& ($("body").hasClass("jhtml-sidebar-fixed") ? sidebarMenu.slimScroll({
	            scrollTo: target.position().top
	        }) : opts.scrollbar(target, -200));
        });
      } else {
      	$(".arrow", $(this)).addClass("open");
      	$(this).parent().addClass("open");
      	nextUL.slideDown(opts.speed, function() {
	        $("body").hasClass("jhtml-sidebar-closed") === false 
	        	&& ($("body").hasClass("jhtml-sidebar-fixed") ? sidebarMenu.slimScroll({
	            scrollTo: target.position().top
	        }) : opts.scrollbar(target, -200));
        });
      }
      if (opts.onClickRow.call(target, rows[index]) == false) {
  			return;
  		}
      setSize(element);
			return false;
		});
		
		$(sidebarMenu).on("click.sidebar", "li > a.ajaxify", function(e) {
			e.stopPropagation();
			var target = $(this), index = target.attr("index");
			opts.loading();
      if (opts.onClickRow.call(target, rows[index]) == false) {
  			return;
  		}
      setTimeout(function() {
      	opts.loaded();
      }, 200);
			return false;
		});
		
		$(window).resize(function(e) {
    	setSize(element);
    	e.stopPropagation();
    });
		
	};
	
	
	/**
	 * 根据菜单ID选中菜单param={menuId:菜单id}
	 */
	function selectItem(element,param) {
		var menuId=param.menuId?param.menuId:(window.location.hash?window.location.hash.replace("#","#sidebar-"):null);
		if(!menuId){
			return;
		}
		var target = $(menuId);
		if(target.length==0){
			return;
		}
		
		//取消当前选中菜单
		$(".open", element).removeClass("open");
		//设置菜单menuId为选中
		target.parent().addClass("open");
		
		// 循环设置上级菜单选中状态
		var parentUL = target.parent().parent();
		while (parentUL.length > 0) {
			parentUL.addClass("open");
			parentUL.parent().addClass("open");
			parentUL.show();
			parentUL.prev().find(".arrow").addClass("open");
			parentUL = parentUL.parent().parent();
		}
		
		var opts = $.data(element, "sidebar").options;
		var nextUL = target.next();
	    if (nextUL.is(":visible")) {
	      	$(".arrow", $(target)).removeClass("open");
	      	$(target).parent().removeClass("open");
	      	nextUL.slideUp(opts.speed, function() {
		        $("body").hasClass("jhtml-sidebar-closed") === false 
		        	&& ($("body").hasClass("jhtml-sidebar-fixed") ? sidebarMenu.slimScroll({
		            scrollTo: target.position().top
		        }) : opts.scrollbar(target, -200));
	        });
	    } else {
	      	$(".arrow", $(target)).addClass("open");
	      	$(target).parent().addClass("open");
	      	nextUL.slideDown(opts.speed, function() {
		        $("body").hasClass("jhtml-sidebar-closed") === false 
		        	&& ($("body").hasClass("jhtml-sidebar-fixed") ? sidebarMenu.slimScroll({
		            scrollTo: target.position().top
		        }) : opts.scrollbar(target, -200));
	        });
	    }
	      
	    //设置大小
	    setSize(element);
	};
	
	
	
	/** --------------------------------系统组件核心方法---------------------------------- */
	$.fn.sidebar = function(options, param) {
		if (typeof opts == "string") {
			return $.fn.sidebar.methods[options](this, param);
		}
		var opts = options || {};
		param = param || {};
		return this.each(function() {
			var state = $.data(this, "sidebar");
			if (state) {
				$.extend(state.opts, opts);
			} else {
				opts = $.extend({}, $.fn.sidebar.defaults, $.fn.sidebar.parseOptions(this), opts);
				$.data(this, "sidebar", {
					options : opts,
					sidebar : $(this).addClass("jhtml-sidebar")
				});
				init(this);
			}
			var rows = [];
			if (opts.data) {
				rows = loadData(this, $.extend(true, [], opts.data));
			}
			if (opts.url) {
				request(this, this);
			}
			setSize(this, param);
			bindEvents(this, rows);
			
			if(opts.selectMenu){
				selectItem(this,param);
			}
			
		});
	};
	
	/** --------------------------------系统组件业务方法---------------------------------- */
	$.fn.sidebar.methods = {
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
	$.fn.sidebar.parseOptions = function(target) {
		return $.extend({}, $.parser.parseOptions(target, ["title"]));
	};

	/** --------------------------------系统默认参数---------------------------------- */
	$.fn.sidebar.defaults = $.extend({}, $.fn.observe.defaults, {
		title: null,
		speed: 20,
		selected: 0,
		fixed: false,
		expanded:true,
		autoScroll:true,
		showLine: true,
		selectMenu:true,
		formatter : function(menu) {
			var opts = $.data(this, 'sidebar').options;
			return menu[opts.text];
		},
		onClickRow: function(row) {
			
		}
	});

})(jQuery);
