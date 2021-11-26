/**
 * [导航标题组件] jhtml-navbar.js
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
	function init(element) {
		var options = $.data(element, 'navbar').options;
		if(options.autoTitle) {
			var cc = $(element);
			$(options.target).find("li.active>.nav-link").each(function(){
				var link = $(this);
				var li = $("<li></li>").append(link.html()).appendTo(cc);
				li.on('mouseover.navbar', function(e) {
					li.addClass('li-focus');
				}).on('mouseout.navbar', function(e) {
					li.removeClass('li-focus');
				}).on("click.navbar", function(e) {
					options.onClick.call(this, link);
				});
			});
		}
	}
	
	function add(element, options) {
		
	}
	
	function remove(element, which) {
		
	}

	/** --------------------------------系统组件核心方法---------------------------------- */
	$.fn.navbar = function(options, param) {
		// 判断参数调用目标方法.
		if (typeof options == 'string') {
			return $.fn.navbar.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'navbar');
			if (state) {
				$.extend(state.options, options);
			} else {
				$.data(this, 'navbar', {
					options : $.extend({}, $.fn.navbar.defaults, $.fn.navbar.parseOptions(this), options),
					navbar : $(this).addClass('jhtml-navbar')
				});
				init(this);
			}
		});
	};
	
	/** --------------------------------系统组件业务方法---------------------------------- */
	$.fn.navbar.methods = {
		options : function(jq) {
			return $.data(jq[0], 'navbar').options;
		},
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
	$.fn.navbar.parseOptions = function(target) {
		return $.extend({}, $.parser.parseOptions(target));
	};

	/** --------------------------------系统默认参数---------------------------------- */
	$.fn.navbar.defaults = {
		autoTitle: false,
		name : 'jhtml-navbar',
		onClick: function(){
			
		}
	};

})(jQuery);
