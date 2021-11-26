<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 系统适应浏览器信息 -->
<!--[if IE 8]>      <html class="ie ie8"> <![endif]-->
<!--[if IE 9]>      <html class="ie ie9"> <![endif]-->
<html lang="zh">
<head>
<meta charset="utf-8" />
<!-- 系统站点基础信息 -->
<title>智慧农业教学实训平台</title>
<!-- 系统站点显示信息 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 系统站点图标信息 -->
<link rel="shortcut icon" href="favicon.ico">
<%--============================================================================
定义布局的JSP：jhtml-layout由header、menus、content、footer几部分组成
============================================================================--%>
<%@ include file="/includes/taglibs.jsp"%><%@ include file="/includes/plugins.jsp"%>
<style type="text/css">
 	.nav-item i{
		color:#fff;
	}
	.nav-item span{
		color:#fff;
	} 
</style>
</head>
<body class="jhtml-header-fixed jhtml-footer-fixed">

	<!-- 系统框架布局页面头部（Header） -->
	<%@ include file="/includes/header.jsp"%>

	<!-- 系统框架布局中部（Center） -->
	<div class="jhtml-center">

		<!-- 系统框架布局左侧菜单（Menus） -->
		<div class="jhtml-sidebar-wrapper" style="margin-top: -80px;">
			<!-- 系统左侧菜单树形面板 -->
			<div class="jhtml-sidebar navbar-collapse collapse" style="background-color: #273140;margin-top: -80px">
				<img src="${ctx}/resources/images/logo.jpg" alt="logo" class="logo-default" style="width:200px;margin-bottom: 15px;margin-top:15px;margin-left: 15px;"/> 
			</div>
		</div>

		<!-- 系统框架布局页面内容（Content） -->
		<div class="jhtml-content-wrapper">
			<!-- 系统显示内容面板 -->
			<div class="jhtml-content">
				<div class="jhtml-tabs"></div>
			</div>
		</div>

	</div>

