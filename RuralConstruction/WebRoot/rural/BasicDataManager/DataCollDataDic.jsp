<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ include file="base/common.html"%>
		<style type= "text/css">
			.page-content{
				padding: 0px 12px 24px;
			}
			
			.col-xs-12{
				width:100%;
				 overflow: hidden;
				 border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:600px;
			}
			
			
			.col-xs-7{	
				 width:50%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#FFF;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 1px;
				 height:600px;
			}
			.col-xs-5{	
				 width:50%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#FFF;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:600px;
			}
			
			
			  .container-fluid{
				position: relative;
		        margin-top: -50px; 
		        height: 50px;
		        clear:both;
				background:#438eb9;
			  }
			  .widget-box{
						margin: 0;
					}
				
		</style>

	</head>

	<body>
	<!-- 插入网页头部标题 -->
	<%@ include file="base/header.html"%>

		<div class="main-container" id="main-container" style="margin-top:27px">
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
								<a href="../index.jsp">主页</a>
							</li>
							<li>基础数据管理</li>
							<li>数据字典</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<!-- PAGE CONTENT BEGINS -->
						<div class = "row">
							<div class = "col-xs-12">
							      <div class = "col-xs-7"> 
								           
							            <table id="grid-table"></table>
	
										<div id="grid-pager"></div>
	
										<script type="text/javascript">
											var $path_base = "/";//this will be used in gritter alerts containing images
										</script>
										 <div id="consoleDlg"></div>
										 	<%-- 
										 <div id="operationarea">  
	                                           <div id="t_resourceTable">  
	                                          </div>  
	                                       </div> 
										 --%>
										  	<%-- 
										<span class="fileupload-process">
							          <div id="total-progress" class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
							            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
							          </div>
							        </span>
							      
									
										<div id="dropzone">
									      <form action="../../upload.action" class="dropzone" method="post" enctype="multipart/form-data" id="dropzoneForm">
										  <div class="fallback">
											<input name="file" type="file" multiple/>
										  </div>
									     </form>
								      </div> --%>
							      </div>
							      <div class = "col-xs-5">
									      <table id="grid-table1"></table>
		
												<div id="grid-pager1"></div>
		
												<script type="text/javascript">
												var $path_base = "/";//this will be used in gritter alerts containing images
												</script>
												
												  <div id="consoleDlg1"></div>
	
						        </div>	
						      
						   </div>
						   
								    
						</div>
						<!-- PAGE CONTENT ENDS -->
						
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
				
			</div><!-- /.main-container-inner -->
			
			
			
		</div><!-- /.main-container -->
		
		
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
		
	
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		
		<script src="assets/js/bootbox.min.js"></script>
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree.min.js"></script>
		<script src="assets/js/dropzone.min.js"></script>
		
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
	
		
		
		
		<!-- end -->
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		
		/*
		var aa = null;
		function getProgress(){
    		$.ajax({
				url: "../../uploadProgress.action",
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
		*/
			jQuery(function($) {
			
			$("#consoleDlg").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 500,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
				
					$("#consoleDlg1").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 500,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
			/*
				try {
				$(".dropzone").dropzone({
					autoProcessQueue:true,//自动提交
					paramName: "file", // The name that will be used to transfer the file
					maxFilesize: 20, // MB
					acceptedFiles: "application/vnd.ms-excel",//,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
					addRemoveLinks : "true",
					dictCancelUpload: "取消上传",
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
					},
					dictDefaultMessage : '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i>拖动文件</span>上传 \<span class="smaller-80 grey">(或者单击)</span> <br /> \<i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
					dictResponseError: '上传文件时出错！',
					//change the previewTemplate to use Bootstrap progress bars
					previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>"
				 });
			} catch(e) {
			  alert('Dropzone.js does not support older browsers!');
			}
	              */
	               /*
	                var currNode = function(){  
                         var Node = $("#grid-table").node();  
                  
                     return Node;  
                         };  
      
                  $("#t_resourceTable").append("<button  id='addB'>导出</button>");  
                $('#addB').button({  
                text : true, 
                 
                icons : {  
                     //primary: 'icon-cloud-download'  
                }  
                });  
                $("#addB").click(function() { 
                 var rowNum = $("#grid-table").jqGrid('getGridParam','records');
                // alert(rowNum);
                
                  var ids="";
					//var myDropzone = new Dropzone("div#dropzone", { url: "/file/post"});
					
					//alert( rowdatas);
					
					if(rowdatas.length>0){
					for(var i=0;i<rowdatas.length;i++)
					{
					  if(i!=rowdatas.length-1){
					 ids += rowdatas[i].dataCollDataDicId+",";
					 }else{
					 ids +=rowdatas[i].dataCollDataDicId;
					 }
			       }
	             }
				
				     window.location.href = "../../dicInformationToExcelNow.action?rowids="+ids+"&rowNum="+rowNum; 
               
               });  
               
	*/
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
	            var grid_selector1 = "#grid-table1";
				var pager_selector1 = "#grid-pager1";
				var rowdatas="";
				var rowdatas1="";
				jQuery(grid_selector).jqGrid({
					url:'../../DataCollDataDic_manageDataCollDataDic.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 450,
					colNames:[ 'dataCollDataDicId', '字典编码','字典名称','是否多选'],
					colModel:[
					     {name:'dataCollDataDicId',index:'dataCollDataDicId', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
					    {name:'dataDicCode',index:'dataDicCode', width:10,editable: true,editoptions:{size:"20",maxlength:"3"},editrules:{required:true,custom:true,custom_func:dicCodeCheck},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'dataDicName',index:'dataDicName', width:30,editable: true,editoptions:{size:"20",maxlength:"100"}},
						{name:'isdChoDic',index:'isdChoDic', width:10, editable: true,search:false,edittype:"select", editoptions: { value:"true:是;false:否"},unformat: aceSwitch
						,formatter:function(cellvalue, options, rowObject){
							var temp;
							if(cellvalue){
								temp = '是';
							} else {
								temp = '否';
							}
							return temp;
							}
						},
					],	
					
			       
				 onSelectRow: function () 
					{   
						//var rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
						var testrowid = $("#grid-table").jqGrid("getGridParam", "selrow");
						jQuery(grid_selector1).jqGrid("setGridParam", {
		                  url :'../../DataCollDicEntry_manageDataCollDicEntry.action?oper=search&JQID='+testrowid,
		                  editurl: '../../DataCollDicEntry_manageDataCollDicEntry.action?JQID='+testrowid,
		                });
		               //nothing is saved
		                jQuery(grid_selector1).jqGrid("setCaption","字典条目").trigger("reloadGrid");
						
					},//点击获取gqgird的当前列的'GRP_ID'的值
				
			
					viewrecords : true,
					rowNum:50,
					rowList:[50,100,150],
					pager : pager_selector,
					altRows: true,
					toppager: true,
					
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        
			         jsonReader: {
						 root:"data",//传递的json数据
						 repeatitems: false,//允许json数据乱序
						 page: "page", // json中代表当前页码的数据
						 total: "total", // json中代表页码总数的数据
						 records: "records", // json中代表数据行总数的数据 
					},
					
					//向后台交互时，所设置的参数名称对应的值，这些值是必须在struts的action中传递的。
				    prmNames : {
					    sort: "sidx", // 表示用于排序的列名的参数名称  
					    order: "sord", // 表示采用的排序方式的参数名称  
					    nd:"nd", // 表示已经发送请求的次数的参数名称  
					    id:"dataCollDataDicId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
					    oper:"oper",    // operation参数名称（我暂时还没用到）  
					    editoper:"edit", // 当在edit模式中提交数据时，操作的名称  
					    addoper:"add", // 当在add模式中提交数据时，操作的名称  
					    deloper:"del", // 当在delete模式中提交数据时，操作的名称  
					    
					    npage: null,   
                        page:"page",    // 表示请求页码的参数名称
                        rows:"rows",    // 表示请求行数的参数名称
                        search:"search", // 表示是否是搜索请求的参数名称
                        totalrows:"total" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
                    },
			
					loadComplete : function() {
						var table = this;
						 rowdatas = $("#grid-table").jqGrid('getRowData');	
					 // alert(rowdatas.length);	
						
						var rowIds = jQuery(grid_selector).jqGrid('getDataIDs'); 
						//alert(rowIds);
						$(grid_selector).jqGrid("setSelection",rowIds[0]);
						setTimeout(function(){
							styleCheckbox(table);
							//$(grid_selector).jqGrid("setSelection",371200000000);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 1000);
					},
					editurl: "../../DataCollDataDic_manageDataCollDataDic.action",
					caption: "数据字典",
			
			
					autowidth: true
			
				});
			
				//enable search/filter toolbar
				//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
			
				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
								.wrap('<label class="inline" />')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
								.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
					}, 0);
				}
				
				
				
				
				
				
				//验证字典编码的唯一性
				function dicCodeCheck(value,colname){
					if(value.length!=0){

							reg=/^[A-Z]{1}[0-9]{2}$/;
						
					}
					if(!reg.test(value)){
						return [false,"字典编码格式为A00!"];
					}else{
						var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).dataCollDataDicId
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../DataCollDataDic_checkDicCode.action?dataDicCode="+value+"&dataCollDataDicId="+id,
						dataType : "json",
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
					if (flag) {
						return [false,"该字典编码已存在!"];
					}
					return [true,""];
					}					
				}

			
			
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',grid_selector,
					{ 	//navbar options
					  cloneToTop:true,
						edit: true,
						editicon : 'icon-pencil blue',
						add: true,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: true,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						view: false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						url: '../../DataCollDataDic_manageDataCollDataDic.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			              $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			                 //return [true, 'successfule!', false];
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			            }, 
					},
					{
						//new record form
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
					url: '../../DataCollDataDic_manageDataCollDataDic.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  //var r=eval('('+xhr.responseText+')');
						  
					      var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table").jqGrid('addRowData', postdata.Id, postdata);
					      return [true, 'successfule!', false];
					    }, 
					},
					{
						//delete record form
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							if(form.data('styled')) return false;
							
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							
							form.data('styled', true);
						},
						url: '../../DataCollDataDic_manageDataCollDataDic.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						
						 var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
			                var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			                $("#delmodgrid-table").jqmHide();//关闭删除弹出框
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
						
						/*onClick : function(e) {
							alert(1);
						}*/
					},
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						},
						/*
						onClose : function(){
						rowdatas = $("#grid-table").jqGrid('getRowData');
							//alert(rowdatas[0].dataCollDataDicId);
								
						},
						*/
						
						
						multipleSearch: true,
						
					
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
					
				).navButtonAdd('#grid-table_toppager',{     
				   caption:"",
				   title:"导入",
				   buttonicon:"icon-cloud-upload blue",
				  //buttonicon:" icon-download-alt", 
				   
				    onClickButton: function(){
						var consoleDlg = $("#consoleDlg");
				consoleDlg.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='upLoadDic.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(InvgatID);
				
				consoleDlg.append(a1);
				
				consoleDlg.dialog("option", "title", "导入文件").dialog("open");
				
				 window.$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单	
				   },       
				       
				   position:"last"      
				}).navButtonAdd('#grid-table_toppager',{     
				   caption:"",
				   title:"导出",
				   //buttonicon:"icon-cloud-upload",
				  buttonicon:" icon-download-alt blue", 
				   
				    onClickButton: function(){
				    var ids="";
				     var rowNum = $("#grid-table").jqGrid('getGridParam','records');
					
					if(rowdatas.length>0){
					for(var i=0;i<rowdatas.length;i++)
					{
					  if(i!=rowdatas.length-1){
					 ids += rowdatas[i].dataCollDataDicId+",";
					 }else{
					 ids +=rowdatas[i].dataCollDataDicId;
					 }
			       }
	             }
				
				    window.location.href = "../../dicInformationToExcelNow.action?rowids="+ids+"&rowNum="+rowNum;
		       },
				    
				   position:"last"    
				   
				});
				 
			
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').remove();
					buttons.eq(0).append('<i class="icon-chevron-left"></i>');
					buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
				}
				
				function beforeDeleteCallback(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
			
			
				//it causes some flicker when reloading or navigating grid
				//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
				//or go back to default browser checkbox styles for the grid
				function styleCheckbox(table) {
				/**
					$(table).find('input:checkbox').addClass('ace')
					.wrap('<label />')
					.after('<span class="lbl align-top" />')
			
			
					$('.ui-jqgrid-labels th[id*="_cb"]:first-child')
					.find('input.cbox[type=checkbox]').addClass('ace')
					.wrap('<label />').after('<span class="lbl align-top" />');
				*/
				}
				
			
				//unlike navButtons icons, action icons in rows seem to be hard-coded
				//you can change them like this in here if you want
				function updateActionIcons(table) {
					/**
					var replacement = 
					{
						'ui-icon-pencil' : 'icon-pencil blue',
						'ui-icon-trash' : 'icon-trash red',
						'ui-icon-disk' : 'icon-ok green',
						'ui-icon-cancel' : 'icon-remove red'
					};
					$(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
					*/
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
			
				//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			   
                    $("#grid-table_toppager_center").hide();
				    $("#grid-table_toppager_right").hide();
			
		       
		
				jQuery(grid_selector1).jqGrid({
					mtype:"post",
					datatype: "json",
					height: 450,
					colNames:['dataCollDicEntryId','条目编码','字典编码','条目名称'],
					colModel:[
					     {name:'dataCollDicEntryId',index:'dataCollDicEntryId', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
					    {name:'dicEntryCode',index:'dicEntryCode', width:40, sorttype:"int", editable: true,editoptions:{size:"20",maxlength:"6"},editrules:{required:true,custom:true,custom_func:entryCodeCheck},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						  {name:'dataCollDataDicId',index:'dataCollDataDicId', width:10, sorttype:"int", editable: true,hidden:true},
						{name:'dicEntryName',index:'dicEntryName', width:40,editable: true,editoptions:{size:"20",maxlength:"100"}},
					],
					 
			    jsonReader: {
							 root:"data",//传递的json数据
							 repeatitems: false,//允许json数据乱序
							 page: "page", // json中代表当前页码的数据
							 total: "total", // json中代表页码总数的数据
							 records: "records", // json中代表数据行总数的数据 
						},
					//向后台交互时，所设置的参数名称对应的值，这些值是必须在struts的action中传递的。
				    prmNames : {
					    sort: "sidx", // 表示用于排序的列名的参数名称  
					    order: "sord", // 表示采用的排序方式的参数名称  
					    nd:"nd", // 表示已经发送请求的次数的参数名称  
					    id:"dataCollDicEntryId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
					    oper:"oper",    // operation参数名称（我暂时还没用到）  
					    editoper:"edit", // 当在edit模式中提交数据时，操作的名称  
					    addoper:"add", // 当在add模式中提交数据时，操作的名称  
					    deloper:"del", // 当在delete模式中提交数据时，操作的名称  
					    //subgridid:"id", // 当点击以载入数据到子表时，传递的数据名称  
					    npage: null,   
                        page:"page",    // 表示请求页码的参数名称
                        rows:"rows",    // 表示请求行数的参数名称
                        search:"search", // 表示是否是搜索请求的参数名称
                        totalrows:"totalrows" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
                    },
                    
			
					viewrecords : true,
					rowNum:50,
					rowList:[50,100,150],
					pager : pager_selector1,
					altRows: true,
					toppager: true,
					
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						var table = this;
						 rowdatas1 = $("#grid-table1").jqGrid('getRowData');	
						
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					//editurl: "../../CountryBasicInfo_manageCountryBasicInfo.action",
					//caption: "市级区划",
					autowidth: true
				});
			
				//enable search/filter toolbar
				//jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})
			
				//switch element when editing inline
				function aceSwitch( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=checkbox]')
								.wrap('<label class="inline" />')
							.addClass('ace ace-switch ace-switch-5')
							.after('<span class="lbl"></span>');
					}, 0);
				}
				//enable datepicker
				function pickDate( cellvalue, options, cell ) {
					setTimeout(function(){
						$(cell) .find('input[type=text]')
								.datepicker({format:'yyyy-mm-dd' , autoclose:true}); 
					}, 0);
				}
				
			//验证性别代码的唯一性
				function entryCodeCheck(value,colname){
					if(value.length!=0){

							reg=/^[A-Z]{1}[0-9]{2}[.][0-9]{2}$/;
						
					}
					if(!reg.test(value)){
						return [false,"字典条目编码格式为A00.00!"];
					}else{
						var id = $(grid_selector1).jqGrid("getRowData",$(grid_selector1).jqGrid('getGridParam','selrow')).dataCollDicEntryId
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../DataCollDicEntry_checkEntryCode.action?dicEntryCode="+value+"&dataCollDicEntryId="+id,
						dataType : "json",
						success : function(data) {
							if (data.success) {
								flag = true;
							} else {
								flag = false;
							}
						}
					});
					if (flag) {
						return [false,"该字典条目编码已存在!"];
					}
					return [true,""];
					}					
				}
			
			
			
				//navButtons
				jQuery(grid_selector1).jqGrid('navGrid',grid_selector1,
					{ 	//navbar options
					   cloneToTop:true,
						edit: true,
						editicon : 'icon-pencil blue',
						add: true,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: true,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						view: false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						//url: '../../CountryBasicInfo_manageCountryBasicInfo.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			              $("#editmodgrid-table1").jqmHide();
			                var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table1").jqGrid('setRowData', id, postdata);
			                 //return [true, 'successfule!', false];
			                $("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
			            }, 
					},
					{
						//new record form
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						//url: '../../CountryBasicInfo_manageCountryBasicInfo.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  //var r=eval('('+xhr.responseText+')');
						   var returndata = JSON.parse(xhr.responseText);
						   if(returndata.success == "successful"){
						   	 var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
					      	jQuery("#grid-table1").jqGrid('addRowData', postdata.Id, postdata);
					         return [true, 'successfule!'];
						   }else{
						   return [false,returndata.success];
						   }
								//bootbox.alert(returndata.success);
					     
					    }, 
					},
					{
						//delete record form
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							if(form.data('styled')) return false;
							
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_delete_form(form);
							
							form.data('styled', true);
						},
						//url: '../../CountryBasicInfo_manageCountryBasicInfo.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						
						        var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
			                var selectedRowIds = $("#grid-table1").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table1").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
			                $("#delmodgrid-table1").jqmHide();//关闭删除弹出框
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
						
						/*onClick : function(e) {
							alert(1);
						}*/
					},
					{
						//search form
						recreateForm: true,
						afterShowSearch: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
							style_search_form(form);
						},
						afterRedraw: function(){
							style_search_filters($(this));
						},
						multipleSearch: true,
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
				).navButtonAdd('#grid-table1_toppager',{     
				   caption:"",
				   title:"导入",
				   buttonicon:"icon-cloud-upload blue",
				  //buttonicon:" icon-download-alt", 
				   
				    onClickButton: function(){
						var consoleDlg1 = $("#consoleDlg1");
				consoleDlg1.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='upLoadEntry.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(InvgatID);
				
				consoleDlg1.append(a1);
				
				consoleDlg1.dialog("option", "title", "导入文件").dialog("open");
				
				 window.$("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单	
				   },       
				       
				   position:"last"      
				}).navButtonAdd('#grid-table1_toppager',{     
				   caption:"",
				   title:"导出",
				   //buttonicon:"icon-cloud-upload",
				  buttonicon:" icon-download-alt blue", 
				   
				    onClickButton: function(){
					//var myDropzone = new Dropzone("div#dropzone", { url: "/file/post"});
					
					 var ids="";
				     var rowNum = $("#grid-table1").jqGrid('getGridParam','records');
					
					if(rowdatas1.length>0){
					for(var i=0;i<rowdatas1.length;i++)
					{
					  if(i!=rowdatas1.length-1){
					 ids += rowdatas[i].dataCollDataDicId+",";
					 }else{
					 ids +=rowdatas[i].dataCollDataDicId;
					 }
			       }
	             }
					window.location.href = "../../entryInformationToExcel.action?rowids="+ids+"&rowNum="+rowNum;
				     
					
				   },       
				       
				   position:"last"      
				});
			
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=sdate]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
					//update buttons classes
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
					
					buttons = form.next().find('.navButton a');
					buttons.find('.ui-icon').remove();
					buttons.eq(0).append('<i class="icon-chevron-left"></i>');
					buttons.eq(1).append('<i class="icon-chevron-right"></i>');		
				}
			
				function style_delete_form(form) {
					var buttons = form.next().find('.EditButton .fm-button');
					buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
					buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
					buttons.eq(1).prepend('<i class="icon-remove"></i>')
				}
				
				function style_search_filters(form) {
					form.find('.delete-rule').val('X');
					form.find('.add-rule').addClass('btn btn-xs btn-primary');
					form.find('.add-group').addClass('btn btn-xs btn-success');
					form.find('.delete-group').addClass('btn btn-xs btn-danger');
				}
				function style_search_form(form) {
					var dialog = form.closest('.ui-jqdialog');
					var buttons = dialog.find('.EditTable')
					buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
					buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
					buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
				}
				
				function beforeDeleteCallback(e) {
					var form = $(e[0]);
					if(form.data('styled')) return false;
					
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_delete_form(form);
					
					form.data('styled', true);
				}
				
				function beforeEditCallback(e) {
					var form = $(e[0]);
					form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
					style_edit_form(form);
				}
			
				function styleCheckbox(table) {
				}
				
				function updateActionIcons(table) {
				}
				
				//replace icons with FontAwesome icons like above
				function updatePagerIcons(table) {
					var replacement = 
					{
						'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
						'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
						'ui-icon-seek-next' : 'icon-angle-right bigger-140',
						'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
					};
					$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
				}
			
				function enableTooltips(table) {
					$('.navtable .ui-pg-button').tooltip({container:'body'});
					$(table).find('.ui-pg-div').tooltip({container:'body'});
				}
			
				//var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			   
                    $("#grid-table1_toppager_center").hide();
				    $("#grid-table1_toppager_right").hide();
		
		
		});	
			
		</script>
		
		<script type="text/javascript">
			$(function(){
			
				//var grid_selector2 = "#grid-table2";
				//var pager_selector2 = "#grid-pager2";
				//var grid_selector3 = "#grid-table3";
				//var pager_selector3 = "#grid-pager3";
		     	 
		     	
		        	 $("#grid-pager_center").attr("width","100");
		        	
		        	
		          // $("#charDataTab").setGridWidth(document.body.clientWidth*0.99);
		       
		     });
		
		</script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0206").addClass("active");
			});
		</script>
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>
