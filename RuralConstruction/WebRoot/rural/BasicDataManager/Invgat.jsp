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
				 height:631px;
			}
			.col-xs-10{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#FFF;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 1px;
				 height:631px;
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
							<li>调查员</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
					
						<div class="col-xs-12">
							
								<!-- PAGE CONTENT BEGINS -->
							<div class="col-xs-10"> 
								
							<table id="grid-table"></table>

								<div id="grid-pager"></div>

								<script type="text/javascript">
									var $path_base = "/";//this will be used in gritter alerts containing images
								</script>
							</div>
								<!-- PAGE CONTENT ENDS -->
				
				</div><!-- /.main-content -->
					</div>
				</div>
			</div><!-- /.main-container-inner -->

			<!-- <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> -->
				<!-- <i class="icon-double-angle-up icon-only bigger-110"></i> -->
			<!-- </a> -->
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

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			/*var grid_data = 
			[ 
				{id:"001",investigatorNumber:"10001",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"002",investigatorNumber:"10002",name:"李四",phoneNumber:"11234283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"003",investigatorNumber:"10003",name:"王五",phoneNumber:"13677883660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"004",investigatorNumber:"10004",name:"小红",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"005",investigatorNumber:"10005",name:"小绿",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"006",investigatorNumber:"10006",name:"小青",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"007",investigatorNumber:"10007",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"008",investigatorNumber:"10008",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"009",investigatorNumber:"10009",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"010",investigatorNumber:"10010",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"011",investigatorNumber:"10011",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"012",investigatorNumber:"10012",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"013",investigatorNumber:"10013",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"014",investigatorNumber:"10014",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"015",investigatorNumber:"10015",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"016",investigatorNumber:"10016",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"017",investigatorNumber:"10017",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				{id:"018",investigatorNumber:"10018",name:"张三",phoneNumber:"13864283660",danwei:"农工办",xueli:"本科",year:"24",sex:"男",zhuanye:"采集",note:"暂无"},
				
			];	*/
			
			jQuery(function($) {
				var grid_selector = "#grid-table";
				var pager_selector = "#grid-pager";
			
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					url:'../../Invgat_manageInvgat.action?oper=search',
					
					//data: grid_data,
					datatype: "json",
					mtype:"post",
					height: 480,
					
					colNames:[ 'id','调查员编号','姓名','性别','出生日期','政治面貌','民族','所学专业','单位','学历','手机号码'],
					colModel:[
						{name:'id',index:'id', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
						
						{name:'InvgatNum',index:'InvgatNum', width:30, sorttype:"int", editable: true,editrules:{required:true,custom:true,custom_func:invgatNumCheck},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						{name:'InvgatName',index:'InvgatName', width:25,editable: true,editoptions:{size:"20",maxlength:"10"},editrules:{required:true},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						//{name:'SexCode',index:'SexCode', width:20,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'SexID',index:'SexID',width:25,align:'center',sortable : false,editable: true,search:false,edittype:"select",editoptions:{dataUrl:"../../selsex_findAll.action" }},
						{name:'InvgatBirth',index:'InvgatBirth',width:35, editable: true, sorttype:"date",unformat: pickDate},//
						//{name:'PolCode',index:'PolCode', width:40,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'PolID',index:'PolID', width:40,align:'center',sortable : false,editable: true,search:false,edittype:"select",editoptions:{dataUrl:"../../selpol_findAll.action" }},
						
						//{name:'NationCode',index:'NationCode', width:30,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'NationID',index:'NationID', width:30,align:'center',sortable : false,editable: true,search:false,edittype:"select",editoptions:{dataUrl:"../../selnation_findAll.action" }},
						
						//{name:'MajorCatgNum',index:'MajorCatgNum', width:30,editable: true,editoptions:{size:"20",maxlength:"30"}},
						{name:'InvgatMajor',index:'InvgatMajor', width:30,align:'center',editable: true,editoptions:{size:"20",maxlength:"20"}},
						
						{name:'InvgatComp',index:'InvgatComp', width:45,editable: true,editoptions:{size:"20",maxlength:"30"}},
						//{name:'EduCode',index:'EduCode', width:40, sorttype:"int", editable: true},
						{name:'EduID',index:'EduID',width:40,align:'center',sortable : false,editable: true,search:false,edittype:"select",editoptions:{dataUrl:"../../seledu_findAll.action" }},
						
						{name:'InvgatTel',index:'InvgatTel', width:35,editable: true,editoptions:{size:"20",maxlength:"11"},editrules:{custom:true,custom_func:TelCheck}},
						//{name:'InvgatNote',index:'InvgatNote', width:40, sortable:false,editable: true,edittype:"textarea", editoptions:{size:"20",maxlength:"200"}}
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
					    id:"id", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
			
					editurl: "../../Invgat_manageInvgat.action",//nothing is saved
					//caption: "专家基本信息",
			
			
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
			
			
			
				
					//验证电话号码
				function TelCheck(value,colname){
				var values = value.trim().length;
				var vals = value.trim();
					if(values!=0){

							reg=/(\d){11}/;
							if(reg.test(vals)){
							return [true,""];
							}else{
							return [false,"手机号码必须由11位数字组成!"];
							}
						
					}else{
						return [true,""];
					}
						
					
					
					
				}
			
				//验证调查员编号的唯一性
				function invgatNumCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/^[S]\d{3}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"调查员编号由首位大写字母S和3位数字组成!"];
					}else{
					
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).id
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../Invgat_checkInvgatNum.action?invgatNum="+value+"&id="+id,
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
						return [false,"该调查员编码已存在!"];
					}
					return [true,""];
				}
			
			
			
			
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
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						url: '../../Invgat_manageInvgat.action', 
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
							$(grid_selector).clearGridData(); 
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
							$("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
						
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
						
						url: '../../Invgat_manageInvgat.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
			                /*var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
			                $("#delmodgrid-table").jqmHide();//关闭删除弹出框*/
			                
			                $("#delmodgrid-table").jqmHide();//关闭删除弹出框
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
				)
			
			
				
				function style_edit_form(form) {
					//enable datepicker on "sdate" field and switches for "stock" field
					form.find('input[name=InvgatBirth]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
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
				$("#0205").addClass("active");
			});
		</script>
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
