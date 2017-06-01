<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
		<style type= "text/css">
		  .table-header{
			text-align:center;
		  }
		  #left{
		  width:22%;
		  height:540px;
     	  margin-top:3px;
		  background-color:#f2f2f2;
		  float:left;
			border:1px solid gray;
		  }
		  #left1{
			 background-color:white;
			  height:605px;
			  
		  }
		  #ul{
			font-size:14px;
			margin-left:15px;
			margin-top:20px;
		  }
		  .list{
			list-style:none;
		  }
		  #right{
		  margin-top:3px;
			width:77.6%;
			float:right;
			border:1px solid gray;
			height: 540px;

		  }
		   #right1{
			background-color:white;
			height: 605px;

		  }
		  .button{
			background-color:transparent; 
			width:55%;
			height:35px;
		  }
		  .button1{
		   background-color:transparent; 
			width:130px;
			height:35px;
		  }
		  .button2{
			border: 2px solid
		  }
		  .span{background-color:#f2f2f2;
		   height:35px;
		   border-bottom:1px solid gray;
		   
		  }
		  img{
			width:20px;
		  }
			.box{
			width:30%; margin-top:10%; margin:auto; padding:28px;
			height:350px; border:1px #111 solid;
			display:none;            /* 默认对话框隐藏 */
			position:absolute;
			z-index:9999;
			background-color:#f2f2f2;
		  }
		  .box.show{display:block;
		  } 
		  .box .x{ font-size:18px; text-align:right; display:block;}
		  .box input{width:80%; font-size:18px; margin-top:18px;}
		  
		.page-content{
			padding:0px 12px 0px;
		  }
		  .col-xs-12{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.col-xs-3{	
				 width:22%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.col-xs-9{	
				 width:78%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:560px;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 30%;
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
							<li>联系人管理</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
					<div class= "row">
						<div class="col-xs-12">
							
					<!-- PAGE CONTENT BEGINS -->
							<!-- 树 -->
							<div  class="col-xs-3"style="height:100%">
							 <div id="bt" class="widget-box"style="height:100%">
								<div class="widget-header header-color-blue2">
									<h4 class="lighter smaller">区划分布</h4>
								</div>
								<div class="widget-body" style="height:100%;">
									
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:90%"></div>
										</div>
									
								</div>
								</div>
							</div>
							<!-- 右半部分 -->
							<div class="col-xs-9">	    
							<table id="grid-table"></table>
									<div id="grid-pager"></div>
									<script type="text/javascript">
										var $path_base = "/";//this will be used in gritter alerts containing images
									</script>
							  </div>
						   </div> 
							<!-- 隐藏的调查员列表 -->
							
						<!-- PAGE CONTENT ENDS -->
					</div>
					</div ><!-- col-xs-13 -->
				</div><!--page-content-->
				
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
		
		<!-- 添加 -->
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		
		<script src="assets/js/bootbox.min.js"></script>
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<!-- 添加 -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		<script type="text/javascript">
			jQuery(function($){
			//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
           		//定义表的名字
           		var ids="";
           		var is="";
				var grid_selector = "#grid-table";
				//定义页数的名字
				var pager_selector = "#grid-pager";
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../Contact_queryAllCompartmentAsTree.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {
						//tree_data=$.parseJSON(data.ss);
						tree_data=data.ss;
						},
				});
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource = new DataSourceTree({data: tree_data});
				$('#tree1').removeData("tree");//移除表中数据
	            $('#tree1').unbind('click');//移除点击事件
	            $('#tree1').unbind('selected');//移除选择事件
             	$('#tree1').ace_tree({
						dataSource: treeDataSource,
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
						    ids = "";
						    is="";
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       output += item.name + ",";
						    }
							ids = ids.substring(0, ids.lastIndexOf(","));
							output = output.substring(0, output.lastIndexOf(","));
							//alert(ids);
	 						jQuery(grid_selector).jqGrid("setGridParam", {
	 						
		                
		                	url :'../../Contact_manageContact.action?oper=search&JQID='+ids,
		                	editurl :'../../Contact_manageContact.action?JQID='+ids
		   
 		                });
 		                jQuery(grid_selector).trigger("reloadGrid");
						
					});	
					$('#tree1').on('opened', function (evt, data) {
					ids="";
							 is = data.additionalParameters['id' ] ;
							// alert(is);
							jQuery(grid_selector).jqGrid("setGridParam", {
								url :'../../Contact_manageContact.action?oper=search&JQID='+is,
		                	editurl :'../../Contact_manageContact.action?JQID='+is
		                	
							});
							jQuery(grid_selector).trigger("reloadGrid");
							//$("#grid-table").trigger("reloadGrid");
						});	
				jQuery(grid_selector).jqGrid({
					//direction: "rtl",
					
					//data: grid_data,
					//datatype: "local",
					//url:'',
					mtype:"post",
					datatype: "json",
					height: 460,
					colNames:[ 'contactID','townBasicInfoID','编号','姓名','办公电话','移动电话','单位','职务', '备注'],
					colModel:[
					    {name:'contactID',index:'contactID', width:20, sorttype:"int", editable: true,hidden:true,key:true},
					     {name:'BasicInfoID',index:'BasicInfoID', width:20, sorttype:"int", editable: true,hidden:true},
					     {name:'contactNum',index:'contactNum', width:50, sorttype:"int", editable: true,editoptions:{size:"20",maxlength:"15"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:ContNumCheck}},
						{name:'contactName',index:'contactName', width:30,editable: true,editoptions:{size:"20",maxlength:"15"}},
						{name:'contactWorkTel',index:'contactWorkTel', width:45,editable: true,editoptions:{size:"20",maxlength:"12"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:WorkTelCheck}},
						{name:'contactMobTel',index:'contactMobTel', width:45,editable: true,editoptions:{size:"20",maxlength:"11"},formoptions:{elmsuffix:"<font color='red'>*</font>"},editrules:{required:true,custom:true,custom_func:MobTelCheck}},
						{name:'contactComp',index:'contactComp', width:90,editable: true,editoptions:{size:"20",maxlength:"50"}},
						{name:'contactPost',index:'contactPost', width:50,editable: true,editoptions:{size:"20",maxlength:"20"}},
						{name:'contactNote',index:'contactNote', width:60, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"15",maxlength:"100"}} 
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
					    id:"contactID", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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
					pager : pager_selector,
					altRows: true,
					toppager: true,
					
					
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
			
					editurl: $path_base+"/dummy.html",//nothing is saved
					//caption: "",
			
			
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
				
			
					//验证固定电话号码
				function WorkTelCheck(value,colname){
				
				
                   // var ss = s.replace(reg, ""); 
					
					if(value.length!=0){

							reg=/^[0]{1}[6]{1}[3]{1}[4]{1}[-][0-9]{7}$/;
						
					}
						
					if(!reg.test(value)){
						return [false,"固定电话必须由'0634-'组成,并且一共11位!"];
					}else{
					return [true,""];
				}
			
			
			}
				
					//验证移动电话号码
				function MobTelCheck(value,colname){
				
					
					if(value.length!=0){

							reg=/(\d){11}/;
						
					}
						
					if(!reg.test(value)){
						return [false,"移动电话必须由11位组成!"];
					}else{
					return [true,""];
				}
			
			}
			
			//验证联系人编号
				function ContNumCheck(value,colname){
				     var zeroNum=0;
				     
				   ids= ids.replace('.','');
				    ids= ids.replace('.','');
				    ids= ids.replace('.','');
				   is= is.replace('.',''); 
				   is= is.replace('.',''); 
				   is= is.replace('.',''); 
				  // alert(is);
				 
				   if(ids.length>0&&value.length!=0){
				
                        is="";
                       // ids="";
						reg=/^[0-9]{11}[.]{1}[0-9]{3}$/;
						
							
						//if(!reg.test(value)){
						var index = value.indexOf(ids);
						
						if(index||(!reg.test(value))){
						return [false,"联系人编码格式为'所属区划.联系人编号(3位)(37120101001.000)'!"];
					}else{
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).contactID
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../Contact_checkVilContNum.action?contactNum="+value+"&contactID="+id,
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
					}
					return [true,""];
					}		
						
					}
					
					if(is.length>0&&value.length!=0){
					for(var i=is.length;i>0;i--){
			         if(is.charAt(i-1)!='0') break;
			           zeroNum++;
		             }
		             //alert(zeroNum);
                      if(zeroNum>=3&&zeroNum<5&&value.length!=0){
                               ids="";
                               //is="";
							reg=/^[0-9]{8}[0]{3}[.]{1}[0-9]{3}$/;
							
							//if(!reg.test(value)){
							var index1 = value.indexOf(is);
						
						if(index1||(!reg.test(value))){
						return [false,"联系人编码格式为'所属区划.联系人编号(3位)(37120101000.000)'!"];
					}else{
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).contactID
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
					url : "../../Contact_checkTownContNum.action?contactNum="+value+"&contactID="+id,
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
					}
					return [true,""];
					}		
						
					}
	
					if(zeroNum>=5&&zeroNum<7&&value.length!=0){
                            ids="";
                            //is="";
							reg=/^[0-9]{6}[0]{5}[.]{1}[0-9]{3}$/;
							
							//if(!reg.test(value)){
							var index = value.indexOf(is);
						
						if(index||(!reg.test(value))){
						return [false,"联系人编码格式为'所属区划.联系人编号(3位)(37120100000.000)'!"];
					}else{
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).contactID
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../Contact_checkCountryContNum.action?contactNum="+value+"&contactID="+id,
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
					}
					return [true,""];
					}		
						
					}
					if(zeroNum>=7&&zeroNum<10&&value.length!=0){
                             ids="";
                            // is="";
							reg=/^[0-9]{4}[0]{7}[.]{1}[0-9]{3}$/;
							
							//alert(1111111);
					//if(!reg.test(value)){
					var index = value.indexOf(is);
						
						if(index||(!reg.test(value))){
						return [false,"联系人编码格式为'所属区划.联系人编号(3位)(37120000000.000)'!"];
					}else{
					var id = $(grid_selector).jqGrid("getRowData",$(grid_selector).jqGrid('getGridParam','selrow')).contactID
						
					var flag;
					$.ajax({
						type : "get",
						async: false,
						url : "../../Contact_checkCityContNum.action?contactNum="+value+"&contactID="+id,
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
					}
					return [true,""];
					}		
						
					}
					

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
						//url: '../../CountryCont_manageCountryCont.action', 
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
						},
						//url: '../../CountryCont_manageCountryCont.action',
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
						//url: '../../CountryCont_manageCountryCont.action',
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
				$("#03").addClass("active");
			});
		</script>
		<!-- 添加end -->
		<!-- inline scripts related to this page -->
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>

