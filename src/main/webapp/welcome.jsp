<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--============================================================================
■页面标题:系统欢迎页面：welcome.jsp
■页面说明：... ...
============================================================================--%>
<%--<%@ include file="/includes/taglibs.jsp"%>--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>welcome欢迎首页</title>

<!-- BEGIN PAGE HEAD-->
<div class="jhtml-head">
	<!-- BEGIN PAGE TITLE -->
	<div class="jhtml-title">
		<h1>
			Dashboard <small>dashboard statistics</small>
		</h1>
	</div>
	<!-- END PAGE TITLE -->
	<!-- BEGIN PAGE TOOLBAR -->
	<div class="jhtml-toolbar">
		<!-- BEGIN THEME PANEL -->
		<div class="btn-group btn-theme-panel">
			<a href="javascript:;" class="btn dropdown-toggle" data-toggle="dropdown"> <i class="fs icon-settings"></i>
			</a>
			<div class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<h3>THEME</h3>
						<ul class="theme-colors">
							<li class="theme-color theme-color-default" data-theme="default"><span class="theme-color-view"></span> <span class="theme-color-name">Dark Header</span></li>
							<li class="theme-color theme-color-light active" data-theme="light"><span class="theme-color-view"></span> <span class="theme-color-name">Light Header</span></li>
						</ul>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-12 seperator">
						<h3>LAYOUT</h3>
						<ul class="theme-settings">
							<li>Theme Style <select class="layout-style-option form-control input-small input-sm">
									<option value="square">Square corners</option>
									<option value="rounded" selected="selected">Rounded corners</option>
							</select>
							</li>
							<li>Layout <select class="layout-option form-control input-small input-sm">
									<option value="fluid" selected="selected">Fluid</option>
									<option value="boxed">Boxed</option>
							</select>
							</li>
							<li>Header <select class="jhtml-header-option form-control input-small input-sm">
									<option value="fixed" selected="selected">Fixed</option>
									<option value="default">Default</option>
							</select>
							</li>
							<li>Top Dropdowns <select class="jhtml-header-top-dropdown-style-option form-control input-small input-sm">
									<option value="light">Light</option>
									<option value="dark" selected="selected">Dark</option>
							</select>
							</li>
							<li>Sidebar Mode <select class="sidebar-option form-control input-small input-sm">
									<option value="fixed">Fixed</option>
									<option value="default" selected="selected">Default</option>
							</select>
							</li>
							<li>Sidebar Menu <select class="sidebar-menu-option form-control input-small input-sm">
									<option value="accordion" selected="selected">Accordion</option>
									<option value="hover">Hover</option>
							</select>
							</li>
							<li>Sidebar Position <select class="sidebar-pos-option form-control input-small input-sm">
									<option value="left" selected="selected">Left</option>
									<option value="right">Right</option>
							</select>
							</li>
							<li>Footer <select class="jhtml-footer-option form-control input-small input-sm">
									<option value="fixed">Fixed</option>
									<option value="default" selected="selected">Default</option>
							</select>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- END THEME PANEL -->
	</div>
	<!-- END PAGE TOOLBAR -->
</div>
<!-- END PAGE HEAD-->
<!-- BEGIN PAGE BREADCRUMB -->
<div title="系统导航栏" class="breadcrumb" data-options="autoTitle:true">
	<!-- <li><i class="fa icon-home"></i><a href="index.html">Home</a></li>
	<li><span class="active">Dashboard</span></li> -->
</div>
<!-- END PAGE BREADCRUMB -->
<!-- BEGIN PAGE BASE CONTENT -->
<!-- BEGIN DASHBOARD STATS 1-->
<%--<div class="row">
	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
		<div class="dashboard-stat red">
			<div class="visual">
				<i class="fa icon-bar-chart-o"></i>
			</div>
			<div class="details">
				<div class="number">
					<span data-counter="counterup" data-value="12,5">0</span>M$
				</div>
				<div class="desc">Total Profit</div>
			</div>
			<a class="more" href="javascript:;"> View more <i class="fs icon-swapright fs icon-white"></i>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
		<div class="dashboard-stat green">
			<div class="visual">
				<i class="fa icon-shopping-cart"></i>
			</div>
			<div class="details">
				<div class="number">
					<span data-counter="counterup" data-value="549">0</span>
				</div>
				<div class="desc">New Orders</div>
			</div>
			<a class="more" href="javascript:;"> View more <i class="fs icon-swapright fs icon-white"></i>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
		<div class="dashboard-stat purple">
			<div class="visual">
				<i class="fa icon-globe"></i>
			</div>
			<div class="details">
				<div class="number">
					+ <span data-counter="counterup" data-value="89"></span>%
				</div>
				<div class="desc">Brand Popularity</div>
			</div>
			<a class="more" href="javascript:;"> View more <i class="fs icon-swapright fs icon-white"></i>
			</a>
		</div>
	</div>
