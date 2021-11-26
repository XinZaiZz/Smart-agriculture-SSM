<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/taglibs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<div class="caption" style="color:#45A3CA;">操作记录查询</div>
	</div>
	<div class="table-box">
		<%--<form name="大棚实时监控查询表单" class="form-horizontal" method="post">
			<div class="form-body">
				<div id="switchDiv"></div>
				<div class="row">
					<div class="col-md-12">
						<img src="${ctx}/resources/images/ssjk/pic01.jpg">
					</div>
					</div>
				<div class="row">
				<div class="col-md-12">
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
		</form>--%>
		<table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			<thead>
				<tr>
					<th id="sid">序号</th>
					<th id="czjlcx_sbmc">设备名称</th>
					<th id="czjlcx_czzl">操作指令</th>
					<th id="czjlcx_clzt">处理状态</th>
					<th id="czjlcx_clsj">处理时间</th>
					<th id="czjlcx_bz">备注</th>
					<th id="czjlcx_czym">操作员名</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${czjlcx_list}" var="list">
					<tr>
						<td>${list.sid}</td>
						<td>${list.sbmc}</td>
						<td>${list.czzl}</td>
						<td>${list.clzt}</td>
						<td>${list.clsj}</td>
						<td>${list.bz}</td>
						<td>${list.czym}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

	<script type="text/javascript" src="${ctx}/webview/farm_ycjk_ssjk/script/farm_ycjk_ssjk.js" charset="UTF-8"></script>
	<script type="text/javascript">

	/*
	* 系统加载后初始化处理
	*
	* */
                /*$.ajax({
                    type:"post",
                    url:"${ctx}/farm_ycjk_ssjk/getOne",
                    data:{sid:1},
                    dataType:"json",
                    success:function(data){
                        $("#switchDiv").empty();
                    	var html = '';
						html += '<div class="row">';
						html += '<div class="col-md-4">';
						if ("1" == data.is_tfj_1) {
                            html += '<input class="ec" type="checkbox"  name="is_tfj_1" checked="true">';
                        }else{
                            html += '<input class="ec" type="checkbox"  name="is_tfj_1">';
                        }
                        html += '1#通风机';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_nfj_1) {
                            html += '<input class="ec" type="checkbox"  name="is_nfj_1" checked="true">';
                        }else{
                            html += '<input class="ec" type="checkbox"  name="is_nfj_1">';
                        }
                        html += '1#暖风机';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_nfj_2) {
                            html += '<input class="ec" type="checkbox"  name="is_nfj_2" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_nfj_2">';
                        }
                        html += '2#暖风机';
                        html += '</div>';
                        html += '</div>';
                        html += '<div class="row">';
						html += '<div class="col-md-4">';
						if ("1" == data.is_bgd_1) {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_1" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_1">';
                        }
						html += '1#补光灯';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_bgd_2) {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_2" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_2">';
                        }
                        html += '2#补光灯';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_bgd_3) {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_3" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_bgd_3">';
                        }
						html += '3#补光灯';
                        html += '</div>';
                        html += '</div>';
                        html += '<div class="row">';
						html += '<div class="col-md-4">';
						if ("1" == data.is_tc_1) {
                            html += '<input class="ec" type="checkbox"  name="is_tc_1" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_tc_1">';
                        }
						html += '1#天窗';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_tc_2) {
                            html += '<input class="ec" type="checkbox"  name="is_tc_2" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_tc_2">';
                        }
						html += '2#天窗';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_cc_1) {
                            html += '<input class="ec" type="checkbox"  name="is_cc_1" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_cc_1">';
                        }
						html += '1#侧窗';
                        html += '</div>';
                        html += '</div>';
                        html += '<div class="row">';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_cl_1) {
                            html += '<input class="ec" type="checkbox"  name="is_cl_1" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_cl_1">';
                        }
                        html += '1#侧帘';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_js) {
                            html += '<input class="ec" type="checkbox"  name="is_js" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_js">';
                        }
                        html += '加湿';
                        html += '</div>';
                        html += '<div class="col-md-4">';
                        if ("1" == data.is_gg) {
                            html += '<input class="ec" type="checkbox"  name="is_gg" checked="true">';
                        }else {
                            html += '<input class="ec" type="checkbox"  name="is_gg">';
                        }
                        html += '灌溉';
                        html += '</div>';
                        html += '</div>';
                        html += '</div>';
                        html += '</div>';
                        $("#switchDiv").append(html);

                        $('.ec').bootstrapSwitch({
                            onText:"ON",
                            offText:"OFF",
                            onColor:"success",
                            offColor:"danger",
                            size:"normal",
                            onSwitchChange:function(event,state){
                                var obj = {};
                                obj.sid = 1;
                                var attr1 = $(this).attr("name");
                                state = state?"1":"2";
                                obj[""+attr1+""] = state;
                                console.log(obj);
                                /!*  if(state==true){
                                    console.log('已打开');
                                 }else{
                                    console.log('已关闭');
                                 } *!/

                                $.ajax({
                                    type:"post",
                                    url:"${ctx}/farm_ycjk_ssjk/updateDataState",
                                    data:obj,
                                    dataType:"json",
                                    success:function(data){
                                        $.message.alert({
                                            message:data.message
                                        });
                                    }
                                });
                    }
                });
            }
        });*/

                /*
                * 点击switch按钮后改变传递参数到controller后改变数据库值
                * */
               /* $('.ec').bootstrapSwitch({
                    onText:"ON",
                    offText:"OFF",
                    onColor:"success",
                    offColor:"danger",
                    size:"normal",
                    onSwitchChange:function(event,state){
                        var obj = {};
                        obj.sid = 1;
                        var attr1 = $(this).attr("name");
                        state = state?"1":"2";
                        obj[""+attr1+""] = state;
                        console.log(obj);
                        /!*  if(state==true){
                            console.log('已打开');
                         }else{
                            console.log('已关闭');
                         } *!/
                        $.ajax({
                            type:"post",
                            url:"${ctx}/farm_ycjk_ssjk/updateDataState",
                            data:obj,
                            dataType:"json",
                            success:function(data){
                                $.message.alert({
                                    message:data.message
                                });
                            }
                        });
                    }
                });*/

	</script>


</body>
</html>