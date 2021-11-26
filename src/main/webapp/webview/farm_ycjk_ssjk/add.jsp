<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:新增字段字段页面：/user_info/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>用户管理-新增用户信息</title>
</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption"  style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>新增用户信息
				</div>
			</div>
			<div class="portlet-body">
	
				<form name="新增用户信息表单" class="form-horizontal" action="${ctx}/userInfo/save"  method="post">
					<div class="form-body">
					<input type="hidden" name="sid"/>
					<input type="hidden" name="created"/>
					<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>用户姓名</label>
									<div class="col-md-9">
										<input type="text" name="name" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>角色</label>
									<div class="col-md-9">
									<select name="roleid" class="form-control">
									</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>账号：</label>
									<div class="col-md-9">
										<input type="text" name="username" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>密码</label>
									<div class="col-md-9">
									<input type="password" name="password" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>
						<!-- Single button -->
							<div class="btn-group">
							  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Action <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu">
							    <li><a href="#">Action</a></li>
							    <li><a href="#">Another action</a></li>
							    <li><a href="#">Something else here</a></li>
							    <li role="separator" class="divider"></li>
							    <li><a href="#">Separated link</a></li>
							  </ul>
							</div>
							<div class="switch-radio2">
			   			 		<input type="radio" name="chartType" value="bar" checked="checked"/>
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
	
	<script type="text/javascript" src="${ctx}/webview/userInfo/script/userInfo.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {
			//查询角色
			loadRole("form[name=新增用户信息表单] select[name=roleid]");
			$("form[name=新增用户信息表单] button[title=保存]").on("click",function(){
				save("form[name=新增用户信息表单]");
			});

			$("form[name=新增用户信息表单] button[title=关闭]").on("click", function() {
				$(".jhtml-tabs").tabs("remove", {
			         text: "新增用户"
			     });
				$(".jhtml-tabs").tabs("select",{
					 text: "用户管理"
				});
			});

		});
	</script>


</body>
</html>