</div>--%>
<%--<div class="clearfix"></div>--%>
<!-- END DASHBOARD STATS 1-->
<%--<div class="row">
	<div class="col-md-6 col-sm-6">
		<!-- BEGIN PORTLET-->
		<div class="portlet light bordered">
			<div class="portlet-title">
				<div class="caption">
					<i class="fs icon-bar-chart font-green"></i> <span class="title-subject font-green bold uppercase">Site Visits</span> <span class="title-helper">weekly stats...</span>
				</div>
				<div class="actions">
					<div class="btn-group btn-group-devided" data-toggle="buttons">
						<label class="btn red btn-outline btn-circle btn-sm active"> <input type="radio" name="options" class="toggle" id="option1">New
						</label> <label class="btn red btn-outline btn-circle btn-sm"> <input type="radio" name="options" class="toggle" id="option2">Returning
						</label>
					</div>
				</div>
			</div>
			<div class="portlet-body">
				<div id="site_statistics_loading">
					<img src="${ctx}/resources/images/loading.gif" alt="loading" />
				</div>
				<div id="site_statistics_content" class="display-none">
					<div id="site_statistics" class="chart"></div>
				</div>
			</div>
		</div>
		<!-- END PORTLET-->
	</div>
	<div class="col-md-6 col-sm-6">
		<!-- BEGIN PORTLET-->
		<div class="portlet light bordered">
			<div class="portlet-title">
				<div class="caption">
					<i class="fs icon-share font-red-sunglo hide"></i> <span class="title-subject font-red-sunglo bold uppercase">Revenue</span> <span class="title-helper">monthly stats...</span>
				</div>
				<div class="actions">
					<div class="btn-group">
						<a href="" class="btn dark btn-outline btn-circle btn-sm dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> Filter Range <span class="fa icon-angle-down"> </span>
						</a>
						<ul class="dropdown-menu pull-right">
							<li><a href="javascript:;"> Q1 2014 <span class="label label-sm label-default"> past </span>
							</a></li>
							<li><a href="javascript:;"> Q2 2014 <span class="label label-sm label-default"> past </span>
							</a></li>
							<li class="active"><a href="javascript:;"> Q3 2014 <span class="label label-sm label-success"> current </span>
							</a></li>
							<li><a href="javascript:;"> Q4 2014 <span class="label label-sm label-warning"> upcoming </span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="portlet-body">
				<div id="site_activities_loading">
					<img src="${ctx}/resources/images/loading.gif" alt="loading" />
				</div>
				<div id="site_activities_content" class="display-none">
					<div id="site_activities" style="height: 228px;"></div>
				</div>
				<div style="margin: 20px 0 10px 30px">
					<div class="row">
						<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
							<span class="label label-sm label-success"> Revenue: </span>
							<h3>$13,234</h3>
						</div>
						<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
							<span class="label label-sm label-info"> Tax: </span>
							<h3>$134,900</h3>
						</div>
						<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
							<span class="label label-sm label-danger"> Shipment: </span>
							<h3>$1,134</h3>
						</div>
						<div class="col-md-3 col-sm-3 col-xs-6 text-stat">
							<span class="label label-sm label-warning"> Orders: </span>
							<h3>235090</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END PORTLET-->
	</div>
</div>--%>
<style >
	#div_img{
		width: 100%;
		height: 695px;
		background-color: #6CC5A1;
	}
	#img01{
		position: relative;
		left: 40%;top: 5%;
		width: 234px;height: 234px;
		border: none;
	}
	#img02{
		position: relative;
		left: 37%;top:26%;
		width: 234px;height: 234px;
		border: none;
	}
	#img03{
		position: relative;right:0%;top:26%;
		width: 234px;height: 234px;
		border: none;
	}
	#img04{
		position: absolute;left: 42%;top:58%;
		width: 234px;height: 234px;
		border: none;
	}
	#img05{
		position: absolute;
		left: 54%;top:58%;
		width: 234px;height: 234px;
	}
</style>

	<%--<script src="resources/js/jquery-2.1.3.min.js"></script>--%>

</head>
<%--<div id="img">
<div class="row">
	<div class="col-md-12">
			<div id="img01"></div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
			<div id="img02"></div>
	</div>
	<div class="col-md-6">
			<div id="img03"></div>
	</div>
</div>

<div class="row">
	<div class="col-md-6">
			<div id="img04"></div>
	</div>
	<div class="col-md-6">
			<div id="img05"></div>
	</div>
</div>
</div>--%>
<div id="div_img" class="row">
	<img id="img01" src="resources/images/ssjk/m01.png">
	<img id="img02" src="resources/images/ssjk/m02.png">
	<img id="img03" src="resources/images/ssjk/m03.png">
	<img id="img04" src="resources/images/ssjk/m04.png">
	<img id="img05" src="resources/images/ssjk/m05.png">
</div>


<script type="text/javascript">
    $("#img01").hover(function () {
        $(this).attr("src","resources/images/ssjk/m01on.png");
    },function () {
        $(this).attr("src","resources/images/ssjk/m01.png");
    });
    $("#img02").hover(function () {
        $(this).attr("src","resources/images/ssjk/m02on.png");
    },function () {
        $(this).attr("src","resources/images/ssjk/m02.png");
    });
    $("#img03").hover(function () {
        $(this).attr("src","resources/images/ssjk/m03on.png");
    },function () {
        $(this).attr("src","resources/images/ssjk/m03.png");
    });
    $("#img04").hover(function () {
        $(this).attr("src","resources/images/ssjk/m04on.png");
    },function () {
        $(this).attr("src","resources/images/ssjk/m04.png");
    });
    $("#img05").hover(function () {
        $(this).attr("src","resources/images/ssjk/m05on.png");
    },function () {
        $(this).attr("src","resources/images/ssjk/m05.png");
    });

</script>
</html>
