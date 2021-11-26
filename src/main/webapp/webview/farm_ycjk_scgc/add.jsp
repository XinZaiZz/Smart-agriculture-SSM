<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:新增字段字段页面：/user_info/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>云追溯系统-新增生产过程</title>
</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption"  style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>新增生产过程
				</div>
			</div>
			<div class="portlet-body">

                <form name="新增生产过程表单" class="form-horizontal" action="${ctx}/farm_ycjk_scgc/save"  method="post">
                    <div class="form-body">
                        <input type="hidden" name="sid"/>
                        <input type="hidden" name="created"/>
                        <input type="hidden" name="createdBy"/>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label col-md-2"><span class="must-filled">*</span>生产过程描述</label>
                                    <div class="col-md-9">
                                        <%--<input type="text" name="name" class="form-control validate[required,maxSize[50]]" />--%>
                                        <input type="text" name="scgcms" class="form-control validate[required,maxSize[50]]" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label col-md-2"><span class="must-filled">*</span>备注信息</label>
                                    <div class="col-md-9">
                                        <%--<select name="roleid" class="form-control">--%>
                                        <%--<select name="yjdj" class="form-control">--%>
                                        <input type="text" name="bzxx" class="form-control validate[required,maxSize[50]]" />
                                        <%--</select>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--<div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="control-label col-md-2"><span class="must-filled">*</span>作用时间</label>
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
                                    <input class="btn btn-success" title="保存" type="button" value="新增" id="sub"></input>
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

    <script type="text/javascript" src="${ctx}/webview/farm_ycjk_scgc/script/farm_ycjk_scgc.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		$(function() {
		    //新增
			$("#sub").on("click",function(){
				save("form[name=新增生产过程表单]");
			});

			$("#close").on("click", function() {
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
