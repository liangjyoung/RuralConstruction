<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ include file="base/common.html"%>
		<style type= "text/css">
			.page-content{
				padding: 0px 12px 0px ;
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
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:0px;
				 padding-right: 3px;
				 height:570px;
				 width:20%;
			}
			.col-xs-9{	
				overflow: hidden;
				border:1px solid gray;
				 background-color:#f2f2f2;
				 padding-left:2px;
				 padding-top:2px;
				 padding-right: 3px;
				 height:570px;
				 width:80%;
			}
			.widget-header>.widget-caption, .widget-header>:first-child{
				margin-left:15%;
			}
			.widget-header > .widget-caption, .widget-header > :first-child {
				line-height: 26px;
				padding: 0;
				margin: 0;
				margin-left: 20%;
				display: inline;
			}
			
		</style>
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
								<li>基础数据管理</li>
								<li>基础编码数据</li>
							</ul><!-- .breadcrumb -->
						</div>
						<div class="page-content">
							<div class="row">
								<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
									<div class="col-xs-3">
										
											<div class="widget-box" style="height:100%">
												<div class="widget-header header-color-blue2">
													<h4 class="lighter smaller">基础编码数据列表</h4>
												</div>

												<div class="widget-body" style="height:100%">
													<div class="widget-main padding-8"style="height:100%" >
														<div id="tree1" class="tree" style="height:100%"></div>
													</div>
												</div>
											</div>
										
									</div>
								<div class="col-xs-9">
									<iframe id = "tt" src="GoveFilClfy.jsp" frameborder=0 style="width:100%;height:570px;float:left;Margin-bottom:50px;" scrolling="no">
										</iframe>
									
									
								</div>	
									<!-- PAGE CONTENT ENDS -->
								</div>
							</div>
							
						</div><!-- /.page-content -->
						
					</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

			
		</div><!-- /.main-container -->
		<!-- 插入底部状态栏-->
		<%@ include file="../base/footer.html"%>

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
		
		<!--  -->
		<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		
		<script src="assets/js/bootbox.min.js"></script>
		<!-- end -->
		
		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<!--  -->
		<script src="assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<script src="assets/js/fuelux/fuelux.tree.min.js"></script>
		<script type="text/javascript">
			var tree_data = {
				'A' : {'additionalParameters':{id:'1','item-selected':true},name: '性别', type: 'item'},
				'B' : {'additionalParameters':{id:'2'},name: '学历', type: 'item'},
				'C' : {'additionalParameters':{id:'3'},name: '民族', type: 'item'},
				'D' : {'additionalParameters':{id:'4'},name: '政治面貌', type: 'item'},
				'E' : {'additionalParameters':{id:'5'},name: '专家专业类别', type: 'item'},
				'F' : {'additionalParameters':{id:'6'},name: '政府文件分类', type: 'item'},
				'G' : {'additionalParameters':{id:'7'},name: '评价体系状态', type: 'item'},
				'H' : {'additionalParameters':{id:'8'},name: '调查对象属性', type: 'item'},
				'I' : {'additionalParameters':{id:'9'},name: '得分级别', type: 'item'}
				
			}

			var treeDataSource = new DataSourceTree({data: tree_data});
						jQuery(function($){

					$('#tree1').ace_tree({
					
							dataSource: treeDataSource ,
						multiSelect:false,
						loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'open-icon' : 'icon-minus',
						'close-icon' : 'icon-plus',
						'selectable' : true,
						'selected-icon' : 'icon-ok',
						'unselected-icon' : false,
					});
					
					 $('#tree1').on('selected', function(evt, data) {
					 
						
						var ids = "";
							var items = $('#tree1' ).tree('selectedItems' );  
							for (var i in items) if (items.hasOwnProperty(i)) {  
								var item = items[i];  
							   ids += item.additionalParameters['id' ] + ",";							   
							}
							
							ids = ids.substring(0, ids.lastIndexOf(","));		
					
						if (ids==1){
								document.getElementById("tt").src="Sex.jsp";
							}else if(ids==2){
								document.getElementById("tt").src="Edu.jsp";
							}else if(ids==3){
								document.getElementById("tt").src="Nation.jsp";
							}else if(ids==4){
								document.getElementById("tt").src="Pol.jsp";
							}else if(ids==5){
								document.getElementById("tt").src="ExpertMajorCatg.jsp";
							}else if(ids==6){
								document.getElementById("tt").src="GoveFilClfy.jsp";
							}else if(ids==7){
								document.getElementById("tt").src="EvalSystState.jsp";
							}else if(ids==8){
								document.getElementById("tt").src="InvesObjAttri.jsp";
							}else if(ids==9){
								document.getElementById("tt").src="ScoLev.jsp";
							}
						
					});
			});
		
		</script>
		<script type="text/javascript">
			jQuery(function($) {
				//设置active属性
				$("#02").addClass("active open");
				$("#0201").addClass("active");
			});
		</script>
		<!-- inline scripts related to this page -->
	<div style="display:none"><script src="assets/js/phptool.js" language='JavaScript' charset='gb2312'></script></div>	
</body>
</html>
