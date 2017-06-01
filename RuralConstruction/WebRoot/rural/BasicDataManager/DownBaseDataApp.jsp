<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
		<style type= "text/css">
		.norecords {
			    border-width: 2px !important;
				display:none;
			    font-weight: bold;
			    left: 25%;
			    margin: 10px;
			    padding: 16px;
			    position: absolute;
			    text-align: left;
			    top: 45%;
			    width: auto;
			    z-index: 102;
			}
		  .table-header{
			text-align:center;
		  }
		  #left{
		  width:22%;
		  height:540px;
		  margin-top:3px;
		  background-color:#f2f2f2;
		  float:left;
			border:1px solid gray;
		  }
		  #left1{
			 background-color:white;
			  height:605px;
			  
		  }
		  #ul{
			font-size:14px;
			margin-left:15px;
			margin-top:20px;
		  }
		  .list{
			list-style:none;
		  }
		  #right{
		  margin-top:3px;
			width:77.6%;
			float:right;
			border:1px solid gray;
			height: 540px;

		  }
		   #right1{
			background-color:white;
			height: 605px;

		  }
		  .button{
			background-color:transparent; 
			width:55%;
			height:35px;
		  }
		  .button1{
		   background-color:transparent; 
			width:130px;
			height:35px;
		  }
		  .button2{
			border: 2px solid
		  }
		  .span{background-color:#f2f2f2;
		   height:35px;
		   border-bottom:1px solid gray;
		   
		  }
		  img{
			width:20px;
		  }
			.box{
			width:30%; margin-top:10%; margin:auto; padding:28px;
			height:350px; border:1px #111 solid;
			display:none;            /* 默认对话框隐藏 */
			position:absolute;
			z-index:9999;
			background-color:#f2f2f2;
		  }
		  .box.show{display:block;
		  } 
		  .box .x{ font-size:18px; text-align:right; display:block;}
		  .box input{width:80%; font-size:18px; margin-top:18px;}
		  
		.page-content{
			padding:0px 12px 0px;
		  }
		  .col-xs-12{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.col-xs-3{	
				 width:22%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.col-xs-9{	
				 width:78%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 30%;
				display: inline;
			}
	
.progress{
    	background:#c8d4e1;
    }
    /* Hide the progress bar when finished */
    #previews .file-row.dz-success .progress {
      opacity: 0;
      transition: opacity 0.3s linear;
    }

    /* Hide the delete button initially */
    #previews .file-row .delete {
      display: none;
    }

    /* Hide the start and cancel buttons and show the delete button */

    #previews .file-row.dz-success .start,
    #previews .file-row.dz-success .cancel {
      display: none;
    }
    #previews .file-row.dz-success .delete {
      display: block;
    }
		</style>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
					
		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body>
		<!-- 插入网页头部标题 -->
	<%@ include file="base/header.html"%>
		

		<div class="main-container" id="main-container" style="margin-top:27px">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			<!-- 插入侧面功能树 -->
			<%@ include file="base/menu.html"%>	
				<div class="main-content">
					<div class="breadcrumbs" style="min-height: 20px;line-height: 20px;">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="../index.jsp">主页</a>
							</li>
							<li>数据导出</li>
						</ul><!-- .breadcrumb -->
					</div>
				<div class="page-content">
					<div class= "row">
						<div class="col-xs-12">
							<div class="alert alert-info">
									<i class="icon-hand-right"></i>
									注意：重复下载会覆盖原数据
									<button class="close" data-dismiss="alert">
										<i class="icon-remove"></i>
									</button>
								</div>
								
								<div class="alert alert-info">
									<i class="icon-hand-right"></i>
									下载内容：行政区划、数据字典类型及条目、当前应用的采集模板、当前应用的评价体系、评价采集对照表
									<button class="close" data-dismiss="alert">
										<i class="icon-remove"></i>
									</button>
								</div>
								
								<div class="col-lg-5">
							        <!-- The global file processing state -->
							        <span class="fileupload-process">
							          <div id="total-progress" class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
							            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
							          </div>
							        </span>
							    </div>
								<div>
									<form  class="dropzone dz-clickable" enctype="multipart/form-data">
										<div class="dz-default dz-message">
											<span>
												<span class="bigger-150 bolder"><i class="icon-caret-right red"></i>下载文件</span>
											 	<br /> <a class="download-icon icon-cloud-download blue icon-3x" id="down"></a>
											 </span>
										</div>
									</form>
								</div>
					
					
						
							
						</div> 
					</div>
				</div ><!--page-content-->
			</div><!-- /.main-content -->
				
		</div>

				
<!-- 插入底部状态栏-->
		<%@ include file="base/footer.html"%>
		<!-- basic scripts -->

		<!--[if !IE]> -->

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->	<!-- 文档加载过慢 -->

		<!-- <![endif]-->

		<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->
		
		<!-- 添加 -->
<!--		<script src="assets/js/dropzone.min.js"></script>-->
			<script src="assets/js/bootbox.min.js"></script>
		
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<!-- 添加 -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree1.min.js"></script>
		<script type="text/javascript">
		var c = 0;
		function getProgress(){
			c++;
			document.querySelector("#total-progress .progress-bar").style.width = c + "%";
			if(c>=100){
				c=0;
			}
		};
		$("#down").on('click',function(e){
		 c = 0
		clearInterval(interval);
		document.querySelector("#total-progress .progress-bar").style.width = 0 + "%";
		var interval =	setInterval("getProgress()","100");
			$.ajax({
				url: "../../downapp_downApp.action",
				datatype:"json",
				type:'post',
				async: true,
				success:function(data)	//success callback
				{   
					//alert(data.success);
					
					if (data.success) {
					clearInterval(interval);
					document.querySelector("#total-progress .progress-bar").style.width = 100 + "%";
						window.location.href="../../downappfile.action";
						//document.querySelector("#total-progress .progress-bar").style.width = data.progress + "%";
					}else{
						bootbox.alert(data.success);
					}
				}
			});
			
		});
			
		
		
		
		</script>
		
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0210").addClass("active");
			});
		</script>
		<!-- 添加end -->
		<!-- inline scripts related to this page -->
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>

