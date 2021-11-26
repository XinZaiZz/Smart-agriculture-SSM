$(function(){
	var error_text = $("label.error");
	$("#tijiao").on('click',function(){
		var username = $("#username").val();
		var passswd = $("#password").val();
		if(username==""||passswd==""){
			error_text.css("display","block");
			return;
		}
		
		$.ajax({
			type:"post",
			url:path+"/userInfo/loginIn",
			data:{username:username,password:passswd},
			dataType:"json",
			success:function(data){
				if(data.success){
					window.location.href=path+"/index.jsp";
				}
				else{
					error_text.css("display","block");
				}
			}
		});
		
		
	});
	$("#username,#password").on('focus',function(){
		error_text.css("display","none");
	});
	
	$("#fangwen").hover(
		function() {
		    $("#scroll").addClass('hover');
		}, 
		function() {
		    $("#scroll").removeClass('hover');
		}
	);
	
});