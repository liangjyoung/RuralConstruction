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
			 
		      #table-header1{
		        padding-left:80px;
		        height:30px;
		        line-height: 30px;
		     
		      }
		      #table-header2{
		        padding-left:350px;
		        height:30px;
		        line-height: 30px;
		      }
		     
		      #right{
		        width:100%;
		        float:right;
		        border:1px solid gray;
		         min-height: 560px;
		
		      }
		       #right1{
		        background-color:white;
		        min-height: 560px;
		
		      }
		      #tree2{
		        margin-left:30px;
		        
		      }
		      #tree1{
		        margin-left:30px;
		        
		      }
		      .button{
		        background-color:transparent; 
		        width:49%;
		        height:35px;
		      }
		      .button1{
		       background-color:transparent; 
		        width:120px;
		        height:35px;
		      }
		      .span{background-color:#f2f2f2;
		       height:35px;
		       border-bottom:1px solid gray;
		      }
		      img{
		        width:20px;
		      }
			.col-xs-3{	
				 width:22%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:570px;
			}
			.col-xs-9{	
				 width:78%;
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
					<li>角色</li>
				</ul><!-- .breadcrumb -->
			</div>
			<div class="page-content">
              <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
				<div class="col-xs-3">
      
					<div class="widget-box" style="height:100%">
                             <div class="widget-header header-color-blue2" >
                                <h4 class="lighter smaller">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角&nbsp;&nbsp;&nbsp;&nbsp;色</h4>
                             </div><!--
							  <div class="span">
									<div>
										  <a href="#" id="id-btn-dialog1"><button class="button">添&nbsp;&nbsp;加</button></a>
										  <a href="#" id="id-btn-dialog2"><button class="button">删&nbsp;&nbsp;除</button></a>
									   
										<div id="dialog-message" class="hide">
											角色名：<input></br></br></br>
											备&nbsp;&nbsp;&nbsp;&nbsp;注：<input>
										</div> #dialog-message 	
								        <div id="dialog-confirm" class="hide">
											<div class="alert alert-info bigger-110">
												即将删除您所选的记录
											</div>
											<p class="bigger-110 bolder center grey">
												<i class="icon-hand-right blue bigger-120"></i>
												你确定？
											</p>
										</div> #dialog-confirm 
									</div> ./span 
										
                              </div>
                            --><div class="widget-body" style="height:100%">
								<div class="widget-main padding-8"style="height:100%" >
									<div id="tree1" class="tree" style="height:100%"></div>
								</div>
							</div>
					</div>
				</div>
				<div class="col-xs-9">
			  
						<div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
           
					<div id="right">
						<div id="right1">
							  <div id="table-header2" style="background-color:#6FB3E0;color:white;font-size:15px">
									  功&nbsp;&nbsp;&nbsp;&nbsp;能&nbsp;&nbsp;&nbsp;&nbsp;权&nbsp;&nbsp;&nbsp;&nbsp;限
							  </div>

							  <div class="table-responsive">
									<div class="span">
										   <span><button id="test"class="button1" type="button" ><i class="icon-ok bigger-120"style="color:#8bad4c"></i>&nbsp&nbsp保存</button></span>
									</div>
									 <div>
											<div id="tree2" class="tree" style="height:100%"></div>       
									  </div>	
									   </div>
		                   </div>
		               </div><!---right-->
		          </div> <!--col-->
				
				</div>
						  
                              
                              </div><!-- PAGE CONTENT ENDS -->
						</div><!-- /.main-content -->
						   </div><!-- /.col -->
							
                      </div><!-- /.main-content -->
                    </div><!-- /.main-container-inner -->

                    
                  </div><!-- /.main-container -->
				  
	<!-- 插入底部状态栏-->
		<%@ include file="base/footer.html"%>


                  <script type="text/javascript">
                    window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
                  </script>

                  <!-- basic scripts -->
                  <script type="text/javascript">
                    if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
                  </script>
                  <script src="assets/js/bootstrap.min.js"></script>
                  <script src="assets/js/typeahead-bs2.min.js"></script>

                  <!--[if !IE]> -->
				<script src="assets/js/bootbox.min.js"></script>
                  <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->  <!-- 文档加载过慢 -->


                  <script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
                  <script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
                  <script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
                  
                  <script src="assets/js/bootbox.min.js"></script>
				  	<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
					<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
                  <!-- <![endif]-->

                  <!--[if IE]>
              <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
              <![endif]-->

                  <!--[if !IE]> -->
                  <script src="assets/js/ace-elements.min.js"></script>
                  <script src="assets/js/ace.min.js"></script>
                  <script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
                    <script src="assets/js/fuelux/fuelux.tree.min.js"></script>
					
		<script type="text/javascript">
                          
                     jQuery(function($){
                    
		          		 var tree_data1;
		          		  var tree_data2;
		          		  
		          		  //获取选择的树名字
							var tree1output ="";
							//获取选择的树的id
							var tree1ids = "";
							var tree2output ="";
							//获取选择的树的id
							var tree2ids = "";
							//获取父节点
							var tree2id = "";
						  $.ajax({
								url: "../../sysrole_SysRole.action",//tree_singTree.action
								async:false,  
								type: 'POST',
								dataType: 'json',
								success : function(data) {
								//tree_data=$.parseJSON(data.ss);
								tree_data1=data.ss;
								},
								});
						
							var treeDataSource = new DataSourceTree({data: tree_data1});
		             	$('#tree1').ace_tree({
					
						dataSource: treeDataSource  ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
								'close-icon' : 'icon-plus',
								'selectable' : true,
								'selected-icon' : 'icon-ok',
								'unselected-icon' : false
							    
					});
					
				
				$('#tree1').on('selected', function(evt, data) {
							//获取选择的树名字
							aa();
						
 						});		 
				       function  aa(){
				         $('#tree2').removeData("tree");//移除表中数据
	                    $('#tree2').unbind("click");//移除点击事件
	                  //  $('#tree2').unbind("selected");//移除选择事件
	                    
	                    	  tree1ids="";
						    var items = $('#tree1' ).tree('selectedItems' );  
						      
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       tree1ids += item.additionalParameters['id' ] + ",";
						       tree1output += item.name + ",";
						    }
							 tree1ids = tree1ids.substring(0, tree1ids.lastIndexOf(","));
							 tree1output = tree1output.substring(0, tree1output.lastIndexOf(","));
							// alert(tree1ids);
						
								$.ajax({
										url: "../../sysfunc_queryAllMenusAsTree.action?ID="+tree1ids,//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										success : function(data) {
										//tree_data=$.parseJSON(data.ss);
										tree_data2=data.ss;
										},
										});
						  
							var treeDataSource2 = new DataSourceTree({data: tree_data2});
									 
								 $('#tree2').ace_tree({
							      dataSource: treeDataSource2 ,
							    
							       multiSelect:true,
							    loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
								'open-icon' : 'icon-minus',
								'close-icon' : 'icon-plus',
								'selectable' : true,
								'selected-icon' : 'icon-ok',
								'unselected-icon' : false
							    
							    });
				       }
				       
				       $('#tree2').on('selected', function(evt, data) {
							
						    var items = $('#tree2' ).tree('selectedItems' );  
						    	 tree2ids='';
						    for (var i in items) if (items.hasOwnProperty(i)) {  
						        var item = items[i];  
						       tree2ids += item.additionalParameters['id' ] + ",";
						       tree2output += item.name + ",";
						    }
							 tree2ids = tree2ids.substring(0, tree2ids.lastIndexOf(","));
							 tree2output = tree2output.substring(0,tree2output.lastIndexOf(","));
 							
 							
 							
					});		
					
					
					
					
					$('#tree2').on('opened', function (evt, data) {
					
					tree2id=data.additionalParameters['id' ];
							//alert(tree2id);
					});
					
				        $( "#test" ).on('click', function(e) {
						
					//alert("tree1--"+tree1ids+"--------tree2--"+tree2ids);
							
						 var items = $('#tree2' ).tree('selectedItems'); 						 
					     var tIds='';
						 for (var i in items) {
							if (items.hasOwnProperty(i)) {  
							   var item = items[i];  
							   tIds += item.additionalParameters['id' ] + ",";
							}
						}
							
							$.ajax({
										url: "../../sysfunc_distributeFunc.action",//tree_singTree.action
										async:false,  
										type: 'POST',
										dataType: 'json',
										data:{ 
			 							   "roleId":tree1ids,
			 							   "funcIdStr":tIds,
			 							  
		 							    },
										success : function(data) {
										// alert("添加成功");
										bootbox.alert(data.success);
										},
										});
							
 							
 						})
				       
				      
			});
							
		</script>	
        <script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#01").addClass("active open");
				$("#0101").addClass("active");
			});
		</script>
    <!-- inline scripts related to this page -->
        <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155570&web_id=155570' language='JavaScript' charset='gb2312'></script></div>
    <!-- inline scripts related to this page -->
        <div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
