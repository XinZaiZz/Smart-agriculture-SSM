<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>欢迎来到登录页面</title>
		<!-- 引入Bootstrap核心样式文件 -->
		<%@ include file="/includes/taglibs.jsp"%><%@ include file="/includes/plugins.jsp"%>
		
		<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${ctx}/resources/css/login/login.css" />
		
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login/demo.css" />
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login/slicebox.css" />
		<link rel="stylesheet" type="text/css" href="${ctx}/resources/css/login/custom.css" />
		<script type="text/javascript" src="${ctx}/resources/js/login/modernizr.custom.46884.js"></script>
	</head>

	<body>
		<div class="container-fluid">
			<div id="content">
				<div id="shouye">
					<div id="scroll">go</div>
					<a href="index.jsp" id="fangwen"><img src="${ctx}/resources/images/主页图标.jpg"/>&nbsp;&nbsp;访问官网首页</a>
				</div>
			</div>
			<div class="row">
				<div id="img_box" class="col-lg-6 col-md-6">
					<div class="container">
						<div class="wrapper">
					
							<ul id="sb-slider" class="sb-slider">
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/1.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>衣带渐宽终不悔，为伊消得人憔悴。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/2.jpg" alt="image2" /></a>
									<div class="sb-description">
										<h3>明月几时有？把酒问青天。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/3.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>满目青山空念远，不如惜取眼前人。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/4.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>秦时明月汉时关，万里长征人未还。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/5.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>溪云初起日沉阁，山雨欲来风满楼。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/6.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>人生自古谁无死？留取丹心照汗青。</h3>
									</div>
								</li>
								<li>
									<a href="#" target="_blank"><img src="${ctx}/resources/images/login/7.jpg" alt="image1" /></a>
									<div class="sb-description">
										<h3>山有木兮木有枝，心悦君兮君不知。</h3>
									</div>
								</li>
							</ul>
					
							<div id="shadow" class="shadow"></div>
							<div id="nav-arrows" class="nav-arrows">
								<a href="#" id="xiayizhang">Next</a>
								<a href="#">Previous</a>
							</div>
						</div>
						<!-- /wrapper -->
					</div>
				</div>
				<div id="tianchong" class="col-lg-1 col-md-1" style="margin-top: 50px;">
					
				</div>
				<div id="login_box" class="col-lg-3 col-md-3 text-center">
					<form id="login" action="${ctx}/userInfo/loginIn" method="post">
						<label class="error" style="display: none;">您输入的用户名或密码错误，请重新输入</label>
					    <div class="form-group has-success">
						    <input type="text" name="username" class="form-control" id="username" placeholder="用户名                                默认：admin">
					    </div>
					    <br />
					    <div class="form-group has-success">
						    <input type="password" name="password" class="form-control" id="password" placeholder="密码                                    默认：123456">
					    </div>
					    <br />
					    <div id="submit">
					  		<button type="submit" id="tijiao" class="btn btn-success">登录</button>
						</div>
					</form>
					<div class="bottom" id="bottom_web" style="display: block;">
						<a href="#" class="link" id="forgetpwd">忘了密码？</a>
						<span class="dotted">|</span> 
						<a href="注册.html" class="link">注册新帐号</a>
						<span class="dotted">|</span> 
						<a class="link" id="feedback_web" href="#">意见反馈</a>
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- 引入jQuery核心js文件 -->
		<script src="${ctx}/resources/js/login/jquery-3.1.0.js"></script>
		<!-- 引入BootStrap核心js文件 -->
		<script src="${ctx}/resources/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${ctx}/resources/js/login/login.js"></script>
		
		<script type="text/javascript" src="${ctx}/resources/js/login/jquery.slicebox.js"></script>
		<script type="text/javascript" src="${ctx}/resources/js/login/anli.js"></script>
	</body>
</html>
