<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>



		
		<style type="text/css">
		.btn-sm {
		    border-width: 2px;
		    font-size: 14px;
		    padding: 3px 0px;
		    line-height: 1.39;
		}
		.widget-header{
		background-image: linear-gradient(to bottom,#6FB3E0 0,#6FB3E0 100%);
		color: #fff;
		}
		.space{
				background:#ccc;
				max-height:2px;
				min-height:2px;
				margin-bottom:1px;
				margin-top:2px;
		}
			.tab-content
			{padding: 0px 12px;}
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
				 height:600px;
			}
			
			.col-xs-8{	
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:600px;
				 width:85%;
			}
			.col-xs-4{	
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:600px;
				 width:15%;
			}
			.dropzone{min-height: 200px;}
			   .ui-jqgrid tr.jqgrow td {
				white-space: normal !important;
				height:auto;
			}
			.widget-box{
				margin: 0;
			}
			/*a {
    color: #fff;
    text-decoration: none;
}*/
		
		   .ui-jqgrid tr.jqgrow td {
				white-space: normal !important;
				height:auto;
			}
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
		  
		
		
			
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				
				display: inline;
			}
			
			.ui-jqdialog .ui-widget-header {
    
    background-image: linear-gradient(to bottom,#6FB3E0 0,#6FB3E0 100%);
    }
    
		</style>

</head>
		

	<body>
	
		<%@ include file="base/header.html"%>

		<div class="main-container" id="main-container" style="margin-top:27px">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<%@ include file="base/menu.html"%>	

				<div class="main-content">
				<div class="breadcrumbs" style="min-height: 20px;line-height: 20px;">
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="../index.jsp">主页</a>
							</li>
							<li>村庄数据在线采集</li>
						</ul><!-- .breadcrumb -->
					</div>
				
					<div class="page-content">
					 <input type="hidden" id="dd1" value="1" onclick="AssignTask2(1)">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
							<!--	<div class="col-xs-7">
								<table id="grid-table0" ></table>
											<div id="grid-pager0"></div>
											<script type="text/javascript">
												var $path_base1 = "/";//this will be used in gritter alerts containing images
											</script>
					
										
								</div>	

								<div class="col-xs-5">
										
										<div style="width:100%;height:100%;">
												<div class="widget-box" style="height:100%">
												<div class="widget-header header-color-blue2 " >
													<h4 class="lighter smaller">调查项目</h4>
												</div>

												<div class="widget-body" style="height:100%">
													<div class="widget-main padding-8"style="height:100%" >
														<div id="tree2" class="tree" style="height:100%"></div>
													</div>
												</div>
												</div>
										</div>
										
								</div>
								
									-->	
										<div class="row">
									<div class="col-md-12 widget-container-span ui-sortable" style="width:100%">
										<div class="widget-header widget-header-small" align='center'style="height:15px">
											<h6 class="lighter" align='center'>村庄数据在线采集</h6>
										</div>
										<div class="widget-body" style="height: 50px;">
											<div class="widget-main">
												
												<div class="row">
												<div class="col-md-4">	
														<!--<select  class="form-control"  id="s2"  onchange="changeGrade(this)">
															<option value="0">村庄</option>
															<div id="o2" >
															</div>
														</select>-->
														<form id="form3" >
														<!--<div>
													        村庄：<input id="txtTreeSelect1" type="text" onclick="showMenu1(); return false;" style="width: 88%;" value="村庄"readonly="readonly"/>
													    </div>
														<div id="menuContent1" class="menuContent" style="display: none; width: 100%; z-index:9998;">-->
																<div style="float:left; left:30px;width:80px">
															     <input value="市"readonly="readonly"type="text"style="width:24px;"/><input id="txtTreeSelect3" type="text" value="莱芜市"readonly="readonly"style="width:56px;"/>
																</div>
															    
																<!--  <div id="menuContent3" class="menuContent" style="display: none;z-index:9999;">
																	<ul id="tree4" class="tree" style="margin-top: 0; width: 120px; height:80px;position: absolute;z-index:9999;border: solid 1px #000; background: #FFF;">
																	</ul>
																</div>-->
																
																<div style="float:left; left:110px;width:132px">
															     <input value="县"readonly="readonly"type="text"style="width:24px;"/><input id="txtTreeSelect4" type="text" onclick="showMenu4(); return false;"value="县"readonly="readonly"style="width:108px;"/>
																</div>
															    
																<div id="menuContent4" class="menuContent" style="display: none;z-index:9999;">
																	<ul id="tree5" class="tree" style="margin-top: 0; width: 200px; height:200px;top:28px;left:90px;position: absolute;z-index:9999;border: solid 1px #000; background: #FFF;">
																	</ul>
																</div>
																
																<div style="float:left; left:242px;width:146px">
															      <input value="镇"readonly="readonly"type="text"style="width:24px;"/><input id="txtTreeSelect5" type="text" onclick="showMenu5(); return false;"value="镇"readonly="readonly"style="width:122px;"/>
																</div>
															    
																<div id="menuContent5" class="menuContent" style="display: none;z-index:9999;">
																	<ul id="tree6" class="tree" style="margin-top: 0; width: 200px; height:200px;top:28px;left:222px;position: absolute;z-index:9999;border: solid 1px #000; background: #FFF;">
																	</ul>
																</div>
																
																
																
														   <!--  <ul id="tree2" class="tree" style="margin-top: 0; width: 84%; height:300px;position: absolute;top:56px;z-index:9998;border: solid 1px #000; background: #FFF;">
														    </ul>
														</div> -->
														</form>
													</div>
													<div class="col-md-2">
														<!--<select class="form-control" id="s1" onchange="changeDepartment(this)" >
															<option value="0">所有年份 </option> 
															<div id="o1">
															</div>
														</select> -->
														<form id="form2" >
														<div>
													        采集年份：<input id="txtTreeSelect2" type="text" onclick="showMenu2(); return false;" style="width: 60%;" value="年份"readonly="readonly"/>
													    </div>
														<div id="menuContent2" class="menuContent" style="display: none; width: 100%;z-index:9998;">
														    <ul id="tree3" class="tree" style="margin-top: 0; width: 75%; height:50px;position: absolute;z-index:9998;border: solid 1px #000; background: #FFF;">
														    </ul>
														</div>
														</form>
													</div>
													
													<div class="col-md-4">
													<!--  	<select class="form-control" id="s3"  >
															<option value="0">调查项目</option>
															<div id="o3">
															</div>
														</select> -->
														<form id="form1" >
														<div>
													       调查项目：<input id="txtTreeSelect" type="text" onclick="showMenu(); return false;" style="width: 80%;" value="调查项目"readonly="readonly"/>
													    </div>
														<div id="menuContent" class="menuContent" style="display: none; width: 100%;z-index:9998;">
														    <ul id="tree1" class="tree" style="margin-top: 0; width: 87%; height:200px;position: absolute;z-index:9998;border: solid 1px #000; background: #FFF;">
														    </ul>
														</div>
														</form>
													</div>
													<!--  <div class="col-md-1" style="width: 60">
														<button type="button" class="btn btn-purple btn-sm" id="search">
															查看
															<i class="icon-search icon-on-right bigger-110"></i>
														</button>
													</div> -->
													<div class="col-md-2" >
														<button type="button" class="btn btn-purple btn-sm" title="导入App的数据"style="width: 35%" id="add1">
															导入App
														<!-- 	<i class="icon-plus-sign icon-on-right bigger-110"></i>  -->
														</button>
														<button type="button" class="btn btn-purple btn-sm" title="添加采集记录和数据"style="width: 35%" id="add">
															添加数据
														<!-- 	<i class="icon-plus-sign icon-on-right bigger-110"></i>  -->
														</button>
														<button type="button" class="btn btn-purple btn-sm" title="保存数据并打分" style="width: 25%"id="save">
															保存
														<!-- 	<i class="icon-plus-sign icon-on-right bigger-110"></i>  -->
														</button>
														
													</div>
													<div id="consoleDlg1"></div>
													<div id="consoleDlg3"></div>
													<div id="consoleDlg4"></div>
												</div>
												
											</div>
										</div>
									</div>
									
								</div>
									<div class="col-xs-4">
												 <ul id="tree2" class="tree" style="margin-top: 0; position: absolute; left:-25px;top:0px; width: 100%; height:440px;border: solid 1px gray; background: #FFF;">
												 </ul>
									</div>
									<div class="col-xs-8">				
										<table id="grid-table" ></table>
											<div id="grid-pager"></div>
											<script type="text/javascript">
												var $path_base1 = "/";//this will be used in gritter alerts containing images
											</script>
					
										<div id="consoleDlg"></div>
										<div id="consoleDlg2"></div>
										
									</div>
							
							
										
								
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

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
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<!--文件上传-->
		<script src="assets/js/dropzone.min.js"></script>
        <script src="assets/js/bootbox.min.js"></script>

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		
		<script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		<script type="text/javascript">
		var sddd1;
		var jj;
		var idf;
		var setting = {
        view: {
            showIcon: false
        },
        data: {         
            simpleData: {
                enable: true
            }
        },
        callback: {            
            onClick: onClick
        }
    	};
		function onClick(jj) {        
        $('#txtTreeSelect').val(jj.name);
    	}
		function showMenu() {
		var cityObj = $('#txtTreeSelect'); 
		var cityOffset = cityObj.offset();
		        $("#menuContent").css({ left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px" }).slideDown("fast");
		        $("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
		        $("#menuContent").fadeOut("fast");
		        $("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
		            hideMenu();
		        }
		}
		$(document).ready(function () {
		var tree_data;
           		//定义表的名字
				//var grid_selector = "#grid-table";
				//定义页数的名字
				//var pager_selector = "#grid-pager";
			//var iddd1=iddd;
							
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../duixiang_sss.action",//tree_singTree.action
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
					/*var rowid8 = $("#grid-table0").jqGrid('getGridParam','selrow');
 							var rowData8 = $("#grid-table0").jqGrid("getRowData",row_id8);//根据上面的id获得本行的所有数据
        				    var val8= rowData8.VilDataCollRecId;*/
							
	 			$('#tree1').on('selected', function(evt, data) {
							//获取选择的树名字
							//var output1 ="";
							//获取选择的树的id
							var ids = "";
							sddd1 = null;
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids = ids.substring(0, ids.lastIndexOf(","));
							 //output1 = output1.substring(0, output1.lastIndexOf(","));
 							var ids1 = "";
						    var items1 = $('#tree2' ).tree('selectedItems' );  
						    for (var i in items1) if (items1.hasOwnProperty(i)) {  
						        var item1 = items1[i];  
						       ids1 += item1.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids1 = ids1.substring(0, ids1.lastIndexOf(","));
        				    jj=ids;
        				    //获取选择的树名字
							var output2 ="";
							//获取选择的树的id
							var ids2 = "";
						    var items2 = $('#tree3' ).tree('selectedItems' );  
						    for (var i in items2) if (items2.hasOwnProperty(i)) {  
						        var item2 = items2[i];  
						       ids2 += item2.additionalParameters['id' ] + ",";
						       output2 += item2.name + ",";
						    }
							 ids2 = ids2.substring(0, ids2.lastIndexOf(","));
							 output2 = output2.substring(0, output2.lastIndexOf(","));
        				    $("#txtTreeSelect").val(item.name);
        				    $('#menuContent').css('display','none'); 
        				    //alert(ids);
        				    //var iddd1=iddd;
 						jQuery(si_selector).jqGrid("setGridParam", {
 						
		                	//url:'../../duixiang_manageDUI.action?oper=search&JQID1='+ids1,
		                	url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids+'&JQID1='+ids1+'&JQID3='+output2,
		   					//editurl: '../../duixiang_manageDUI.action&JQID='+ids1,
		   					
 		                });
 		                jQuery(si_selector).trigger("reloadGrid",[ {page : 1 }]);
						
					});
					$('#tree1').on('opened', function (evt, data) {
							var is = data.additionalParameters['id' ] ;
							idf=is;
							var sddd="";
							sddd=data.additionalParameters['children' ];
							//alert(sddd);
							sddd1=sddd;
							var ids1 = "";
						    var items1 = $('#tree2' ).tree('selectedItems' );  
						    for (var i in items1) if (items1.hasOwnProperty(i)) {  
						        var item1 = items1[i];  
						       ids1 += item1.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids1 = ids1.substring(0, ids1.lastIndexOf(","));
							 //获取选择的树名字
							var output2 ="";
							//获取选择的树的id
							var ids2 = "";
						    var items2 = $('#tree3' ).tree('selectedItems' );  
						    for (var i in items2) if (items2.hasOwnProperty(i)) {  
						        var item2 = items2[i];  
						       ids2 += item2.additionalParameters['id' ] + ",";
						       output2 += item2.name + ",";
						    }
							 ids2 = ids2.substring(0, ids2.lastIndexOf(","));
							 output2 = output2.substring(0, output2.lastIndexOf(","));
						//	alert(is);
						//alert(ids1);
							var is1= data.name;
							$("#txtTreeSelect").val(is1);
							$('#menuContent').css('display','none'); 
							jQuery(si_selector).jqGrid("setGridParam", {
								url :'../../duixiang_manageDUI.action?oper=search&JQID = hh&ObjFSID='+is+'&JQID1='+ids1+'&JQID3='+output2,
								//editurl :'../../duixiang_manageDUI.action?ObjFSID='+is,
							});
							jQuery(si_selector).trigger("reloadGrid",[ {page : 1 }]);
					});
				
					var tree_data2;
           		//定义表的名字
				//var grid_selector = "#grid-table";
				//定义页数的名字
				//var pager_selector = "#grid-pager";
			//var iddd1=iddd;
							
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../jilu_singTree.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {

						tree_data2=data.ss;

						},
						});
						
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource2 = new DataSourceTree({data: tree_data2});
             	$('#tree3').ace_tree({
					
						dataSource: treeDataSource2  ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : false,
					});
					/*var rowid8 = $("#grid-table0").jqGrid('getGridParam','selrow');
 							var rowData8 = $("#grid-table0").jqGrid("getRowData",row_id8);//根据上面的id获得本行的所有数据
        				    var val8= rowData8.VilDataCollRecId;*/
							
	 			$('#tree3').on('selected', function(evt, data) {
							//获取选择的树名字
							var output2 ="";
							//获取选择的树的id
							var ids2 = "";
						    var items2 = $('#tree3' ).tree('selectedItems' );  
						    for (var i in items2) if (items2.hasOwnProperty(i)) {  
						        var item2 = items2[i];  
						       ids2 += item2.additionalParameters['id' ] + ",";
						       output2 += item2.name + ",";
						    }
							 ids2 = ids2.substring(0, ids2.lastIndexOf(","));
							 output2 = output2.substring(0, output2.lastIndexOf(","));
							 var ids1 = "";
						    var items1 = $('#tree2' ).tree('selectedItems' );  
						    for (var i in items1) if (items1.hasOwnProperty(i)) {  
						        var item1 = items1[i];  
						       ids1 += item1.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids1 = ids1.substring(0, ids1.lastIndexOf(","));
							 //output1 = output1.substring(0, output1.lastIndexOf(","));
							 var ids = "";
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids = ids.substring(0, ids.lastIndexOf(","));
							  $("#txtTreeSelect2").val(output2);
							  $('#menuContent2').css('display','none'); 
 							//alert(output2);
        				    //idd=ids1;
        				    //var iddd1=iddd;
        				     if(sddd1!==null){
        				   //alert('folder');
        				   var hh=idf;
        				   ids="hh";
        				   //alert(hh);
        				   //alert(ids);
        				   }else{
        				  // alert('item');
        				   var hh="hh";
        				   //alert(hh);
        				   }
 						jQuery(si_selector).jqGrid("setGridParam", {
 							//url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids+'&JQID1='+ids1+'&JQID3='+output2,
 							url :'../../duixiang_manageDUI.action?oper=search&ObjFSID='+hh+'&JQID='+ids+'&JQID1='+ids1+'&JQID3='+output2,
		                	//url:'../../duixiang_manageDUI.action?oper=search&JQID3='+output2,
		                	//url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids1,
		   					//editurl: '../../duixiang_manageDUI.action&JQID='+ids1,
		   					
 		                });
 		                jQuery(si_selector).trigger("reloadGrid",[ {page : 1 }]);
						
					});
				//var iddd;
				});
		</script>
		
		<script type="text/javascript">
		var jj2;
		var setting2 = {
        view: {
            showIcon: false
        },
        data: {         
            simpleData: {
                enable: true
            }
        },
        callback: {            
            onClick: onClick2
        }
    	};
		function onClick2(jj2) {        
        $('#txtTreeSelect2').val(jj2);
    	}
		function showMenu2() {
		var cityObj2 = $('#txtTreeSelect2'); 
		var cityOffset2 = cityObj2.offset();
		        $("#menuContent2").css({ left: cityOffset2.left + "px", top: cityOffset2.top + cityObj2.outerHeight() + "px" }).slideDown("fast");
		        $("body").bind("mousedown", onBodyDown2);
		}
		function hideMenu2() {
		        $("#menuContent2").fadeOut("fast");
		        $("body").unbind("mousedown", onBodyDown2);
		}
		function onBodyDown2(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent2").length > 0)) {
		            hideMenu2();
		        }
		}
		$(document).ready(function () {
				
				
				});
		</script>
		<script type="text/javascript">
		var jj4;
		var setting4 = {
        view: {
            showIcon: false
        },
        data: {         
            simpleData: {
                enable: true
            }
        },
        callback: {            
            onClick: onClick4
        }
    	};
		function onClick4(jj4) {        
        $('#txtTreeSelect4').val(jj4);
    	}
		function showMenu4() {
		var cityObj4 = $('#txtTreeSelect4'); 
		var cityOffset4 = cityObj4.offset();
		        $("#menuContent4").css({ left: cityOffset4.left + "px", top: cityOffset4.top + cityObj4.outerHeight() + "px" }).slideDown("fast");
		        $("body").bind("mousedown", onBodyDown4);
		}
		function hideMenu4() {
		        $("#menuContent4").fadeOut("fast");
		        $("body").unbind("mousedown", onBodyDown4);
		}
		function onBodyDown4(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent4").length > 0)) {
		            hideMenu4();
		        }
		}
		$(document).ready(function () {
				var tree_data3;
           		//定义表的名字
				//var grid_selector = "#grid-table";
				//定义页数的名字
				//var pager_selector = "#grid-pager";
			//var iddd1=iddd;
							
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../coutree_singTree.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {

						tree_data3=data.ss;

						},
						});
						
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource3 = new DataSourceTree({data: tree_data3});
             	$('#tree5').ace_tree({
					
						dataSource: treeDataSource3  ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : false,
					});
					/*var rowid8 = $("#grid-table0").jqGrid('getGridParam','selrow');
 							var rowData8 = $("#grid-table0").jqGrid("getRowData",row_id8);//根据上面的id获得本行的所有数据
        				    var val8= rowData8.VilDataCollRecId;*/
							
	 			$('#tree5').on('selected', function(evt, data) {
							//获取选择的树名字
							var output3 ="";
							//获取选择的树的id
							var ids3 = "";
						    var items3 = $('#tree5' ).tree('selectedItems' );  
						    for (var i in items3) if (items3.hasOwnProperty(i)) {  
						        var item3 = items3[i];  
						       ids3 += item3.additionalParameters['id' ] + ",";
						       output3 += item3.name + ",";
						    }
							 ids3 = ids3.substring(0, ids3.lastIndexOf(","));
							 output3 = output3.substring(0, output3.lastIndexOf(","));
							  $("#txtTreeSelect4").val(item3.name);
							  $('#menuContent4').css('display','none'); 
 							//alert(output2);
        				    //idd=ids1;
        				    //var iddd1=iddd;
 						/*jQuery(si_selector).jqGrid("setGridParam", {
 							url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids+'&JQID1='+ids1+'&JQID3='+output2,
		                	//url:'../../duixiang_manageDUI.action?oper=search&JQID3='+output2,
		                	//url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids1,
		   					//editurl: '../../duixiang_manageDUI.action&JQID='+ids1,
		   					
 		                });
 		                jQuery(si_selector).trigger("reloadGrid",[ {page : 1 }]);*/
 		                 $('#tree6').removeData("tree");
 		                 $('#tree6').unbind("click");//移除点击事件
 		                  $('#tree6').trigger("reloadGrid");
 		                var tree_data4;
           	
							 
				$.ajax({
						
						url: "../../towntree_singTree.action?&JQID="+ids3,//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {

						tree_data4=data.ss;

						},
						});
						
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource4 = new DataSourceTree({data: tree_data4});
             	$('#tree6').ace_tree({
					
						dataSource: treeDataSource4  ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : false,
					});
					/*var rowid8 = $("#grid-table0").jqGrid('getGridParam','selrow');
 							var rowData8 = $("#grid-table0").jqGrid("getRowData",row_id8);//根据上面的id获得本行的所有数据
        				    var val8= rowData8.VilDataCollRecId;*/
							
	 			$('#tree6').on('selected', function(evt, data) {
							//获取选择的树名字
							var output4 ="";
							//获取选择的树的id
							var ids4 = "";
						    var items4 = $('#tree6' ).tree('selectedItems' );  
						    for (var i in items4) if (items4.hasOwnProperty(i)) {  
						        var item4 = items4[i];  
						       ids4 += item4.additionalParameters['id' ] + ",";
						       output4 += item4.name + ",";
						    }
							 ids4 = ids4.substring(0, ids4.lastIndexOf(","));
							 output4 = output4.substring(0, output4.lastIndexOf(","));
							  $("#txtTreeSelect5").val(item4.name);
							  $('#menuContent5').css('display','none'); 
							  
 						 $('#tree2').removeData("tree");
 		                 $('#tree2').unbind("click");//移除点击事件
 		                  $('#tree2').trigger("reloadGrid");
				var tree_data1;
           	
				$.ajax({
						url: "../../viltree_singTree.action?JQID="+ids4,//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {

						tree_data1=data.ss;

						},
						});
						
				//引用树本身的方法定义树的源数据，并将数据加载到树结构中
				var treeDataSource1 = new DataSourceTree({data: tree_data1});
             	$('#tree2').ace_tree({
					
						dataSource: treeDataSource1  ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : false,
					});
					/*var rowid8 = $("#grid-table0").jqGrid('getGridParam','selrow');
 							var rowData8 = $("#grid-table0").jqGrid("getRowData",row_id8);//根据上面的id获得本行的所有数据
        				    var val8= rowData8.VilDataCollRecId;*/
							
	 			$('#tree2').on('selected', function(evt, data) {
							//获取选择的树名字
							//var output1 ="";
							//获取选择的树的id
							
							var ids1 = "";
						    var items1 = $('#tree2' ).tree('selectedItems' );  
						    for (var i in items1) if (items1.hasOwnProperty(i)) {  
						        var item1 = items1[i];  
						       ids1 += item1.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						    }
							 ids1 = ids1.substring(0, ids1.lastIndexOf(","));
							 //output1 = output1.substring(0, output1.lastIndexOf(","));
							 var ids = "";
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       //output1 += item1.name + ",";
						       // ttr =item.additionalParameters['children' ];
						    }
						    
							 ids = ids.substring(0, ids.lastIndexOf(","));
							 //获取选择的树名字
							var output2 ="";
							//获取选择的树的id
							var ids2 = "";
						    var items2 = $('#tree3' ).tree('selectedItems' );  
						    for (var i in items2) if (items2.hasOwnProperty(i)) {  
						        var item2 = items2[i];  
						       ids2 += item2.additionalParameters['id' ] + ",";
						       output2 += item2.name + ",";
						    }
							 ids2 = ids2.substring(0, ids2.lastIndexOf(","));
							 output2 = output2.substring(0, output2.lastIndexOf(","));
 							//alert(ids);
        				    //idd=ids1;
        				    //var iddd1=iddd;
        				    //$("#txtTreeSelect1").val(item1.name);
        				    //var hh;
        				    //alert(idf);
        				   if(sddd1!==null){
        				   //alert('folder');
        				   var hh=idf;
        				   ids="hh";
        				   //alert(hh);
        				   //alert(ids);
        				   }else{
        				  // alert('item');
        				   var hh="hh";
        				   //alert(hh);
        				   }
        				   
 						jQuery(si_selector).jqGrid("setGridParam", {
 						
 							url :'../../duixiang_manageDUI.action?oper=search&ObjFSID='+hh+'&JQID='+ids+'&JQID1='+ids1+'&JQID3='+output2,
 							//url :'../../duixiang_manageDUI.action?oper=search&JQID = hh&ObjFSID='+is+'&JQID1='+ids1+'&JQID3='+output2,
		                	//url:'../../duixiang_manageDUI.action?oper=search&JQID='+ids1,
		                	//url :'../../duixiang_manageDUI.action?oper=search&ObjFSID = hh&JQID='+ids1,
		   					//editurl: '../../duixiang_manageDUI.action&JQID='+ids1,
		   					
 		                });
 		                jQuery(si_selector).trigger("reloadGrid",[ {page : 1 }]);
 		                
 		                
						
					});
						
					});
						
					});
				
				});
		</script>
		
		<script type="text/javascript">
		var jj5;
		var setting5 = {
        view: {
            showIcon: false
        },
        data: {         
            simpleData: {
                enable: true
            }
        },
        callback: {            
            onClick: onClick5
        }
    	};
		function onClick5(jj5) {        
        $('#txtTreeSelect5').val(jj5);
    	}
		function showMenu5() {
		var cityObj5 = $('#txtTreeSelect5'); 
		var cityOffset5 = cityObj5.offset();
		        $("#menuContent5").css({ left: cityOffset5.left + "px", top: cityOffset5.top + cityObj5.outerHeight() + "px" }).slideDown("fast");
		        $("body").bind("mousedown", onBodyDown5);
		}
		function hideMenu5() {
		        $("#menuContent5").fadeOut("fast");
		        $("body").unbind("mousedown", onBodyDown5);
		}
		function onBodyDown5(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent5").length > 0)) {
		            hideMenu5();
		        }
		}
		$(document).ready(function () {
				
				
				
				
				});
		</script>
		
		
		
		<script type="text/javascript">
					
				var si_selector = "#grid-table";
				var pager_selector = "#grid-pager";
			jQuery(function($) {
					
			
				jQuery(si_selector).jqGrid({
					//direction: "rtl",
					
					///rl: "../../duixiang_manageDUI.action?oper=search",
					mtype:"post",
					datatype: "json",
					height: 385,
					colNames:['','记录ID','调查对象Id','编码','调查对象','','输入/选择值',/*'单位',*/'',/*'选择输入(左)',*/'','备注','','','',''],
					colModel:[
					
					{name:'InvesObjDataId',index:'InvesObjDataId', width:100,/*key:true,*/  hidden:true},
					
					{name:'VilDataCollRecID',index:'VilDataCollRecID', width:100, hidden:true,editable: true},
						{name:'InvesObjId',index:'InvesObjId', width:100,hidden:true,editable: false},
						{name:'InvesObjCode',index:'InvesObjCode', width:70,editable: false},
						{name:'InvesObjName',index:'InvesObjName', width:300,editable: false,formatter:myformat},
						 {name:'IsMustCollData',index:'IsMustCollData', width:30,editable: false,  hidden:true},
						{name:'InvesObjDataValu',index:'InvesObjDataValu', width:100,editable: false, cellattr: function(rowId, value, rowObject, colModel, arrData) { return ' colspan=2 '; }, formatter : function(value, options, rData){ return value + ""+rData['DataCollDicEntryId']; }},
						//{name:'InvesObjComp',index:'InvesObjComp',hidden:true, width:100,editable: false},
						{name:'DataCollDicEntryId',index:'DataCollDicEntryId',  width:80,align:'center',sortable : false,editable: false,search:true,cellattr: function(rowId, value, rowObject, colModel, arrData) { return " style=display:none; "; }},
						//{name:'DataCollDataDicName',index:'DataCollDataDicName', width:100,editable: false,hidden:true},
						{name:'DataCollDataDicId',index:'DataCollDataDicId', width:100,hidden:true,editable: false},
						{name:'InvesObjNote',index:'InvesObjNote', width:200,editable: true},
						//{name:'InvesObjAttriId',index:'InvesObjAttriId', width:100,editable: true},
						{name:'IsdChoDic',index:'IsdChoDic', width:100,hidden:true,editable: true},
						{name:'InvesObjAttri',index:'InvesObjAttri', width:100,hidden:true,editable: true},
						{name:'AssignTask',index:'AssignTask',formatter: experAssignTask, width:65,align:'center',search:false,sortable:false},
						{name:'AssignTask1',index:'AssignTask1',formatter: experAssignTask1, width:65,align:'center',search:false,sortable:false}
						/*{name:'myac',index:'', width:80, fixed:true, sortable:false, resize:false,
							formatter:'actions', 
							formatoptions:{ 
								//keys:true,
								
								delOptions:{recreateForm: true, beforeShowForm:beforeDeleteCallback},
								editformbutton:true, editOptions:{recreateForm: true, beforeShowForm:beforeEditCallback}
							}
						}*/
						//{name:'InvesProNum',index:'InvesProNum', width:100,hidden:true,editable: true},
						
						//{name:'InvesObjComp',index:'InvesObjComp', width:100,hidden:true,editable: true},
						
						//{name:'IsMus',index:'IsMus', width:100,hidden:true,  editable: true}
						
					], 
					 onSelectRow: function () 
					{   
						/*//var rowid = jQuery("#grid-table").jqGrid("getGridParam", "selrow");
						var rowid1 = $("#grid-table").jqGrid("getGridParam", "selrow");	
						//alert(rowid);
						jQuery(si_selector1).jqGrid("setGridParam", {
		                  url :'../../shuxing_manageSHU.action?oper=search&JQID='+rowid1,
		                 
		                });
		                jQuery(si_selector1).jqGrid("setCaption","属性").trigger("reloadGrid");*/
						
					},//点击获取gqgird的当前列的'GRP_ID'的值
			   
					viewrecords : true,
					rowNum:10000,
					//rowList:[50,100,150],
					pager : pager_selector,
					//altRows: true,
					//toppager: true,
					rownumbers: true,
					
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
					    id:"InvesObjDataId", // 表示当在编辑数据模块中发送数据时，使用的id的名称  
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

                   
					//multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			
					
					loadComplete : function() {
						var table = this;
						
						setTimeout(function(){
							styleCheckbox(table);
							
							updateActionIcons(table);
							updatePagerIcons(table);
							enableTooltips(table);
						}, 0);
					},
			
					editurl: "../../duixiang_manageDUI.action",//nothing is saved
					//caption:"调查对象", //"<td id='grid-pager3_left' align='left'><table class='ui-pg-table navtable' style='float:left;table-layout:auto;' border='0' cellpadding='0' cellspacing='0'><tbody><tr><td data-original-title='Add new row' id='add_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-plus-sign purple'></span></div></td><td data-original-title='Edit selected row' id='edit_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-pencil blue'></span></div></td><td data-original-title='Delete selected row' id='del_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-trash red'></span></div></td><td data-original-title='Find records' id='search_grid-table' title='' class='ui-pg-button ui-corner-all'><div class='ui-pg-div'><span class='ui-icon icon-search orange'></span></div></td>",
	
			
					autowidth: true,
					 //subGrid: true,  // (1)开启子表格支持  
	        /**subGridRowExpanded: function(subgrid_id, row_id) {  // (2)子表格容器的id和需要展开子表格的行id，将传入此事件函数  
	            var subgrid_table_id;  
	            subgrid_table_id = subgrid_id + "_t";   // (3)根据subgrid_id定义对应的子表格的table的id  
	              
	            var subgrid_pager_id;  
	            subgrid_pager_id = subgrid_id + "_pgr"  // (4)根据subgrid_id定义对应的子表格的pager的id
	            
	             var rowDate = $("#grid-table").jqGrid('getRowData', row_id); 
	             
	             ID1=rowDate.DataCollDataDicId; 	              
	            // (5)动态添加子报表的table和pager  
	            $("#" + subgrid_id).html("<table id='"+subgrid_table_id+"' class='scroll'></table><div id='"+subgrid_pager_id+"' class='scroll'></div>");  
	             
	            // (6)创建jqGrid对象  
	            $("#" + subgrid_table_id).jqGrid({  
	                url: "../../DataCollDicEntry_manageDataCollDicEntry.action?oper=search&JQID="+ID1,  // (7)子表格数据对应的url，注意传入的contact.id参数  
	                datatype: "json",  
	               colNames:['dataCollDicEntryId','条目编码','字典编码','条目名称'],
					colModel:[
					     {name:'dataCollDicEntryId',index:'dataCollDicEntryId', width:60, sorttype:"int",key:true, editable: false,search:false,hidden:true},
					    {name:'dicEntryCode',index:'dicEntryCode', width:100, sorttype:"int", editable: true,editoptions:{size:"20",maxlength:"30"},formoptions:{elmsuffix:"<font color='red'>*</font>"}},
						  {name:'dataCollDataDicId',index:'dataCollDataDicId', width:10, sorttype:"int", editable: true,hidden:true},
						{name:'dicEntryName',index:'dicEntryName', width:150,editable: true,editoptions:{size:"20",maxlength:"30"}},
					],
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
	                pager: subgrid_pager_id,
	                rowList:[10,20,30],  
	                rowNum:10,
                viewrecords: true,  
                height: 100,  
	                rowNum: 5 ,
	                multiselect: true,
					//multikey: "ctrlKey",
			        multiboxonly: true,
			        autowidth: true,
			        
	                
	           }); 
	           jQuery("#" + subgrid_table_id).jqGrid('navGrid',"#" + subgrid_pager_id,
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
					/*{
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
			             $("#" + subgrid_table_id).jqmHide();
			                var id = $("#" + subgrid_table_id).jqGrid('getGridParam', 'selrow');
			                jQuery("#" + subgrid_table_id).jqGrid('setRowData', id, postdata);
			               
			                $("#" + subgrid_table_id).trigger("reloadGrid");//操作完成后刷新表单
			            }, 
					},*/
					/*{
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
						
					      var id = $("#" + subgrid_table_id).jqGrid('getGridParam', 'selrow');
					      jQuery("#" + subgrid_table_id).jqGrid('addRowData', postdata.Id, postdata);
					      return [true, 'successfule!', false];
					    }, 
					},*/
					/*{
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
			                var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#" + subgrid_table_id).jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#" + subgrid_table_id).trigger("reloadGrid");//操作完成后刷新表单
			                $("#" + subgrid_table_id).jqmHide();//关闭删除弹出框
			            },
			            closeAfterDel: true,
			            closeOnEscape: true,
						
					},*/
					/*{
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
				).navSeparatorAdd("#" + subgrid_pager_id,{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd("#" + subgrid_pager_id,{     
				   caption:"",
				   title:"保存",
				   buttonicon:"icon-cloud-upload", 
				   
				    onClickButton: function(){
					 //var InvesObjID = $("#InvesObjName").val();
					//var id=$(grid_selector).jqGrid("getGridParam","selrow");//获得单行id
					var ids=$("#" + subgrid_table_id).jqGrid("getGridParam","selarrrow");//获得多行id
					
        				var rowData = $("#grid-table").jqGrid("getRowData",row_id);//根据上面的id获得本行的所有数据
        				
        				var val= rowData.VilDataCollRecID; //获得制定列的值 （auditStatus 为colModel的name）
					 	var val1=rowData.InvesObjId;
					//alert(ids);
					
				   $.ajax({
						type : "post",
						async: false,
						url : "../../duixiang_manageDUI1.action?oper=add&InvesObjId="+val1+"&VilDataCollRecId="+val+"&DataCollDicEntryId="+ids,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								window.parent.$("#consoleDlg").dialog("close");
		
				               window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?invesObjID="+InvesObjID+"&oper=search",
				                });
				                 window.parent.$("#grid-table").jqGrid("setCaption","成功").trigger("reloadGrid");
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
	            
	       		}  **/

			
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
				function myformat ( cellvalue, options, rowObject )
    {
      if (rowObject.IsMustCollData==true){
      return '<font color="red">' + cellvalue + '</font>';//or use classes
      } else{
      return '<font color="black">' + cellvalue + '</font>';//or use classes
      }
    }
			function experAssignTask(cellvalue, options, rowObject){
			//alert(rowObject.IsdChoDic);
				//if(rowObject.IsdChoDic==null){
					/*if(rowObject.InvesObjAttri=='memo'){
						return "上传文件";
					}else{
					return "请录入数据值";
					}
				}*/
				//else{
				//alert(rowObject.InvesObjName);
				var sss=options.rowId;
				return "<input id='AS' type='button' value='编辑' onclick='AssignTask(\""+sss+"\",\""+rowObject.InvesObjNote+"\",\""+rowObject.InvesObjDataId+"\",\""+rowObject.InvesObjAttri+"\",\""+rowObject.InvesObjCode+"\",\""+rowObject.InvesObjName+"\",\""+rowObject.InvesObjDataValu+"\",\""+rowObject.IsdChoDic+"\",\""+rowObject.DataCollDataDicId+"\",\""+rowObject.InvesObjId+"\",\""+rowObject.VilDataCollRecID+"\")'/>";
				//}
					//InvesObjNote
				} 
				function experAssignTask1(cellvalue, options, rowObject){
			//alert(rowObject.IsdChoDic);
				//if(rowObject.IsdChoDic==null){
					/*if(rowObject.InvesObjAttri=='memo'){
						return "上传文件";
					}else{
					return "请录入数据值";
					}
				}*/
				//else{
				var sss=options.rowId;
				return "<input type='button' value='附件' onclick='AssignTask1(\""+sss+"\",\""+rowObject.InvesObjNote+"\",\""+rowObject.InvesObjDataId+"\",\""+rowObject.InvesObjAttri+"\",\""+rowObject.InvesObjCode+"\",\""+rowObject.InvesObjName+"\",\""+rowObject.InvesObjDataValu+"\",\""+rowObject.IsdChoDic+"\",\""+rowObject.DataCollDataDicId+"\",\""+rowObject.InvesObjId+"\",\""+rowObject.VilDataCollRecID+"\")'/>";
				//}
					//InvesObjNote
				} 
			
				//navButtons
				jQuery(si_selector).jqGrid('navGrid',pager_selector,
					{ 	//navbar options
					//cloneToTop: true,
						edit: false,
						editicon : 'icon-pencil blue',
						add:  false,
						addicon : 'icon-plus-sign purple',
						del: false,
						delicon : 'icon-trash red',
						search: false,
						searchicon : 'icon-search orange',
						refresh: false,
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
						url: '../../duixiang_manageDUI.action',
					    mtype: 'POST',
			            afterSubmit: function (xhr, postdata) {
			                var id = $("#grid-table").jqGrid('getGridParam', 'selrow');
			                jQuery("#grid-table").jqGrid('setRowData', id, postdata);
			                 //return [true, 'successfule!', false];
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
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
							var form = $(e[0]);
							form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
							style_edit_form(form);
						},
						//url: '../../duixiang_manageDUI.action',
					    mtype: 'POST',
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
						url: '../../duixiang_manageDUI.action',
					    mtype: 'POST',
						//添加删除逻辑
						afterSubmit: function (xhr, postdata) {
							$("#delmodgrid-table").jqmHide();//关闭删除弹出框
			                var selectedRowIds = $("#grid-table").jqGrid("getGridParam", "selarrrow");
			                var len = selectedRowIds.length;
			                for (var i = 0; i < len ; i++) {
			                    $("#grid-table").jqGrid("delRowData", selectedRowIds[0]);
			                }
			                $("#grid-table").trigger("reloadGrid");//操作完成后刷新表单
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
				)/*.navSeparatorAdd(pager_selector,{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd(pager_selector,{     
				   caption:"保存",
				   title:"校验必选项后保存",
				   buttonicon:"icon-cloud-upload blue", 
				   
				    onClickButton: function(){
					
					var rowIds = $("#grid-table").jqGrid('getDataIDs'); 
        				var obj = $("#grid-table").jqGrid("getRowData",rowIds[0]);
        				var val2= obj.VilDataCollRecID; //获得制定列的值 （auditStatus 为colModel的name）
						//alert(val2);
				   $.ajax({
						type : "post",
						async: false,
						url : "../../duixiang_DDD.action?VilDataCollRecId="+val2,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								
							}
						}
					});
					
				   },       
				       
				   //position:"last"    
				}).navSeparatorAdd(pager_selector,{
					sepclass : "ui-separator",
					sepcontent: '',
				}).navButtonAdd(pager_selector,{     
				   caption:"文件上传与查看",
				   title:"文件上传与查看",
				   buttonicon:"icon-folder-close blue", 
				   
				   onClickButton: function(){ 
				   	   var consoleDlg2 = $("#consoleDlg2");
				consoleDlg2.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a3="";
				
				 a3 = "<iframe src='upLoadImg.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				
				
				
				consoleDlg2.append(a3);
				
				consoleDlg2.dialog("option", "title", "文件").dialog("open");
				
					},
				    position:"last"
				});*/
			
			
				
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
				
				
			$("#consoleDlg").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 410,
					position : "center", // 窗口显示的位置
					width : 670,
					 //modal: true, //蒙层
					   
				});
				$("#consoleDlg2").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 500,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
				$("#save").click(function(){
						/* //var InvesObjID = $("#InvesObjName").val();
					
					//var idws=$("#grid-table0").jqGrid("getGridParam","selarrrow");//获得多行id
					var idws=$("#grid-table").jqGrid("getGridParam","selrow");//获得单行id
        				var rowData1 = $("#grid-table").jqGrid("getRowData",idws);//根据上面的id获得本行的所有数据
        				
        				var val2= rowData1.VilDataCollRecId; //获得制定列的值 （auditStatus 为colModel的name）
					 	//var val21=idd;
					//alert(ids);*/
					var rowIds = $("#grid-table").jqGrid('getDataIDs'); 
        				var obj = $("#grid-table").jqGrid("getRowData",rowIds[0]);
        				var val2= obj.VilDataCollRecID; //获得制定列的值 （auditStatus 为colModel的name）
						//alert(val2);
				   $.ajax({
						type : "post",
						async: false,
						url : "../../duixiang_DDD.action?VilDataCollRecId="+val2,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								//window.parent.$("#consoleDlg1").dialog("close");
		
				               /*window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?invesObjID="+InvesObjID+"&oper=search",
				                });*/
				                // window.parent.$("#grid-table").trigger("reloadGrid",[ {page : 1 }]);
							}
						}
					});
					});
				
			});
			function AssignTask(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID) {
				$("#grid-table").jqGrid("setSelection",sss);
				//alert("-------->"+DataCollDataDicId+"---------------->"+InvesObjId+"---------------->"+VilDataCollRecID);
				//alert(IsdChoDic);
				var consoleDlg = $("#consoleDlg");
				consoleDlg.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a1="";
				if(IsdChoDic=='true'){
				 a1 += "<iframe src='ObjColldDataInves1.jsp?InvesObjDataId="+InvesObjDataId+"&sss="+sss+"&InvesObjCode="+InvesObjCode+"&InvesObjName="+encodeURI(InvesObjName)+"&DataCollDataDicId="+DataCollDataDicId+"&InvesObjId="+InvesObjId+"&VilDataCollRecID="+VilDataCollRecID+"&InvesObjNote="+InvesObjNote+"'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				}
				if(IsdChoDic=='false'){
				 a1 += "<iframe src='ObjColldDataInves2.jsp?InvesObjDataId="+InvesObjDataId+"&sss="+sss+"&InvesObjCode="+InvesObjCode+"&InvesObjName="+encodeURI(InvesObjName)+"&DataCollDataDicId="+DataCollDataDicId+"&InvesObjId="+InvesObjId+"&VilDataCollRecID="+VilDataCollRecID+"&InvesObjNote="+InvesObjNote+"'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				}
				 if(IsdChoDic=='null'){
				a1 += "<iframe src='ObjColldDataInves3.jsp?InvesObjDataId="+InvesObjDataId+"&sss="+sss+"&InvesObjCode="+InvesObjCode+"&InvesObjName="+encodeURI(InvesObjName)+"&InvesObjDataValu="+InvesObjDataValu+"&InvesObjId="+InvesObjId+"&VilDataCollRecID="+VilDataCollRecID+"&InvesObjNote="+InvesObjNote+"'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				}
				consoleDlg.append(a1);
				
				consoleDlg.dialog("option", "title", "输入框").dialog("open");
				
				
			};
			function AssignTask1(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID) {
				$("#grid-table").jqGrid("setSelection",sss);
				 var consoleDlg2 = $("#consoleDlg2");
				consoleDlg2.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a3="";
				
				 a3 = "<iframe src='upLoadImg.jsp?InvesObjId="+InvesObjId+"&VilDataCollRecID="+VilDataCollRecID+"&sss="+sss+"'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				
				
				
				consoleDlg2.append(a3);
				
				consoleDlg2.dialog("option", "title", "文件").dialog("open");
				
				
			};
		</script>
		
		<script type="text/javascript">
			jQuery(function($){
				
			$("#consoleDlg1").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 400,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
				$("#add").click(function(){
						var consoleDlg1 = $("#consoleDlg1");
				consoleDlg1.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a2="";
				
				 a2 = "<iframe src='VilDataCollRec.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				
				
				
				consoleDlg1.append(a2);
				
				consoleDlg1.dialog("option", "title", "添加采集记录").dialog("open");
				})
			
			});
		</script>
		<script type="text/javascript">
			jQuery(function($){
				
			$("#consoleDlg3").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 510,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
				$("#add1").click(function(){
						var consoleDlg3 = $("#consoleDlg3");
				consoleDlg3.html("");  
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a4="";
				
				 a4 = "<iframe src='upLoadAll.jsp'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				
				
				
				consoleDlg3.append(a4);
				
				consoleDlg3.dialog("option", "title", "导入").dialog("open");
				})
			
			});
		</script>
		
		
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#06").addClass("active");
			});
			$("#consoleDlg4").dialog({
					autoOpen : false, // 是否自动弹出窗口
					modal : true, // 设置为模态对话框
					resizable : true,
					height : 380,
					position : "center", // 窗口显示的位置
					width : 800,
					 //modal: true, //蒙层
					   
				});
			function AssignTask2(dd1) {
				
				 var consoleDlg4 = $("#consoleDlg4");
				consoleDlg4.html("");  
				//alert(dd1);
				//var a1 = "<iframe src='studentAdjustClass.jsp?op=add&loginName="+loginName+"&stuNo="+stuNo+"&userName="+userName+"&sexId="+sexId+"&id="+id+"&stuAddress="+stuAddress+ "' style='width: 100%;height: 100%' scrolling='no' frameborder='0'></iframe>";
				var a4="";
				
				 a4 = "<iframe src='VilDataCollRec1.jsp?dd1="+encodeURI(dd1)+"'style='width: 100%;height: 100%' scrolling='auto' frameborder='0'></iframe>";
				//alert(IsdChoDic);
				
				
				
				consoleDlg4.append(a4);
				
				consoleDlg4.dialog("option", "title", "添加采集记录").dialog("open");
				
				
			};
		</script>
		
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>