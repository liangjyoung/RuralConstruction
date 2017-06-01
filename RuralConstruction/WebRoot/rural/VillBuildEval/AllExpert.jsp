<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
	</head>
<style type= "text/css">
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
		</style>
	<body>
		<!-- 插入网页头部标题 -->
		<div class="main-content">
					<div class="page-content">
						<div class="col-xs-12">
							<div class="col-xs-3">
								<div class="widget-box"style="height:100%">
									<div class="widget-header header-color-blue2">
										<h4 class="lighter smaller">专家专业分类</h4>
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
							</div>	
								
						</div><!-- col-xs-12 -->
					</div><!-- page-content -->
				</div><!-- /.main-content -->
		<!-- 插入底部状态栏-->
		
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
			<script type="text/javascript"><!--
		
		
			jQuery(function($){
          	 	//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
           		//定义表的名字
           		//var ids = "";
				var grid_selector = "#grid-table";
				//定义页数的名字
				var pager_selector = "#grid-pager";
			
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../allexp_singTree.action",//tree_singTree.action
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
 							jQuery(grid_selector).jqGrid("setGridParam", {
		                		url :'../../allexp_manageExpert.action?oper=search&JQID='+ids,
		   						//editurl:'../../exp_manageExpert.action?JQID='+ids	
 		               		 });
 		               	 jQuery(grid_selector).jqGrid("setCaption",output).trigger("reloadGrid");
						
					});		
	
				jQuery(grid_selector).jqGrid({
					mtype:"post",
					datatype: "json",
					height: 440,
					colNames:['expertID', '专家编号','姓名','性别','职称','办公电话','手机','出生日期','地址'],
					colModel:[
						{name:'expertID',index:'expertID', width:60, key:true, editable: false,search:false,hidden:true},
						{name:'ExpertNum',index:'ExpertNum', width:40, editable: true,editrules:{required:true,custom:true,custom_func:expertNumCheck},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'ExpertName',index:'ExpertName', width:30,editable: true,editoptions:{size:"20",maxlength:"10"},editrules:{required:true},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'SexID',index:'SexID',width:20,align:'center',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:"../../selsex_findAll.action" }},
						//{name:'ExpertBirth',index:'ExpertBirth', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
						//{name:'PolCode',index:'PolCode', width:40, editable: true,edittype:"select",editoptions:{value:"QZ:群众;GQ:共青团员;ZY:中共预备党员;ZD:中共党员"}},
						//{name:'NationCode',index:'NationCode',hidden:true, width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						
						//{name:'ExpertMajorCatgID',index:'ExpertMajorCatgID',hidden:true, width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'EduID',index:'EduID', width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						
						{name:'ExpertTitle',index:'ExpertTitle', width:40,editable: true,editoptions:{size:"20",maxlength:"8"}},
						//{name:'ExpertPost',index:'ExpertPost', width:60,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'ExpertWorkTel',index:'ExpertWorkTel', width:55,editable: true,editoptions:{size:"20",maxlength:"13"}},
						{name:'ExpertMobTel',index:'ExpertMobTel', width:55,editable: true,editoptions:{size:"20",maxlength:"13"}},
						//{name:'ExpertQQ',index:'ExpertQQ', width:30,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'ExpertComp',index:'ExpertComp', width:30,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'ExpertGraReli',index:'ExpertGraReli', width:50,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'ExpertEmail',index:'ExpertEmail', width:50,hidden:true,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'ExpertWx',index:'ExpertWx', width:50,hidden:true,editable: true,editoptions:{size:"20",maxlength:"30"}}
						{name:'ExpertBirth',index:'ExpertBirth', width:40, sortable:false,editable: true, sorttype:"date",unformat: pickDate},
						{name:'ExpertAddress',index:'ExpertAddress', width:60, sortable:false,editable: true,edittype:"textarea", editoptions:{size:"20",maxlength:"50"}},
						//{name:'CityBasicInfoID',index:'CityBasicInfoID', width:60, sortable:false,editable: true,editoptions:{size:"20",maxlength:"12"}}
						
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
					    id:"expertID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
					pager : pager_selector,
					altRows: true,
					//toppager: true,
					
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						var table = this;
						setTimeout(function(){
							styleCheckbox(table);
							//$("#grid-table").jqGrid('setSelection','001');
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
			
					//editurl: '../../exp_manageExpert.action?JQID='+ids,//nothing is saved
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
			
				//验证专家编号的唯一性
				function expertNumCheck(value,colname){
					if(value.length!=0){

							reg=/^[A-Z]{2}\d{3}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"专家编号有2位大写字母和3位数字组成!"];
					}else{
						var expertID = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).expertID
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../exp_checkExpertNum.action?expertNum="+value+"&expertID="+expertID,
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
						return [false,"该专家编码已存在!"];
					}
					return [true,""];
					}					
					
					
					
					
				}
				
			
				//navButtons
					jQuery(grid_selector).jqGrid('navGrid',pager_selector,
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
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						//url: '../Userr_manage.action',
					   // mtype: 'POST',
					    afterSubmit: function (xhr, postdata) {
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
				).navButtonAdd(pager_selector,{  
					    caption:"分配专家",  
					   buttonicon:"icon-external-link",   
					   onClickButton: function(){  
					   var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			            
			           
			            $.ajax({
						type : "post",
						async: false,
						url : "../../expsel_distributeExp.action?oper=add&allid="+selectedRowIds,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
			           success : function(data) {
							alert(data.success);
							window.parent.$("#consoleDlg").dialog("close");
							
				                 window.parent.$("#grid-table").jqGrid("setCaption","分配情况").trigger("reloadGrid");
				                 window.parent.$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
							},
						});
			           
			            
					   },  
					   
					 
			                 
					    position:"last"  

					 });
			
			                
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=ExpertBirth]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
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
			
	
					
		
		--></script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0204").addClass("active");
			});
		</script>
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
