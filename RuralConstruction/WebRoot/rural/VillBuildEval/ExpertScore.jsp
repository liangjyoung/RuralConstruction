<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
	</head>
<style type= "text/css">
			.ui-jqgrid tr.jqgrow td {
			white-space: normal !important;
			height:auto;
			}
			.page-content{
				padding: 0 0 0 ;
			}
			.col-xs-12{	
				 width:100%;
				 overflow: hidden;
				 border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:570px;
			}
			.col-xs-3{	
				 width:16%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:570px;
			}
			.col-xs-9{	
				 width:84%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:570px;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 30px;
				padding: 0;
				margin: 0;
				margin-left: 18%;
				display: inline;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 18%;
				display: inline;
			}
			.space{
			background:#ccc;
			max-height:2px;
			min-height:2px;
			margin-bottom:1px;
			margin-top:2px;
		}
		.tab-content {
    		padding: 0px;
    		}
		</style>
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
							<li>专家评价</li>
							<li>专家打分</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="col-xs-12">
							<div class="col-xs-3">
								<div class="widget-box"style="height:100%">
									<div class="widget-header header-color-blue2">
										<h4 class="lighter smaller">区划分布</h4>
									</div>
									<div class="widget-body"style="height:100%">
										<div class="widget-main">
											<div id="tree1" class="tree"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-9">
								<table id="grid-table"></table>
									<div id="grid-pager"></div>
									<script type="text/javascript">
										var $path_base = "/";
									</script>
							<div class="space"></div>
							<ul class="nav nav-tabs  tab-color-blue background-blue" id="myTab4">
									<li class="active">
										<a data-toggle="tab" href="#shuxing">
												属性数据
										</a>
									</li>
									<li>
										<a data-toggle="tab" href="#wenjian">
												文件数据
										</a>
									</li>
								</ul>
								<div class="tab-content">
								<div id="shuxing" class="tab-pane in active">
										<table id="grid-table1"></table>
										<div id="grid-pager1"></div>
										<script type="text/javascript">
											var $path_base = "/";//this will be used in gritter alerts containing images
										</script>
								</div>
								<div id="wenjian" class="tab-pane ">
									<div class="row">							
										<!-- <p>此处应该显示该评价规则的所有文件</p> -->
										<div id="filelist" style="padding-left: 30px; padding-top:10px; height: 160px; overflow: auto;"></div>
									</div>
								</div>
							</div>
							</div>	
								
						</div><!-- col-xs-12 -->
					</div><!-- page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->
		<!-- 插入底部状态栏-->
		<%@ include file="base/footer.html"%>

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> --> <!-- 文档加载过慢 -->

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
		<script type="text/javascript">
			jQuery(function($){
          	 	//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
           		//定义表的名字
           		//var ids = "";
				var grid_selector = "#grid-table";
				//定义页数的名字
				var pager_selector = "#grid-pager";
				var grid_selector1 = "#grid-table1";
				//定义页数的名字
				var pager_selector1 = "#grid-pager1";
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../expertOLGra_getVilsTree.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {
						tree_data=data.ss;
						},
						});
						
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource = new DataSourceTree({data: tree_data});
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
					
					
 					jQuery(grid_selector).jqGrid("setGridParam", {
		                url :'../../expertOLGra_manageEvalCont.action?oper=search&distID='+ids,
		   				//editurl:'../../expertOLGra_saveScore.action'
 		             });
 		            jQuery(grid_selector).jqGrid("setCaption",output+"评价得分").trigger("reloadGrid");
						
					});		
					var lastsel2;
					var tempSave = true;//是否是暂存在前台，防止“保存”和“提交”时判断两次分数合法性，防止弹出两个提示窗
					jQuery(grid_selector).jqGrid({
					datatype: "json",
					mtype:"post",
					height: 255,
					colNames:['ID','评价内容编码','评价内容','备注','分值','得分','打分原因'],
					colModel:[
						{name:'EvalContId',index:'EvalContId',width:30, key:true,editable:false, editoptions:{size:"20",maxlength:"30"},hidden:true},
						{name:'EvalContNum',index:'EvalContNum',width:30, editable:false, editoptions:{size:"20",maxlength:"30"}},
						{name:'EvalContDes',index:'EvalContDes', width:60, editable:false, editoptions:{size:"20",maxlength:"30"}},
						{name:'EvalContNote',index:'EvalContNote', width:40, sortable:false,editable: false,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
						{name:'EvalContScore',index:'EvalContScore', width:20, editable:false},
						{name:'Score',index:'Score', width:20, sortable:false,
							editable: true,
							editrules:{
								edithidden:true,
								number:true,
								custom:true, 
								custom_func:function(value, colNames){
												//var rowId=$("#grid-table").jqGrid("getGridParam","selrow");
												var max = parseInt($("#grid-table").jqGrid('getRowData',lastsel2).EvalContScore);
	   											var re = /^(0|[1-9]\d*)$/;
	   											if(tempSave&&(value < 0 || value > max || (value!="" && !re.test(value)))){
							       					return [false, "不是正确的分值，请输入正确的分值！"];  
												}else{
												    return [true,""];
												}
											}
							}
						},
						{name:'GraRea',index:'GraRea', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
					], 
			 
				
					onSelectRow : function(id) {
					//单击该行使其处于可编辑状态
				     if (id && id !== lastsel2) {
				       jQuery('#grid-table').jqGrid('saveRow', lastsel2);
				       jQuery('#grid-table').jqGrid('editRow', id, true);
				       lastsel2 = id;
				      }
				      var contID = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
				      var ids = "";
				      var items = $('#tree1' ).tree('selectedItems' );  
				      for (var i in items) if (items.hasOwnProperty(i)) {  
				          var item = items[i];  
				          ids += item.additionalParameters['id' ] + ",";
				      }
					  ids = ids.substring(0, ids.lastIndexOf(","));
					 // alert(methID);
					 // alert(ids);
					  jQuery(grid_selector1).jqGrid("setGridParam", {
		                
		                	url :'../../evalContObjAttri_getObjAttri.action?oper=search&distID='+ids+'&contID='+contID,
		   
 		                });
 		                jQuery(grid_selector1).jqGrid("setCaption","相关属性").trigger("reloadGrid");
 		                //htmlobj=$.ajax({url:'../../servlet/ListFileServlet?distID='+ids+'&contID='+contID,async:false});
 		                htmlobj=$.ajax({url:'../../evalContFileData_getFiles.action?distID='+ids+'&contID='+contID,async:false});
						$("#filelist").html(htmlobj.responseText);
				    },
			       //	beforeSelectRow: beforeSelectRow1,
					viewrecords : true,
					rowNum:10000,
					//rowList:[10,20,30],
					pager : pager_selector,
					pgbuttons: false,//上下按钮  
					pginput:false,//输入框
					altRows: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        beforeSelectRow: beforeSelectRow,
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
					    id:"VilEvalScoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						//alert(rowIds[0]);
						setTimeout(function(){
							styleCheckbox(table);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					//caption: "村庄评价得分",
					autowidth: true
			
				});
			
				//实现单选，前提是	multiselect: true,  multiboxonly:true,  beforeSelectRow: beforeSelectRow,//js方法 
			    function beforeSelectRow() {  
            		$(grid_selector).jqGrid('resetSelection');  
            		return(true);  
        		}
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
				jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
					  // cloneToTop:true,
						edit: false,
						editicon : 'icon-pencil blue',
						add: false,
						addicon : 'icon-plus-sign purple',
						del: false,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						view: true,
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
					
					
					jQuery(grid_selector1).jqGrid({
					//url:'../../evalsys_manageEvalSys.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 80,
					colNames:['id','调查对象','调查对象数据值','说明'],
					colModel:[
						{name:'InvesObjDataId',index:'InvesObjDataId', width:100, sorttype:"int", editable: true,hidden:true},
						{name:'InvesObjName',index:'InvesObjName', width:200, sorttype:"int", editable: true},
						
						{name:'InvesObjDataValu',index:'InvesObjDataValu', width:200, editable: true},
						{name:'InvesObjDataNote',index:'InvesObjDataNote', width:200, editable: true}
					], 
			       
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					
					pager : pager_selector1,
					altRows: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        //emptyrecords:"sss",
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
					    id:"InvesObjDataId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						//var rowIds = jQuery(grid_selector1).jqGrid('getDataIDs'); 
					//	$(grid_selector1).jqGrid("setSelection",rowIds[0]);
						
						var rowNum = $(grid_selector1).jqGrid('getGridParam','records');
						if(rowNum == 0 || rowNum == null){
							if($(".norecords").html() == null){
								$(grid_selector1).parent().append("<div class=\"norecords\">本方法下没有对应的对象属性可供参考。</div>");
							}
							$(".norecords").show();
							}else{
							$(".norecords").hide();
						}
						//alert(rowIds[0]);
						setTimeout(function(){
							styleCheckbox(table);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
							test(table);
						}, 0);
					},
					//caption: "村庄评价得分",
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
				jQuery(grid_selector1).jqGrid('navGrid',pager_selector1,
					{ 	//navbar options
					  // cloneToTop:true,
						edit: false,
						editicon : 'icon-pencil blue',
						add: false,
						addicon : 'icon-plus-sign purple',
						del: false,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh: true,
						refreshicon : 'icon-refresh green',
						view: true,
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
					
				).navSeparatorAdd(pager_selector,{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd(pager_selector,{     
				   caption:"",
				   title:"保存",
				   buttonicon:"icon-file", 
				   
				   onClickButton: function(){ 
				   	   tempSave=false;//每个单行不在进行单独判断分数的合法性，在下面统一判断
				   	   //保存之前一行所打的 分数
				   	   jQuery('#grid-table').jqGrid('saveRow', lastsel2);
					   var obj=$("#grid-table").jqGrid("getRowData");//[0].Score;
					   //alert(JSON.stringify(obj));
					   var re = /^(0|[1-9]\d*)$/;
					   var canSubmit = true; 
					   var scores = "[";
					   for(var i in obj){
						   if (obj.hasOwnProperty(i)) {
							   //if(!re.test(obj[i].Score))//isNaN(obj[i].Score)
							   //    //obj[i].Score = "";
							   //    continue;
							   //alert(obj[i].Score+" = zongfen"+obj[i].EvalContScore);
							   if((obj[i].Score!="" && !re.test(obj[i].Score)) || parseInt(obj[i].Score) > parseInt(obj[i].EvalContScore) || parseInt(obj[i].Score) < 0){
							       alert("编号为"+obj[i].EvalContNum+"的评价得分不合法！\n请修改后再进行保存！");
							       canSubmit = false;
							       tempSave = true;//之后可以进行单行分数合法性的判断
							       break;
							   }
							   scores += "{'contID':'" + obj[i].EvalContId + "','Score':'" + obj[i].Score + "','GraRea':'" + obj[i].GraRea + "'},";
						   }
					   }
					   if(canSubmit){
						   scores += "{}]";
						   var ids = "";
					       var items = $('#tree1' ).tree('selectedItems' );  
					       for (var i in items) if (items.hasOwnProperty(i)) {  
					           var item = items[i];  
					           ids += item.additionalParameters['id' ] + ",";
					       }
						   ids = ids.substring(0, ids.lastIndexOf(","));
						   $.ajax({
								url: "../../expertOLGra_saveScore.action",//?distID="+ids+"&scores="+encodeURI(scores,"utf-8"),//scores,
								async:false,  
								type: 'POST',
								data: {distID:ids, scores:scores, sub:false},
								dataType: 'json',
								scriptCharset: 'utf-8',
								success : function(data) {
								//tree_data=data.ss;
								alert("保存成功！");
								},
							});
							location.reload(true);
						}
					}
				    //position:"last"
				}).navButtonAdd(pager_selector,{     
				   caption:"",
				   title:"提交",
				   buttonicon:"icon-cloud-upload", 
				   
				   onClickButton: function(){ 
				   	   tempSave=false;//每个单行不在进行单独判断分数的合法性，在下面统一判断
				   	   //保存之前一行所打的 分数
				   	   jQuery('#grid-table').jqGrid('saveRow', lastsel2);
					   var obj=$("#grid-table").jqGrid("getRowData");//[0].Score;
					   //alert(JSON.stringify(obj));
					   var re = /^(0|[1-9]\d*)$/;
					   //var canSubmit = false; 
					   var isValid = true;
					   var scores = "[";
					   for(var i in obj){
						   if (obj.hasOwnProperty(i)) {
							   //if(!re.test(obj[i].Score))//isNaN(obj[i].Score)
							   //    //obj[i].Score = "";
							   //    continue;
							   //alert(obj[i].Score+" = zongfen"+obj[i].EvalContScore);
							   if((obj[i].Score!="" && !re.test(obj[i].Score)) || parseInt(obj[i].Score) > parseInt(obj[i].EvalContScore) || parseInt(obj[i].Score) < 0){
							       alert("编号为"+obj[i].EvalContNum+"的评价得分不合法！\n请修改后在进行提交！");
							       isValid = false;
							       tempSave = true;//之后可以进行单行分数合法性的判断
							       return false;
							   }
							   if(obj[i].Score==""){
							       alert("请完成所有项的打分后再进行提交！");
							       isValid = false;
							       tempSave = true;//之后可以进行单行分数合法性的判断
							       return false;
							   }
							   scores += "{'contID':'" + obj[i].EvalContId + "','Score':'" + obj[i].Score + "','GraRea':'" + obj[i].GraRea + "'},";
						   }
					   }
					   if(isValid && confirm("提交后将不能进行修改，您确认提交吗？")){
						   scores += "{}]";
						   var ids = "";
					       var items = $('#tree1' ).tree('selectedItems' );  
					       for (var i in items) if (items.hasOwnProperty(i)) {  
					           var item = items[i];  
					           ids += item.additionalParameters['id' ] + ",";
					       }
						   ids = ids.substring(0, ids.lastIndexOf(","));
						   $.ajax({
								url: "../../expertOLGra_saveScore.action",//?distID="+ids+"&scores="+encodeURI(scores,"utf-8"),//scores,
								async:false,  
								type: 'POST',
								data: {distID:ids, scores:scores, sub:true},
								dataType: 'json',
								scriptCharset: 'utf-8',
								success : function(data) {
								//tree_data=data.ss;
								alert("提交成功！");
								},
							});
							location.reload(true);//刷新网页
						}
					}
				    //position:"last"
				});
				
	//专家分配表		
		
				
				
				
				
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
					
			});
			

		</script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#07").addClass("active open");
				$("#0702").addClass("active");
			});
		</script>
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
