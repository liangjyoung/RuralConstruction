<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
 <!DOCTYPE html>
<html lang="en">
	<head>
		
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
		
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="assets/css/chosen.css" />

		<script src="assets/js/ace-extra.min.js"></script>
		<script src="assets/js/jquery-1.9.1.js"></script>
	</head> 

	<body>
		<div class="main-container" id="main-container">
			<div class="main-container-inner">
                <div class="main-content">
					<div class="page-content"> 
						<div class="row"> 
							<div class="col-xs-12"> 
								<!-- PAGE CONTENT BEGINS -->
								  
								<input type="hidden" id="InvgatID" value="<%=request.getParameter("InvgatID") %> ">
								<table id="grid-table"></table>

								<div id="grid-pager"></div>

								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
	
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

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			/*var grid_data = 
			[ 
				{VilNum:"100000000000",VilName:"A村",VilLongi:"30",VilLati:"30",VilMeas:"100",VilPop:"10000",VilHholds:"3333",VilNatural:"3",VilIntro:"100000"},
				
				
				
			];	*/
			
			
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
			
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					url:'../../VilBasicInfo_manageVilBasicInfo.action?oper=search',
					//data: grid_data,
					datatype: "json",
					mtype:"post",
					height: 215,
					colNames:['VilBasicInfoID','村庄名称','人口数', '户数','自然村数','面积'],
					colModel:[
					    {name:'VilBasicInfoID',index:'VilBasicInfoID', width:50, sorttype:"int",key:true, editable: false,search:false,hidden:true},
						{name:'VilName',index:'VilName', width:50,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'VilPop',index:'VilPop', width:30,editable: true,},
						{name:'VilHholds',index:'VilHholds', width:30,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'VilNatural',index:'VilNatural', width:30, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}} ,
						{name:'VilMeas',index:'VilMeas', width:40, editable: true,}, 
					], 
					viewrecords : true,
					rowNum:10,
					rowList:[10,20,30],
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					
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
					    id:"VilBasicInfoID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
			
					editurl: "../../VilInfo_manageVilBasicInfo.action",//nothing is saved
					//caption: "村庄区划",
			
			
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
					jQuery(grid_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
					   //cloneToTop:true,
						edit: false,
						editicon : 'icon-pencil blue',
						add: false,
						addicon : 'icon-plus-sign purple',
						del: false,
						delicon : 'icon-trash red',
						search: true,
						searchicon : 'icon-search orange',
						refresh: false,
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
						url: '../../VilInfo_manageVilBasicInfo.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			               
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
						
						url: '../../VilInfo_manageVilBasicInfo.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						
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
						url: '../../VilBasicInfo_manageVilBasicInfo.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
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
				).navSeparatorAdd(pager_selector,{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd(pager_selector,{     
				   caption:"",
				   title:"提交",
				   buttonicon:"icon-cloud-upload", 
				   
				    onClickButton: function(){
					 var InvgatID = $("#InvgatID").val();
					//var id=$(grid_selector).jqGrid("getGridParam","selrow");//获得单行id
					var ids=$(grid_selector).jqGrid("getGridParam","selarrrow");//获得多行id
					//alert(ids);
					
				   $.ajax({
						type : "post",
						async: false,
						url : "../../InvgatDworks_manageInvgatDwork.action?oper=add&invgatID="+InvgatID+"&vilBasicInfoID="+ids,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								window.parent.$("#consoleDlg").dialog("close");
		
				               window.parent.$("#grid-table1").jqGrid("setGridParam", {
				                  url : "../../InvgatDworks_manageInvgatDwork.action?invgatID="+InvgatID+"&oper=search",
				                });
				                 window.parent.$("#grid-table1").jqGrid("setCaption","分配情况").trigger("reloadGrid");
							}
						}
					});
					
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
			   
                    $("#grid-table1_toppager_center").hide();
				    $("#grid-table1_toppager_right").hide();
	    });
		</script>
		
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
