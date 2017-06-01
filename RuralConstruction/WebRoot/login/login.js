$(document).ready(function(){
	document.getElementById("username").focus();
	
	var loginUrl 		= 	"login_Login.action";				
	//var loginTypeUrl	=	"sysuserType_findAll.action";	
	
	var username	= 	'';
	var password 	= 	'';
	var checkcode 	= 	'';

	/**
	* 登录
	*/
	var loginSuccess = false;
	
	//$(document).on('keyup',function(e){
    //  	if(e.keyCode === 13){			//回车登录
    //     login();
    //  	}
   // });
    $("#login").click(function(){
    	 login();						//点击登录
    });
    
    function login(){
    
    	username	= 	$("#username").val();
		password 	= 	$("#password").val();
		checkcode 	= 	$("#checkcode").val();
		if(username != '' && password != '') {
			
			$.ajax({
				url			:	loginUrl,
				datatype	:	"json",
				//type		:	'POST',			//默认为GET方式
				async		: 	false,			//同步
				data		: {
					'username'  : encodeURI(username),
					'password'  : password,
					'checkcode'  : checkcode
					//'logintype' : logintype
				},
				success:function(data)
				{  
					//console.log(data);
					//成功则跳转页面
				       	if(data.success == true){
						window.location.href = "rural/index.jsp";
//						alert(data.msg);
					}else if(data.success == false){
						
							alert(data.msg);
							window.location.reload(); 
							document.getElementById("password").focus();
							document.getElementById("checkcode").value="";
					}
				},
				error:function(e){ 
					  alert("请求出错");
				},
				beforeSend:function(){ 
				}
			});
		}else{
			alert("请填写完整登录信息");
		}
    }
});
