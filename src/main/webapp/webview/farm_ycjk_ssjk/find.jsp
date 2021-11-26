<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:管理系统用户页面：/farm_ycjk_ssjk/findDefineData.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>远程农业监控系统-大棚实时监控</title>
</head>
<body>
	<div class="portlet box ">
	<div class="portlet-title">
		<div class="caption" style="color:#45A3CA;">大棚实时监控表单</div>
	</div>
	<div class="portlet-body">
		<form name="大棚实时监控查询表单" class="form-horizontal" method="post">
			<div class="form-body">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<label class="control-label col-md-4">用户名：</label>
							<div class="col-md-8">
								<input type="text" name="name" class="form-control" placeholder="请输入用户名.." />
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
							<button class="btn btn-default" title="清空" type="button">清空</button>
							<button class="btn btn-default" title="新增" type="button">新增</button>
							<button class="btn btn-default" title="批量删除" type="button">批量删除</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<div class="portlet box bordered">
	<div class="portlet-title">
		<div class="caption">
			大棚实时监控列表
		</div>
	</div>
	<div class="portlet-body">
		<table title="大棚实时监控列表" class="table datagrid table-striped table-bordered table-hover order-farm_ycjk_ssjk"> 
		</table>
	</div>
</div>
	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_ssjk/script/farm_ycjk_ssjk.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {
			
			//查询大棚实时监控
			getFarm_ycjk_ssjk("table[title=大棚实时监控列表]");
			
			//新增大棚实时监控
			$("form[name=大棚实时监控查询表单] button[title=新增]").on("click", function() {
				add();
			});
			
			$("form[name=大棚实时监控查询表单] button[title=查询]").on("click", function() {
				var datagrid = $("table[title=大棚实时监控列表]").datagrid();
				datagrid.api().ajax.reload();
			});
			
			$("form[name=大棚实时监控查询表单] button[title=清空]").on("click", function() {
				clear("form[name=大棚实时监控查询表单]");
			});
			$("button[title=批量删除]").on("click", function() {
				deleteChartInfo("table[title=大棚实时监控列表]");
			}); 

		});
	</script>


</body>
</html>