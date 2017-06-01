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
								<div class="widget-body" style="position:absolute;height:100%; width:100%;overflow:auto">
									<div class="table-responsive">
										<div class="widget-main padding-8"style="height:100%" >
											<div id="tree1" class="tree" style="height:90%"></div>
										</div>
									</div>
								</div>
							</div>
							<!-- 右半部分 -->
							
							<div class="col-xs-9">	    
								
								   年份：<select id="yrs" onchange="yearChange()">
										</select>&nbsp;&nbsp;&nbsp;
								 统计图：<select style="max-width:180px" id="selline" onchange="lineChange()" >
								     <option value="0">个数统计图</option>
								     <option value="1">百分比统计图</option>
								     </select>
								 <div id="line" style="width: 900px;height:500px;"> </div>
								 <div id="line2" style="width: 900px;height:500px;"> </div>
								 
								
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
		
		 
			
		  var a1=0;
		  var a2=0;
		  var a3=0;
		  var a4=0;
		  var a5=0;
		  var a6=0;
		  var a7=0;
		  var colltime;
		  var treeSel;//选中父节点的值
		  var sum;//总村庄个数
		  
		 var linevalue ;	//用于获取选择框选中的值
		 
		 linechart();
		 
		 //改变年份时
		 function yearChange()  
			{  
				colltime = document.getElementById("yrs").value;	
				linevalue = document.getElementById("selline").value;
		  		$.ajax({
							url: "../../scolev_scoLevStatistics.action?JQID="+treeSel+"&&collTime="+colltime,
							datatype:"json",
							type:'post',
							
							success:function(data)	//success callback
							{   
								var json = data.count;
								
								var json = data.count;
								a1 = json[0];					
								a2 = json[1];					
								a3 = json[2];					
								a4 = json[3];					
								a5 = json[4];					
								a6 = json[5];					
								a7 = json[6];	
								sum=a1+a2+a3+a4+a5+a6+a7;	
											
								if(linevalue =="0"){
									var a = document.getElementById("line").style.display='block';
									var b = document.getElementById("line2").style.display='none';
									
								}else{
									var a = document.getElementById("line").style.display='none';
									var b = document.getElementById("line2").style.display='block';
									
								} 
									linechart();
									linechart2();		
								
								
							},
						});
		   
				} 
		
		//改变选择统计图时
		 function lineChange()  
			{  
				colltime = document.getElementById("yrs").value;	
				linevalue = document.getElementById("selline").value;
		  		$.ajax({
							url: "../../scolev_scoLevStatistics.action?JQID="+treeSel+"&&collTime="+colltime,
							datatype:"json",
							type:'post',
							success:function(data)	//success callback
							{   
								var json = data.count;
								
								var json = data.count;
								a1 = json[0];					
								a2 = json[1];					
								a3 = json[2];					
								a4 = json[3];					
								a5 = json[4];					
								a6 = json[5];					
								a7 = json[6];		
								sum=a1+a2+a3+a4+a5+a6+a7;	
								linechart2();		
								if(linevalue =="0"){
									var a = document.getElementById("line").style.display='block';
									var b = document.getElementById("line2").style.display='none';
									
								}else{
									var a = document.getElementById("line").style.display='none';
									var b = document.getElementById("line2").style.display='block';
									
								}
									linechart();
									linechart2();										
								
							},
						});
		   
				} 
		
		
		
		
		
		//个数统计图
		  function linechart(){
		  var myChart = echarts.init(document.getElementById('line'));
		  	option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'cross',
							crossStyle: {
								color: '#999'
							}
						}
					},
					toolbox: {
						feature: {
							dataView: {show: true, readOnly: false},
							magicType: {show: true, type: ['line', 'bar']},
							restore: {show: true},
							saveAsImage: {show: true}
						}
					},
					legend: {
						data:['本级分数以上','本级分数以下','本级村庄个数']
					},
					xAxis: [
						{
							type: 'category',
							data: ['0-500分','500-600分','600-700分','700-800分','800-900分','900-1000分','1000-1100分'],
							axisPointer: {
								type: 'shadow'
							}
						}
					],
					yAxis: [
						{
							type: 'value',
							name: '村庄个数（单位：个）',
							min: 0,
							max: a1+a2+a3+a4+a5+a6+a7+4,
							interval: Math.ceil((a1+a2+a3+a4+a5+a6+a7+4)/10) ,
							axisLabel: {
								formatter: '{value}'
							}
						},
						
					],
					series: [
						
						{
							name:'本级分数以上',
							type:'line',
							data:[a1+a2+a3+a4+a5+a6+a7, a2+a3+a4+a5+a6+a7, a3+a4+a5+a6+a7, a4+a5+a6+a7, a5+a6+a7,a6+a7,a7]
						},
						{
							name:'本级分数以下',
							type:'line',
							data:[a1, a1+a2, a1+a2+a3, a1+a2+a3+a4, a1+a2+a3+a4+a5, a1+a2+a3+a4+a5+a6, a1+a2+a3+a4+a5+a6+a7]
						},
						{
							name:'本级村庄个数',
							type:'bar',
							data:[a1, a2, a3, a4, a5, a6, a7]
						}
					]
				};
		  
		  	 myChart.setOption(option);
		  }
		  
		  
		  //百分比统计图
		  function linechart2(){
			  var myChart = echarts.init(document.getElementById('line2'));
			  	option = {
						tooltip: {
							trigger: 'axis',
							axisPointer: {
								type: 'cross',
								crossStyle: {
									color: '#999'
								}
							}
						},
						toolbox: {
							feature: {
								dataView: {show: true, readOnly: false},
								magicType: {show: true, type: ['line', 'bar']},
								restore: {show: true},
								saveAsImage: {show: true}
							}
						},
						legend: {
							data:['本级分数以上','本级分数以下','本级村庄个数']
						},
						xAxis: [
							{
								type: 'category',
								data: ['0-500分','500-600分','600-700分','700-800分','800-900分','900-1000分','1000-1100分'],
								axisPointer: {
									type: 'shadow'
								}
							}
						],
						yAxis: [
							{
								type: 'value',
								name: '村庄个数百分比',
								min: 0,
								max: 100,
								interval: 10 ,
								axisLabel: {
									formatter: '{value}%'
								}
							},
							
						],
						series: [
							
							{
								name:'本级分数以上',
								type:'line',
								data:[((a1+a2+a3+a4+a5+a6+a7)/sum)*100, ((a2+a3+a4+a5+a6+a7)/sum)*100,((a3+a4+a5+a6+a7)/sum)*100,((a4+a5+a6+a7)/sum)*100,((a5+a6+a7)/sum)*100,((a6+a7)/sum)*100,(a7/sum)*100]
							},
							{
								name:'本级分数以下',
								type:'line',
								data:[(a1/sum)*100, ((a1+a2)/sum)*100, ((a1+a2+a3)/sum)*100, ((a1+a2+a3+a4)/sum)*100, ((a1+a2+a3+a4+a5)/sum)*100, ((a1+a2+a3+a4+a5+a6)/sum)*100, ((a1+a2+a3+a4+a5+a6+a7)/sum)*100]
							},
							{
								name:'本级村庄个数',
								type:'bar',
								data:[(a1/sum)*100, (a2/sum)*100, (a3/sum)*100, (a4/sum)*100, (a5/sum)*100, (a6/sum)*100, (a7/sum)*100]
							}
						]
					};
			  
			  	 myChart.setOption(option);
		  }
		  
		  
			jQuery(function($){
			
			
			//年份下拉框
			
			$.ajax({
			        async: false,
			        type: "POST",
			        url:  "../../CTVRank_getYears.action",
			        dataType: "json",
			        success: function (dataMap) {
			            for (var i = 0; i < dataMap.years.length; i++) {
			            	if(i!=0)
			                	$("#yrs").append("<option value='"+dataMap.years[i]+"'>" + dataMap.years[i] + "</option>");
			                else
			                	$("#yrs").append("<option value='"+dataMap.years[i]+"' selected='selected'>" + dataMap.years[i] + "</option>");
			            }
			            
			        }
			    });
			
			
			
			
			
			
			
			
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
							colltime = document.getElementById("yrs").value;	
							linevalue = document.getElementById("selline").value;
		                 treeSel= ids;
		                 	
		                   $.ajax({
								url: "../../scolev_scoLevStatistics.action?JQID="+treeSel+"&&collTime="+colltime,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									var json = data.count;
									
									a1 = json[0];					
									a2 = json[1];					
									a3 = json[2];					
									a4 = json[3];					
									a5 = json[4];					
									a6 = json[5];					
									a7 = json[6];	
								   sum=a1+a2+a3+a4+a5+a6+a7;
									
									if(linevalue =="0"){
										var a = document.getElementById("line").style.display='block';
										var b = document.getElementById("line2").style.display='none';
										
									}else{
										var a = document.getElementById("line").style.display='none';
										var b = document.getElementById("line2").style.display='block';
										
									}
									linechart();
										linechart2();		
									
								},
							});
							
							
 		               
						});
 		               
						
					
					$('#tree1').on('opened', function (evt, data) {
					ids="";
							 is = data.additionalParameters['id' ] ;
							treeSel= is;
							
							colltime = document.getElementById("yrs").value;
							linevalue = document.getElementById("selline").value;
							$.ajax({
								url: "../../scolev_scoLevStatistics.action?JQID="+treeSel+"&&collTime="+colltime,
								datatype:"json",
								type:'post',
								success:function(data)	//success callback
								{   
									var json = data.count;
									
									var json = data.count;
									a1 = json[0];					
									a2 = json[1];					
									a3 = json[2];					
									a4 = json[3];					
									a5 = json[4];					
									a6 = json[5];					
									a7 = json[6];					
									sum=a1+a2+a3+a4+a5+a6+a7;	
									if(linevalue =="0"){
										var a = document.getElementById("line").style.display='block';
										var b = document.getElementById("line2").style.display='none';
										
									}else{
										var a = document.getElementById("line").style.display='none';
										var b = document.getElementById("line2").style.display='block';
										
									}
										linechart();
										linechart2();		
									
									
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

