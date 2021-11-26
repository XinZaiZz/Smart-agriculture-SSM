<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:修改字段字段页面：/user_info/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>云信息追溯系统-修改物流质量过程</title>
</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption"  style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>修改物流质量过程
				</div>
			</div>
			<div class="portlet-body">
	
				<form name="修改物流质量过程表单" class="form-horizontal" action="${ctx}/farm_ycjk_wlzlgc/save"  method="post">
					<div class="form-body">
					<input type="hidden" name="sid"/>
					<input type="hidden" name="created"/>
					<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>产品号码</label>
									<div class="col-md-9">
										<%--<input type="text" name="name" class="form-control validate[required,maxSize[50]]" />--%>
										<input type="text" name="cphm" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>追溯类别</label>
									<div class="col-md-9">
									<%--<select name="roleid" class="form-control">--%>
									<%--<select name="yjdj" class="form-control">--%>
										<input type="text" name="zslb" class="form-control validate[required,maxSize[50]]" />
									</select>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>操作名称</label>
									<div class="col-md-9">
										<%--<input type="text" name="username" class="form-control validate[required,maxSize[50]]" />--%>
										<input type="text" name="czmc" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>
						<input type="hidden" name="czsj">
							<%--<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>密码</label>
									<div class="col-md-9">
									<input type="password" name="password" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>--%>
					</div>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="btn-group">
									<%--<button class="btn btn-success" title="保存" type="button">保存</button>--%>
									<input class="btn btn-success" title="保存" type="button" value="保存" id="sub"></input>
								    <%--<button class="btn btn-default" title="关闭" type="button">关闭</button>--%>
									<input class="btn btn-default" title="关闭" type="button" value="关闭" id="close"></input>
							    </div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_wlzlgc/script/farm_ycjk_wlzlgc.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {
			//查询角色
			// loadRole("form[name=修改预警策略配置表单] select[name=roleid]");
			loadRole("form[name=修改物流质量过程表单] select[name=yjdj]");

			if("${param.sid}"){
				$.ajax({
					type: "POST",
					dataType:"json",
					url: "${ctx}/farm_ycjk_wlzlgc/getOne",
					data:{sid:"${param.sid}"},
					success: function(data) {
						//加载数据
						load("form[name=修改物流质量过程表单]",data);
						
						//处理角色的设置
						//下拉组件的回显
						/*$("select").each(function(i,c){
							var name = $(c).attr("yjdj");
							$(c).find("option[value="+data.data[name]+"]").attr("selected","selected");
						});*/
					},
					error: function(data){
						$.messager.alert("提示信息",data.message);
					}
				});
			}

			
			$("#sub").on("click",function(){
				updsave("form[name=修改物流质量过程表单]");
			});

			$("#close").on("click", function() {
				$(".jhtml-tabs").tabs("remove", {
			         text: "修改用户"
			     });
				$(".jhtml-tabs").tabs("select",{
					 text: "用户管理"
				});
			});

		});
	</script>


</body>
</html>
