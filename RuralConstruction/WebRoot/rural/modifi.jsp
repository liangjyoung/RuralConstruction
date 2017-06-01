<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
  <%@ include file="base/common.html"%>

  <body>
		

		<!-- 插入网页头部标题 -->
		<%@ include file="base/header.html"%>
		<div class="main-container" id="main-container"style="margin-top:27px">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
				<!-- 插入侧面功能树 -->
				<%@ include file="base/menu.html"%>

				<div class="main-content">
					<div class="breadcrumbs" style="min-height: 20px;line-height: 20px;">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="index.jsp">主页</a>
							</li>
							<li>修改密码</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content" >
						<div class="row">
							<div class="col-xs-12" style="margin-top:3%">
								<!-- PAGE CONTENT BEGINS -->
								
								<form id="form111" class="form-horizontal" >
								
									<div class="space-12"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 原始密码 </label>

										<div class="col-sm-9">
											<input type="password" id="oldPassword" name="oldPassword" placeholder="原始密码" class="col-xs-10 col-sm-5" required/>
										</div>
									</div>
									
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 新密码 </label>

										<div class="col-sm-9">
											<input type="password" id="newPassword" name="newPassword" placeholder="新密码" class="col-xs-10 col-sm-5" required/>
										</div>
									</div>
									
									<div class="space-4"></div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3"> 确认新密码 </label>

										<div class="col-sm-9">
											<input type="password" id="renewPassword" name="renewPassword" placeholder="确认新密码" class="col-xs-10 col-sm-5" required/>
										</div>
									</div>
									
									<div class="space-4"></div>
					
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" id="submit">
												<i class="icon-ok bigger-110"></i>
												提交
											</button>

											&nbsp; &nbsp; &nbsp;
											 <button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												重置
											</button> 
										</div>
									</div>
								</form>
								
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					
				<%@ include file="base/footer.html"%>
			
			
			
			
			
		<script language="javascript" type="text/javascript">
		
			document.getElementById("oldPassword").focus();
			var oldPassword =document.getElementById("oldPassword");
			var newPassword =document.getElementById("newPassword");
			$(document).on('keyup',function(e){
		      	if(e.keyCode === 13){			//回车修改
		         submit();
		      	}
		    });
		    $("#submit").click(function(){
		    	 submit();						//点击修改
		    });
		    function submit(){
				$(document).ready(function(){
				
					if(form111.newPassword.value==''||form111.renewPassword.value == ''|| form111.oldPassword.value == '') {
						alert("输入不能为空");
						document.getElementById("oldPassword").focus();
						//from111.renewPassword.focus();
						document.getElementById("newPassword").value="";
						document.getElementById("renewPassword").value="";
						document.getElementById("oldPassword").value="";
					}
					else if(form111.newPassword.value!=form111.renewPassword.value)
					{
						alert("两次输入密码不一致");
						document.getElementById("oldPassword").focus();
						document.getElementById("newPassword").value="";
						document.getElementById("renewPassword").value="";
						document.getElementById("oldPassword").value="";
						//from111.renewPassword.focus();
						//return false;
						
					}
					else{	
					$.ajax({
			                cache: true,
			                type: "POST",
			                url:"../login_updatepassword.action",
			                data:$('#form111').serialize(),
			                async: false,
			              success:function(data){
			              if(data.success==true)
					       {
			            	  document.getElementById("oldPassword").focus();
								document.getElementById("newPassword").value="";
								document.getElementById("renewPassword").value="";
								document.getElementById("oldPassword").value="";
					       alert("修改成功");
					      // window.location.reload();
					       return true;
					      
					       }else{
					      	 alert("原始密码错误");
					      	document.getElementById("oldPassword").focus();
							document.getElementById("newPassword").value="";
							document.getElementById("renewPassword").value="";
							document.getElementById("oldPassword").value="";
					      	 return false;
			     				}
			     				         
			              }
			            });
						//$("#form111").submit();
						}
					});
		    
		    }
		
		</script>

		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->	<!-- 文档加载过慢 -->

		<!-- <![endif]-->

		<!--[if IE]>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='base/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='base/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
		</script>
		<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='base/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
		<script src="base/assets/js/bootstrap.min.js"></script>
		<script src="base/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="base/assets/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="base/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="base/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="base/assets/js/jquery.slimscroll.min.js"></script>
		<script src="base/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="base/assets/js/jquery.sparkline.min.js"></script>
		<script src="base/assets/js/flot/jquery.flot.min.js"></script>
		<script src="base/assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="base/assets/js/flot/jquery.flot.resize.min.js"></script>

		<!-- ace scripts -->

		<script src="base/assets/js/ace-elements.min.js"></script>
		<script src="base/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				//$("#sysManage").addClass("active open");
				//$("#sysManage li:eq(3)").addClass("active");
			});
		</script>
</body>
</html>

