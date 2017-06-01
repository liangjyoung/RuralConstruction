<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
        <style type="text/css">
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
		.widget-main {
         padding: 6px;
		 }
		.page-content {
			background: #fff;
			margin: 0;
			padding: 0px 12px 0px;
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
		.space{
			background:#ccc;
			max-height:2px;
			min-height:2px;
			margin-bottom:1px;
			margin-top:2px;
		}
		.col-xs-3{	
	  	 width:26%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:450px;
			}
			.col-xs-9{	
				 width:73%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:450px;
			}
         .ui-jqgrid tr.jqgrow td {
				white-space: normal !important;
				height:auto;
			}
		#dialog-message{
			min-width:400px;
		}
		#bt{width:100%;}
	#h4{text-align:center;}
		</style>
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
							<li>基础数据管理</li>
							<li>评价体系</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
							   <table id="grid-table"></table>
								<div id="grid-pager"></div>
									<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
									</script>
									
									
								<div id="dialog">
									<div id="dialog-message1" class="hide">
									   请选择所要修改的评价体系状态：<select style="max-width:180px" id="select-state" >
												<div id="o5"></div>
									    	</select>
									</div><!-- #dialog-message -->	
								</div>
								
								
								<div id="dialog1">
									<div id="dialog-message2" class="hide">
									   请选择所要复制的评价体系版本：<select style="max-width:180px" id="select-version" >
												<div id="o6"></div>
									    	</select>
									</div><!-- #dialog-message -->	
								</div>
							<div class="space"></div>
							<div class= "col-xs-3">
								<div id="bt" class="widget-box" style="height:100%">
									<div  id="h4" class="widget-header header-color-blue2">
                                		<h4  class="lighter smaller">评价指标</h4>
                            		 </div>
									<div class="span">
										<a class="ui-pg-div" id="id-btn-dialog1"><span class="ui-icon icon-plus-sign purple"></span></a>
										  <a  id="id-btn-dialog2" class="ui-pg-div"><span class="ui-icon icon-trash red"></span></a>
										  
										
								
										<div id="dialog-message" class="hide">
										    上级节点：<select style="max-width:180px" id="s1" onchange="changePro(this)" >
										    
										         <option value="0">无父节点</option> 
													<div id="o1"></div>
										    	</select>
										    </br></br>
											指标编号：<input id="evalNum"><font color='red'>*</font></br></br>
											指标名称：<input id="evalName">
											</br></br>
											专业类别：<select style="max-width:180px" id="s2" onchange="changeEval(this)" >
												
													<div id="o2"></div>
										    	</select></br></br>
										   分 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;值：<input id="evalSco"><font color='red'>*</font>
										</div><!-- #dialog-message -->	
								        
								        <div id="dialog-confirm" class="hide">
											<div class="alert alert-info bigger-110">
												即将删除您所选的记录
											</div>
											<p class="bigger-110 bolder center grey">
												<i class="icon-hand-right blue bigger-120"></i>
												你确定？
											</p>
										</div><!-- #dialog-confirm -->
                              </div>
									
									<div class="widget-body" style="height:100%">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:88%"></div>
										</div>
									</div>
								</div>
							</div>
							<div class = "col-xs-9">
								<table id="grid-table1"></table>
									<div id="grid-pager1"></div>
									<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
									</script>
								<div class="space"></div>
							
									
							</div><!-- /.col --> 
							<div id="consoleDlg"></div>
							</div><!-- /.row -->
						<!-- PAGE CONTENT ENDS -->
					</div><!-- /.page-content -->	
						
				
				</div>	
				 
		<!-- 插入底部状态栏-->
		<%@ include file="base/footer.html"%>

				
			</div><!-- /.main-container-inner -->

			
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
<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
		
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		<script src="assets/js/bootbox.min.js"></script>
		<script src="assets/js/jqGrid/grid.subgrid.js"></script>
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		<!-- end -->
	

		<!-- inline scripts related to this page -->
		
		<script type="text/javascript">
		
		 	
		var EditEvalSystID;
		 var hash = {};    //定义一个哈希表 用于去除重复元素
		
		
			//评价体系版本下拉框
				$.ajax({
					url: "../../evalsys_queryAllEvalSys.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						//aler(json);
						for(var i=0; i<json.length; i++)  
						{  
							$("#select-version").append("<option value=\"" + json[i].EvalSystId + "\">" + json[i].EvalSystNote +"</option>");
						}  
					},
				});
			
			
			
			
			//评价指标下拉框
				$.ajax({
					url: "../../evalsys_queryAll.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						//aler(json);
						for(var i=0; i<json.length; i++)  
						{  
							$("#s1").append("<option value=\"" + json[i].EvalIndNum + "\">" + json[i].EvalIndName +"</option>");
						}  
					},
				});
				
				
				//专业类别下拉框
				$.ajax({
					url: "../../evalsys_queryExpertMajorCatg.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						//aler(json);
						for(var i=0; i<json.length; i++)  
						{  
							$("#s2").append("<option value=\"" + json[i].ExpertMajorCatgID + "\">" + json[i].ExpertMajorCatg +"</option>");
						}  
					},
				});
		</script>
		

		<script type="text/javascript"><!--
		
		
		
				function EvalMethObj(EvalMethID){
					var consoleDlg = $("#consoleDlg");
				consoleDlg.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='EvalMethObj.jsp?EvalMethID="+EvalMethID+"'style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				consoleDlg.append(a1);
				
				consoleDlg.dialog("option", "title", "调查对象").dialog("open");
				
				};
			
			
			$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
					_title: function(title) {
						var $title = this.options.title || '&nbsp;'
						if( ("title_html" in this.options) && this.options.title_html == true )
							title.html($title);
						else title.text($title);
					}
				}));	
				
				
				$( "#id-btn-dialog1" ).on('click', function(e) {
					e.preventDefault();
			
					var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
						modal: true,
						title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> 添加评价指标</h4></div>",
						title_html: true,
						buttons: [ 
							
							{
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								
								click: function() {
								        
								        var no = $("#evalNum").val().trim();
								        var sco = $("#evalSco").val().trim();
								       
								       if(no.length==0){
								        $("#evalNum").focus();
								        alert('评价指标编号不能为空');
								        
								       }else{		
								      		 reg=/^[0-9]{2}[.][0-9]{2}[.][0-9]{2}[.][0-9]{2}$/;
											if(!reg.test(no)){
											alert("请按照00.00.00.00的格式填写");
											}else{
											 	
												if(sco==""){
													 $("#evalSco").focus();
								        			 alert('分数不能为空');
												}else{
													reg1=/^([1-4][0-9]{2}|500|[1-9]?[0-9])$/;
											 		if(!reg1.test(sco)){
											 		alert("请填写0-500的分数！");
											 		}else{
											 			 var evalNum = document.getElementById("evalNum").value;	
														var evalName = document.getElementById("evalName").value;	
														var sv=document.getElementById("s1").value;
														var sc =document.getElementById("s2").value;
														var evalSco =document.getElementById("evalSco").value;
														var  rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
														
																			
														$.ajax({
														url: "../../evalsys_addMenusAsTree.action",//tree_singTree.action
														async:false,  
														type: 'POST',
														dataType: 'json',
														data:{ 
							 							   "evalNum":evalNum,
							 							   "evalName":evalName,
							 							   "sv":sv,
							 							   "sc":sc,
							 							   "evalSco":evalSco,
							 							   "evalSystid":rowid
							 							   
						 							    },
														success : function(data) {
														//tree_data=$.parseJSON(data.ss);
														var mess = data.success;
														alert(mess);
														location.reload();
														},
														});
												 		}
													
												}
											
											
											}
								       }
								       
								
									
								} 
							},
							{
								text: "取消",
								"class" : "btn btn-xs",
								click: function() {
									$( this ).dialog( "close" ); 
								} 
							}
							
							
						]
					});
			
				});
			
			
					$( "#id-btn-dialog2" ).on('click', function(e) {
					e.preventDefault();
				
					$( "#dialog-confirm" ).removeClass('hide').dialog({
						resizable: false,
						modal: true,
						title: "<div class='widget-header'><h4 class='smaller'><i class='icon-warning-sign red'></i>删除角色</h4></div>",
						title_html: true,
						buttons: [
							{
								html: "<i class='icon-trash bigger-110'></i>&nbsp; 删除",
								"class" : "btn btn-danger btn-xs",
								click: function() {
										//获得子节点
								 var items = $('#tree1' ).tree('selectedItems'); 						 
					   			  var tIds='';
								 for (var i in items) {
									if (items.hasOwnProperty(i)) {  
									   var item = items[i];  
									   tIds += item.additionalParameters['id' ] + ",";
									   
									}
								}
								
								
									$.ajax({
										url: "../../evalsys_delMenusAsTree.action",//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										data:{ 
			 							   "evalNo":tIds,
			 							   
		 							    },
										success : function(data) {
										
										var mess = data.success;
										alert(mess);
										location.reload();
										   
										},
										});
										
								
									//$( this ).dialog( "close" );
								}
							}
							,
							{
								html: "<i class='icon-remove bigger-110'></i>&nbsp; 取消",
								"class" : "btn btn-xs",
								click: function() {
									$( this ).dialog( "close" );
								}
							}
						]
					});
				});
				
		
			
			
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				var grid_selector1 = "#grid-table1";
				var pager_selector1 = "#grid-pager1";
				var grid_selector2 = "#grid-table2";
				var pager_selector2 = "#grid-pager2";
				$("#consoleDlg").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 480,
					position : "center", // 窗口显示的位置
					width : 700
				});
				jQuery(grid_selector).jqGrid({
					url:'../../evalsys_manageEvalSys.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 50,
					colNames:[ 'id','评价体系版本','体系名称','状态','开始使用的时间','结束使用的时间'],
					colModel:[
					   {name:'EvalSystID',index:'EvalSystID', width:40,editable: true,key:true,hidden:true,editoptions:{size:"20",maxlength:"30"}},
					   {name:'EvalSystNote',index:'EvalSystNote', width:15, sortable:false,editable: true}, 
					   {name:'EvalSystName',index:'EvalSystName', width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
					   {name:'EvalSystStateID',index:'EvalSystStateID', width:30,editable:false,editoptions:{size:"20",maxlength:"30"}},
					   {name:'Startime',index:'Startime',width:20, editable:true, datefmt:"yyyy",unformat: pickDate},
					   {name:'Endtime',index:'Endtime',width:20, editable:true, datefmt:"yyyy",unformat: pickDate}
					   

					], 
				
			        onSelectRow: function () 
					{   
						$(grid_selector1).clearGridData();
						//jQuery(grid_selector1).trigger("reloadGrid");
						var tree_data;
 						var rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
 						//alert(rowid);
 						 EditEvalSystID = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
 						//alert(EditEvalSystID);
 						
 						
 						
 						
 						
 						$.ajax({
							url: "../../evalsys_evalIndStructree.action?TreeJS="+rowid,//tree_singTree.action
							async:false,  
							type: 'POST',
							dataType: 'json',
							success : function(data) {
								//callback({ data: data.ss });
								tree_data=data.ss;
							}
						});
 						var treeDataSource = new DataSourceTree({data: tree_data});
 					 	$('#tree1').removeData("tree");//移除表中数据
	                    $('#tree1').unbind('click');//移除点击事件
	                    $('#tree1').unbind('selected');//移除选择事件
             			$('#tree1').ace_tree({
							dataSource: treeDataSource  ,
							multiSelect:false,
							loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
							'open-icon' : 'icon-minus',
							'close-icon' : 'icon-plus',
							'selectable' : true,
							'selected-icon' : 'icon-ok',
							'unselected-icon' : false,
						});
 						$('#tree1').on('selected', function(evt, data) {
							//获取选择的树名字
							var output ="";
							//获取选择的树的id
							var ids = "";
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       output += item.name + ",";
						    }
							 ids = ids.substring(0, ids.lastIndexOf(","));
							 output = output.substring(0, output.lastIndexOf(","));
 									//alert(ids);
 							$("#add_grid-table1").show();		
							jQuery(grid_selector1).jqGrid("setGridParam", {
								url :'../../evalmeth_manageEvalMeth.action?oper=search&EvaFSID = hh&EvaSID='+ids,
								editurl :'../../evalmeth_manageEvalMeth.action?EvaSID='+ids,
							});
							jQuery(grid_selector1).jqGrid("setCaption","评价内容").trigger("reloadGrid");
						});		
						$('#tree1').on('opened', function (evt, data) {
							var is = data.additionalParameters['id' ] ;
							//alert(is);
							
							jQuery(grid_selector1).jqGrid("setGridParam", {
								url :'../../evalmeth_manageEvalMeth.action?oper=search&EvaSID = hh&EvaFSID='+is,
								editurl :'../../evalmeth_manageEvalMeth.action?EvaFSID='+is,
							});
							
							jQuery(grid_selector1).jqGrid("setCaption","评价内容").trigger("reloadGrid");
							$("#add_grid-table1").hide();
						});
						
					},//点击获取gqgird的当前列的'GRP_ID'的值
			
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					toppager: true,
					multiselect: false,
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
					    id:"EvalSystID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						var rowIds = jQuery(grid_selector).jqGrid('getDataIDs'); 
						$(grid_selector).jqGrid("setSelection",rowIds[0]);
						
						setTimeout(function(){
							styleCheckbox(table);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 500);
					},
					caption: "评价体系",
					editurl :"../../evalsys_manageEvalSys.action",
					autowidth: true
			
				});
			
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
						search: false,
						searchicon : 'icon-search orange',
						refresh: false,
						refreshicon : 'icon-refresh green',
						view: false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						//closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "successful"){
						   $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			                 return [true, rd.success];
			                
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			                }else{
			                	return [false, rd.success];
			                }
			            }
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
					//	url: '../../invesObj_manageInvesObj.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "successful"){
						  	var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
					      	jQuery("#grid-table").jqGrid('addRowData', postdata.Id, postdata);
					     	return [true, rd.success];
					     	
					     	 $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
						  }else{
						  	  return [false, rd.success];
						  }
						 // bootbox.alert(rd.success);
					      
					    }
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
						 mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						 $("#delmodgrid-table").jqmHide();//关闭删除弹出框
							var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
							var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
							   var len = selectedRowIds.length;
							     for (var i = 0; i < len ; i++) {
							        $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
							       }
							 $("#grid-table").trigger("reloadGrid");
							
			                
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
						
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
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
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
				   title:"修改评价体系状态",
				   buttonicon:" icon-edit",
				  //buttonicon:" icon-download-alt", 
				  
				    onClickButton: function(){  
					// var  rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
					//			alert(rowid);
					
					//评价体系状态下拉框
					   
						$.ajax({
						
							url: "../../evalsys_queryAllState.action?EvalSysID="+EditEvalSystID,
							
							datatype:"json",
							type:'post',
							success:function(data)	//success callback
							{   
							   
								var json = data.info;
							 
							 	$("#select-state").empty();
							 						  
								for(var i=0; i<json.length; i++)  
								{  
								$("#select-state").append("<option value=\"" + json[i].EvalSystStateId + "\">" + json[i].EvalSystStateDes +"</option>");
								}  
							},
						});
 						
 					
					
					var dialog = $( "#dialog-message1" ).removeClass('hide').dialog({
						modal: true,
						title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>修改评价体系状态</h4></div>",
						title_html: true,
						
						buttons: [ 
							{
							
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								click: function() {
								 var EvalSystStateID=document.getElementById("select-state").value;
								 var  EditEvalSystID = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
								
										$.ajax({
										url: "../../evalsys_editState.action",//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										data:{ 
			 							  "editEvalSystID":EditEvalSystID,
			 							  "evalSystStateID":EvalSystStateID,
		 							    },
										success : function(data) {
										//tree_data=$.parseJSON(data.ss);
										var mess = data.success;
										alert(mess);
										location.reload();
										},
										});
											
								}
							 },	
						
							{
								text: "取消",
								"class" : "btn btn-xs",
								click: function() {
									$( this ).dialog( "close" ); 
								} 
							}
							
							
						]
					});
					   
					   },   
					    position:"last"       
				}).navButtonAdd('#grid-table_toppager',{     
				   caption:"",
				   title:"复制上年模板",
				   buttonicon:"icon-hdd",
				  //buttonicon:" icon-download-alt", 
				  
				    onClickButton: function(){  
					// var  rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
					//			alert(rowid);
					
					var dialog = $( "#dialog-message2" ).removeClass('hide').dialog({
						modal: true,
						title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i>复制模板</h4></div>",
						title_html: true,
						
						buttons: [ 
							{
						    	
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								click: function() {
								 var s66=document.getElementById("select-version").value;
								 var  rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
							
										$.ajax({
										url: "../../evalsys_copeSysEval.action",//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										data:{ 
			 							  "EvalSystID":rowid,
			 							   "EvalSystID2":s66,
		 							    },
										success : function(data) {
										//tree_data=$.parseJSON(data.ss);
										var mess = data.success;
										alert(mess);
										location.reload();
										},
										});
											
								}
							 },	
						
							{
								text: "取消",
								"class" : "btn btn-xs",
								click: function() {
									$( this ).dialog( "close" ); 
								} 
							}
							
							
						]
					});
					   
					   },   
					    position:"last"       
				});
				
				
			jQuery(grid_selector1).jqGrid({
					//url:'../../evalsys_manageEvalSys.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 300,
					colNames:[ '','分序号','评价内容','分值','主客观值','考核方式','建设要求','计分方法','备注','分配调查对象'],
					colModel:[
					    {name:'EvalContId',index:'EvalContId', width:10,  editable: true,key:true,hidden:true},
					    {name:'EvalContSeqNum',index:'EvalContSeqNum', width:23, editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:SeqCheck}},  
						{name:'EvalContDes',index:'EvalContDes', width:177,  editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"},editoptions:{size:"20",maxlength:"200"}},
						{name:'EvalContScore',index:'EvalContScore', width:20, sortable:false,editable: true,editrules: {required:true,number:true,minValue:0,maxValue:50},formoptions:{elmsuffix:"<font color='red'>*</font>"}} ,
						{name:'IsSubjGra',index:'IsSubjGra', width:30,editable: true,edittype:"select",editoptions: { value:"2:2;1:1;-1:-1;-21:-21;-22:-22;-31:-31;-32:-32;-41:-41;-42:-42;-51:-51;-52:-52;-6:-6;-7:-7;-8:-8;-9:-9"}},
						{name:'ExamMethID',index:'ExamMethID', width:30,editable: true,edittype:"select",editoptions:{dataUrl:"../../exam_findAll.action" }},
						{name:'BulReq',index:'BulReq', width:60,editable: true,hidden:true},
						{name:'EvalContScorMeth',index:'EvalContScorMeth', width:60, hidden:true,sortable:false,editable: true},
                        {name:'EvalContNote',index:'EvalContNote', width:20, hidden:true,editrules:{edithidden:true},sortable:false,editable: true},
                        {name:'DistInvesObj',index:'DistInvesObj',formatter: DistInvesObj, width:50,align:'center',search:false,sortable:false}
						  
					], 
			 
				/*
			        onSelectRow: function () 
					{   
						var tree_data;
 						var  EvalMethID = jQuery(grid_selector1).jqGrid("getGridParam", "selrow");
 						
 						jQuery(grid_selector2).jqGrid("setGridParam", {
								url :'../../evalcontobj_manageEvalContObj.action?oper=search&EvalObjID='+EvalMethID,
								editurl :'../../evalcontobj_manageEvalContObj.action?EvalObjID='+EvalMethID,
							});
						jQuery(grid_selector2).jqGrid("setCaption","调查对象分配结果").trigger("reloadGrid");
						
 						//alert(EvalMethID);
 						//EvalMethObj(EvalMethID);
					
					},//点击获取gqgird的当前列的'GRP_ID'的值
			*/
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector1,
					altRows: true,
					toppager: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			       // beforeSelectRow: beforeSelectRow,
			       	subGrid : true,//(1)开启子表格
					subGridOptions : {//子表格选项
						//plusicon : 'icon-plus',
						//minusicon : 'ui-icon-minus',
						openicon: 'icon-double-angle-right bigger-170 blue',
						//expandOnLoad: false,
						//selectOnExpand : false,
						//reloadOnExpand : true
					},
					
					subGridRowExpanded : function(subgrid_id, row_id){ // (2)子表格容器的id和需要展开子表格的行id，将传入此事件函数
						var subgrid_table_id;  
	            		subgrid_table_id = subgrid_id + "_t";   // (3)根据subgrid_id定义对应的子表格的table的id  
	              		var subgrid_pager_id;  
	            		subgrid_pager_id = subgrid_id + "_pgr"  // (4)根据subgrid_id定义对应的子表格的pager的id
	             		var rowDate = $(grid_selector1).jqGrid('getRowData', row_id); 
	             		var EvalMethID =  rowDate.EvalContId;
						//alert(rowDate.VilEvalScoID);
						 // (5)动态添加子报表的table和pager  
	            		$("#" + subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+subgrid_pager_id+"' class='scroll'></div>");  
	           			// (6)创建jqGrid对象  
	            		$("#" + subgrid_table_id).jqGrid({
	            			url :'../../evalcontobj_manageEvalContObj.action?oper=search&EvalObjID='+EvalMethID,
	            			datatype: "json", 
	            			colNames:[ '','调查对象编号','调查对象名称','计分用值','是否必填','备注'],
							colModel:[
							    {name:'EvalContInvesObjID',index:'EvalContInvesObjID', width:10,search:true,editable: false,key:true,hidden:true},
							    {name:'EvalContInvesObjCode',index:'EvalContInvesObjCode', width:55, search:true,editable: false},  
								{name:'EvalContInvesObjName',index:'EvalContInvesObjName', width:150,  search:true,editable: false},
								{name:'EvalContInvesObjValue',index:'EvalContInvesObjValue', width:40, sortable:false,editable: true},
								{name:'EvalContInvesObjMus',index:'EvalContInvesObjMus', width:50, sortable:false,editable: true,edittype:"select",editoptions: { value:"true:是;false:否"}},
								{name:'EvalContInvesObjNote',index:'EvalContInvesObjNote', width:50,editable: true}
								
								  
							], 
							jsonReader: {   // (8)针对子表格的jsonReader设置  
	                     		root:"data",//传递的json数据
						 		repeatitems: false,//允许json数据乱序
								page: "page", // json中代表当前页码的数据
						 		total: "total", // json中代表页码总数的数据
						 		records: "records", // json中代表数据行总数的数据  
	               			},  
			                prmNames: {
			                	sort: "sidx", // 表示用于排序的列名的参数名称  
							    order: "sord", // 表示采用的排序方式的参数名称  
							    nd:"nd", // 表示已经发送请求的次数的参数名称  
							    id:"EvalContInvesObjID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
							    oper:"oper",    // operation参数名称（我暂时还没用到）  
							    editoper:"edit", // 当在edit模式中提交数据时，操作的名称  
							    addoper:"add", // 当在add模式中提交数据时，操作的名称  
							    deloper:"del", // 当在delete模式中提交数据时，操作的名称  
							    //subgridid:"id", // 当点击以载入数据到子表时，传递的数据名称  
							    npage: null,   
		                       	page:"page",    // 表示请求页码的参数名称
		                       	rows:"rows",    // 表示请求行数的参数名称
		                       	search:"search", // 表示是否是搜索请求的参数名称
		                       	totalrows:"total" // 表示需从Server得到总共多少行数据的参数名称，参见jqGrid选项中的rowTotal
		                       },  
		                       
		                        pager: subgrid_pager_id,
	                			rowList:[20,40,100],  
	               				rowNum:20,
                				viewrecords: true,  
               					height: 80,  
	                			//rowNum: 5 ,
	                			multiselect: true,
			        			multiboxonly: true,
			       				autowidth: true,
			       				loadComplete : function() {
								var table = this;
								var rowNum = $("#" + subgrid_table_id).jqGrid('getGridParam','records');
						
								if(rowNum == 0 || rowNum == null){
									if($(".norecords").html() == null){
										$("#" + subgrid_table_id).parent().append("<div class=\"norecords\">暂无数据</div>");
									}
									$(".norecords").show();
									}else{
									$(".norecords").hide();
								}
			       				setTimeout(function(){
									styleCheckbox(table);
									updateActionIcons(table);
									updatePagerIcons(table);
									enableTooltips(table);
								}, 500);
								},
								
								
								 editurl :'../../evalcontobj_manageEvalContObj.action?EvalObjID='+EvalMethID
						
		                     });
		                       
		                      	
		                  $("#" + subgrid_table_id).jqGrid('sortableRows', {  
							items : '.jqgrow:not(.unsortable)'}
							)   
							
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
			 $("#" + subgrid_table_id).jqGrid('sortableRows', {  
					items : '.jqgrow:not(.unsortable)'}
				) 
			
				//navButtons
				jQuery("#" + subgrid_table_id).jqGrid('navGrid',"#"+subgrid_pager_id,
					{ 	//navbar options
					  // cloneToTop:true,
						edit: true,
						editicon : 'icon-pencil blue',
						add: false,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh: false,
						refreshicon : 'icon-refresh green',
						view: false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						//closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			           
							 $("#editmod" + subgrid_table_id).jqmHide();
			                var id = $("#" + subgrid_table_id).jqGrid('getGridParam', 'selrow');
			                jQuery("#" + subgrid_table_id).jqGrid('setRowData', id, postdata);
			                $("#" + subgrid_table_id).trigger("reloadGrid");//操作完成后刷新表单
			            }, 
			            closeAfterEdit: true, 
			            closeOnEscape: true
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
						}
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
						afterSubmit: function (xhr, postdata) {
						
			                $("#delmod" + subgrid_table_id).jqmHide();//关闭删除弹出框
							///if(xhr.responseText.success){
							var returndata = JSON.parse(xhr.responseText);
							bootbox.alert(returndata.success);
							var selectedRowIds = $("#" + subgrid_table_id).jqGrid("getGridParam", "selarrrow");
							var len = selectedRowIds.length;
							for (var i = 0; i < len ; i++) {
							   $("#" + subgrid_table_id).jqGrid("delRowData", selectedRowIds[0]);
							}
							  $("#" + subgrid_table_id).trigger("reloadGrid");
						           },
			         
			            closeAfterDel: true,
			            closeOnEscape: true,
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
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
					
				);
				
				
					 },
			       
			       
			       
			       
			       
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
					    id:"EvalContId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						var rowIds = jQuery(grid_selector1).jqGrid('getDataIDs'); 
						$(grid_selector1).jqGrid("setSelection",rowIds[0]);
						
						setTimeout(function(){
							styleCheckbox(table);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 500);
					},
					
					autowidth: true
			
				});/*
			 function beforeSelectRow() {  
            		$(grid_selector1).jqGrid('resetSelection');  
            		return(true);  
        		}*/
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
			
			function SeqCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^\d{1,3}\.\d{1,2}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"分序号组成结构,如:1.1; 111.11等"];
					}else{
					return [true,""];
					}
				}
			
				function DistInvesObj(cellvalue, options, rowObject){
					return  "<button class='btn btn-minier btn-info' onclick='EvalMethObj(\""+rowObject.EvalContId+"\")'>分配调查对象</button>";
				}
				//navButtons
				jQuery(grid_selector1).jqGrid('navGrid',grid_selector1,
					{ 	
						cloneToTop: true,
						edit: true,
						editicon : 'icon-pencil blue',
						add: true,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh: false,
						refreshicon : 'icon-refresh green',
						view: false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						//edit record form
						//closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "successful"){
						   $("#editmodgrid-table1").jqmHide();
			                var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table1").jqGrid('setRowData', id, postdata);
			                 return [true, rd.success];
			                
			                $("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
			                }else{
			                	return [false, rd.success];
			                }
			            }
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
					//	url: '../../invesObj_manageInvesObj.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "successful"){
						  	var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
					      	jQuery("#grid-table1").jqGrid('addRowData', postdata.Id, postdata);
					     	return [true, rd.success];
						  }else{
						  	  return [false, rd.success];
						  }
						 // bootbox.alert(rd.success);
					      
					    }
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
						 mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						 $("#delmodgrid-table1").jqmHide();//关闭删除弹出框
							var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
							var selectedRowIds = $("#grid-table1").jqGrid("getGridParam", "selarrrow");
							                var len = selectedRowIds.length;
							                for (var i = 0; i < len ; i++) {
							                    $("#grid-table1").jqGrid("delRowData", selectedRowIds[0]);
							                    }
							                  $("#grid-table1").trigger("reloadGrid");
							
			                
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
						onClick : function(e) {
							alert(1);
						}
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
						}
						,
						multipleSearch: true,
						/**
						multipleGroup:true,
						showQuery: true
						*/
					},
					{
						//view record form
						recreateForm: true,
						beforeShowForm: function(e){
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
						}
					}
					
				);
				
				
				
				
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=Startime]').datepicker({format:'yyyy' , autoclose:true})
						.end().find('input[name=stock]')
							  .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');
			
					form.find('input[name=Endtime]').datepicker({format:'yyyy' , autoclose:true})
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
			
				$("#grid-table_toppager_center").hide();
				$("#grid-table_toppager_right").hide();
				$("#grid-table1_toppager_center").hide();
				$("#grid-table1_toppager_right").hide();
				
			});
		--></script>
				<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0209").addClass("active");
			});
		</script>
		
		
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
			