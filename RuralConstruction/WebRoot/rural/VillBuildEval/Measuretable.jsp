<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>


		<style type= "text/css">
			.page-content{
				padding: 0 0 0 ;
			} 
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

.ui-jqgrid tr.jqgrow td {
				white-space: normal !important;
				height:auto;
			}
		#bt{width:100%;}
		#h4{text-align:center;}
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
				 padding-top:0px;
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
    #bt{width:100%;}
	#h4{text-align:center;}
			
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
							<li>得分与诊断提升</li>
							<li>诊断提升</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
					
						<div class="col-xs-12">
						 <span class="fileupload-process">
							          <div id="total-progress"  style="display:none;"class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
							            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
							          </div>
							        </span>
						
							<div class="col-xs-3">
							
							
								<div id="bt" class="widget-box" style="height:100%">
									<div id="h4" class="widget-header header-color-blue2">
										<h4 class="lighter smaller">村庄区划</h4>
									</div>
									
									<div class="widget-body" style="height:100%">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:88%"></div>
										</div>
									</div>
								</div>
							
							
							</div>
							<div class="col-xs-9">
		
									<table id="grid-table"></table>

									<div id="grid-pager"></div>

									<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
									</script>
							
							
							</div>
										
											
								<!-- PAGE CONTENT ENDS -->
					</div>
					
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

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>

		 <script src="assets/js/bootbox.min.js"></script>
		 <script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
		 <script src="assets/js/jquery.ui.touch-punch.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>


		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree.min.js"></script>
		<script type="text/javascript">
		var c = 0;
		function getProgress(){
			c++;
			document.querySelector("#total-progress .progress-bar").style.width = c + "%";
			if(c>=100){
				c=0;
			}
		};
		
			jQuery(function($){
          	 	//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
          	 	var ids = "";
          	 	var output ="";
           		//定义表的名字
				var grid_selector = "#grid-table";
				//定义页数的名字
				var pager_selector = "#grid-pager";
			
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../getVil_manageVils.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {

						tree_data=data.ss;

						},
						});
			var treeDataSource = new DataSourceTree({data: tree_data});

					$('#tree1').ace_tree({
					
						dataSource: treeDataSource ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : "icon-ok",
						'unselected-icon' : false,
					});

				
				
					 $('#tree1').on('selected', function(evt, data) {
					  output ="";
						ids = "";
							var items = $('#tree1' ).tree('selectedItems' );  
							for (var i in items) if (items.hasOwnProperty(i)) {  
								var item = items[i];  
							   ids += item.additionalParameters['id' ] + ",";	
							    output += item.name + ",";						   
							}
							
							ids = ids.substring(0, ids.lastIndexOf(","));	
							
							 output = output.substring(0, output.lastIndexOf(","));						
							//alert(ids);
						
					jQuery(grid_selector).jqGrid("setGridParam", {
		                
		                	url :'../../measimpro_manageMeasureimpro.action?oper=search&VilID='+ids,
		   				//	editurl:'../../citysfil_manageCitysFil.action?JQID='+ids	
 		                });
 		                jQuery(grid_selector).jqGrid("setCaption",output+"诊断提升").trigger("reloadGrid");
						
					});		
	
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					
					//data: grid_data,
					//datatype: "local",
					//url:'',
					mtype:"post",
					datatype: "json",
					height: 400,
					colNames:['','','评价序号','评价内容','分值','现状得分'],
					colModel:[
						{name:'EvalScoID',index:'EvalScoID',width:40, sorttype:"int", editable: false, key:true,hidden:true},
						//{name:'GoveFilClfyID',index:'GoveFilClfyID', width:40, sortable:false,editable: true,edittype:"select",editoptions:{dataUrl:"../../seldataCollDataDic_findAll.action" }},
						
						{name:'VilEvalscoID',index:'VilEvalscoID',width:40, sorttype:"int", editable: false, hidden:true},
						
						{name:'evalContSeqNum',index:'evalContSeqNum',width:20, sortable:false,editable: true},
						{name:'evalContDes',index:'evalContDes', editoptions:{size:"20",maxlength:"12"},width:60,editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'evalContScore',index:'evalContScore', editoptions:{size:"20",maxlength:"30"},width:30, editable: true},
						{name:'autoEvalSco',index:'autoEvalSco', editoptions:{size:"20",maxlength:"50"},width:30, sortable:false,editable: true,editoptions:{rows:"2",cols:"10"}}
						//{name:'CitysFilMadTim',index:'CitysFilMadTim', width:40,editable: true,sorttype:"date",unformat: pickDate},
						//{name:'CitysFilPubComp',index:'CitysFilPubComp',editoptions:{size:"20",maxlength:"50"}, width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'CitysFilExpl',index:'CitysFilExpl',editoptions:{size:"20",maxlength:"200"},width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						
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
					    id:"EvalScoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
					rowNum:100,
					rowList:[100,200,300],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					toppager: true,
					 multiselect : true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
					subGrid : true,//(1)开启子表格
					subGridOptions : {//子表格选项
						//plusicon : 'icon-plus',
						//minusicon : 'ui-icon-minus',
						openicon: 'icon-double-angle-right bigger-170 blue',
						expandOnLoad: false,
						//selectOnExpand : false,
						//reloadOnExpand : true
					},
			
					subGridRowExpanded : function(subgrid_id, row_id){ // (2)子表格容器的id和需要展开子表格的行id，将传入此事件函数
						var subgrid_table_id;  
	            		subgrid_table_id = subgrid_id + "_t";   // (3)根据subgrid_id定义对应的子表格的table的id  
	              		var subgrid_pager_id;  
	            		subgrid_pager_id = subgrid_id + "_pgr"  // (4)根据subgrid_id定义对应的子表格的pager的id
	             		var rowDate = $(grid_selector).jqGrid('getRowData', row_id); 
	             		var EvalScoID =  rowDate.EvalScoID;
						//alert(EvalScoID);
						 // (5)动态添加子报表的table和pager  
	            		$("#" + subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+subgrid_pager_id+"' class='scroll'></div>");  
	           			// (6)创建jqGrid对象  
	            		$("#" + subgrid_table_id).jqGrid({
	            			url:"../../impromeasure_manageimproMeas.action?oper=search&EvalScoID="+EvalScoID,
	            			datatype: "json", 
	            			colNames:['','提升措施','提升措施单位','提升措施数值','预计提升分数','提升措施备注'],
	            			colModel:[
	            				{name:'PrmtMeasID',index:'PrmtMeasID', width:60, key:true, editable: false,search:false,hidden:true},
					    		{name:'PrmtMeas',index:'PrmtMeas', width:60, editable: true,search:false,editrules: {required:true},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
					    		{name:'PrmtMeasComp',index:'PrmtMeasComp', width:35, editable: true,search:false,editrules: {required:true},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
					    		{name:'PrmtMeasValue',index:'PrmtMeasValue', width:35,  editable: true,editrules: {required:true,number:true,minValue:0,maxValue:50},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						  		{name:'ExpectPrmtSco',index:'ExpectPrmtSco', width:35,  editable: true,editrules: {required:true,number:true,minValue:0,maxValue:10000},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
								{name:'PrmtMeasNote',index:'PrmtMeasNote', width:30,editable: true}
							
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
							    id:"PrmtMeasID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
	                			rowList:[10,20,30],  
	               				rowNum:10,
                				viewrecords: true,  
               					height: 200,  
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
								 editurl :"../../impromeasure_manageimproMeas.action?EvalScoID="+EvalScoID,
								//caption: "提升措施"
		                     });
		                       
		                  $("#" + subgrid_table_id).jqGrid('sortableRows', {  
							items : '.jqgrow:not(.unsortable)'}
							) 
							
					jQuery("#" + subgrid_table_id).jqGrid('navGrid',"#"+subgrid_pager_id,
					{ 	//navbar options
					  // cloneToTop:true,
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
							 $("#editmod" + subgrid_table_id).jqmHide();
			                var id = $("#" + subgrid_table_id).jqGrid('getGridParam', 'selrow');
			                jQuery("#" + subgrid_table_id).jqGrid('setRowData', id, postdata);
			                $("#" + subgrid_table_id).trigger("reloadGrid");//操作完成后刷新表单
			                return [true, rd.success];
			              }else{
			                 return [false, rd.success];
			                }
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
						},
						mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "success"){
						  	var id = $("#" + subgrid_table_id).jqGrid('getGridParam', 'selrow');
					      	jQuery("#" + subgrid_table_id).jqGrid('addRowData', postdata.Id, postdata);
					     	return [true, rd.success];
					     	 
						  }else{
						  	  return [false, rd.success];
						  }
					    },
			            closeAfterEdit: true, 
			            closeOnEscape: true
						
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
			
			
					loadComplete : function() {
						var table = this;
						
						var rowNum = $(grid_selector).jqGrid('getGridParam','records');
						
								if(rowNum == 0 || rowNum == null){
									if($(".norecords").html() == null){
										$(grid_selector).parent().append("<div class=\"norecords\">暂无数据</div>");
									}
									$(".norecords").show();
									}else{
									$(".norecords").hide();
								}
						
						setTimeout(function(){
							styleCheckbox(table);
							//$("#grid-table").jqGrid('setSelection','001');
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 500);
					},
			
					//editurl: $path_base+"/dummy.html",//nothing is saved
					caption: "诊断提升",
			
			
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
			
				
				
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',grid_selector,
					{ 	//navbar options
					 	cloneToTop:true,
						edit: false,
						editicon : 'icon-pencil blue',
						add: false,
						addicon : 'icon-plus-sign purple',
						del: false,
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
						//编辑功能
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						//url: '../../exp_manageExpert.action', 
						//mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			            	$("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			                 //return [true, 'successfule!', false];
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			            }, 
			            //url :'../../exp_manageExpert.action?oper=search&JQID='+ids,
						
					},
					{
						//new record form
							width:350,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
						$(grid_selector).clearGridData();
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
							$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
						},
						//url: '../Userr_manage.action',
					   // mtype: 'POST',
					    afterSubmit: function (xhr, postdata) {
					       var rd = JSON.parse(xhr.responseText);
						  		bootbox.alert(rd.success);
						  $("#editmodgrid-table").jqmHide();
					      var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table").jqGrid('addRowData', postdata.Id, postdata);
					      return [true, 'successfule!', false];
					    }, 
					    closeAfterAdd: true, 
			            closeOnEscape: true
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
						//url: '../../exp_manageExpert.action',
					    //mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						    var rs = JSON.parse(xhr.responseText);
						  		bootbox.alert(rs.success);
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

						
						//onClick : function(e) {
							//alert(1);
						//}
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
				   title:"下载报表",
				   buttonicon:"download-icon icon-cloud-download blue", 
				   onClickButton: function(){
				     	var selrowids = $("#grid-table").jqGrid('getGridParam','selarrrow');
				     	if (selrowids==""||selrowids==null) {
							bootbox.alert("请选择评价内容");
						} else {
							var rowData = $("#grid-table").jqGrid('getRowData',selrowids[0]);
							var VilEvalscoIDs=rowData.VilEvalscoID;
							$("#total-progress").show();
							c = 0
							clearInterval(interval);
							document.querySelector("#total-progress .progress-bar").style.width = 0 + "%";
							var interval =	setInterval("getProgress()","100");
							
							$.ajax({
								type : "post",
								async: true,
								url : "../../downfile_createApplicationTable.action?VilNum="+ids+"&VilEvalscoID="+VilEvalscoIDs+"&EvalContScoreID="+selrowids,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
								dataType : "json",
								success : function(data) {
									if(data.success){
									var s = output+'.zip';
									var ss = encodeURI(encodeURI(s));
									clearInterval(interval);
									document.querySelector("#total-progress .progress-bar").style.width = 100 + "%";
									
									window.location.href='../../downtable.action?vilName='+ss;
									$("#total-progress").hide();
										
										
									}else{
										bootbox.alert(data.success);
											$("#total-progress").hide();
									}
								}
							});
						}
					
					
					
				   
		       },
				    
				   position:"last"    
				   
				});
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=CitysFilMadTim]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
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
					
			});
		
		</script>
		
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#08").addClass("active open");
				$("#0803").addClass("active");
			});
		</script>
	
		
		
		
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
