<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:修改字段字段页面：/user_info/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>云溯源查询监管系统-修改信息发布操作</title>

	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<script type="text/javascript" charset="utf-8" src="${ctx}/resources/plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/resources/plugins/ueditor/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="${ctx}/resources/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<style type="text/css">
		#editor{
			width: 1024px;
			height: auto;
		}
	</style>
</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption"  style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>修改信息发布操作
				</div>
			</div>
			<div class="portlet-body">
	
				<form name="修改信息发布操作表单" class="form-horizontal" action="${ctx}/farm_ycjk_xxfb/save"  method="post">
					<div class="form-body">
					<input type="hidden" name="sid"/>
					<input type="hidden" name="created"/>
					<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>信息标题</label>
									<div class="col-md-9">
										<%--<input type="text" name="name" class="form-control validate[required,maxSize[50]]" />--%>
										<input type="text" name="xxbt" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>信息内容</label>
									<div class="col-md-9">
									<%--<select name="roleid" class="form-control">--%>
									<%--<select name="yjdj" class="form-control">--%>
										<%--<input type="text" name="xxnr" class="form-control validate[required,maxSize[50]]" />--%>
									<%--</select>--%>
										<script id="editor" type="text/plain"></script>
										<input type="hidden" name="xxnr" id="info_text" class="form-control validate[required,maxSize[50]]">
										<%--<script id="editor" type="text/plain" style="width: 1024px;height: 500px"></script>--%>

									</div>
								</div>
							</div>
						</div>
						<%--<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>作用时间：</label>
									<div class="col-md-9">
										&lt;%&ndash;<input type="text" name="username" class="form-control validate[required,maxSize[50]]" />&ndash;%&gt;
										<input type="text" name="zysj" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>--%>
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
									<input class="btn btn-success" title="修改" type="button" value="修改" id="sub"></input>
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



	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_xxfb/script/farm_ycjk_xxfb.js" charset="UTF-8"></script>
	<script type="text/javascript">
        var ue = UE.getEditor('editor');
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {
			//查询角色
			// loadRole("form[name=修改预警策略配置表单] select[name=roleid]");
			loadRole("form[name=修改信息发布操作表单] select[name=yjdj]");

			if("${param.sid}"){
				$.ajax({
					type: "POST",
					dataType:"json",
					url: "${ctx}/farm_ycjk_xxfb/getOne",
					data:{sid:"${param.sid}"},
					success: function(data) {
						//加载数据
						load("form[name=修改信息发布操作表单]",data);

						// console.log(ue.getContentTxt());
						// console.log($("#info_text").val())
						//处理角色的设置
						//下拉组件的回显
						/*$("select").each(function(i,c){
							var name = $(c).attr("yjdj");
							$(c).find("option[value="+data.data[name]+"]").attr("selected","selected");
						});*/

                        ue.addListener("ready", function () {
                            ue.setContent($("#info_text").val());
                        });
					},
					error: function(data){
						$.messager.alert("提示信息",data.message);
					}
				});
			}

            // alert($("#info_text").val());
			
			$("#sub").on("click",function(){
                $("#info_text").val(ue.getContent()).val();
				save1("form[name=修改信息发布操作表单]");
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
