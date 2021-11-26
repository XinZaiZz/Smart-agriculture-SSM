/**
 * [核心解析组件] jhtml-parser.js
 * 
 * Licensed under the GPL: http://www.liyong.com.cn/licenses.txt
 * 
 * Copyright 2010 liyong [ 343639986@qq.com ]
 * 
 * ----------------------------------------------------------------------------
 * 
 */
(function($) {
	
	$.parser = {
		auto : true,
		onComplete : function(context) {
		},
		plugins:[],
		parse : function(context) {
			var aa = [];
			for (var i = 0; i < $.parser.plugins.length; i++) {
				var name = $.parser.plugins[i];
				var r = $('.jhtml-' + name, context);
				if (r.length) {
					if (r[name]) {
						r[name]();
					} else {
						aa.push({
							name : name,
							jq : r
						});
					}
				}
			}
			if (aa.length && window.Loader) {
				var names = [];
				for (var i = 0; i < aa.length; i++) {
					names.push(aa[i].name);
				}
				Loader.load(names, function() {
					for (var i = 0; i < aa.length; i++) {
						var name = aa[i].name;
						var jq = aa[i].jq;
						jq[name]();
					}
					$.parser.onComplete.call($.parser, context);
				});
			} else {
				$.parser.onComplete.call($.parser, context);
			}
		},

		parseValue : function(property, value, parent, delta) {
			delta = delta || 0;
			var v = $.trim(String(value || ''));
			var endchar = v.substr(v.length - 1, 1);
			if (endchar == '%') {
				v = parseInt(v.substr(0, v.length - 1));
				if (property.toLowerCase().indexOf('width') >= 0) {
					v = Math.floor((parent.width() - delta) * v / 100.0);
				} else {
					v = Math.floor((parent.height() - delta) * v / 100.0);
				}
			} else {
				v = parseInt(v) || undefined;
			}
			return v;
		},

		/**
		 * parse options, including standard 'data-options' attribute.
		 * 
		 * calling examples: $.parser.parseOptions(target);
		 * $.parser.parseOptions(target,
		 * ['id','title','width',{fit:'boolean',border:'boolean'},{min:'number'}]);
		 */
		parseOptions : function(target, properties) {
			var t = $(target);
			var options = {};

			var s = $.trim(t.attr('data-options'));
			if (s) {
				if (s.substring(0, 1) != '{') {
					s = '{' + s + '}';
				}
				options = (new Function('return ' + s))();
			}
			$.map([ 'width', 'height', 'left', 'top', 'minWidth', 'maxWidth', 'minHeight', 'maxHeight' ], function(p) {
				var pv = $.trim(target.style[p] || '');
				if (pv) {
					if (pv.indexOf('%') == -1) {
						pv = parseInt(pv) || undefined;
					}
					options[p] = pv;
				}
			});

			if (properties) {
				var opts = {};
				for (var i = 0; i < properties.length; i++) {
					var pp = properties[i];
					if (typeof pp == 'string') {
						opts[pp] = t.attr(pp);
					} else {
						for ( var name in pp) {
							var type = pp[name];
							if (type == 'boolean') {
								opts[name] = t.attr(name) ? (t.attr(name) == 'true') : undefined;
							} else if (type == 'number') {
								opts[name] = t.attr(name) == '0' ? 0 : parseFloat(t.attr(name)) || undefined;
							}
						}
					}
				}
				$.extend(options, opts);
			}
			return options;
		}
	};
	
})(jQuery);

