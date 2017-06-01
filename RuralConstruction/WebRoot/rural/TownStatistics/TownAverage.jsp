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
							<li> 镇级平均分计算</li>
							
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
							
							   
									
									
								
								
								
							<div class="row">
									<div class="col-md-12 widget-container-span ui-sortable" style="width:100%">
										<div class="widget-header header-color-blue2 widget-header-small" align='center' style="height:15px">
											<h6 class="lighter" align='center' style="margin-left:0%">镇级平均分</h6>
										</div>
										<div class="widget-body" style="height: 50px;">
											<div class="widget-main">
												
												<div class="row">
												
													<div class="col-md-2">
													
														<div>
									<label for="form-field-select-3">请选择年份：</label>
									<select id="yrs" onchange="yearChange()">
										
									</select>
								</div>
													</div>
													
													<div class="col-md-4" style="padding-top:4px">
													<label id ="totalAver" for="form-field-select-3" ></label>
														
													</div>
													
												
												</div>
												
											</div>
										</div>
									</div>
									
								</div>
								
								
								
								
								
								
								
								
							<div class= "col-xs-3">
								<div class="widget-box" style="height:100%">
									<div class="widget-header header-color-blue2">
										<h4 class="lighter smaller">评价指标</h4>
									</div>
									
									
									
									<div class="widget-body" style="height:100%">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:100%"></div>
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
		$(document).ready(function () {
			    $.ajax({
			        async: false,
			        type: "POST",
			        url: "../../TownScoreOrder_getYears.action",
			        dataType: "json",
			        success: function (dataMap) {
			            for (var i = 0; i < dataMap.years.length; i++) {
			               
			            	if(i!=0)
			                	$("#yrs").append("<option value='"+dataMap.years[i]+"'>" + dataMap.years[i] + "</option>");
			                else  //默认选中
			                	$("#yrs").append("<option value='"+dataMap.years[i]+"' selected='selected'>" + dataMap.years[i] + "</option>");
			            }
			            
			            loadOption($('#yrs option:selected').val());
			        }
			    });
			    
			    
			    
			    
			    
			     
			});
		
		 function yearChange()  
		{  
		    //var year = $(selectObj).val();  
		    //alert(year);
		    loadOption($('#yrs option:selected').val());
		} 
		
		
		
		//ajax 异步加载配置数据项  
		function loadOption(year)  
		{  
			$.ajax({
							url: "../../TownAverage_evalIndStructree.action?TreeJS="+year,//tree_singTree.action
							async:false,  
							type: 'POST',
							dataType: 'json',
							success : function(data) {
								//callback({ data: data.ss });
								tree_data=data.ss;
							}
			
			});
			
			$.ajax({
					url: "../../TownAver_townAver.action?year="+year,
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.averList;
						for(var i =0;i<json.length;i++){
						//alert(json[i].vilEvaAver);
						document.getElementById("totalAver").innerText = "总平均分:"+json[i].vilEvaAver;
						}
						
				           
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
								url :'../../TownAverage_manageEvalAver.action?oper=search&EvaFSID = hh&EvaSID='+ids,
								editurl :'../../TownAverage_manageEvalAver.action?EvaSID='+ids,
							});
							jQuery(grid_selector1).jqGrid("setCaption","评价内容").trigger("reloadGrid");
						});		
						$('#tree1').on('opened', function (evt, data) {
							var is = data.additionalParameters['id' ] ;
							//alert(is);
							
							jQuery(grid_selector1).jqGrid("setGridParam", {
								url :'../../TownAverage_manageEvalAver.action?oper=search&EvaSID = hh&EvaFSID='+is,
								editurl :'../../TownAverage_manageEvalAver.action?EvaFSID='+is,
							});
							
							jQuery(grid_selector1).jqGrid("setCaption","评价内容").trigger("reloadGrid");
							$("#add_grid-table1").hide();
						});
						
					
						
						var grid_selector1 = "#grid-table1";
				var pager_selector1 = "#grid-pager1";
						
						jQuery(grid_selector1).jqGrid({
					//url:'../../evalsys_manageEvalSys.action?oper=search',
					datatype: "json",
					mtype:"post",
					height: 350,
					colNames:[ '','分序号','评价内容','平均分'],
					colModel:[
					    {name:'EvalContId',index:'EvalContId', width:10,  editable: true,key:true,hidden:true},
					    {name:'EvalContSeqNum',index:'EvalContSeqNum', width:23, editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true}},  
						{name:'EvalContDes',index:'EvalContDes', width:177,  editable: true,formoptions:{elmsuffix:"<font color='red'>*</font>"},editoptions:{size:"20",maxlength:"200"}},
						{name:'EvalContScore',index:'EvalContScore', width:20, sortable:false,editable: true,editrules: {required:true,number:true,minValue:0,maxValue:50},formoptions:{elmsuffix:"<font color='red'>*</font>"}} 
						//{name:'IsSubjGra',index:'IsSubjGra', width:30,editable: true,edittype:"select",editoptions: { value:"2:2;1:1;-1:-1;-2:-2;-3:-3;-4:-4;-5:-5;-6:-6;-7:-7;-8:-8;-9:-9"}},
						//{name:'ExamMethID',index:'ExamMethID', width:30,editable: true,edittype:"select",editoptions:{dataUrl:"../../exam_findAll.action" }},
						//{name:'BulReq',index:'BulReq', width:60,editable: true,hidden:true},
						//{name:'EvalContScorMeth',index:'EvalContScorMeth', width:60, hidden:true,sortable:false,editable: true},
                        //{name:'EvalContNote',index:'EvalContNote', width:20, hidden:true,editrules:{edithidden:true},sortable:false,editable: true},
                        //{name:'DistInvesObj',index:'DistInvesObj',formatter: DistInvesObj, width:50,align:'center',search:false,sortable:false}
						  
					], 
			 
				
					viewrecords : true,
					rowNum:50,
					rowList:[50,100,150],
					pager : pager_selector1,
					altRows: true,
					//toppager: true,
					multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			       // beforeSelectRow: beforeSelectRow,
			       
					
			       
			       
			       
			       
			       
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
						}, 0);
					},
					
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
		   
		}
		</script>
		
		
		

		
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#10").addClass("active");
				//$("#0209").addClass("active");
			});
		</script>
		
		
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
			