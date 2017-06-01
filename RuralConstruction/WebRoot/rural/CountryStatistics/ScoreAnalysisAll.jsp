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
								<div class="widget-header header-color-blue2">
									<h4 class="lighter smaller">区划分布</h4>
								</div>
								<div class="widget-body" style="position:absolute;height:100%; width:100%;overflow:auto">
									<div class="table-responsive">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:100%"></div>
										</div>
									</div>
								</div>
							</div>
							<!-- 右半部分 -->
							<div class="col-xs-9">	    
										<ul class="nav nav-tabs  tab-color-blue background-blue" id="myTab4">
										<li id = "zhe" class = "active">
											<a data-toggle="tab" href = "#lineChart" id ="line">
													各年平均分折线图
											</a>
										</li>
										<li id = "zhexian">
											<a data-toggle="tab" href = "#lineChartNum" id ="linenum">
													各年度达标村庄数目折线图
											</a>
										</li>
								
								</ul>
								<div class="tab-content">
								
										<div id="lineChart" class="tab-pane in active">
											<div class="row">							
													<div class="widget-header widget-header-flat" id ="lin">
														<h4 class="lighter">
															<i class="icon-signal"></i>
															各年平均分折线图
														</h4>
									
													</div>
													<div class="widget-body">
														<div class="widget-main padding-4">
															<div id="sales-charts"style="width:500px;height:500px"></div>
														</div><!-- /widget-main -->
													</div><!-- /widget-body -->
							
											</div>
										</div>
										
										<div id="lineChartNum" class="tab-pane">
											<div class="row">							
													<div class="widget-header widget-header-flat" id ="count">
														<h4 class="lighter">
															<i class="icon-signal"></i>
															各年度达标村庄数目折线图
														</h4>
									
													</div>
													<div class="widget-body">
														<div class="widget-main padding-4">
															<div id="num-charts"style="width:500px;height:500px"></div>
														</div><!-- /widget-main -->
													</div><!-- /widget-body -->
							
											</div>
										</div>
								
								</div>
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
		
		<script src="assets/js/flot/jquery.flot.min.js"></script>
		<script src="assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="assets/js/bootbox.min.js"></script>
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<!-- 添加 -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		 <script src="assets/js/echarts.min.js"></script>
		
		<script type="text/javascript">
		  var myChart = echarts.init(document.getElementById('sales-charts'));
		  var myChart_1 = echarts.init(document.getElementById('num-charts'));
		
	 
				var option = {
						    
						    tooltip: {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['平均分']
						    },
						    toolbox: {
						        show: true,
						        feature: {
						            dataZoom: {
						                yAxisIndex: 'none'
						            },
						            dataView: {readOnly: false},
						            magicType: {type: ['line', 'bar']},
						            restore: {},
						            saveAsImage: {}
						        }
						    },
						    xAxis:  {
						        type: 'category',
						        data: []
						    },
						    yAxis: {
						     type: 'value',
						      
						    //  data: ['100','200','300','400','500','600','700','800','900','1000']
						        
						    },
						    series: [
						        {
						            name:'平均分',
						            type:'line',
						            data:[]
						            
						            
						        },
						   
						    ]
						};
					
					var option_1 = {
						    
						    tooltip: {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['达标数目']
						    },
						    toolbox: {
						        show: true,
						        feature: {
						            dataZoom: {
						                yAxisIndex: 'none'
						            },
						            dataView: {readOnly: false},
						            magicType: {type: ['line', 'bar']},
						            restore: {},
						            saveAsImage: {}
						        }
						    },
						    xAxis:  {
						        type: 'category',
						        data: []
						    },
						    yAxis: {
						     type: 'value',
						      
						    //  data: ['100','200','300','400','500','600','700','800','900','1000']
						        
						    },
						    series: [
						        {
						            name:'达标数目',
						            type:'line',
						            data:[]
						            
						            
						        },
						   
						    ]
						};
					
				
				
				  myChart.setOption(option);
				  myChart_1.setOption(option_1);
			
			jQuery(function($){
			//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
           		//定义表的名字
           		var ids="";
           		var is="";
           		 var lineData = "";
			    var lineData1 = "";
				var grid_selector = "#grid-table";
				//定义页数的名字
				var pager_selector = "#grid-pager";
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../AdmiTree_queryAllCompartmentAsTree.action",//tree_singTree.action
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
							
		   
 		               
 		                $.ajax({
								url: "../../AllAver_allAverAnalysis.action?JQID="+ids,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									    var json = data.averList;
									
										var Series = []; // 准备存放图表数据  
								        var XAxis = [];
								        //var json = jsons.data;// 后台返回的json  
								        for(var i=0;i < json.length;i++){  
								           
								           // it.name = json[i].name;// 先将每一项填充数据  
								            //legends.push(json[i].name);// 将每一项的图例名称也放到图例的数组中  
								            XAxis.push(json[i].collTime);
								            //alert(json[i].vilEvaAver);
								            Series.push(json[i].vilEvaAver);
								        }  
								           
								       
								       // option.xAxis.data = json[i].collTime;// 这一步是设置X轴数据了，需要注意：option.xAxis.data = json.xcontent这样不行  
								                              // 折线图可设置上下两个X轴，所以必须是option.xAxis[0].data = json.xcontent  
								                     //option.legend.data = legends;// 设置图例  
								                             option.xAxis.data= XAxis ;
								                              option.series[0].data = Series; // 设置图表  
								                              myChart.setOption(option);// 重新加载图表  
								                       },  
								                       error:function(){  
								                              alert("数据加载失败！请检查数据链接是否正确");  
								                       } 
						            
									
									
							});
							
							$.ajax({
								url: "../../AllNum_allStandardNum.action?JQID="+ids,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									var json1 = data.numList;
									
									 var Series1 = []; // 准备存放图表数据  
							        var XAxis1 = [];
							        //var json = jsons.data;// 后台返回的json  
							        for(var i=0;i < json1.length;i++){  
							           
							           // it.name = json[i].name;// 先将每一项填充数据  
							            //legends.push(json[i].name);// 将每一项的图例名称也放到图例的数组中  
							            XAxis1.push(json1[i].collTime);
							            //alert(json[i].vilEvaAver);
							            Series1.push(json1[i].vilEvaNum);
							        }  
							           
							       
							       // option.xAxis.data = json[i].collTime;// 这一步是设置X轴数据了，需要注意：option.xAxis.data = json.xcontent这样不行  
							                              // 折线图可设置上下两个X轴，所以必须是option.xAxis[0].data = json.xcontent  
							                     //option.legend.data = legends;// 设置图例  
							                             option_1.xAxis.data= XAxis1 ;
							                              option_1.series[0].data = Series1; // 设置图表  
							                              myChart_1.setOption(option_1);// 重新加载图表  
							                       },  
							                       error:function(){  
							                              alert("数据加载失败！请检查数据链接是否正确");  
							                       } 	
									
									
							});
							
						});
 		               
						
					
					$('#tree1').on('opened', function (evt, data) {
					ids="";
							 is = data.additionalParameters['id' ] ;
							
							$.ajax({
								url: "../../AllAver_allAverAnalysis.action?JQID="+is,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									 var json = data.averList;
									
										var Series = []; // 准备存放图表数据  
								        var XAxis = [];
								        //var json = jsons.data;// 后台返回的json  
								        for(var i=0;i < json.length;i++){  
								           
								           // it.name = json[i].name;// 先将每一项填充数据  
								            //legends.push(json[i].name);// 将每一项的图例名称也放到图例的数组中  
								            XAxis.push(json[i].collTime);
								            //alert(json[i].vilEvaAver);
								            Series.push(json[i].vilEvaAver);
								        }  
								           
								       
								       // option.xAxis.data = json[i].collTime;// 这一步是设置X轴数据了，需要注意：option.xAxis.data = json.xcontent这样不行  
								                              // 折线图可设置上下两个X轴，所以必须是option.xAxis[0].data = json.xcontent  
								                     //option.legend.data = legends;// 设置图例  
								                             option.xAxis.data= XAxis ;
								                              option.series[0].data = Series; // 设置图表  
								                              myChart.setOption(option);// 重新加载图表  
								                       },  
								                       error:function(){  
								                              alert("数据加载失败！请检查数据链接是否正确");  
								                       } 
						            
							});
							
							$.ajax({
								url: "../../AllNum_allStandardNum.action?JQID="+is,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									var json1 = data.numList;
									
									 var Series1 = []; // 准备存放图表数据  
							        var XAxis1 = [];
							        //var json = jsons.data;// 后台返回的json  
							        for(var i=0;i < json1.length;i++){  
							           
							           // it.name = json[i].name;// 先将每一项填充数据  
							            //legends.push(json[i].name);// 将每一项的图例名称也放到图例的数组中  
							            XAxis1.push(json1[i].collTime);
							            //alert(json[i].vilEvaAver);
							            Series1.push(json1[i].vilEvaNum);
							        }  
							           
							       
							       // option.xAxis.data = json[i].collTime;// 这一步是设置X轴数据了，需要注意：option.xAxis.data = json.xcontent这样不行  
							                              // 折线图可设置上下两个X轴，所以必须是option.xAxis[0].data = json.xcontent  
							                     //option.legend.data = legends;// 设置图例  
							                             option_1.xAxis.data= XAxis1 ;
							                              option_1.series[0].data = Series1; // 设置图表  
							                              myChart_1.setOption(option_1);// 重新加载图表  
							                       },  
							                       error:function(){  
							                              alert("数据加载失败！请检查数据链接是否正确");  
							                       } 	
									
							});
							
						});	
				
			
			
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

