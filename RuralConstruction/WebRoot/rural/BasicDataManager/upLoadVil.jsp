<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
 <!DOCTYPE html>
<html lang="en">
	<head>
			<link href="../base/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../base/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="../base/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="../base/assets/css/jquery-ui-1.10.3.full.min.css" />
		<link rel="stylesheet" href="../base/assets/css/datepicker.css" />
		<link rel="stylesheet" href="../base/assets/css/ui.jqgrid.css" />

		<!-- fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<link rel="stylesheet" href="../base/assets/css/test.css" />


        <link rel="stylesheet" href="assets/css/dropzone.css" />
		<!-- ace styles -->

		<link rel="stylesheet" href="../base/assets/css/ace.min.css" />
		<link rel="stylesheet" href="../base/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="../base/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="../base/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="../base/assets/js/ace-extra.min.js"></script>
		<script src="../base/assets/js/jquery-1.9.1.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="../base/assets/js/html5shiv.js"></script>
		<script src="../base/assets/js/respond.min.js"></script>
		<![endif]-->
		
		
		 <style type= "text/css">
			

		      
		      .col-xs-3{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:500px;
			}
			
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 30%;
				display: inline;
			}
			 .span{background-color:#f2f2f2;
		   height:35px;
		   border-bottom:1px solid gray;
		   
		  }
		   .button1{
		   background-color:transparent; 
			width:110px;
			height:35px;
		  }
		  .button2{
			 background-color:transparent; 
			width:105px;
			height:35px;
		  }
		     
			
		</style>
	</head> 

	<body>
		<div class="main-container" id="main-container">
			<div class="main-container-inner">
                <div class="main-content">
					<div class="page-content"> 
						<div class="row"> 
							<div class="col-xs-12"> 
								<!-- PAGE CONTENT BEGINS -->
								   <div class="alert alert-info">
										<i class="icon-hand-right"></i>
										注意：重复导入会覆盖原数据
										<button class="close" data-dismiss="alert">
											<i class="icon-remove"></i>
										</button>
								    </div>
								     <div class="alert alert-info">
										<i class="icon-hand-right"></i>
										注意：在导入村庄数据之前，请确保其所属的镇已经导入，否则导入失败！
										<button class="close" data-dismiss="alert">
											<i class="icon-remove"></i>
										</button>
								    </div>
									<div class="alert alert-info">
										<i class="icon-hand-right"></i>
										下载村庄数据模板
										<a href="../../downloadVil.action" class="btn btn-purple btn-sm">
											下载模板	
											<i class="icon-download-alt icon-on-right bigger-110"></i>
										</a>
										<button class="close" data-dismiss="alert">
											<i class="icon-remove"></i>
										</button>
										<font color="red">字段顺序必须与模板一致</font>
									</div>
								
					
									
								        <span class="fileupload-process">
								          <div id="total-progress" class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
								            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
								          </div>
								        </span>
										<div id="dropzone">
									      <form action="../../uploadVil.action" class="dropzone" method="post" enctype="multipart/form-data" id="dropzoneForm">
										  <div class="fallback">
											<input name="file" type="file" multiple/>
										  </div>
									     </form>
								      </div> 
										
											
								
	
								<!-- PAGE CONTENT ENDS -->
							</div>
						</div>
						
				 </div><!-- /.page-content --> 
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
	    <script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
	    
	     <script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
          <script src="assets/js/fuelux/fuelux.treep.min.js"></script>
           <script src="assets/js/dropzone.min.js"></script>
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			
			var aa = null;
		function getProgress(){
    		$.ajax({
				url: "../../uploadProgressVil.action",
				datatype:"json",
				type:'post',
				//async: false,
				success:function(data)	//success callback
				{   
					if (data.success) {
						document.querySelector("#total-progress .progress-bar").style.width = data.progress + "%";
					}
				}
			});
		}
		jQuery(function($) {
		
		try {
				$(".dropzone").dropzone({
					autoProcessQueue:true,//自动提交
					paramName: "file", // The name that will be used to transfer the file
					maxFilesize: 20, // MB
					acceptedFiles: "application/vnd.ms-excel",//,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
					addRemoveLinks : "true",
					dictCancelUpload: "取消导入",
					dictCancelUploadConfirmation: "取消上传确认",
					dictRemoveFile: "关闭",
					//clickable：true,
					dictFallbackMessage:"你的浏览器不支持拖拽上传功能",
					dictInvalidFileType:"不支持此种文件类型的处理",
					dictResponseError:"服务器响应无效",
					init: function() {
						this.on("success", function(file, responseText) {
							document.querySelector("#total-progress").style.opacity = "0";
			            	window.clearInterval(aa); 
			            	file.previewTemplate.appendChild(document.createTextNode(responseText));
				        });
						this.on("addedfile", function(file, responseText) { 
			            	//alert("文件已上传完成,后台正在处理数据,这个过程可能需要几分钟的时间,请耐心等待.");
			            });
						this.on("uploadprogress", function(file, progress, bytesSent) {
						    // Display the progress
						});
						// Update the total progress bar
					    this.on("totaluploadprogress", function(progress) {
					    	//document.querySelector("#total-progress .progress-bar").style.width = progress + "%";
					    });
					    this.on("sending", function(file) {
					        // Show the total progress bar when upload starts
					        document.querySelector("#total-progress").style.opacity = "1";
					        aa = window.setInterval("getProgress()",500);
				        });
				         this.on("success", function(file) {
					        // console.log("File " + file.name + "uploaded"); 
					         window.parent.$("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
				        });
					},
					dictDefaultMessage : '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i>拖动文件</span>导入 \<span class="smaller-80 grey">(或者单击)</span> <br /> \<i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
					dictResponseError: '导入文件时出错！',
					//change the previewTemplate to use Bootstrap progress bars
					previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
				 });
			} catch(e) {
			  alert('Dropzone.js does not support older browsers!');
			}
		});	
		</script>
		
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
