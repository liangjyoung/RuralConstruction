<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="base/common.html"%>
		<style type= "text/css">
		  .table-header{
			text-align:center;
		  }
		  .span{background-color:#f2f2f2;
		   height:35px;
		   border-bottom:1px solid gray;
		   
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
				 height:600px;
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
								<div class="widget-body" style="position:absolute;height:90%; width:100%;overflow:auto">
									<div class="table-responsive">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:100%"></div>
										</div>
									</div>
								</div>
							</div>
							<!-- 右半部分 -->
							
							<div class="col-xs-9">	    
								
								   年份：<select id="yrs" onchange="yearChange()">
										</select>&nbsp;&nbsp;&nbsp;
								项目：
								<select id="item" onchange="itemChange()">
									<option value="total" selected="selected">总平均分排名</option>
									<option value="firstlevel">一级指标平均分排名</option>
								</select>&nbsp;&nbsp;&nbsp;
								一级指标：
								<select id="s_firstlevel" onchange="indChange()">
								</select>
								 <div id="ctvrank" style="width: 880px;height:480px;" > </div>
								 

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
		<script src="assets/js/echartss.min.js"></script>
		<!-- 添加 -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.treeno.min.js"></script>
		<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('ctvrank'));
        var treeSel;
        var output = "";
		$(document).ready(function () {
		    $.ajax({
		        async: false,
		        type: "POST",
		        url: "../../CTVRank_getYears.action",
		        dataType: "json",
		        success: function (dataMap) {
		            for (var i = 0; i < dataMap.years.length; i++) {
		            	if(i!=0)
		                	$("#yrs").append("<option value='"+dataMap.years[i]+"'>" + dataMap.years[i] + "</option>");
		                else
		                	$("#yrs").append("<option value='"+dataMap.years[i]+"' selected='selected'>" + dataMap.years[i] + "</option>");
		            }
		            myChart.showLoading();
		            loadOption($('#yrs option:selected').val());
		        }
		    });
		    
		});
        

        // 指定图表的配置项和数据
        var option = {
		    title: {
		        text: '',
		        top : 'bottom',
		        left : 'center',
		        textStyle: {
		        color: '#333',
		        fontStyle: 'normal',
		        fontWeight: 'lighter',
		        fontFamily: 'sans-serif',
		        fontSize: 15,
		        },
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
		        bottom: '5%',
		        containLabel: true
		    },
		    xAxis: [
		    	{
		    		name:'行政区划',
		    		nameRotate: 270,
		    		type: 'category',
		        	data: []
		    	}
		    ],
		    yAxis:
		    [ 
			    {
			    	name:'分数（分）',
			        type: 'value',
			        boundaryGap: [0, 0.01]
			    }
			],
		    series: [
		        {
		            name: '总分',
		            type: 'bar',
		            barWidth: '20',
		            data: [],
		            label: {
		                normal: {
		                    show: true,
		                    position: 'top',
		                },
		            },
		        }
		    ],
		    toolbox: { //可视化的工具箱
                show: true,
                feature: {
                    dataView: { //数据视图
                        show: true
                    },
                    restore: { //重置
                        show: true
                    },
                    dataZoom: { //数据缩放视图
                        show: true
                    },
                    saveAsImage: {//保存图片
                        show: true
                    },
                    magicType: {//动态类型切换
                        type: ['bar', 'line']
                    }
                }
            },
		};
		
		//loadOption($('#yrs option:selected').val());
        // 使用刚指定的配置项和数据显示图表。
        ////myChart.setOption(option);
        //myChart_1.setOption(option_1);
        function itemChange()
        {
        	if($('#item option:selected').val() == "firstlevel")
        		getFirstLevelInd();//获得一级指标添加到下拉列表中
        	else
        		document.getElementById("s_firstlevel").options.length = 0; 
        	loadOption($('#yrs option:selected').val());
        }
        function getFirstLevelInd()
        {
        	$.ajax({
				url: "../../CTVRank_getFirstLevelInd.action",//tree_singTree.action
				async:false,  
				type: 'POST',
				dataType: 'json',
				success : function(dataMap) {
					for (var i = 0; i < dataMap.firstLevelIndNum.length; i++) {
		            	if(i!=0)
		                	$("#s_firstlevel").append("<option value='"+dataMap.firstLevelIndNum[i]+"'>" + dataMap.firstLevelIndName[i] + "</option>");
		                else
		                	$("#s_firstlevel").append("<option value='"+dataMap.firstLevelIndNum[i]+"' selected='selected'>" + dataMap.firstLevelIndName[i] + "</option>");
		            }
		            //myChart.showLoading();
		            //loadOption($('#yrs option:selected').val());
				},
			});
        }
        function indChange()
        {
        	loadOption($('#yrs option:selected').val());
        }
        function yearChange()  
		{  
		    //var year = $(selectObj).val();  
		    //alert(year);
		    myChart.showLoading();
		    loadOption($('#yrs option:selected').val());
		} 
		//ajax 异步加载配置数据项  
		function loadOption(year)  
		{  
			
		    $.ajax({  
		        url: '../../CTVRank_CTVRank.action?year='+year+'&treeDiviCode='+treeSel+'&selectedItem='+$('#item option:selected').val()+'&selectedFirstLevelInd='+$('#s_firstlevel option:selected').val(),  
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
		                option.title.text = output+dataMap.graphName;
		                myChart.hideLoading();
		                myChart.setOption(option,true);  
		                
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
           		//定义表的名字
           		var ids="";
           		var is="";
           		var colltime = "";
           		output="";
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
							output ="";
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
							colltime = document.getElementById("yrs").value;	

		                 	treeSel= ids;
		                 	
		                   $.ajax({
								url: "../../CTVRank_CTVRank.action?treeDiviCode="+treeSel+"&year="+colltime+'&selectedItem='+$('#item option:selected').val()+'&selectedFirstLevelInd='+$('#s_firstlevel option:selected').val(),  
								datatype:"json",
								type:'post',
								success:function(dataMap)	//success callback
								{   
									if (dataMap)  
						            {  
						                //var option = MYCHART._option;  //e2中感觉这个命名十分奇怪，居然要这样获取，必须先设置才有这个属性  
						                if (dataMap.seriesData == null) {  
						                    option.series[0].data = [''];  
						                    option.xAxis[0].data = [''];
						                }  
						                else {  
						                
						                    option.series[0].data = dataMap.seriesData;  
						                    option.xAxis[0].data = dataMap.xAxisData;  
						                }  
						                option.title.text = output+dataMap.graphName;
						                myChart.hideLoading();
						                myChart.setOption(option,true);  
						                
						            }		
									
								},
							});
							
							
 		               
						});
 		               
						
					
					$('#tree1').on('opened', function (evt, data) {
							ids="";
							 is = data.additionalParameters['id' ] ;
							 output = data.name;
							treeSel= is;
							
							colltime = document.getElementById("yrs").value;
							
							$.ajax({
								url: "../../CTVRank_CTVRank.action?treeDiviCode="+treeSel+"&year="+colltime+'&selectedItem='+$('#item option:selected').val()+'&selectedFirstLevelInd='+$('#s_firstlevel option:selected').val(),  
								datatype:"json",
								type:'post',
								success:function(dataMap)	//success callback
								{   
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
						                option.title.text = output+dataMap.graphName;
						                myChart.hideLoading();
						                myChart.setOption(option,true);  
						                
						            }		
									
								},
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

