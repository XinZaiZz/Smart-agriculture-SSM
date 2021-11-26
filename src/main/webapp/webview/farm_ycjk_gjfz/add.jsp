<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%--============================================================================
■页面标题:新增字段字段页面：/user_info/add.jsp
■页面说明：... ...
============================================================================--%>
<!DOCTYPE html>
<html lang="zh">
<head>
<title>告警阀值设置</title>

</head>
<body>
	<div class="union-content union-tasks">
		<div class="portlet box bordered">
			<div class="portlet-title">
				<div class="caption"  style="color:#45A3CA;">
					<i class="fs icon-pin font-yellow-crusta"></i>告警阀值设置
				</div>
			</div>
			<div class="portlet-body">
	
				<form name="告警阀值设置表单" class="form-horizontal" action="${ctx}/farm_ycjk_gjfz/save"  method="post" id="form">
					<div class="form-body">
					<input type="hidden" name="sid" value="1"/>
					<input type="hidden" name="created"/>
					<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6" style="text-align: center">
								<div class="max">
									上限值
								</div>
							</div>
							<div class="col-md-6" style="text-align: center">
								<div class="min">
									下限值
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>空气温度</label>
									<div class="col-md-9">
										<input type="text" name="kqwd_max" class="form-control validate[required,maxSize[50]]" />
									</div>℃
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="kqwd_min" class="form-control validate[required,maxSize[50]]" />
									</div>℃
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>空气湿度</label>
									<div class="col-md-9">
										<input type="text" name="kqsd_max" class="form-control validate[required,maxSize[50]]" />
									</div>%
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="kqsd_min" class="form-control validate[required,maxSize[50]]" />
									</div>%
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>CO2浓度</label>
									<div class="col-md-9">
										<input type="text" name="co2_max" class="form-control validate[required,maxSize[50]]" />
									</div>ppm
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="co2_min" class="form-control validate[required,maxSize[50]]" />
									</div>ppm
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>光照强度</label>
									<div class="col-md-9">
										<input type="text" name="gzqd_max" class="form-control validate[required,maxSize[50]]" />
									</div>Lux
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="gzqd_min" class="form-control validate[required,maxSize[50]]" />
									</div>Lux
								</div>
							</div>
						</div>
						<!-- Single button -->
							<%--<div class="btn-group">
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
							</div>--%>
					</div>

					<%--<div class="form-body">
						<input type="hidden" name="sid"/>
						<input type="hidden" name="created"/>
						<input type="hidden" name="createdBy"/>
						<div class="row">
							<div class="col-md-6">
								<div class="max">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上限值
								</div>
							</div>
							<div class="col-md-6">
								<div class="min">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下限值
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>土壤温度</label>
									<div class="col-md-9">
										<input type="text" name="max_kqwd" class="form-control validate[required,maxSize[50]]" />
									</div>℃
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="min_kqwd" class="form-control validate[required,maxSize[50]]" />
									</div>℃
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>土壤水分</label>
									<div class="col-md-9">
										<input type="text" name="max_kqsd" class="form-control validate[required,maxSize[50]]" />
									</div>%
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="min_kqsd" class="form-control validate[required,maxSize[50]]" />
									</div>%
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>土壤EC值</label>
									<div class="col-md-9">
										<input type="text" name="max_co2" class="form-control validate[required,maxSize[50]]" />
									</div>mS/cm
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="min_co2" class="form-control validate[required,maxSize[50]]" />
									</div>mS/cm
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled">*</span>土壤PH</label>
									<div class="col-md-9">
										<input type="text" name="max_gzqd" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-2"><span class="must-filled"></span></label>
									<div class="col-md-9">
										<input type="text" name="min_gzqd" class="form-control validate[required,maxSize[50]]" />
									</div>
								</div>
							</div>
						</div>
						<!-- Single button -->
						&lt;%&ndash;<div class="btn-group">
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
                        </div>&ndash;%&gt;
					</div>--%>
					<div class="form-actions">
						<div class="row">
							<div class="col-md-12 text-center">
								<div class="btn-group">
									<%--<button class="btn btn-success" title="保存" type="submit">保存</button>--%>
									<input class="btn btn-success" title="保存" type="button" value="保存" id="sub"></input>

									<input class="btn btn-default" title="关闭" type="button" value="关闭" id="close"></input>
								    <%--<button class="btn btn-default" title="关闭" type="button">关闭</button>--%>
							    </div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_gjfz/script/farm_ycjk_gjfz.js" charset="UTF-8"></script>
	<script type="text/javascript">
		/**
		 * 系统页面加载后初始化处理.
		 */
		/*$("#sub").click(function () {
			$("#form").ajaxSubmit(function (data) {
				alert(data.message);
            });
        });*/

		$(function() {
			//查询角色
			loadRole("form[name=告警阀值设置表单] select[name=roleid]");
			$("#sub").on("click",function(){
				save("form[name=告警阀值设置表单]");
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
