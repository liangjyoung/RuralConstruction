<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
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
				 width:20%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:570px;
			}
			.col-xs-9{	
				 width:80%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:570px;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 0%;
				display: inline;
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
					<li>用户管理</li>
					<li>用户</li>
				</ul><!-- .breadcrumb -->
			</div>
			<div class="page-content">
              <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
				<div class="col-xs-3">
               
                          <div class="widget-box" style="height:100%" style="width:100%">
                             <div class="widget-header header-color-blue2" style="text-align:center">
                                <h4 class="lighter smaller">角&nbsp;&nbsp;色</h4>
                             </div>
                            <div class="widget-body" style="height:100%">
                         		 <div class="widget-main padding-8"style="height:100%" >
                         				<div id="tree1" class="tree" style="height:100%"></div>
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
						  
                              
                              </div><!-- PAGE CONTENT ENDS -->
						</div><!-- /.main-content -->
						   </div><!-- /.col -->
							
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
							<script type="text/javascript"><!--
				                     
                    
                     
                     
                     jQuery(function($){
			           var tree_data;
			           
							var grid_selector = "#grid-table";
							var pager_selector = "#grid-pager";
						
							$.ajax({
								url: "../../sysuser_SysRole.action",//tree_singTree.action
								async:false,  
								type: 'POST',
								dataType: 'json',
								success : function(data) {
									tree_data=data.ss;
								},
							});
                     
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
					
					var defaultOptions = {
									mtype:"post",
									datatype: "json",
									height: 360,
									colNames: ['用户角色ID','用户编号','用户名称','用户备注','用户所属区划编码'],
									colModel: [
										{name:'SysRoleUserID',index:'SysRoleUserID',sorttype:"int", editable: false, key:true,hidden:true},
										{name:'SysUserID',index:'SysUserID',sorttype:"int", editable: true,hidden:true},
										{name:'UserName',index:'UserName',editable: true,editoptions:{size:"20",maxlength:"20"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:UserNameCheck}},
										{name:'UserNote',index:'UserNote',editoptions:{size:"20",maxlength:"200"},editable:true, sorttype:"date",unformat: pickDate},
										//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
										//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40,sortable : false,search:true,edittype:"select",editoptions:{dataUrl:"../../selsex_selectData.action" }}
										{name:'UserBeloDiviCode',index:'UserBeloDiviCode',align:'left',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:'../../sysuser_selectData.action'}}
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
									    id:"SysRoleUserID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
									
									toppager: true,
									width:200,
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
									//editurl: $path_base+"/dummy.html",//nothing is saved
									autowidth: true
								}
						$('#tree1').on('selected', function(evt, data) {
					
							var output ="";
							var ids = "";
							var items = $('#tree1' ).tree('selectedItems' );  
							for (var i in items) if (items.hasOwnProperty(i)) {  
								var item = items[i];  
							   ids += item.additionalParameters['id' ] + ",";	
							    output += item.name + ",";						   
							}
							
							
							ids = ids.substring(0, ids.lastIndexOf(","));	
							 output = output.substring(0, output.lastIndexOf(","));	
							
							var buttonGroup = { 	//navbar options
								  	cloneToTop:true,
									edit: true, 
									editicon : 'icon-pencil blue',
									add: true,
									addicon : 'icon-plus-sign purple',
									del: true,
									delicon : 'icon-trash red',
									search: false,
									searchicon : 'icon-search orange',
									refresh: true,
									refreshicon : 'icon-refresh green',
									view: false,
									viewicon : 'icon-zoom-in grey',
								};
							
								var colN=[];
								var colM=[];
								if(ids==1){
								colN=['用户角色ID','用户编号','用户名称','用户备注'];
								colM= [
								{name:'SysRoleUserID',index:'SysRoleUserID',sorttype:"int", editable: false, key:true,hidden:true},
								{name:'SysUserID',index:'SysUserID',sorttype:"int", editable: true,hidden:true},
								{name:'UserName',index:'UserName',editable: true,editoptions:{size:"20",maxlength:"20"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:UserNameCheck}},
								{name:'UserNote',index:'UserNote',editable:true,editoptions:{size:"20",maxlength:"200"},},
								//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
								//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40,sortable : false,search:true,edittype:"select",editoptions:{dataUrl:"../../selsex_selectData.action" }}
								//{name:'UserBeloDiviCode',index:'UserBeloDiviCode',width:15,hidden:true,align:'right',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:"../../sysuser_selectData.action" }}
								];
								}else if(ids==6||ids==7){
									colN=['用户角色ID','用户编号','用户名称','用户备注'];
									colM= [
									{name:'SysRoleUserID',index:'SysRoleUserID',sorttype:"int", editable: false, key:true,hidden:true},
									{name:'SysUserID',index:'SysUserID',sorttype:"int", editable: true,hidden:true},
									{name:'UserName',index:'UserName',editable: true,editoptions:{size:"20",maxlength:"20"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:UserNameCheck}},
									{name:'UserNote',index:'UserNote',editable:true,editoptions:{size:"20",maxlength:"200"},},
									//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
									//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40,sortable : false,search:true,edittype:"select",editoptions:{dataUrl:"../../selsex_selectData.action" }}
									//{name:'UserBeloDiviCode',index:'UserBeloDiviCode',width:15,hidden:true,align:'right',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:"../../sysuser_selectData.action" }}
									];
									buttonGroup = { 	//navbar options
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
									};
									}else{
									colN = ['用户角色ID','用户编号','用户名称','用户备注','用户所属区划编码'];
									colM= [
									{name:'SysRoleUserID',index:'SysRoleUserID',sorttype:"int", editable: false, key:true,hidden:true},
									{name:'SysUserID',index:'SysUserID',sorttype:"int", editable: true,hidden:true},
									{name:'UserName',index:'UserName',editable: true,editoptions:{size:"20",maxlength:"20"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:UserNameCheck}},
									{name:'UserNote',index:'UserNote',editable:true,editoptions:{size:"20",maxlength:"200"},},
									//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"10"}},
									//{name:'UserBeloDiviCode',index:'UserBeloDiviCode', width:40,sortable : false,search:true,edittype:"select",editoptions:{dataUrl:"../../selsex_selectData.action" }}
									{name:'UserBeloDiviCode',index:'UserBeloDiviCode',align:'left',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:'../../sysuser_selectData.action?JQID='+ids }}
									];
									}					
									defaultOptions = {
									mtype:"post",
									datatype: "json",
									height: 360,
									colNames: colN,
									colModel: colM,
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
									id:"SysRoleUserID", // 表示当在编辑数据模块中发送数据时，使用的id的名称
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
									toppager: true,
									width:200,
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
									//editurl: $path_base+"/dummy.html",//nothing is saved
									autowidth: true
									};
									jQuery(grid_selector).GridUnload();
									jQuery(grid_selector).jqGrid(defaultOptions);
									
									$("#grid-table_toppager_center").hide();
				    				$("#grid-table_toppager_right").hide();
									
							//navButtons
						jQuery(grid_selector).jqGrid('navGrid',grid_selector,
							buttonGroup,
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
					            	var rw = JSON.parse(xhr.responseText);
								 	alert(rw.success);
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
								var rf = JSON.parse(xhr.responseText);
								 bootbox.alert(rf.success);
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
							    title:"重置密码",
							   buttonicon:"icon-exchange",   
							   onClickButton: function(){  
							   	//aa(); 
							  
							   	var ids1 = $(grid_selector).jqGrid('getGridParam','selrow');
							   	
							   
									var ids = "";
									var items = $('#tree1' ).tree('selectedItems' );  
									for (var i in items) if (items.hasOwnProperty(i)) {  
										var item = items[i];  
									   ids += item.additionalParameters['id' ] + ",";	
									    output += item.name + ",";						   
									}
									
									ids = ids.substring(0, ids.lastIndexOf(","));	
							   	
							   $.ajax({
							   
									type : "post",
									async: false,
									url : "../../sysuser_resetPassword.action?SysRoleUserID="+ids1+"&JQID="+ids,        
									dataType : "json",
									success : function(data) {
										
										alert(data.success);
										
									}
								}) 
								
							   },   
							    position:"last"  
		
							 });
																
						  							 
							 setTimeout(function () {
								jQuery(grid_selector).jqGrid("setGridParam", {
 		                		url :'../../sysuser_manageSysUser.action?oper=search&JQID='+ids,
			                	editurl:'../../sysuser_manageSysUser.action?JQID='+ids,
							});					
										
							 jQuery(grid_selector).jqGrid("setCaption",output).trigger("reloadGrid");
							},20);
							 
							 
	 		         
 		               		
						
					});		
					
					
					function UserNameCheck(value,colname){
					var SysUserID = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).SysUserID
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../sysuser_checkUserName.action?UserName="+value+"&SysUserID="+SysUserID,
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
						return [false,"该用户名称已存在!"];
					}
					return [true,""];				
					
					
					
				}
				//jQuery(grid_selector).jqGrid(defaultOptions);
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
                    
				   // grid-table_toppager_center
			});
      --></script>
	  
	  <script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#01").addClass("active open");
				$("#0102").addClass("active");
			});
		</script>
        </div>
    <!-- inline scripts related to this page -->
        <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155570&web_id=155570' language='JavaScript' charset='gb2312'></script></div>
    <!-- inline scripts related to this page -->
        <div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>