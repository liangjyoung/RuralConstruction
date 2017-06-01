<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>

	</head>
<style type= "text/css">
			.ui-jqgrid tr.jqgrow td {
			white-space: normal !important;
			height:auto;
			}
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
			.col-xs-3{	
				 width:16%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:570px;
			}
			.col-xs-9{	
				 width:84%;
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:570px;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 30px;
				padding: 0;
				margin: 0;
				margin-left: 18%;
				display: inline;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 18%;
				display: inline;
			}
			.space{
			background:#ccc;
			max-height:2px;
			min-height:2px;
			margin-bottom:1px;
			margin-top:2px;
		}
		.tab-content {
    		padding: 0px;
    		}
		</style>
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
							<li>专家评价</li>
							<li>专家打分</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="col-xs-12">
								

								<ul class="nav nav-tabs  tab-color-blue background-blue" id="myTab4">
										<li class="active">
											<a data-toggle="tab" href="#totalscore">
													村庄总得分排序
											</a>
										</li>
										<li>
											<a data-toggle="tab" href="#firstlevelscore">
													一级指标得分排序
											</a>
										</li>
								</ul>
							<div class="tab-content">
								<div>
									<label for="form-field-select-3">请选择年份</label>
									<select id="yrs" onchange="yearChange()">
									
									</select>
								</div>
								<div id="totalscore" class="tab-pane in active">
									 <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
									 <div id="tolscoreorder" style="width: 1000px;height:450px;"></div>
								</div>
								<div id="firstlevelscore" class="tab-pane ">
									<div class="col-xs-3">
										<div class="widget-box"style="height:100%">
											<div class="widget-header header-color-blue2">
												<h4 class="lighter smaller">一级指标</h4>
											</div>
											<div class="widget-body"style="height:80%">
												<div class="widget-main">
													<div id="tree1" class="tree"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-xs-9">
									<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
									 <div id="firstlevelscoreorder" style="width: 1000px;height:400px;"></div>
									 </div>
								</div>
							</div>
								
						</div><!-- col-xs-12 -->
					</div><!-- page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->
		<!-- 插入底部状态栏-->
		<%@ include file="base/footer.html"%>
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
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
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<script src="assets/js/chosen.jquery.min.js"></script>
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree.min.js"></script>
		<script src="js/echarts.min.js"></script>
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
			                else
			                	$("#yrs").append("<option value='"+dataMap.years[i]+"' selected='selected'>" + dataMap.years[i] + "</option>");
			            }
			            loadOption($('#yrs option:selected').val());
			        }
			    });
			    
			});
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('tolscoreorder'));
        var myChart_1 = echarts.init(document.getElementById('firstlevelscoreorder'));

        // 指定图表的配置项和数据
        var option = {
		    title: {
		        text: '村庄总分排序'
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    legend: {
		        data: []
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: [
		    	{
		    		type: 'category',
		        	data: []
		    	}
		    ],
		    yAxis:
		    [ 
			    {
			        type: 'value',
			        boundaryGap: [0, 0.01]
			    }
			],
		    series: [
		        {
		            name: '总分',
		            type: 'bar',
		            barWidth: '20',
		            data: []
		        }
		    ]
		};
		var option_1 = {
		    title: {
		        text: '村庄一级指标排序'
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
		    legend: {
		        data: []
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: [
		    	{
		    		type: 'category',
		        	data: []
		    	}
		    ],
		    yAxis:
		    [ 
			    {
			        type: 'value',
			        boundaryGap: [0, 0.01]
			    }
			],
		    series: [
		        {
		            name: '总分',
		            type: 'bar',
		            barWidth: '20',
		            data: []
		        }
		    ]
		};
		//loadOption($('#yrs option:selected').val());
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        myChart_1.setOption(option_1);
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
		        url: '../../TownScoreOrder_totalScoreOrder.action?yr='+year,  
		        type: 'get',  
		        dataType: 'json',  
		        async: false,  
		        success: function (dataMap) {  
		            if (dataMap)  
		            {  
		                //var option = MYCHART._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
		                if (dataMap.seriesData == null) {  
		                    option.series[0].data = [''];  
		                    option.xAxis[0].data = ['']  
		                }  
		                else {  
		                    option.series[0].data = dataMap.seriesData;  
		                    option.xAxis[0].data = dataMap.xAxisData;  
		                }  
		                myChart.setOption(option,true);  
		            }  
		        },  
		        error: function ()  
		        {  
		            alert("请求失败!");  
		        }  
		    })  
		}
		function loadOption_1(year,indNum)  
		{  
		    $.ajax({  
		        url: '../../TownFirstLevelScoreOrder_firstLevelIndOrder.action?year='+year+'&indNum='+indNum,  
		        type: 'get',  
		        dataType: 'json',  
		        async: false,  
		        success: function (dataMap) {  
		            if (dataMap)  
		            {  
		                //var option = MYCHART._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
		                if (dataMap.seriesData == null) {  
		                    option_1.series[0].data = [''];  
		                    option_1.xAxis[0].data = ['']  
		                }  
		                else {  
		                    option_1.series[0].data = dataMap.seriesData;  
		                    option_1.xAxis[0].data = dataMap.xAxisData;  
		                }  
		                myChart_1.setOption(option_1,true);  
		            }  
		        },  
		        error: function ()  
		        {  
		            alert("请求失败!");  
		        }  
		    })  
		}
		jQuery(function($){
          	 	//定义树的数据结构形式——————这是个对象
          	 	var tree_data;
           		
				//后台调用action得到数据并赋值给tree_data
				$.ajax({
						url: "../../TownFirstLevelScoreOrder_getFirstLevelInd.action",//tree_singTree.action
						async:false,  
						type: 'POST',
						dataType: 'json',
						success : function(data) {
						tree_data=data.tree;
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
					
					loadOption_1($('#yrs option:selected').val(),ids);
						
				});		
					
			});  
    </script>
  </body>
</html>
