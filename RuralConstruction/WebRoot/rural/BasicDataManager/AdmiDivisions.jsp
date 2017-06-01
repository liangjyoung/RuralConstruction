<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
				 height:631px;
			}
			.col-xs-3{	
				 overflow: hidden;
				 border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:631px;
				 width:20%;
			}
			.col-xs-9{	
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:631px;
				 width:80%;
			}
			.col-xs-7{	
				 width:66%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#FFF;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 1px;
				 height:631px;
			}
			.col-xs-5{	
				 width:60%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:631px;
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
							<li>镇及以上行政区划</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<!-- PAGE CONTENT BEGINS -->
						<div class = "row">
							<div class = "col-xs-12">
						
						    <div  style="width:100%;float:left;"> 
										<table id="grid-table"></table>

									<div id="grid-pager"></div>

									<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
									</script>
									<div id="consoleDlg"></div>
									<table id="grid-table1"></table>

										<div id="grid-pager1"></div>

										<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
										</script>
										<div id="consoleDlg1"></div>
										
										<!-- <div class="space"></div> -->
									<table id="grid-table2"></table>

										<div id="grid-pager2"></div>

										<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
										</script>
										<div id="consoleDlg2"></div>
									</div>
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
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
		
		
	
		
		
		
		<!-- end -->
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
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
				$("#consoleDlg2").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 500,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
	
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
	            var grid_selector1 = "#grid-table1";
				var pager_selector1 = "#grid-pager1";
			    var grid_selector2 = "#grid-table2";
				var pager_selector2 = "#grid-pager2"; 
				var rowdatas="";
				var rowdatas1="";
				var rowdatas2="";
				
				//var rowData;
				　//var proBasicInfoID = "aa";
				jQuery(grid_selector).jqGrid({
					url:'../../CityBasicInfo_manageCityBasicInfo.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 80,
					colNames:['cityBasicInfoID', '编号','市名','proBasicInfoID','经度','纬度','面积(平方公里)','人口数(万人)','户数','简介'],
					colModel:[
					     {name:'cityBasicInfoID',index:'cityBasicInfoID', width:20, sorttype:"int", editable: true,key:true,hidden:true},
					    {name:'cityNum',index:'cityNum', width:20,  editable: true,editoptions:{size:"18",maxlength:"14"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:cityNumCheck}},  
                        {name:'cityName',index:'cityName', width:20, sortable:false,editable: true,editoptions:{size:"18",maxlength:"10"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true}} ,
						 {name:'proBasicInfoID',index:'proBasicInfoID', width:20, sorttype:"int", editable: true,hidden:true},
						{name:'cityLongi',index:'cityLongi', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"}} ,
						{name:'cityLati',index:'cityLati', width:10,editable: true,editoptions:{size:"15",maxlength:"20"}},
						{name:'cityMeas',index:'cityMeas', width:10,editable: true,editoptions:{size:"15",maxlength:"20"},editrules: {number:true,minValue:0}},
						{name:'cityPop',index:'cityPop', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"},editrules: {number:true,minValue:0}},
                        {name:'cityHholds',index:'cityHholds', width:10, sorttype:"int", editable: true,editoptions:{size:"15",maxlength:"20"},editrules: {number:true,minValue:0}},
                        {name:'cityIntro',index:'cityIntro', width:20,editable: true,edittype:"textarea", editoptions:{rows:"5",cols:"10"},hidden:true, editrules:{edithidden:true}}, 						
					], 
					 onSelectRow: function ()  {   
						var rowid = $("#grid-table").jqGrid("getGridParam", "selrow");
						
						jQuery(grid_selector1).jqGrid("setGridParam", {
		                  url :'../../CountryBasicInfo_manageCountryBasicInfo.action?oper=search&JQID='+rowid,
		                 
		                   editurl:'../../CountryBasicInfo_manageCountryBasicInfo.action?JQID='+rowid,
		                });
		                jQuery(grid_selector1).jqGrid("setCaption","县（区）级区划").trigger("reloadGrid");
		              // jQuery(grid_selector2).jqGrid("setCaption","镇级区划").trigger("reloadGrid");
		                // $("#grid-table2").trigger("reloadGrid");
		    
					},//点击获取gqgird的当前列的'GRP_ID'的值
				

					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
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
					    id:"cityBasicInfoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						
						var rowIds = jQuery(grid_selector).jqGrid('getDataIDs'); 
						//alert(rowIds);
						$(grid_selector).jqGrid("setSelection",rowIds[0]);
						//rowData = $("#grid-table").jqGrid('getRowData',rowIds[0]);
						//proBasicInfoID= rowData.proBasicInfoID;
						//alert(proBasicInfoID);
						setTimeout(function(){
							styleCheckbox(table);
							//$(grid_selector).jqGrid("setSelection",371200000000);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 1000);
					},
					//alert(proBasicInfoID);
					editurl: "../../CityBasicInfo_manageCityBasicInfo.action",
					caption: "市级区划",
			
			
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
				
				
					//验证市级编号
				function cityNumCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[0-9]{4}[.]{1}[0]{2}[.]{1}[0]{2}[.]{1}[0]{3}/;
						
					}
						
					if(!reg.test(value)){
						return [false,"市编号的格式为xxxx.00.00.000"];
					}else{
					/*
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).cityBasicInfoID
					//alert (id);	
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../CityBasicInfo_checkCityNum.action?cityNum="+value+"&cityBasicInfoID="+id,
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
						return [false,"该编码已存在!"];
					}*/
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
						url: '../../CityBasicInfo_manageCityBasicInfo.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             var rd = JSON.parse(xhr.responseText);
						  if(rd.success == "添加成功"){
			              $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			                 return [true, rd.success];
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			                }else{
			                return [false, rd.success];
			                }
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
						url: '../../CityBasicInfo_manageCityBasicInfo.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  //var r=eval('('+xhr.responseText+')');
						  var rd = JSON.parse(xhr.responseText);
						   if(rd.success == "添加成功"){
					      var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table").jqGrid('addRowData', postdata.Id, postdata);
					        return [true, 'successfule!'];
					      }else{
			                	return [false, rd.success];
			                }
					      
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
						url: '../../CityBasicInfo_manageCityBasicInfo.action',
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
						multipleSearch: true,
						
						//url: 'Sex_manageSex.action',
					    //mtype: 'POST',
						//添加删除逻辑
						//afterSubmit: function (xhr, postdata) {
			            //    var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			            //    var len = selectedRowIds.length;
			            //    for (var i = 0; i < len ; i++) {
			            //        $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
			            //    }
			            //    $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			            //},
			            //closeAfterDel: true,
			            //closeOnEscape: true,
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
				   title:"导入",
				   buttonicon:"icon-cloud-upload blue",
				  //buttonicon:" icon-download-alt", 
				   
				    onClickButton: function(){
						var consoleDlg = $("#consoleDlg");
				consoleDlg.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='upLoadCity.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
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
				    
					//alert(rowdatas[0].townBasicInfoID)
					if(rowdatas.length>0){
					for(var i=0;i<rowdatas.length;i++)
					{
					  if(i!=rowdatas.length-1){
					 ids += rowdatas[i].cityBasicInfoID+",";
					 }else{
					 ids +=rowdatas[i].cityBasicInfoID;
					  
					 }
			       }
	             }
				
				    window.location.href = "../../cityInformationToExcel.action?rowids="+ids+"&rowNum="+rowNum;
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
			   
                  
		
		
				jQuery(grid_selector1).jqGrid({
					mtype:"post",
					datatype: "json",
					height: 120,
					colNames:[ 'countryBasicInfoID','编号','名称','cityNum','经度','纬度','面积(平方公里)','人口数(万人)','户数','简介'],
					colModel:[
					    {name:'countryBasicInfoID',index:'countryBasicInfoID', width:20, sorttype:"int", editable: true,key:true,hidden:true},
					    {name:'countryNum',index:'countryNum', width:20, sorttype:"int", editable: true,editoptions:{size:"18",maxlength:"14"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:countryNumCheck}},  
                        {name:'countryName',index:'countryName', width:20, sortable:false,editable: true,editoptions:{size:"18",maxlength:"10"},formoptions:{elmsuffix:"<font color='red'>*</font>"}} ,
						 {name:'cityBasicInfoID',index:'cityBasicInfoID', width:20, sorttype:"int", editable: true,hidden:true},
						{name:'countryLongi',index:'countryLongi', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"}} ,
						{name:'countryLati',index:'countryLati', width:10,editable: true,editoptions:{size:"15",maxlength:"20"}},
						{name:'countryMeas',index:'countryMeas', width:10,editable: true,editoptions:{size:"15",maxlength:"20"}},
						{name:'countryPop',index:'countryPop', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"},editrules: {number:true,minValue:0}},
                        {name:'countryHholds',index:'countryHholds', width:10, sorttype:"int", editable: true,editoptions:{size:"15",maxlength:"20"}},
                        {name:'countryIntro',index:'countryIntro', width:20,editable: true,edittype:"textarea",editoptions:{rows:"5",cols:"10"},hidden:true, editrules:{edithidden:true}}, 						
						
						  
					], 
					
					 onSelectRow: function () 
					{   
						var rowid11="";
						rowid11 = $("#grid-table1").jqGrid("getGridParam", "selrow");
						//alert(rowid11);
						jQuery(grid_selector2).jqGrid("setGridParam", {
		                  url :'../../TownBasicInfo_manageTownBasicInfo.action?oper=search&JQID='+rowid11,
		                	editurl:'../../TownBasicInfo_manageTownBasicInfo.action?JQID='+rowid11
		                });
		                jQuery(grid_selector2).jqGrid("setCaption","(乡)镇级区划").trigger("reloadGrid");
						
					},//点击获取gqgird的当前列的'GRP_ID'的值
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
					    id:"countryBasicInfoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector1,
					altRows: true,
					toppager: true,
					
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						var table = this;
						 rowdatas1 = $("#grid-table1").jqGrid('getRowData');	
						
						var rowIds = jQuery(grid_selector1).jqGrid('getDataIDs'); 
						//alert(rowIds);
						if(rowIds == ""||rowIds ==null){
						 $(grid_selector2).clearGridData(); 
						}else{
							$(grid_selector1).jqGrid("setSelection",rowIds[0]);
						}
						setTimeout(function(){
							styleCheckbox(table);
							//$(grid_selector).jqGrid("setSelection",371200000000);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 10000);
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
				
				
					//验证县/(区)级编号
				function countryNumCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[0-9]{4}[.]{1}[0-9]{2}[.]{1}[0]{2}[.]{1}[0]{3}/;
						
					}
						
					if(!reg.test(value)){
						return [false,"县(区)级编号的格式为3712.xx.00.000!"];
					}else{
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
			             var rd = JSON.parse(xhr.responseText);
						   if(rd.success == "添加成功"){
			              $("#editmodgrid-table1").jqmHide();
			                var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table1").jqGrid('setRowData', id, postdata);
			                return [true, 'successfule!'];
			                $("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
			            	
					      }else{
			                	return [false, rd.success];
			                }
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
					     var rd = JSON.parse(xhr.responseText);
						   if(rd.success == "添加成功"){
						  //var r=eval('('+xhr.responseText+')');
					      var id = $("#grid-table1").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table1").jqGrid('addRowData', postdata.Id, postdata);
					      return [true, 'successfule!'];
					      }else{
			                	return [false, rd.success];
			                }
					      
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
				
				var a1 = "<iframe src='upLoadCountry.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
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
				    var ids="";
				     var rowNum = $("#grid-table1").jqGrid('getGridParam','records');
				    
					//alert(rowdatas[0].townBasicInfoID)
					if(rowdatas1.length>0){
					for(var i=0;i<rowdatas1.length;i++)
					{
					  if(i!=rowdatas1.length-1){
					 ids += rowdatas1[i].countryBasicInfoID+",";
					 }else{
					 ids +=rowdatas1[i].countryBasicInfoID;
					  
					 }
			       }
	             }
				
				    window.location.href = "../../countryInformationToExcel.action?rowids="+ids+"&rowNum="+rowNum;
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
			
				
		
		jQuery(grid_selector2).jqGrid({
					mtype:"post",
					datatype: "json",
					height:160,
					colNames:[ 'townBasicInfoID','编号','名称','所属县','经度','纬度','面积(平方公里)','人口数(万人)','户数','简介'],
					colModel:[
					    {name:'townBasicInfoID',index:'townBasicInfoID', width:20, sorttype:"int", editable: true,key:true,hidden:true},
					    {name:'townNum',index:'townNum', width:20, sorttype:"int", editable: true,editoptions:{size:"18",maxlength:"14"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:townNumCheck}},  
                        {name:'townName',index:'townName', width:20, sortable:false,editable: true,editoptions:{size:"18",maxlength:"10"},formoptions:{elmsuffix:"<font color='red'>*</font>"}} ,
						{name:'countryBasicInfoID',index:'countryBasicInfoID', width:20, sorttype:"int", editable: true,hidden:true},  
						{name:'townLongi',index:'townLongi', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"}} ,
						{name:'townLati',index:'townLati', width:10,editable: true,editoptions:{size:"15",maxlength:"20"}},
						{name:'townMeas',index:'townMeas', width:10,editable: true,editoptions:{size:"15",maxlength:"20"}},
						{name:'townPop',index:'townPop', width:10, sortable:false,editable: true,editoptions:{size:"15",maxlength:"20"},editrules: {number:true,minValue:0}},
                        {name:'townHholds',index:'townHholds', width:10, sorttype:"int", editable: true,editoptions:{size:"15",maxlength:"20"}},
                        {name:'townIntro',index:'townIntro', width:20,editable: true,edittype:"textarea",edittype:"textarea", editoptions:{rows:"5",cols:"10"},hidden:true, editrules:{edithidden:true}}, 						
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
					    id:"townBasicInfoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector2,
					altRows: true,
					toppager: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true, 
	
					loadComplete : function() {
						var table = this;
						 rowdatas2 = $("#grid-table2").jqGrid('getRowData');	
						 //alert(rowdatas2[0].townBasicInfoID);
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
			
					
					//editurl: "../../TownBasicInfo_manageTownBasicInfo.action",
					//caption: "市级区划",
					autowidth: true
				});
			
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
			
			//验证镇级编号
				function townNumCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[0-9]{4}[.]{1}[0-9]{2}[.]{1}[0-9]{2}[.]{1}[0]{3}/;
						
					}
						
					if(!reg.test(value)){
						return [false,"镇编号的格式为3712.01.xx.000!"];
					}else{
					
					return [true,""];
					}		
			}
				//navButtons
				jQuery(grid_selector2).jqGrid('navGrid',grid_selector2,
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
						//url: '../../TownBasicInfo_manageTownBasicInfo.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             var rd = JSON.parse(xhr.responseText);
						   if(rd.success == "添加成功"){
		
			             $("#editmodgrid-table2").jqmHide();
			                var id = $("#grid-table2").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table2").jqGrid('setRowData', id, postdata);
			                return [true, 'successfule!'];
			                $("#grid-table2").trigger("reloadGrid");//操作完成后刷新表单
			             
			             
					      }else{
			                	return [false, rd.success];
			                }
			             
			            }, 
					},
					{
						//new record form
						
						
						closeAfterAdd: true,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
						// var rowid1 = $("#grid-table1").jqGrid("getGridParam", "selrow");
						//alert(rowid1);
						//jQuery(grid_selector2).jqGrid("setGridParam", {
		              // url: '../../TownBasicInfo_manageTownBasicInfo.action?oper=add&JQID='+rowid1,
		               // });
					
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						
						//url: '../../TownBasicInfo_manageTownBasicInfo.action?oper=add&JQID='+rowid11,
						
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  //var r=eval('('+xhr.responseText+')');
						   var rd = JSON.parse(xhr.responseText);
						   if(rd.success == "添加成功"){
					      var id = $("#grid-table2").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table2").jqGrid('addRowData', postdata.Id, postdata);
					       return [true, 'successfule!'];
					      }else{
			                	return [false, rd.success];
			                }
					      
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
						//url: '../../TownBasicInfo_manageTownBasicInfo.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
						
						 var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
								
								
			                var selectedRowIds = $("#grid-table2").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table2").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table2").trigger("reloadGrid");//操作完成后刷新表单
			                $("#delmodgrid-table2").jqmHide();//关闭删除弹出框
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
				).navButtonAdd('#grid-table2_toppager',{     
				   caption:"",
				   title:"导入",
				   buttonicon:"icon-cloud-upload blue",
				  //buttonicon:" icon-download-alt", 
				   
				    onClickButton: function(){
						var consoleDlg2 = $("#consoleDlg2");
				consoleDlg2.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='upLoadTown.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(InvgatID);
				
				consoleDlg2.append(a1);
				
				consoleDlg2.dialog("option", "title", "导入文件").dialog("open");
				
				 window.$("#grid-table2").trigger("reloadGrid");//操作完成后刷新表单	
				   },       
				       
				   position:"last"      
				}).navButtonAdd('#grid-table2_toppager',{     
				   caption:"",
				   title:"导出",
				   //buttonicon:"icon-cloud-upload",
				  buttonicon:" icon-download-alt blue", 
				   
				    onClickButton: function(){
				    var ids="";
				     var rowNum = $("#grid-table2").jqGrid('getGridParam','records');
				    
					//alert(rowdatas[0].townBasicInfoID)
					if(rowdatas2.length>0){
					for(var i=0;i<rowdatas2.length;i++)
					{
					  if(i!=rowdatas2.length-1){
					 ids += rowdatas2[i].townBasicInfoID+",";
					 }else{
					 ids +=rowdatas2[i].townBasicInfoID;
					  
					 }
			       }
	             }
				
				    window.location.href = "../../townInformationToExcel.action?rowids="+ids+"&rowNum="+rowNum;
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
				     $("#grid-table2_toppager_center").hide();
				    $("#grid-table2_toppager_right").hide();
            
				    
		});	
			
		</script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0202").addClass("active");
			});
		</script>
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>
