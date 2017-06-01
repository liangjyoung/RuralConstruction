<html>

<head>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" />
<title>美丽乡村建设标准化建设管理与评价系统</title>

<script src="login/jquery-1.9.1.js"></script>	
<link rel="shortcut icon" href="login/favicon.ico">	
<script src="login/login.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->
		
		<link href="login/assets/css/bootstrap.min-modify.css" rel="stylesheet" />
		<link rel="stylesheet" href="login/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="login/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="login/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="login/assets/css/datepicker.css" />
		<link rel="stylesheet" href="login/assets/css/ui.jqgrid.css" />

		<!-- fonts -->

		<link rel="stylesheet" href="login/assets/css/test.css" />

		<!-- ace styles -->

		<link rel="stylesheet" href="login/assets/css/ace.min-modify.css" />
		<link rel="stylesheet" href="login/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="login/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="login/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->			
<style type="text/css">
.main-container-inner{
		
		}
		 .font {
			 padding:0px 20px;
		}
		 
	  .back1{
		 background-color: rgba(57, 69, 87, 0);
	  }
	  .login{
	  height:440px;
	  background-color: rgba(57, 69, 87, 0);
	  padding:7px 0px
	  }
	  .login1{
		padding:0px 0px;
	  }
	  .login2{
		border:2px solid #24ADA6;
		background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#c5d0dc), to(#f6f6f8));
	  }
	  .validate{
	  float:left;
	  padding-left:30px;
	  }
	  .button{
		float:left;
		text-align:left;
		padding:20px 30px;
		align:left;
		width:100%;
		
	  }
	  .back2{
		text-align: center;
		position: relative;
		background-color: rgb(255, 255, 255);
		background-repeat: repeat-x;
		background-attachment: scroll;
		background-clip: border-box;
		background-origin: padding-box;
		background-position-x: left;
		background-position-y: top;
		background-size: auto auto;
	  }
	  .login_main{
		width: 891px;
		margin: 0 auto;
	  }
	  .header {
		 font-size:35px;
		 border:0px;
		 text-align:center;
		 width: 100%;
			float: left;
		  padding:0px 0px;
		  font-family:"黑体";
		  margin-top: 10px;
      }
      .header1 {
		  font-family:"仿宋";
      }
	  .login_left{
		float: left;
		height: 340px;
		width: 426px;
		background-color: transparent;
		background-image: url("login/login_left.jpg");
		background-repeat: no-repeat;
		background-attachment: scroll;
		background-clip: border-box;
		background-origin: padding-box;
		background-position-x: 0%;
		background-position-y: 0%;
		background-size: auto auto;
	  }
	  .login_pic{
		margin: 29px 0 0 0;
		border-width: 0px;
	  }
	  .login_right{
		float: left;
		height: 340px;
		width: 462px;
		background: url(login/login_right.jpg) no-repeat;
		text-align: left;
		padding:100px 0px 0px 30px;
	  }
	  
		</style>
		<script src="login/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="login/assets/js/html5shiv.js"></script>
		<script src="login/assets/js/respond.min.js"></script>
		<![endif]-->
