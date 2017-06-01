<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="base/common.html"%>
		<style>
			.page-content{
				padding: 0px 12px 24px ;
			}
			
			.col-xs-12{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
	     	<!--height:570px;-->
			}
			.col-xs-10{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#FFF;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 1px;
			<!--height:630px;-->
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
							<li>村庄区划</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content"> 
						<div class="row"> 
							<div class="col-xs-12"> 
								<!-- PAGE CONTENT BEGINS -->
										<div class="col-xs-10"> 
												<table id="grid-table"></table>
				
												<div id="grid-pager"></div>
				
												<script type="text/javascript">
													var $path_base = "/";//this will be used in gritter alerts containing images
												</script>
												 <div id="consoleDlg1"></div>
										</div>
								
								
								<!-- PAGE CONTENT ENDS -->
							</div>
						</div>
						
				 </div><!-- /.page-content --> 
				</div><!-- /.main-content -->

				

			</div><!-- /.main-container-inner -->

			<!-- <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a> -->
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
		

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree.min.js"></script>
		<script src="assets/js/dropzone.min.js"></script>
		
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>




	

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			/*var grid_data = 
			[ 
				{VilNum:"100000000000",VilName:"A村",VilLongi:"30",VilLati:"30",VilMeas:"100",VilPop:"10000",VilHholds:"3333",VilNatural:"3",VilIntro:"100000"},
				
				
				
			];	*/
			
			
				jQuery(function($) {
				
				$("#consoleDlg1").dialog({
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
				var rowdatas1="";
				var rowdatas="";
				jQuery(grid_selector).jqGrid({
					url:'../../VilBasicInfo_manageVilBasicInfo.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 445,
					colNames:[ 'VilBasicInfoId','村庄编号','村庄名称','所属镇','面积','人口数', '户数','自然村数','经度','纬度','村庄简介'],
					colModel:[			   
					    {name:'VilBasicInfoId',index:'VilBasicInfoID', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
					    {name:'VilNum',index:'VilNum', width:60, sorttype:"int", editable: true,hidden:false,key:true,editoptions:{size:"20",maxlength:"14"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:vilNumCheck}},
					  {name:'VilName',index:'VilName', editoptions:{size:"20",maxlength:"10"},width:60,editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:vilNameCheck}},						
					   {name:'TownBasicInfoId',index:'TownBasicInfoId', search:false,width:60, sorttype:"int", editable: true,hidden:false,edittype:"select",editoptions:{dataUrl:"../../seltownBasicInfo_findAll.action" },formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'VilMeas',index:'VilMeas',editoptions:{size:"20",maxlength:"20"}, width:35, editable: true,},
						{name:'VilPop',index:'VilPop',editoptions:{size:"20",maxlength:"20"}, width:35,editable: true,},
						{name:'VilHholds',index:'VilHholds',editoptions:{size:"20",maxlength:"20"}, width:35,editable: true},
						{name:'VilNatural',index:'VilNatural',editoptions:{size:"20",maxlength:"20"}, width:35, sortable:false,editable: true} ,
						{name:'VilLongi',index:'VilLongi', editoptions:{size:"20",maxlength:"20"},width:35, editable: true,},
						{name:'VilLati',index:'VilLati', editoptions:{size:"20",maxlength:"20"},width:35, editable: true,},
						{name:'VilIntro',index:'VilIntro', width:60, sortable:false,editable: true,edittype:"textarea",editrules:{edithidden:true},editoptions:{rows:"10",cols:"20"},hidden:true} 
					], 
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
					    id:"VilBasicInfoId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						 rowdatas1 = $("#grid-table").jqGrid('getRowData');	
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
					editurl: "../../VilBasicInfo_manageVilBasicInfo.action",//nothing is saved
					caption: "村庄信息",
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
								
				
				//验证村庄编号
				function vilNumCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[0-9]{4}[.][0-9]{2}[.][0-9]{2}[.][0-9]{3}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"请按照0000.00.00.000的格式进行编码!"];
					}else{
					
					
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).VilBasicInfoId
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../VilBasicInfo_checkVilNum.action?vilNum="+value+"&vilBasicInfoId="+id,
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
						return [false,"该村庄编号已存在!"];
					}
					return [true,""];
					}					
				}
			
			
			//验证村庄编号
				function vilNameCheck(value,colname){
				
					
					
                     return [true,""];
                
				
				}
			
			
			
			
			
				
				//navButtons
				jQuery(grid_selector).jqGrid('navGrid',grid_selector,
					{ 	//navbar options
						cloneToTop: true,
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
					
			            
			            recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						url: '../../VilBasicInfo_manageVilBasicInfo.action',  
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
							 $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			               // alert(JSON.stringify(postdata));
			               
			               // alert(postdata[0]);
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
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
						$(grid_selector).clearGridData(); 
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
						},
						url: '../../VilBasicInfo_manageVilBasicInfo.action',
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
							//}
			            },
			            afterComplete:function(xhr){
			            	
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
						}
						,
						closeAfterSearch:true,//搜索后关闭搜索对话框
						multipleSearch: true,
					
			            closeOnEscape: true,
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
						var consoleDlg1 = $("#consoleDlg1");
				consoleDlg1.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				
				var a1 = "<iframe src='upLoadVil.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				
				
				consoleDlg1.append(a1);
				
				consoleDlg1.dialog("option", "title", "导入文件").dialog("open");
				
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
					
					if(rowdatas1.length>0){
					for(var i=0;i<rowdatas.length;i++)
					{
					  if(i!=rowdatas1.length-1){
					 ids += rowdatas1[i].dataCollDataDicId+",";
					 }else{
					 ids +=rowdatas1[i].dataCollDataDicId;
					 }
			       }
	             }
				
				    window.location.href = "../../vilInformationToExcelNow.action?rowids="+ids+"&rowNum="+rowNum;
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
				$("#0203").addClass("active");
			});
		</script>
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

