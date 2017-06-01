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
		<style type= "text/css">
		
	
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
		</style>
	</head> 

	<body>
		<div class="main-container" id="main-container">
			<div class="main-container-inner">
                <div class="main-content">
					<div class="page-content"> 
						<div class="row"> 
							<div class="col-xs-12"> 
								<!-- PAGE CONTENT BEGINS -->
								  <!--
								
								 -->
								 <% 
									java.net.URLDecoder urlDecoder=new java.net.URLDecoder(); 
									String dd1 = request.getParameter("dd1").toString();
										dd1 = new String(dd1.getBytes("ISO-8859-1"), "utf-8");
										
									%>
									 <input type="hidden" id="dd1" value="<%=dd1 %> ">
								  <input type="hidden" id="VilDataCollRecID" value="<%=request.getParameter("VilDataCollRecID") %> ">
								 <input type="hidden" id="DataCollDataDicId" value="<%=request.getParameter("DataCollDataDicId") %> ">
								 <input type="hidden" id="InvesObjId" value="<%=request.getParameter("InvesObjId") %> ">
								 <input type="hidden" id="VilDataCollRecID" value="<%=request.getParameter("VilDataCollRecID") %> ">
								<table id="grid-table0"></table>
									<span class="fileupload-process">
							          <div id="total-progress" class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0">
							            <div class="progress-bar progress-bar-success" style="width:0%;" data-dz-uploadprogress></div>
							          </div>
							        </span>
								<div id="grid-pager0"></div>

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
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
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
			/*  var grid_data = 
			[ 
				{VilNum:"100000000000",VilName:"A村",VilLongi:"30",VilLati:"30",VilMeas:"100",VilPop:"10000",VilHholds:"3333",VilNatural:"3",VilIntro:"100000"},
				
				
				
			];	*/
			
			
			jQuery(function($) {
				var si_selector0 = "#grid-table0";
				var pager_selector0 = "#grid-pager0";
				var DataCollDataDicId = $("#DataCollDataDicId").val();
				var InvesObjId = $("#InvesObjId").val();
				var VilDataCollRecID = $("#VilDataCollRecID").val();
				var dd1=$("#dd1").val();
				jQuery(si_selector0).jqGrid({
					
					url: "../../jilu_manage.action?oper=search",
					mtype:"post",
					datatype: "json",
					height: 200,
					colNames:['','村庄','调查员','上传者（App）','采集时间','备注'],
					colModel:[
					{name:'VilDataCollRecId',index:'VilDataCollRecId', width:100,  hidden:true,editable: true, key:true},
					{name:'VilBasicInfoID',index:'VilBasicInfoID', width:100,align:'center',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:"../../selvil_findAll.action" }},
					{name:'InvgatID',index:'InvgatID', width:100,align:'center',sortable : false,editable: true,search:true,edittype:"select",editoptions:{dataUrl:"../../selinv_findAll.action" }},
					{name:'CollEqptCode',index:'CollEqptCode', width:100,editable: false},
						{name:'CollTim',index:'CollTim',width:90, editable:true, sorttype:"date",unformat: pickDate,formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						
						{name:'CilDataCollRecNote',index:'CilDataCollRecNote', width:100,editable: true}
						
						
					], 
				
			   
					viewrecords : true,
					rowNum:50,
					rowList:[50,100,150],
					pager : pager_selector0,
					altRows: true,
					toppager: true,
					rownumbers: true,
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
					    id:"VilDataCollRecId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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

					loadComplete : function() {
						var table = this;
						
						/*var rowIds1 = jQuery("#grid-table0").jqGrid('getDataIDs'); 
						$("#grid-table0").jqGrid("setSelection",rowIds1[rowIds1.length-1]);*/
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
						onSelectRow: function (rowid,status) 
					{   
						/*//var rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
						//var rowid = $("#grid-table0").jqGrid("getGridParam", "selrow");
						var rowid = $("#grid-table0").jqGrid('getGridParam','selrow');//根据点击行获得点击行的id（id为jsonReader: {id: "id" },）
        				var rowData = $("#grid-table0").jqGrid("getRowData",rowid);//根据上面的id获得本行的所有数据
        				var val= rowData.VilDataCollRecId; //获得制定列的值 （auditStatus 为colModel的name）
						//var valii=idd;
						
						//alert(rowid);
						jQuery(si_selector).jqGrid("setGridParam", {
		                  //url :'../../duixiang_manageDUI.action?oper=search&JQID1='+idr,
		                 url:"../../duixiang_manageDUI1.action?oper=search&JQID1="+val,
		                });
		                
		                //iddd=val;
		                jQuery(si_selector).jqGrid("setCaption","调查对象").trigger("reloadGrid");
		                var idws=$("#grid-table0").jqGrid("getGridParam","selarrrow");//获得多行id
					
        				var rowData1 = $("#grid-table0").jqGrid("getRowData",idws);//根据上面的id获得本行的所有数据
        				//alert(rowData1);
        				var val2= rowData1.VilDataCollRecId; //获得制定列的值 （auditStatus 为colModel的name）
					 	//var val21=idd;
					//alert(ids);
					
				   $.ajax({
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI.action?oper=search&VilDataCollRecId="+val2,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								//alert(data.success);
								
								window.parent.$("#consoleDlg").dialog("close");
		
				               window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?JQID1="+val21+"&VilDataCollRecId="+val2,
				                });
				                 $("#grid-table").trigger("reloadGrid");
							}
						}
					});*/
						
					},//点击获取gqgird的当前列的'GRP_ID'的值//点击获取gqgird的当前列的'GRP_ID'的值
			
					editurl: "../../jilu_manage.action",//nothing is saved
					caption:"村庄采集记录", //"<td id='grid-pager3_left' align='left'><table class='ui-pg-table navtable' style='float:left;table-layout:auto;' border='0' cellpadding='0' cellspacing='0'><tbody><tr><td data-original-title='Add new row' id='add_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-plus-sign purple'></span></div></td><td data-original-title='Edit selected row' id='edit_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-pencil blue'></span></div></td><td data-original-title='Delete selected row' id='del_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-trash red'></span></div></td><td data-original-title='Find records' id='search_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-search orange'></span></div></td>",
	
					//hiddengrid : true,
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
				jQuery(si_selector0).jqGrid('navGrid',si_selector0,
					{ 	//navbar options
					cloneToTop: true,
						edit: true,
						editicon : 'icon-pencil blue',
						add:  true,
						addicon : 'icon-plus-sign purple',
						del: true,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh:  false,
						refreshicon : 'icon-refresh green',
						view:  false,
						viewicon : 'icon-zoom-in grey',
					},
					{
						recreateForm: true,
						updateAfterCheck:true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						url: '../../jilu_manage.action',
					    mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			            $("#editmodgrid-table0").jqmHide();
			                var id = $("#grid-table0").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table0").jqGrid('setRowData', id, postdata);
			                 //return [true, 'successfule!', false];
			                $("#grid-table0").trigger("reloadGrid");//操作完成后刷新表单
			            }, 
			            closeAfterEdit: true, 
			           // closeOnEscape: true
					},
					{
						//new record form
						width:350,
						recreateForm: true,
						viewPagerButtons: false,
						beforeShowForm : function(e) {
						$("#grid-table0").jqGrid('resetSelection');
							var form = $(e[0]);
								$("#grid-table0").clearGridData(); 
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
							$("#grid-table0").trigger("reloadGrid");
						},
						url: '../../jilu_manage.action',
					    mtype: 'post',
					     
					    afterSubmit: function (xhr, postdata) {
					    
							//$("#grid-table0").jqmHide();
							  var id = $("#grid-table0").jqGrid('getGridParam', 'selrow');
							 
					      jQuery("#grid-table0").jqGrid('addRowData', postdata.Id, postdata);
					      
					      return [true, 'successfule!', false];
							
					
					    
					    }, 
					  
					    closeAfterAdd: true, 
			            //closeOnEscape: true
			            	
					   
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
						url: '../../jilu_manage.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
							$("#delmodgrid-table0").jqmHide();//关闭删除弹出框
			                var selectedRowIds = $("#grid-table0").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table0").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table0").trigger("reloadGrid");//操作完成后刷新表单
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
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
						multipleSearch: true
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
				).navSeparatorAdd('#grid-table0_toppager',{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd('#grid-table0_toppager',{     
				   caption:"App的数据包的导入",
				   title:"请添加相应村的采集记录",
				   buttonicon:"icon-cloud-upload", 
				   
				    onClickButton: function(){
					 //var InvesObjID = $("#InvesObjName").val();
					var idws=$("#grid-table0").jqGrid("getGridParam","selrow");//获得单行id
					//var idws=$("#grid-table0").jqGrid("getGridParam","selarrrow");//获得多行id
					
        				var rowData1 = $("#grid-table0").jqGrid("getRowData",idws);//根据上面的id获得本行的所有数据
        				//alert(rowData1);
        				var val2= rowData1.VilDataCollRecId; //获得制定列的值 （auditStatus 为colModel的name）
					 	//var val21=idd;
					//alert(ids);
					//alert(dd1);
					c = 0
		            clearInterval(interval);
		            document.querySelector("#total-progress .progress-bar").style.width = 0 + "%";
					var interval =	setInterval("getProgress()","100");
					$.ajax({
									url: "../../duixiang_UploadData.action?FilIdef="+encodeURI(encodeURI(dd1)),
									datatype:"json",
									type:'post',
									async: true,
									success:function(data)	//success callback
									{   
										if (data.success) {
											clearInterval(interval);
											document.querySelector("#total-progress .progress-bar").style.width = 100 + "%";
											window.parent.$("#consoleDlg4").dialog("close");
											alert("导入成功");
											window.parent.$("#grid-table").trigger("reloadGrid",[ {page : 1 }]);
											
										}
									}
					});
				  /* $.ajax({
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI.action?oper=add&VilDataCollRecId="+val2,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								window.parent.$("#consoleDlg1").dialog("close");
		
				               window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?oper=search&VilDataCollRecId="+val2,
				                });
				                 window.parent.$("#grid-table").trigger("reloadGrid",[ {page : 1 }]);
							}
						}
					});*/
					
				   },       
				       
				   position:"last"    
				}); 
			
			
				
				function style_edit_form(form) {
					//日期的时间选择器
					form.find('input[name=CollTim]').datepicker({format:'yyyy-mm-dd' , autoclose:true})
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
			$("#grid-table0_toppager_center").hide();
				$("#grid-table0_toppager_right").hide();
	    });
	    var c = 0;
		function getProgress(){
			c++;
			document.querySelector("#total-progress .progress-bar").style.width = c + "%";
			if(c>=100){
				c=0;
			}
		};
		
		 
		</script>
		
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
