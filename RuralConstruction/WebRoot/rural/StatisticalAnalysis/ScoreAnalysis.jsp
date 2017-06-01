<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
		<style type= "text/css">
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
							<li>统计分析</li>
							<li>时间序列分析</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class= "row">
							<div class="col-xs-12">
							
					<!-- PAGE CONTENT BEGINS -->
							
							<!-- 右半部分 -->
                              
					
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
															<div id="sales-charts"style="width:800px;height:500px"></div>
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
						
						<!-- PAGE CONTENT ENDS -->
				      </div >
				  </div><!--page-content-->
				
			  </div><!-- /.main-content -->

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
		<script src="assets/js/jquery-ui-1.10.3.full.min.js"></script>
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
		 <script src="assets/js/echarts.min.js"></script>
		<!-- 添加 -->

		<script type="text/javascript">
		  var myChart = echarts.init(document.getElementById('sales-charts'));
		  var myChart_1 = echarts.init(document.getElementById('num-charts'));
		
		// var lineData = "";
			// var lineData1 = "";
			  
				 
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
			
			
			
			$.ajax({
					url: "../../TownAver_townAverAnalysis.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.averList;
						
						
						//linechart();
						
						//var legends = [];// 准备存放图例数据  
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
					url: "../../TownNum_townStandardNum.action",
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
			  
			
			
			
		
		</script>
		<script type="text/javascript">
			$(function(){
			
				
		     		var s = $("#myTab4").width();
		     		//alert(s);
		     		$("#grid-table1").setGridWidth(s);
		        	$("#grid-pager1_left").removeAttr("style");
		        	$("#grid-table2").setGridWidth(s);
		        	$("#grid-table3").setGridWidth(s);
		        	$("#grid-pager2_left").removeAttr("style");
		        	$("#grid-pager3_left").removeAttr("style");
		        	
		     });
		
		</script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#09").addClass("active open");
				$("#0903").addClass("active");
				
				
			});
		</script>
		<!-- 添加end -->
		<!-- inline scripts related to this page -->
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>

