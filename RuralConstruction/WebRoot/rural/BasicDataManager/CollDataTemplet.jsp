<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
		<style type= "text/css">
		
			
			.span{background-color:#f2f2f2;
			   height:25px;
			   height-line:25px;
			   border-bottom:1px solid gray;
			 }
		.page-content{
			padding:0px 0px 0px;
		  }
		  .col-xs-12{
				width:100%;
				 overflow: hidden;
		         border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
	
			}
		  .col-xs-3{	
				 overflow: hidden;
				 border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:605px;
				 width:26%;
			}
			.col-xs-9{	
				overflow: hidden;
				border:1px solid gray;
			 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:605px;
				 width:74%;
			}
		  .space{
			background:#ccc;
			max-height:2px;
			min-height:2px;
			margin-bottom:1px;
			margin-top:2px;
		}
		.box{
        width:100%; margin-top:10%; margin:auto; padding:28px;
        height:300px; border:1px #111 solid;
        display:none;            /* 默认对话框隐藏 */
        position:absolute;
        z-index:9999;
        background-color:#f2f2f2;
      }
      .box.show{display:block;
      } 
      .box .x{ font-size:18px; text-align:right; display:block;}
      .box input{width:80%; font-size:18px; margin-top:18px;}
      .widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 0%;
				display: inline;
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
							<li>采集数据模板</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
					
						<div class="col-xs-12">
					<div class="col-xs-3">
      
					<div id="bt" class="widget-box" style="height:100%">
                             <div  id="h4" class="widget-header header-color-blue2">
                                <h4  class="lighter smaller">调查项目</h4>
                             </div>
							  <div class="span">
										<a class="ui-pg-div" id="id-btn-dialog1"><span class="ui-icon icon-plus-sign purple"></span></a>
										  <a  id="id-btn-dialog2" class="ui-pg-div"><span class="ui-icon icon-trash red"></span></a>
										  
										
								
										<div id="dialog-message" class="hide">
										    上级节点：<select style="max-width:180px" id="s1" onchange="changePro(this)" >
										    
										         <option value="0">无父节点</option> 
													<div id="o1"></div>
										    	</select>
										    </br></br></br>
											项目编号：<input id="proNum"><font color='red'>*</font></br></br></br>
											项目名称：<input id="proName">
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
									<div id="tree1" class="tree" style="height:90%"></div>
								</div>
							</div>
					</div>
				</div>
							<div class="col-xs-9">
							
						            <table id="grid-table"></table>

									<div id="grid-pager"></div>

									
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

                  <!--[if !IE]> -->

                  <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->  <!-- 文档加载过慢 -->


                  <script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
                  <script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
                  <script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
                  
                  <script src="assets/js/bootbox.min.js"></script>
				  	<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
					<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
				
					<script src="assets/js/bootbox.min.js"></script>
                  <!-- <![endif]-->

                  <!--[if IE]>
              <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
              <![endif]-->

                  <!--[if !IE]> -->
                  <script src="assets/js/ace-elements.min.js"></script>
                  <script src="assets/js/ace.min.js"></script>
                  <script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
                    <script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		
		<script type="text/javascript">
		
		
		
		
	
			 jQuery(function($) {
				
			});
			
			//下拉框
			
				
				$.ajax({
					url: "../../invespro_queryAll.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						//aler(json);
						for(var i=0; i<json.length; i++)  
						{  
							$("#s1").append("<option value=\"" + json[i].InvesProNum + "\">" + json[i].InvesProName +"</option>");
						}  
					},
				});
		</script>
		
		
		
			<script type="text/javascript">
		
			jQuery(function($){
           var tree_data;
           
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
				 var grid_selector1 = "#grid-table1";
				var pager_selector1 = "#grid-pager1";
			
				$.ajax({
						url: "../../invespro_queryAllMenusAsTree.action",//tree_singTree.action
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
					
			//获取子节点
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
 									
 						jQuery(grid_selector).jqGrid("setGridParam", {
		                
		                	url :'../../invesObj_manageInvesObj.action?oper=search&ObjFSID = hh&JQID='+ids,
		                	editurl: "../../invesObj_manageInvesObj.action?ObjFSID = hh&JQID="+ids,
		   
 		                });
 		                jQuery(grid_selector).jqGrid("setCaption","调查对象").trigger("reloadGrid");
 		                $("#add_grid-table").show();
						
					});		
					//获取父节点
					$('#tree1').on('opened', function (evt, data) {
							var is = data.additionalParameters['id' ] ;
						//	alert(is);
							jQuery(grid_selector).jqGrid("setGridParam", {
								url :'../../invesObj_manageInvesObj.action?oper=search&JQID = hh&ObjFSID='+is,
								editurl :'../../invesObj_manageInvesObj.action?&JQID = hh&ObjFSID='+is,
							});
							jQuery(grid_selector).jqGrid("setCaption","调查对象").trigger("reloadGrid");
							$("#add_grid-table").hide();
					});
	
		
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
						title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> 添加调查项目</h4></div>",
						title_html: true,
						buttons: [ 
							
							{
								text: "确定",
								"class" : "btn btn-primary btn-xs",
								
								click: function() {
								        
								        var no = $("#proNum").val().trim();
								        
								       if(no.length==0){
								        $("#proNum").focus();
								        alert('调查项目编号不能为空');
								        
								       }else{		
								      		 reg=/^[0-9]{2}[.][0-9]{2}[.][0-9]{2}[.][0-9]{2}$/;
											if(!reg.test(no)){
											alert("请按照00.00.00.00的格式填写");
											}else{
											
												 var proNum = document.getElementById("proNum").value;	
												var proName = document.getElementById("proName").value;	
												var sv=document.getElementById("s1").value;
													
																	
												$.ajax({
													url: "../../invespro_addMenusAsTree.action",//tree_singTree.action
													async:false,  
													type: 'POST',
													dataType: 'json',
													data:{ 
						 							   "proNum":proNum,
						 							   "proName":proName,
						 							   "sv":sv
						 							   
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
										url: "../../invespro_delMenusAsTree.action",//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										data:{ 
			 							   "proNo":tIds,
			 							   
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
				
		
		
		
		
		
		
		
			
			
			
		//调查对象
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					
					//data: grid_data,
					//datatype: "local",
					//url:'',
					mtype:"post",
					datatype: "json",
					height: 450,
					colNames:[ '对象ID','对象编号','对象名称','项目编号', '数据字典名称','对象单位','对象属性','对象长度','是否基础数据','备注'],
					colModel:[					   
					    {name:'invesObjID',index:'invesObjID', width:40, sortable:false, editable: false, key:true,hidden:true},
					    {name:'invesObjCode',index:'invesObjCode', width:30, sortable:false,editoptions:{size:"20",maxlength:"9"},editable: true ,formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:objCodeCheck}} ,
					    {name:'invesObjName',index:'invesObjName', width:30,editable: true,editoptions:{size:"20",maxlength:"100"},},						
						{name:'invesProNum',index:'invesProNum', width:30,editable: true,hidden:true},						
						{name:'dataCollDataDicId',index:'dataCollDataDicId', search:false,width:30, sortable:false,editable: true,edittype:"select",editoptions:{dataUrl:"../../seldataCollDataDic_findAll.action" } } ,						
						{name:'invesObjComp',index:'invesObjComp', width:30, sortable:false,editable: true,hidden:true } ,
						{name:'invesObjAttriId',index:'invesObjAttriId', width:30, sortable:false,editable: true,edittype:"select",editoptions:{dataUrl:"../../selinvesObjAttri_findAll.action" }} ,
						{name:'invesObjLengt',index:'invesObjLengt', width:30, sortable:false,editoptions:{size:"20",maxlength:"3"},editable: true } ,
						{name:'mus',index:'mus', width:30, sortable:false,editable: true  ,edittype:"select",editoptions: { value:"true:是;false:否"},unformat: aceSwitch
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
						{name:'invesObjNote',index:'invesObjNote', width:30, sortable:false,editable: true } ,
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
					    id:"invesObjID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
				//	    oper:"oper",    // operation参数名称（我暂时还没用到）  
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
					
					
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					loadComplete : function() {
						var table = this;
						
					//	var rowIds = jQuery(grid_selector).jqGrid('getDataIDs'); 
						//alert(rowIds);
					//	$(grid_selector).jqGrid("setSelection",rowIds[0]);
						setTimeout(function(){
							styleCheckbox(table);
							//$(grid_selector).jqGrid("setSelection",371200000000);
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 1000);
					},
			//		editurl: "../../invesObj_manageInvesObj.action",
					caption: "调查对象属性",
			
			
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
				
				
				//验证编号
				function objCodeCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[A-Z]{1}[0-9]{2}[.][0-9]{2}[.][0-9]{2}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"编号必须符合A00.00.00格式"];
					}else{
					
					
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).invesObjID
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../invesObj_objCodeCheck.action?invesObjCode="+value+"&invesObjID="+id,
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
						return [false,"调查对象编号已存在!"];
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
						search: false,
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
						
						
						
				//		url: '../../invesObj_manageInvesObj.action', 
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
						$(grid_selector).clearGridData(); 
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
							$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
						},
					//	url: '../../invesObj_manageInvesObj.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						  var rd = JSON.parse(xhr.responseText);
						//  bootbox.alert(rd.success);
						  
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
						url: '../../invesObj_manageInvesObj.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
			                 $("#delmodgrid-table").jqmHide();//关闭删除弹出框
							///if(xhr.responseText.success){
							var returndata = JSON.parse(xhr.responseText);
								bootbox.alert(returndata.success);
								var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
							                var len = selectedRowIds.length;
							                for (var i = 0; i < len ; i++) {
							                    $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
							                }
							                //$(grid_selector).dialog("close");
							                $("#grid-table").trigger("reloadGrid");
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
				)
			
			
				
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
			
			
			
			
			
			});
			
					
		
		</script>
				<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0208").addClass("active");
			});
		</script>
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
