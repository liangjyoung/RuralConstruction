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
			

		      
		      .col-xs-3{	
				 width:100%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:500px;
			}
			
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 30%;
				display: inline;
			}
			 .span{background-color:#f2f2f2;
		   height:35px;
		   border-bottom:1px solid gray;
		   
		  }
		   .button1{
		   background-color:transparent; 
			width:110px;
			height:35px;
		  }
		  .button2{
			 background-color:transparent; 
			width:105px;
			height:35px;
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
								  
								<input type="hidden" id="InvgatID" value="<%=request.getParameter("InvgatID") %> ">
					
									
								<div  class="col-xs-3"style="height:100%">
								<div class="widget-header header-color-blue2">
									<h4 class="lighter smaller">区划分布</h4>
								</div>
								<div class="widget-body" style="height:500px">
									<div class="table-responsive">
										<div class="widget-main padding-8"style="470px" >
											<div id="tree1" class="tree" style="height:450px"></div>
										</div>
										
										 <span><button id="test"class="button1" type="button" ><i class="icon-ok bigger-120"style="color:#8bad4c"></i>&nbsp&nbsp确定</button></span>
									    <span><button id="cancel"class="button2" type="button" ><i class="icon-remove bigger-120"style="color:#8bad4c"></i>&nbsp&nbsp取消</button></span> 
									</div>
								</div>
							</div>
										 
										
											
								
	
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
	    
	     <script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
          <script src="assets/js/fuelux/fuelux.treep.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			
			 jQuery(function($){
                    
		          var ids;		
		         var tree_data;
           		//定义表的名字
				
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../District_queryAllCompartmentAsTree.action",//tree_singTree.action
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
	                    $('#tree1').unbind("click");//移除点击事件
             	$('#tree1').ace_tree({
						dataSource: treeDataSource,
						multiSelect:true,
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
						    var items = $('#tree1' ).tree('selectedItems' );  
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       ids += item.additionalParameters['id' ] + ",";
						       output += item.name + ",";
						    }
							ids = ids.substring(0, ids.lastIndexOf(","));
							output = output.substring(0, output.lastIndexOf(","));
	 						
					});	
					$('#tree1').on('opened', function (evt, data) {
							var is = data.additionalParameters['id' ] ;
						
						});	
						
						
						
					  $( "#test" ).on('click', function(e) {
					  
					   var InvgatID = $("#InvgatID").val();
					
				       var items = $('#tree1' ).tree('selectedItems'); 						 
					     var tIds='';
						 for (var i in items) {
							if (items.hasOwnProperty(i)) {  
							   var item = items[i];  
							   tIds += item.additionalParameters['id' ] + ",";
							}
						}
					
				   $.ajax({
						type : "post",
						async: false,
						url : "../../InvgatDworks_manageInvgatDwork1.action?oper=add&invgatID="+InvgatID+"&vilBasicInfoID="+tIds,  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success : function(data) {
							if(data.success){
								//alert(InvgatNum);
								alert(data.success);
								
								window.parent.$("#consoleDlg").dialog("close");
		
				               window.parent.$("#grid-table1").jqGrid("setGridParam", {
				                  url : "../../InvgatDworks_manageInvgatDwork.action?invgatID="+InvgatID+"&oper=search",
				                });
				                 window.parent.$("#grid-table1").jqGrid("setCaption","分配情况").trigger("reloadGrid");
				                 window.parent.$("#grid-table1").trigger("reloadGrid");//操作完成后刷新表单
							}
						}
					});
							
                   })
                   
                     $( "#cancel" ).on('click', function(e){
                     window.parent.$("#consoleDlg").dialog("close");
                     
                     })
			 });
						
		</script>
		
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
