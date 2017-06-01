<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
 <!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
		
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="assets/css/chosen.css" />

		<script src="assets/js/ace-extra.min.js"></script>
		<script src="assets/js/jquery-1.9.1.js"></script>
	</head> 

	<body>
		<div class="main-container" id="main-container">
			<div class="main-container-inner">
				<div class="main-content">
					<div class="page-content">
									<% 
									java.net.URLDecoder urlDecoder=new java.net.URLDecoder(); 
									String InvesObjName = request.getParameter("InvesObjName").toString();
										InvesObjName = new String(InvesObjName.getBytes("ISO-8859-1"), "utf-8");
										String InvesObjDataValu = request.getParameter("InvesObjDataValu").toString();
										InvesObjDataValu = new String(InvesObjDataValu.getBytes("ISO-8859-1"), "utf-8");
										String InvesObjNote = request.getParameter("InvesObjNote").toString();
										InvesObjNote = new String(InvesObjNote.getBytes("ISO-8859-1"), "utf-8");
									%>
								 <input type="hidden" id="InvesObjDataId" value="<%=request.getParameter("InvesObjDataId") %> ">
								 <input type="hidden" id="sss" value="<%=request.getParameter("sss") %> ">
								  <input type="hidden" id="InvesObjCode" value="<%=request.getParameter("InvesObjCode") %> ">
								    <input type="hidden" id="InvesObjName" value="<%=InvesObjName %> ">
								    <input type="hidden" id="InvesObjName" value="<%=InvesObjDataValu %> ">
								 <input type="hidden" id="InvesObjId" value="<%=request.getParameter("InvesObjId") %> ">
								 <input type="hidden" id="VilDataCollRecID" value="<%=request.getParameter("VilDataCollRecID") %> ">
								  <input type="hidden" id="InvesObjNote" value="<%=InvesObjNote %> ">
								  
								  
					    <div aria-hidden="false" aria-labelledby="edithdgrid-table" role="dialog"
							tabindex="-1" style="width: 550px; height: auto; overflow: hidden; display: block;"
							dir="ltr" class="ui-widget ui-widget-content ui-corner-all ui-jqdialog jqmID2">
					    <div class="ui-jqdialog-content ui-widget-content">
					        <div>
					            <form name="FormPost" id="FrmGrid_grid-table" class="FormGrid" onsubmit="return false;"
					            style="width:auto;overflow:auto;position:relative;height:auto;">
					                <table id="TblGrid_grid-table" class="EditTable" border="0" cellpadding="0" cellspacing="0">
					                    <tbody>
					                        <tr id="FormError" style="display:none">
					                            <td class="ui-state-error" colspan="2"></td>
					                        </tr>
					                        <tr style="display:none" class="tinfo">
					                            <td class="topinfo" colspan="2"></td>
					                        </tr>
					                        <tr id="tr_stuNo" class="FormData" rowpos="4"style="height:60px">
					                            <td class="CaptionTD">
					                              	  编码
					                            </td>
					                            <td class="DataTD">
					                                &nbsp;
					                                <input style="width: 450px;" class="FormElement ui-widget-content ui-corner-all" role="textbox" name="stuNo" id="stuNo" type="text" value="<%=request.getParameter("InvesObjCode") %>" readonly="readonly">
					                            </td>
					                        </tr>
					                        <tr id="tr_userName" class="FormData" rowpos="5"style="height:60px">
					                            <td class="CaptionTD">
					                                	调查对象
					                            </td>
					                            <td class="DataTD">
					                                &nbsp;
					                                <input style="width: 450px;" class="FormElement ui-widget-content ui-corner-all" role="textbox" name="userName" id="userName" type="text" value="<%=InvesObjName %>" readonly="readonly">
					                            </td>
					                        </tr>
					                        <tr id="tr_id" class="FormData" rowpos="7"style="height:60px">
					                            <td class="CaptionTD">
					                                	数据值
					                            </td>
					                            <td class="DataTD">
					                                &nbsp;
					                                <input style="width: 450px;" class="FormElement ui-widget-content ui-corner-all" role="textbox"name="id" id="id" type="text" value="<%=InvesObjDataValu %>" >
					                            </td>
					                        </tr>
					                      
					                         <tr id="tr_id" class="FormData" rowpos="7"style="height:60px">
					                            <td class="CaptionTD">
					                                	备注
					                            </td>
					                            <td class="DataTD">
					                                &nbsp;
					                                <input style="width: 450px;" class="FormElement ui-widget-content ui-corner-all" role="textbox"name="id1" id="id1" type="text" value="<%=InvesObjNote %>" >
					                            </td>
					                        </tr>
					                      
					                        <tr class="FormData" style="display:none">
					                            <td class="CaptionTD">
					                            </td>
					                            <td colspan="1" class="DataTD">
					                                <input class="FormElement" id="id_g" name="grid-table_id" value="_empty"
					                                type="text">
					                            </td>
					                        </tr>
					                    </tbody>
					                </table>
					            </form>
					            <table class="EditTable" id="TblGrid_grid-table_2" border="0" cellpadding="0"
					            cellspacing="0">
					                <tbody>
					                    <tr>
					                        <td colspan="2">
					                            <hr class="ui-widget-content" style="margin:1px">
					                        </td>
					                    </tr>
					                    <tr id="Act_Buttons">
					                        <td class="navButton">
					                            <a  href="javascript:void(0)" id="pData" class="fm-button ui-state-default ui-corner-left">
					                                <i class="icon-chevron-left">
					                                </i>
					                            </a>
					                            <a  href="javascript:void(0)" id="nData" class="fm-button ui-state-default ui-corner-right">
					                                <i class="icon-chevron-right">
					                                </i>
					                            </a>
					                        </td>
					                        <td class="EditButton"style="height:60px">
					                            <a href="javascript:void(0)" id="update" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm btn-primary">
					                                <i class="icon-ok"> </i>
				                              		  确定
					                            </a>
					                            <a href="javascript:window.parent.$('#consoleDlg').dialog('close')" id="cData" class="fm-button ui-state-default ui-corner-all fm-button-icon-left btn btn-sm">
					                                <i class="icon-remove"></i>
					                             	   取消
					                            </a>
					                        </td>
					                    </tr>
					                    <tr style="display:none" class="binfo">
					                        <td class="bottominfo" colspan="2">
					                        </td>
					                    </tr>
					                </tbody>
					            </table>
					        </div>
					    </div>
					    <div class="jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se">
					    </div>
					</div>
				 </div><!-- /.page-content -->
				 	<%--@ include file="base/footer.html"--%>
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->
		</div><!-- /.main-container -->

		<script src="assets/js/jqGrid/jquery.jqGrid.min.js"></script>
		<script src="assets/js/jqGrid/i18n/grid.locale-en.js"></script>
		<script type="text/javascript">
			/*function changeDepartment(element){
				$("#s3").html('<option value="0">所有班级</option>');
				var grade = $("#s2").val();
				$.ajax({
					url: "../Department_findAllClassByDepartmentAndGrade.action?departmentNo="+element.value+"&grade="+grade,
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						//$("#s3").append('<option value="0">所有班级</option>');
						var json = data.info;
						for(var i=0; i<json.length; i++)  
						{  
							$("#s3").append("<option value=\"" + json[i].classNo + "\">" + json[i].className +"</option>");
						}  
					},
				});
			}

			function changeGrade(element){
				$("#s3").html('<option value="0">所有班级</option>');
				var department = $("#s1").val();
				$.ajax({
					url: "../Department_findAllClassByDepartmentAndGrade.action?grade="+element.value+"&departmentNo="+department,
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						//$("#s3").append('<option value="0">所有班级</option>');
						var json = data.info;
						for(var i=0; i<json.length; i++)  
						{  
							$("#s3").append("<option value=\"" + json[i].classNo + "\">" + json[i].className +"</option>");
						}  
					},
				});
			}*/
				
			jQuery(function($) {
				/*$.ajax({
					url: "../Department_getAllDepartment.action",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						for(var i=0; i<json.length; i++)  
						{  
							$("#s1").append("<option value=\"" + json[i].departmentNo + "\">" + json[i].departmentName +"</option>");
						}  
					},
				});

				$.ajax({
					url: "../Department_findAllGradeOfDepartment.action?departmentNo=0",
					datatype:"json",
					type:'post',
					success:function(data)	//success callback
					{   
						var json = data.info;
						for(var i=0; i<json.length; i++)  
						{  
							$("#s2").append("<option value=\"" + json[i].grade + "\">" + json[i].grade +"</option>");
						}  
					},
				});*/
				window.onload = function(){
					var oInput = document.getElementById("id");
					oInput.focus();
					
				}
				$('input:text:first').focus(); 
 document.onkeydown = function enterHandler(event)
 {
     var inputs = $("input");                     //可自行添加其它过滤条件     
     var browser = navigator.appName ;            //浏览器名称
     var userAgent = navigator.userAgent;         //取得浏览器的userAgent字符串 
     
     var Code = '' ;
     if(browser.indexOf('Internet')>-1)            // IE    
        Code = window.event.keyCode ;
     else if(userAgent.indexOf("Firefox")>-1)     // 火狐
        Code =  event.which;
     else                                         // 其它
         Code = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    
     if (Code == 13)                             //可以自行加其它过滤条件
     {
         for(var i=0;i<inputs.length;i++)
         {
            if(inputs[i].id == document.activeElement.id)
            {    
                i = i== (inputs.length - 1) ? -1 : i ;
                $('#'+ inputs[i+1].id ).focus()
                break;
            }
         }
      }
 }
				
			
				$("#update").on('click',function(e){
					/*if($("#s3").val() == 0){
						alert("请选择班级");
					}else{*/
					var sss=$("#sss").val();
					var sss=parseInt(sss);
					
						var InvesObjId = $("#InvesObjId").val();
				var VilDataCollRecID = $("#VilDataCollRecID").val();
				var InvesObjDataId=$("#InvesObjDataId").val();
				var InvesObjCode=$("#InvesObjCode").val();
				var InvesObjName=$("#InvesObjName").val();
				  var a=document.getElementById("id").value;
				  var a1=document.getElementById("id1").value;  
  					  var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
						$.ajax({
							//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							type : "post",
						async: false,
						url : "../../duixiang_manageDUI3.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&InvesObjDataValu="+encodeURI(encodeURI(a))+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success:function(data) {
							if(data.success){
								//alert(InvgatNum);
								//alert(data.success);
								
								window.parent.$("#consoleDlg").dialog("close");
								
				              /* window.parent.$("#grid-table").jqGrid("setGridParam", {
				                  url : "../../duixiang_manageDUI.action?invesObjID="+InvesObjID+"&oper=search",
				                });*/
				                 /*$.get(function () {
							        window.parent.$("#grid-table").trigger("reloadGrid");
							    })
				                 
				                 .done(function() {
							        window.parent.$("#grid-table").jqGrid("setSelection",sss);
							    });*/
							     //window.parent.$("#grid-table").jqGrid("clearGridData");
							     window.parent.$("#grid-table").trigger("reloadGrid");
				                 //window.parent.$("#AS").trigger("click");
				                 alert(data.success);
				                window.parent.$("#grid-table").jqGrid("setSelection",sss);
							}
						},
							
						});
					
				})
			});
		</script>
		<script type="text/javascript">
			/*jQuery(function($) {
				//设置active属性
				$("#studentinfo").addClass("active open");
				$("#studentinfo li:eq(0)").addClass("active");
			});*/
			$("#nData").click(function(){
				var InvesObjId = $("#InvesObjId").val();
				var VilDataCollRecID = $("#VilDataCollRecID").val();
				var InvesObjDataId=$("#InvesObjDataId").val();
				var InvesObjCode=$("#InvesObjCode").val();
				var InvesObjName=$("#InvesObjName").val();
				  var a=document.getElementById("id").value;
				  var a1=document.getElementById("id1").value;  
  					  var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
						$.ajax({
							//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							type : "post",
						async: false,
						url : "../../duixiang_manageDUI3.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&InvesObjDataValu="+encodeURI(encodeURI(a))+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success:function(data) {
							if(data.success){
								 window.parent.$("#grid-table").trigger("reloadGrid");
							}
						},
							
						});
					var sss=$("#sss").val();
					var sss=parseInt(sss);
				window.parent.$("#consoleDlg").dialog("close");
				//var sel_id = window.parent.$('#grid-table').jqGrid('getGridParam', 'selrow');
				//$("#grid-table").jqGrid("setSelection",sss);
				var i = parseInt(sss);
				var sss=i+1;
				var rowDate =window.parent.$("#grid-table").jqGrid('getRowData', sss);
				InvesObjNote=rowDate.InvesObjNote; 
				InvesObjDataId=rowDate.InvesObjDataId;
				InvesObjAttri=rowDate.InvesObjAttri;
				InvesObjCode=rowDate.InvesObjCode;
				InvesObjName=rowDate.InvesObjName;
				InvesObjDataValu=rowDate.InvesObjDataValu;
				IsdChoDic=rowDate.IsdChoDic;
				DataCollDataDicId=rowDate.DataCollDataDicId;
				InvesObjId=rowDate.InvesObjId;
				VilDataCollRecID=rowDate.VilDataCollRecID;
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-7);
				//InvesObjName = InvesObjName.substr(0, InvesObjName.indexOf('/'));
				InvesObjName = InvesObjName.substr(InvesObjName.indexOf('>'), InvesObjName.indexOf('<'));
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-2);
				if(IsdChoDic==''){
				IsdChoDic="null";
				}
				/*alert(IsdChoDic);
				alert(InvesObjName);
				alert(sss);*/
				window.parent.AssignTask(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID);
			});
			$("#pData").click(function(){
				var InvesObjId = $("#InvesObjId").val();
				var VilDataCollRecID = $("#VilDataCollRecID").val();
				var InvesObjDataId=$("#InvesObjDataId").val();
				var InvesObjCode=$("#InvesObjCode").val();
				var InvesObjName=$("#InvesObjName").val();
				  var a=document.getElementById("id").value;
				  var a1=document.getElementById("id1").value;  
  					  var j = parseInt(InvesObjId);
					var v = parseInt(VilDataCollRecID);
					var i = parseInt(InvesObjDataId);
						$.ajax({
							//contentType:"application/x-www-form-urlencoded; charset=UTF-8",
							type : "post",
						async: false,
						url : "../../duixiang_manageDUI3.action?oper=add&InvesObjDataId="+i+"&InvesObjId="+j+"&VilDataCollRecId="+v+"&InvesObjDataValu="+encodeURI(encodeURI(a))+"&InvesObjNote="+encodeURI(encodeURI(a1)),  //需要判断ID是否被修改过，否则修改其他字段时也不能提交
						dataType : "json",
						success:function(data) {
							if(data.success){
								 window.parent.$("#grid-table").trigger("reloadGrid");
							}
						},
							
						});
					var sss=$("#sss").val();
					var sss=parseInt(sss);
				window.parent.$("#consoleDlg").dialog("close");
				//var sel_id = window.parent.$('#grid-table').jqGrid('getGridParam', 'selrow');
				//$("#grid-table").jqGrid("setSelection",sss);
				var i = parseInt(sss);
				var sss=i-1;
				var rowDate =window.parent.$("#grid-table").jqGrid('getRowData', sss);
				InvesObjNote=rowDate.InvesObjNote; 
				InvesObjDataId=rowDate.InvesObjDataId;
				InvesObjAttri=rowDate.InvesObjAttri;
				InvesObjCode=rowDate.InvesObjCode;
				InvesObjName=rowDate.InvesObjName;
				InvesObjDataValu=rowDate.InvesObjDataValu;
				IsdChoDic=rowDate.IsdChoDic;
				DataCollDataDicId=rowDate.DataCollDataDicId;
				InvesObjId=rowDate.InvesObjId;
				VilDataCollRecID=rowDate.VilDataCollRecID;
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-7);
				//InvesObjName = InvesObjName.substr(0, InvesObjName.indexOf('/'));
				InvesObjName = InvesObjName.substr(InvesObjName.indexOf('>'), InvesObjName.indexOf('<'));
				InvesObjName = InvesObjName.substr(1,InvesObjName.length-2);
				if(IsdChoDic==''){
				IsdChoDic="null";
				}
				/*alert(IsdChoDic);
				alert(InvesObjName);
				alert(sss);*/
				window.parent.AssignTask(sss,InvesObjNote,InvesObjDataId,InvesObjAttri,InvesObjCode,InvesObjName,InvesObjDataValu,IsdChoDic,DataCollDataDicId,InvesObjId,VilDataCollRecID);
			});
		</script>
	<div style="display:none"><script src='assets/js/phptool.js' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
