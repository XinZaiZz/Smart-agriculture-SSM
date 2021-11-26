<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 系统框架布局顶部（Header） -->
<div class="jhtml-header navbar md-shadow-z-1" style="background-color:#fff;border: 0 none;margin-left:250px;">
  <!-- 系统顶部布局信息 -->
  <div class="jhtml-header-inner">
    <!-- 菜单图标放大缩小 -->
   <!--  <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a> -->
    <!-- 顶部右角布局信息 -->
    
 	<!-- <div class="jhtml-logo" style="margin-top:20px;height:50px;">
      <div style="font-size: 15px;color:#D4D4D4;">欢迎登陆数据可视化平台！</div>
    </div> -->
    <!-- <div class="jhtml-logo" style="margin-top:20px;height:50px;">
   		<button type="button" class="btn btn-default" name="linkDesk" style="opacity:0.5;">前台展示</button>
   	</div> -->
   	<div class="step-body" style="min-width:300px;position: absolute;left:120px;" id="myStepIndex">
	<div class="step-header">
	</div>
	</div>
    <div class="jhtml-top">
      <div class="top-menu">
      	<div class="row" style="margin-top:15px;margin-right: 30px;">
      		<%--<img src="${ctx}/resources/images/user.png"/>--%>
            <%--<p id="log_in">欢迎 ${user.name} 登陆系统</p>--%>
            <ins id="log_in" style="color: #ff2835" ></ins>

      		<a href="${ctx }/userInfo/loginout"><img src="${ctx}/resources/images/log-out.png"/></a></i>
      	</div>
      </div>
      <!-- END TOP NAVIGATION MENU -->
    </div>
  </div>
</div>
<!-- 顶部布局固定段落清除信息 -->
<div class="clearfix"></div>

<script type="text/javascript">
    var html = '';
    var username = "${user.name}";
    if ( username != ''){
        html += '欢迎 <q >'+username +'</q>用户登陆系统';
        $("#log_in").append(html);
    } else{
        html += '<a href="webview/login.jsp" style="color: #4a6aff">点这儿可以登陆哦</a>';
        $("#log_in").append(html);
    }

</script>