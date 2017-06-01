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
								  <!--
								
								 -->
								 <% 
								 java.net.URLDecoder urlDecoder=new java.net.URLDecoder();
								 String InvesObjName = request.getParameter("InvesObjName").toString();
										InvesObjName = new String(InvesObjName.getBytes("ISO-8859-1"), "utf-8");
										String InvesObjNote = request.getParameter("InvesObjNote").toString();
										InvesObjNote = new String(InvesObjNote.getBytes("ISO-8859-1"), "utf-8");
									%>
								 <input type="hidden" id="DataCollDataDicId" value="<%=request.getParameter("DataCollDataDicId") %> ">
								 <input type="hidden" id="sss" value="<%=request.getParameter("sss") %> ">
								 <input type="hidden" id="InvesObjCode" value="<%=request.getParameter("InvesObjCode") %> ">
								    <input type="hidden" id="InvesObjName" value="<%=InvesObjName %> ">
								 <input type="hidden" id="InvesObjId" value="<%=request.getParameter("InvesObjId") %> ">
								 <input type="hidden" id="VilDataCollRecID" value="<%=request.getParameter("VilDataCollRecID") %> ">
								  <input type="hidden" id="InvesObjDataId" value="<%=request.getParameter("InvesObjDataId") %> ">
								  <input type="hidden" id="InvesObjNote" value="<%=InvesObjNote %> ">
								<table id="grid-table2">
								<div class="row">
									<div class="col-md-12 widget-container-span ui-sortable" style="width:100%">
										<div class="widget-header widget-header-small"align="center" style="height:0px;min-height: 20px;">
											多选
										</div>
										<div class="widget-body" style="height: 75px;">
											<div class="widget-main">
												
												<div class="row">
												
													<!--  <div class="col-md-1" style="width: 60">
														<button type="button" class="btn btn-purple btn-sm" id="search">
															查看
															<i class="icon-search icon-on-right bigger-110"></i>
														</button>
													</div> -->
													<div class="col-md-10" >
													编码：  <input style="width:91%"class="FormElement ui-widget-content ui-corner-all" role="textbox"name="id2" id="id2" type="text" value="<%=request.getParameter("InvesObjCode") %>" readonly="readonly">
													调查对象：  <input style="width:87%"class="FormElement ui-widget-content ui-corner-all" role="textbox"name="id3" id="id3" type="text" value="<%=InvesObjName %>" readonly="readonly">
												
													</div>
													
												</div>
												
											</div>
										</div>
									</div>
									
								</div>
								
								</table>
							<div class="row">
									<div class="col-md-12 widget-container-span ui-sortable" style="width:100%">
										
										<div class="widget-body" style="border: 1px solid #CCC">
											<div class="widget-main">
												
												<div class="row">
													
												
													
													<div class="col-md-12">
														<div>
														<div>
													      	备注：  <input style="width:500px"class="FormElement ui-widget-content ui-corner-all" role="textbox"name="id1" id="id1" type="text" value="<%=InvesObjNote %>" >
														</div>
														 <table class="EditTable" id="TblGrid_grid-table_2" border="0" cellpadding="0"
												            cellspacing="0"style="width:580px;background-color:white">
												                <tbody>
												                    <tr>
												                        <td colspan="2">
												                            <hr class="ui-widget-content" style="margin:1px">
												                        </td>
												                    </tr>
														 <tr id="Act_Buttons">
									                        <td class="navButton">
									                            <a  href="javascript:void(0)" id="pData" class="fm-button ui-state-default ui-corner-left">
									                                <i class="icon-chevron-left">
									                                </i>
									                            </a>
									                            <a  href="javascript:void(0)" id="nData" class="fm-button ui-state-default ui-corner-right">
									                                <i class="icon-chevron-right">
									                                </i>
									                            </a>
									                        </td>
														<!--	<span style="width:25%"><button  id="update"  type="button" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
					                          
																<i class="icon-ok"> </i>
																  确定
															
															</button></span>
															<span style="width:25%"><button  id="cancel" type="button"class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm" >
														   
																<i class="icon-remove"></i>
																   取消
															
															</button></span>-->
															 <td class="EditButton"style="height:60px;text-align: right;">
									                            <a href="javascript:void(0)" id="update" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
									                                <i class="icon-ok"> </i>
								                              		  确定
									                            </a>
									                            <a href="javascript:window.parent.$('#consoleDlg').dialog('close')" id="cancel" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm">
									                                <i class="icon-remove"></i>
									                             	   取消
									                            </a>
									                        </td>
														</tr>
																		<tr style="display:none" class="binfo">
										                        <td class="bottominfo" colspan="2">
										                        </td>
										                    </tr>
										                </tbody>
										            </table>
													    </div>
														



													</div>
													
												</div>
												
											</div>
										</div>
									</div>
									
								</div>
							
								<!--  <div id="grid-pager2"></div> -->
								
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
			/*  var grid_data = 
			[ 
				{VilNum:"100000000000",VilName:"A村",VilLongi:"30",VilLati:"30",VilMeas:"100",VilPop:"10000",VilHholds:"3333",VilNatural:"3",VilIntro:"100000"},
				
				
				
			];	*/
			
			
			jQuery(function($) {
				var grid_selector2 = "#grid-table2";
				var pager_selector2 = "#grid-pager2";
				var DataCollDataDicId = $("#DataCollDataDicId").val();
				var InvesObjId = $("#InvesObjId").val();
				var VilDataCollRecID = $("#VilDataCollRecID").val();
				var InvesObjDataId=$("#InvesObjDataId").val();
				
				jQuery(grid_selector2).jqGrid({
					//direction: "rtl",
					 url: "../../DataCollDicEntry_manageDataCollDicEntry.action?oper=search&JQID="+DataCollDataDicId,  // (7)子表格数据对应的url，注意传入的contact.id参数  
	                datatype: "json",  
	                mtype:"post",
	               colNames:['dataCollDicEntryId','条目编码','字典编码','条目名称'],
					colModel:[
					     {name:'dataCollDicEntryId',index:'dataCollDicEntryId', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
					    {name:'dicEntryCode',index:'dicEntryCode', width:100, sorttype:"int", editable: true,editoptions:{size:"20",maxlength:"30"},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						  {name:'dataCollDataDicId',index:'dataCollDataDicId', width:10, sorttype:"int", editable: true,hidden:true},
						{name:'dicEntryName',index:'dicEntryName', width:150,editable: true,editoptions:{size:"20",maxlength:"30"}},
					],
					  
	                rowList:[10,20,30],  
	                rowNum:15,
                viewrecords: true,  
                height: 100,  
	                //rowNum: 5 ,
	                multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        pager: pager_selector2,
			        
	                jsonReader: {   // (8)针对子表格的jsonReader设置  
	                     root:"data",//传递的json数据
						 repeatitems: false,//允许json数据乱序
						 page: "page", // json中代表当前页码的数据
						 total: "total", // json中代表页码总数的数据
						 records: "records", // json中代表数据行总数的数据  
	                },  
	                prmNames: {sort: "sidx", // 表示用于排序的列名的参数名称  
					    order: "sord", // 表示采用的排序方式的参数名称  
					    nd:"nd", // 表示已经发送请求的次数的参数名称  
					    id:"dataCollDicEntryId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					}, 
					editurl: "../../DataCollDicEntry_manageDataCollDicEntry.action",
	              //caption: "多选",
			        autowidth: true,
			        
	                
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
					jQuery(grid_selector2).jqGrid('navGrid',pager_selector2,
					{ 	//navbar options
					   //cloneToTop:true,
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
						closeAfterEdit: true,
						recreateForm: true,
						beforeShowForm : function(e) {
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						url: '../../DataCollDicEntry_manageDataCollDicEntry.action', 
						mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			             $("#editmodgrid-table").jqmHide();
			                var id = $("#grid-table2").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table2").jqGrid('setRowData', id, postdata);
			               
			                $("#grid-table2").trigger("reloadGrid");//操作完成后刷新表单
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
						
						url: '../../DataCollDicEntry_manageDataCollDicEntry.action',
					    mtype: 'post',
					    afterSubmit: function (xhr, postdata) {
						
					      var id = $("#grid-table2").jqGrid('getGridParam', 'selrow');
					      jQuery("#grid-table2").jqGrid('addRowData', postdata.Id, postdata);
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
						url: '../../DataCollDicEntry_manageDataCollDicEntry.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
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
			   
                    $("#grid-table2_toppager_center").hide();
				    $("#grid-table2_toppager_right").hide();
				    $( "#cancel" ).on('click', function(e){
                     window.parent.$("#consoleDlg").dialog("close");
                     
                     })
				$("#update").on('click', function(e) {
				var sss=$("#sss").val();
					var sss=parseInt(sss);
						 var DataCollDataDicId = $("#DataCollDataDicId").val();
					//var id=$(grid_selector).jqGrid("getGridParam","selrow");//获得单行id
					var ids=$(grid_selector2).jqGrid("getGridParam","selarrrow");//获得多行id
					var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
					 var a1=document.getElementById("id1").value;
					 
					 //alert(v);
				//alert(j);
        				/**var rowData = $("#grid-table").jqGrid("getRowData",ids);//根据上面的id获得本行的所有数据
        				
        				var val= rowData.VilDataCollRecID; //获得制定列的值 （auditStatus 为colModel的name）
					 	var val1=rowData.InvesObjId;**/
					//alert(ids);
					
				   $.ajax({
				   //contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI1.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&DataCollDicEntryId="+ids+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								window.parent.$("#consoleDlg").dialog("close");
								// window.parent.$("#grid-table").jqGrid("clearGridData");
				               /*window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?InvesObjId="+InvesObjId+"&oper=search",
				                });*/
				                 window.parent.$("#grid-table").trigger("reloadGrid");
				                 alert(data.success);
				                window.parent.$("#grid-table").jqGrid("setSelection",sss);
							}
						}
					});
				})
				$("#nData").click(function(){
				  var DataCollDataDicId = $("#DataCollDataDicId").val();
					//var id=$(grid_selector).jqGrid("getGridParam","selrow");//获得单行id
					var ids=$(grid_selector2).jqGrid("getGridParam","selarrrow");//获得多行id
					var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
					 var a1=document.getElementById("id1").value;
					
					//alert(v);
				//alert(j);
				   $.ajax({
				   //contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI1.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&DataCollDicEntryId="+ids+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								
				               /*window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?InvesObjId="+InvesObjId+"&oper=search",
				                });*/
				                 window.parent.$("#grid-table").trigger("reloadGrid");
							}
						}
					});
					var sss=$("#sss").val();
					var sss=parseInt(sss);
				window.parent.$("#consoleDlg").dialog("close");
				//var sel_id = window.parent.$('#grid-table').jqGrid('getGridParam', 'selrow');
				//$("#grid-table").jqGrid("setSelection",sss);
				var i = parseInt(sss);
				var sss=i+1;
				var rowDate =window.parent.$("#grid-table").jqGrid('getRowData', sss);
				InvesObjNote=rowDate.InvesObjNote; 
				InvesObjDataId=rowDate.InvesObjDataId;
				InvesObjAttri=rowDate.InvesObjAttri;
				InvesObjCode=rowDate.InvesObjCode;
				InvesObjName=rowDate.InvesObjName;
				InvesObjDataValu=rowDate.InvesObjDataValu;
				IsdChoDic=rowDate.IsdChoDic;
				DataCollDataDicId=rowDate.DataCollDataDicId;
				InvesObjId=rowDate.InvesObjId;
				VilDataCollRecID=rowDate.VilDataCollRecID;
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-7);
				//InvesObjName = InvesObjName.substr(0, InvesObjName.indexOf('/'));
				InvesObjName = InvesObjName.substr(InvesObjName.indexOf('>'), InvesObjName.indexOf('<'));
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-2);
				if(IsdChoDic==''){
				IsdChoDic="null";
				}
				/*alert(IsdChoDic);
				alert(InvesObjName);
				alert(sss);*/
				window.parent.AssignTask(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID);
			});
			$("#pData").click(function(){
				 var DataCollDataDicId = $("#DataCollDataDicId").val();
					//var id=$(grid_selector).jqGrid("getGridParam","selrow");//获得单行id
					var ids=$(grid_selector2).jqGrid("getGridParam","selarrrow");//获得多行id
					var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
					 var a1=document.getElementById("id1").value;
				   $.ajax({
				   //contentType:"application/x-www-form-urlencoded; charset=UTF-8",
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI1.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&DataCollDicEntryId="+ids+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								
				               /*window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?InvesObjId="+InvesObjId+"&oper=search",
				                });*/
				                 window.parent.$("#grid-table").trigger("reloadGrid");
							}
						}
					});
					var sss=$("#sss").val();
					var sss=parseInt(sss);
				window.parent.$("#consoleDlg").dialog("close");
				//var sel_id = window.parent.$('#grid-table').jqGrid('getGridParam', 'selrow');
				//$("#grid-table").jqGrid("setSelection",sss);
				var i = parseInt(sss);
				var sss=i-1;
				var rowDate =window.parent.$("#grid-table").jqGrid('getRowData', sss);
				InvesObjNote=rowDate.InvesObjNote; 
				InvesObjDataId=rowDate.InvesObjDataId;
				InvesObjAttri=rowDate.InvesObjAttri;
				InvesObjCode=rowDate.InvesObjCode;
				InvesObjName=rowDate.InvesObjName;
				InvesObjDataValu=rowDate.InvesObjDataValu;
				IsdChoDic=rowDate.IsdChoDic;
				DataCollDataDicId=rowDate.DataCollDataDicId;
				InvesObjId=rowDate.InvesObjId;
				VilDataCollRecID=rowDate.VilDataCollRecID;
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-7);
				//InvesObjName = InvesObjName.substr(0, InvesObjName.indexOf('/'));
				InvesObjName = InvesObjName.substr(InvesObjName.indexOf('>'), InvesObjName.indexOf('<'));
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-2);
				if(IsdChoDic==''){
				IsdChoDic="null";
				}
				/*alert(IsdChoDic);
				alert(InvesObjName);
				alert(sss);*/
				window.parent.AssignTask(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID);
			});
	    });
		</script>
		
		
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
