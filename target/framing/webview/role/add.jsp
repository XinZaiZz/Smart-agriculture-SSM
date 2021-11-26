<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:新增字段字段页面：/role/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>角色管理-新增角色信息</title>
</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption" style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>新增角色信息
				</div>
			</div>
			<div class="portlet-body">
	
				<form name="新增角色信息表单" class="form-horizontal" action="${ctx}/role/save"  method="post">
					<div class="form-body">
					<input type="hidden" name="sid"/>
					<input type="hidden" name="created"/>
					<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>角色名</label>
									<div class="col-md-9">
										<input type="text" name="name" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
							
						</div>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="btn-group">
									<button class="btn btn-success" title="保存" type="button">保存</button>
								    <button class="btn btn-default" title="关闭" type="button">关闭</button>
							    </div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/webview/role/script/role.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {

			$("form[name=新增角色信息表单] button[title=保存]").on("click",function(){
				save("form[name=新增角色信息表单]");
			});

			$("form[name=新增角色信息表单] button[title=关闭]").on("click", function() {
				$(".jhtml-tabs").tabs("remove", {
			         text: "新增角色"
			     });
				$(".jhtml-tabs").tabs("select",{
					 text: "角色管理"
				});
			});

		});
	</script>


</body>
</html>