</head>
<body class="login-layout back2"> 
	<form name="form1" method="post" id="form1" onsubmit="return false;">
		<input type="hidden" name="__VIEWSTATE" value="dDwyODE2NTM0OTg7Oz4RLExvHLi3hfD4UXyz4TFom8lzxA==" />

			
			<div class="login_main">
				<div class="login_logo header">
					<img src="login/title.jpg">
				</div>
				
				<div class="login_left">
					<img class="login_pic" src="login/login_pic.jpg">
				</div>
				<div class="login_right">
				
				<fieldset>
							

							<div style="padding-left:5%">
							<table>
									<tr>
										<td style="width:20%">
										<b>用户名：</b>
										</td>
										<td>
											<span class="input-icon input-icon-right" style="margin:5px 0px">
												<input type="text" placeholder="用户名" name="username" id="username"/>
												<i class="icon-user"></i>
											</span>
										</td>
										<td></td>
									</tr>
									<tr>
										<td>
										<b>密&nbsp;&nbsp;&nbsp;码：</b>
										</td>
										<td>

												<span class="input-icon input-icon-right" style="margin:5px 0px">
													<input type="password" placeholder="密码" name="password" id="password"/>
													<i class="icon-lock"></i>
												</span>
										</td>
										<td></td>
									</tr>
									<tr>
										<td>
										<b>验证码：</b>
										</td>
										<td>
											<span class="input-icon input-icon-right" style="margin:5px 0px">
												<input type="text"  placeholder="验证码" id="checkcode" name="checkcode" />
											</span>
										</td>
										<td><img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/checkImg.action" onclick="change()" title="点击更换验证码"  width="65" height="30" style="padding-left:4px;float:right">  </td>
									</tr>
								</table>
							</div>
							<div class="button">
								<span style="padding-right:30px">
									<button id="login" type="submit" class="width-35  btn btn-sm btn-primary" >
										<i class="icon-key"></i>登录	</button>
								</span>
								<span><button type="reset" class="width-35 btn btn-sm btn-primary">
									<i class="icon-undo"></i>
									重置
								</button></span>
							</div>
							<div class="space-4"></div>
						</fieldset>
				</div>
				
				<div class="login_copyright">
				<hr />
								<p class="text-center">
								
				@版权所有 © 2017 建议使用
				<a style="text-decoration:none;" href="download/ChromeStandalone_57.0.2987.110_Setup.zip" target="_blank">Google Chrome浏览器</a>或
				<a style="text-decoration:none;" href="download/360cse_8.7.0.306.exe" target="_blank">360浏览器极速浏览器</a>，分辨率1366*768以上
			
									</p>
								
								<p class="text-center">
									山东省村镇住宅工程技术研究中心
								</p>
				</div>
			</div>
		</form>
		
		 <script>  
         function change(){  
        var img1 = document.getElementById("checkImg");  
        img1.src="${pageContext.request.contextPath}/checkImg.action?"+new Date().getTime();  
    }  
  
</script>
		
  		<script>
			var config=""; 
			configUrl="./syswebConfig_findinfo.action";
			$.ajax({
			url:configUrl,
			async:false,
			success:function(data){
			config=data.info[0];
			 
			},error:function(e){  
					console.log("syswebConfig_findinfo.action错误");
			}
		    });
			$(function(){ 
				if(config.webBottom!=undefined){
					$("#webBottom").html(config.webBottom);
                }
                if(config.bannerIP!=undefined){//修改banner
                    //$("#bannerIP").html("<img src="+config.bannerIP+">");
                    //$("#bannershow").attr("src","./upload/"+config.bannerIP); 
                    //$("#bannershow").css("background","url("+"./upload/"+config.bannerIP+")");
                }
                if(config.schoolShort!=undefined){
                    $("#schoolShort").html(config.schoolShort);
                }
                if(config.schoolName!=undefined || config.webTitle!=undefined){
                	var testStr = config.schoolName + config.webTitle;
                	var webStr  = '';
                   	if(testStr.length <= 18) {			
                   		webStr +=	'<img src="" id="logoshow" width="50px" height="50px">';
						webStr +=	'<h3 class="text-center text-primary" >';
						webStr +=	'<span style="height:50px;line-height:50px" id="schoolName" ></span>';
						webStr +=	'</h3>';
						$("#short").append(webStr);
						$('#long').hide();
                   	}else {
                   		webStr +=	'<img src="" id="logoshow" width="50px" height="50px">';
						webStr +=	'<h3 class="text-center text-primary test2" >';
						webStr +=	'<div style="height:20px;line-height:20px;margin-bottom:8px; margin-left: -25px;" id="schoolName"></div>';
						webStr +=	'</h3>';
						$("#long").append(webStr);
						$('#short').hide();
                   	}
                	
                
                    $("#schoolName").html(config.schoolName);
                    $("#webTitle").html(config.webTitle);
                    
                }
                
                
                if(config.webUpper!=undefined){
                    $("#webUpper").html(config.webUpper);
                }
                if(config.webConfigNo!=undefined){
                    $("#webConfigNo").html(config.webConfigNo);
                }
                if(config.webLogo!=undefined){//修改logo
                    $("#logoshow").attr("src","./upload/"+config.webLogo); 
                }
               	if(config.contact!=undefined){
                    $("#contact").html(config.contact);
                }
　          }); 
		</script>
		
					
</body>
</html>