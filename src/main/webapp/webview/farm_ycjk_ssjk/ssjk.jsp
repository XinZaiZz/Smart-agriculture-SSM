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
<style>
	.top{
		background-image: url(/resources/images/ssjk/devtt.png);
		width: 700px;
		height: 24px;
		text-align: left;
		color: white;
	}
	.t1{
		width: 700px;

		background-color: #289C73;
	}
	#anniu{
		width: 700px;
		background-color: #98D7BD;
		text-align: left;
	}
	.name1{
		text-align: center;
	}
</style>
<body>
<div class="portlet box ">
	<div class="portlet-title">
		<div class="caption" style="color:#45A3CA;">大棚实时监控表单</div>
	</div>
	<div class="portlet-body">
		<form name="大棚实时监控查询表单" class="form-horizontal" method="post">
			<div class="form-body">
				<div id="switchDiv"></div><br>
				<div class="row">
					<div class="col-md-12">
						<img src="${ctx}/resources/images/ssjk/pic01.jpg" style="width: 700px">
						<div class="top"> 空气环境</div>
						<table border="1px solid black" class="t1">
							<tr>
								<td>空气温度1</td>
								<td>22℃</td>
								<td>空气湿度1</td>
								<td>0.8%</td>
							</tr>
							<tr>
								<td>空气温度2</td>
								<td>28.2℃</td>
								<td>空气湿度2</td>
								<td>0.9%</td>
							</tr>
							<tr>
								<td>光照强度1</td>
								<td>20Lux</td>
								<td>二氧化碳1</td>
								<td>0.4ppm</td>
							</tr>
							<tr>
								<td>光照强度2</td>
								<td>30Lux</td>
								<td>二氧化碳2</td>
								<td>0.6ppm</td>
							</tr>
						</table>
						<div class="top"> 土壤环境</div>
						<table border="1px solid black" class="t1">
							<tr>
								<td>土壤温度1</td>
								<td>22℃</td>
								<td>土壤水分1</td>
								<td>0.8%</td>
							</tr>
							<tr>
								<td>土壤温度2</td>
								<td>11℃</td>
								<td>土壤水分2</td>
								<td>0.5%</td>
							</tr>
							<tr>
								<td>土壤温度3</td>
								<td>15℃</td>
								<td>土壤水分3</td>
								<td>0.1%</td>
							</tr>
							<tr>
								<td>土壤温度4</td>
								<td>20℃</td>
								<td>土壤水分4</td>
								<td>0.9%</td>
							</tr>
							<tr>
								<td>土壤EC1</td>
								<td>0.22mS/cm</td>
								<td>土壤EC2</td>
								<td>0.21mS/cm</td>
							</tr>
							<tr>
								<td>土壤EC3</td>
								<td>0.20mS/cm</td>
								<td>土壤PH1</td>
								<td>6.5</td>
							</tr>
							<tr>
								<td>土壤PH2</td>
								<td>7</td>
								<td>土壤PH3</td>
								<td>3</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
					</div>
				</div>
			</div>
			<%--<div class="form-actions">
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
			</div>--%>
		</form>
	</div>
</div>

<script type="text/javascript" src="${ctx}/webview/farm_ycjk_ssjk/script/farm_ycjk_ssjk.js" charset="UTF-8"></script>
<script type="text/javascript">

    //新增大棚实时监控
    $("form[name=大棚实时监控查询表单] button[title=新增]").on("click", function() {
        add();
    });

    /*
    * 系统加载后初始化处理
    *
    * */
    $.ajax({
        type:"post",
        url:"${ctx}/farm_ycjk_ssjk/getOne",
        data:{sid:1},
        dataType:"json",
        success:function(data){
            $("#switchDiv").empty();
            var html = '';
            html += '<div class="row" >';
            html+='<table border="1px solid red" cellspacing="50px" id="anniu">';
            html+='<tr>';
            html+='<td width="30px" class="name1">';
            html+='风';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_tfj_1) {
                html += '<input class="ec" type="checkbox"  name="is_tfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_tfj_1">';
            }

            html += '1#通风机';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_nfj_1) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_nfj_1">';
            }
            html += '1#暖风机';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_nfj_2) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2" checked="true">';
            }else {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2">';
            }
            html += '2#暖风机';
            html+='</td>';
            html+='</tr>';
            html+='<tr>';
            html+='<td class="name1">';
            html+='灯';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_bgd_1) {
                html += '<input class="ec" type="checkbox"  name="is_tfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_tfj_1">';
            }

            html += '1#补光灯';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_bgd_2) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_nfj_1">';
            }
            html += '2#补光灯';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_bgd_3) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2" checked="true">';
            }else {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2">';
            }
            html += '3#补光灯';
            html+='</td>';
            html+='</tr>';
            html+='<tr>';
            html+='<td class="name1">';
            html+='窗';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_tc_1) {
                html += '<input class="ec" type="checkbox"  name="is_tfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_tfj_1">';
            }

            html += '1#天窗';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_tc_2) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_nfj_1">';
            }
            html += '2#天窗';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_cc_1) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2" checked="true">';
            }else {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2">';
            }
            html += '1#侧窗';
            html+='</td>';
            html+='</tr>';
            html+='<tr>';
            html+='<td class="name1">';
            html+='帘';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_cl_1) {
                html += '<input class="ec" type="checkbox"  name="is_tfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_tfj_1">';
            }

            html += '1#侧帘';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_gs) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_1" checked="true">';
            }else{
                html += '<input class="ec" type="checkbox"  name="is_nfj_1">';
            }
            html += '加'+'    '+'湿';
            html+='</td>';
            html+='<td>';
            if ("1" == data.is_gg) {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2" checked="true">';
            }else {
                html += '<input class="ec" type="checkbox"  name="is_nfj_2">';
            }
            html += '灌'+'    '+'溉';
            html+='</td>';
            html+='</tr>';
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
                    /*  if(state==true){
                        console.log('已打开');
                     }else{
                        console.log('已关闭');
                     } */

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
    });

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