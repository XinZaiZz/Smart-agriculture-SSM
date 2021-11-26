<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:管理系统用户页面：/farm_ycjk_czjlcx/findDefineData.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>农业物联网生产系统-信息发布表单</title>
	<%--<style type="text/css">
		#bckgDIV{
			background-image: url(resources/images/sbgl/devbg.png);
			background-position-x: center;
			background-position-y: center;
			margin: 0 auto;
			height: 525px;
			width: 700px;
		}
	</style>--%>
</head>
<body>
	<div class="portlet box ">
	<div class="portlet-title">
 <%--       <div class="row">
            <div class="col-md-6">--%>
		        <div class="caption" style="color:#45A3CA;">信息发布表单</div>
            <%--</div>--%>
		<%--<div class="form-actions">
				<div class="btn-group" style="float: right" >
					<button class="btn btn-success" title="新增" type="button" id="add-btn">新增</button>
				</div>
		</div>--%>
		<%--</div>--%>
	</div>
		<%--<div style="text-align: center">
			<div id="bckgDIV">
				&lt;%&ndash;<img src="resources/images/sbgl/devbg.png">&ndash;%&gt;
				<div id="fwq">
				<img src="resources/images/sbgl/right.png" id="right_101">
				</div>
					<div id="wlcs">
				<img src="resources/images/sbgl/right.png" id="right_201">
					</div>
					<div id="txwg">
				<img src="resources/images/sbgl/right.png" id="right_301">
					</div>
					<div id="cgq">
				<img src="resources/images/sbgl/right.png" id="right_401">
				<img src="resources/images/sbgl/right.png" id="right_402">
				<img src="resources/images/sbgl/right.png" id="right_403">
				<img src="resources/images/sbgl/right.png" id="right_404">
				<img src="resources/images/sbgl/right.png" id="right_405">
					</div>
			</div>
		</div>--%>
	<div class="portlet-body">
		<%--<form name="预警策略配置表单" class="form-horizontal" method="post">
			<div class="form-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label col-md-4">查询起始时间</label>
							<div class="col-md-8">
									<input type="date" name="name"  class="form-control"/>
							</div>
						</div>
					</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class="control-label col-md-4">查询结束时间</label>
									<div class="col-md-8">
										<input type="date" name="name"  class="form-control"/>
									</div>
							</div>
						</div>
				</div>
			</div>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-12 text-right">
						<div class="btn-group">
							<button class="btn btn-default" title="查询" type="button">查询</button>
						</div>
					</div>
				</div>
			</div>
		</form>--%>
	</div>
</div>
<div class="portlet box bordered">
	<div class="portlet-title">
		<div class="caption">
			信息发布列表
		</div>
	</div>
	<div class="portlet-body">
		<table title="信息发布列表" class="table datagrid table-striped table-bordered table-hover order-farm_ycjk_xxfb">
		</table>
	</div>
</div>
	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_xxfb/script/farm_ycjk_xxfb.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {

			//查询大棚实时监控
			getFarm_ycjk_xxfb("table[title=信息发布列表]");
			
			//新增大棚实时监控
			$("#add-btn").on("click", function() {
				add();
			});
			
			$("form[name=信息发布表单] button[title=查询]").on("click", function() {
				var datagrid = $("table[title=信息发布列表]").datagrid();
				datagrid.api().ajax.reload();
			});
			
			$("form[name=信息发布表单] button[title=清空]").on("click", function() {
				clear("form[name=设备管理表单]");
			});
			$("button[title=批量删除]").on("click", function() {
				deleteChartInfo("table[title=信息发布列表]");
			}); 

		});
	</script>


</body>
</html>