</body>
<script type="text/javascript">
	/**
	 * 系统页面加载后初始化处理.
	 */
	 $(function() {

			$(".jhtml-tabs").tabs({
				data : [ {
					sid : "2015101",
					text : "欢迎页",
					iconCls : "",
					url : "${ctx}/welcome.jsp",
					mode : "ajaxify"
				} ]
			});

		$(".jhtml-sidebar").sidebar({
			data : [{
				sid : "2015101",
				text : "用户管理",
				iconCls : "fa icon-users",
				url : "${ctx}/webview/userInfo/find.jsp",
				mode : "ajaxify"/*  ,
				children:[{
					sid : "20151011",
					text : "用户管理",
					iconCls : "fs icon-cloud-upload",
					url : "${ctx}/shareTableInfo/addFlow",
					mode : "ajaxify"
				}]  */
			},{
				sid : "2015102",
				text : "角色管理",
				iconCls : "fa icon-male",
				url : "${ctx}/webview/role/find.jsp",
				mode : "ajaxify"
			},{
				sid : "2015103",
				text : "远程农业监控系统",
				iconCls : "fa icon-database",
				mode : "up",
				children:[{
					sid : "20151031",
					text : "大棚实时监控",
					iconCls : "fa icon-eye",
					url : "${ctx}/webview/farm_ycjk_ssjk/ssjk.jsp",
					mode : "ajaxify"
				},
                {
                    sid : "20151032",
                    text : "操作记录查询",
                    iconCls : "fs icon-doc",
                    <%--url : "${ctx}/farm_ycjk_czjlcx/findAll",--%>
                    url : "${ctx}/webview/farm_ycjk_czjlcx/find.jsp",
                    mode : "ajaxify"
                },
                    {
                        sid : "20151033",
                        text : "告警阀值设置",
                        iconCls : "fa icon-cog",
                        url : "${ctx}/webview/farm_ycjk_gjfz/add.jsp",
                        mode : "ajaxify"
                    }]
			},
				{
                sid : "2015104",
                text : "农业物联网生产系统",
                iconCls : "fa icon-bar-chart-o",
                mode : "up",
                children:[{
                    sid : "20151041",
                    text : "灾害预警功能",
                    iconCls : "fa icon-exclamation-triangle",
                    url : "${ctx}/webview/farm_ycjk_zhyj/zhyj.jsp",
                    mode : "ajaxify"
                },
                    {
                        sid : "20151042",
                        text : "作物生长历史",
                        iconCls : "fa icon-tree",
                        url : "${ctx}/webview/farm_ycjk_zwszls/find.jsp",
                        mode : "ajaxify"
                    },
                    {
                        sid : "20151043",
                        text : "预警策略配置",
                        iconCls : "fa icon-exclamation",
                        url : "${ctx}/webview/farm_ycjk_yjclpz/yjclpz.jsp",
                        mode : "ajaxify"
                    },
                    {
                        sid : "20151044",
                        text : "设备管理",
                        iconCls : "fa icon-laptop",
                        url : "${ctx}/webview/farm_ycjk_sbgl/sbgl.jsp",
                        mode : "ajaxify"
                    },
                    {
                        sid : "20151045",
                        text : "环境趋势",
                        iconCls : "fs icon-bar-chart",
                        url : "${ctx}/webview/farm_ycjk_hjqs/hjqs.jsp",
                        mode : "ajaxify"
                    },
                    {
                        sid : "20151046",
                        text : "实时监控",
                        iconCls : "fs icon-pie-chart",
                        url : "${ctx}/webview/farm_ycjk_scgl_ssjk/ssjk.jsp",
                        mode : "ajaxify"
                    }]
            },
                {
                    sid : "2015105",
                    text : "云溯源查询监管系统",
                    iconCls : "fa icon-columns",
                    mode : "up",
                    children:[
                        {
                            sid : "20151052",
                            text : "信息发布",
                            iconCls : "fa icon-list-alt",
                            <%--url : "${ctx}/farm_ycjk_czjlcx/findAll",--%>
                            url : "${ctx}/webview/farm_ycjk_xxfb/xxfb.jsp",
                            mode : "ajaxify"
                        },
                        {
                            sid : "20151053",
                            text : "信息发布操作",
                            iconCls : "fa icon-pencil",
                            url : "${ctx}/webview/farm_ycjk_xxfb/add.jsp",
                            mode : "ajaxify"
                        }]
                },
				{
                    sid : "2015106",
                    text : "云信息追溯系统",
                    iconCls : "fa icon-paper-plane-o",
                    mode : "up",
                    children:[{
                        sid : "20151061",
                        text : "生产过程跟踪",
                        iconCls : "fa icon-navicon",
                        <%--url : "${ctx}/webview/farm_ycjk_scgcgz/scgcgz.jsp",--%>
                        url : "${ctx}/farm_ycjk_scgc/findAll",
                        mode : "ajaxify"
                    },
                        {
                            sid : "20151062",
                            text : "生产过程",
                            iconCls : "fa icon-wheelchair",
                            <%--url : "${ctx}/farm_ycjk_czjlcx/findAll",--%>
                            url : "${ctx}/webview/farm_ycjk_scgc/scgc.jsp",
                            mode : "ajaxify"
                        },
                        {
                            sid : "20151063",
                            text : "物流质量过程",
                            iconCls : "fa icon-truck",
                            url : "${ctx}/webview/farm_ycjk_wlzlgc/wlzlgc.jsp",
                            mode : "ajaxify"
                        }]
                },
                {
                    sid : "2015107",
                    text : "系统管理",
                    iconCls : "fa icon-server",
                    mode : "up",
                    children:[
                        {
                            sid : "20151071",
                            text : "系统日志",
                            iconCls : "fa icon-clipboard",
                            url : "${ctx}/webview/farm_ycjk_xtrz/xtrz.jsp",
                            mode : "ajaxify"
                        }]
                }
			],
			onClickRow : function(item) {
				if(item.mode == "ajaxify"){
					$(".jhtml-tabs").tabs("add", {
						iconCls : item.iconCls,
						text : item.text,
						event : item.sid,
						url : item.url,
						close : true
					});
				}
			}
		});

		// 初始化顶部滑动菜单方法.
		$(".sidebar-toggler").frame("initSidebar");

		// 初始化顶部全局搜索方法.
		$(".search-form").frame("initSearch");

	});
</script>
</html>

