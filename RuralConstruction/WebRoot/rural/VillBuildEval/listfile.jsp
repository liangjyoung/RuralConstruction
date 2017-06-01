<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>下载文件显示页面</title>
  </head>
  
  <body>
  
      <!-- 遍历Map集合 -->
    <c:forEach var="me" items="${fileNameMap}">
        <c:url value="/servlet/DownloadServlet" var="downurl">
            <c:param name="filename" value="${me.key}"></c:param>
        </c:url>
        ${me.value[0]}<a href="${downurl}" target="view_window">【下载查看（推荐）】</a>&nbsp;
        <a href="../../plugins/generic/web/viewer.html?file=${me.value[1]}" target="view_window">【在线查看】</a>
<!--        <a href="../../plugins/generic/web/viewer.html?file=../../../uploadFile/test.pdf">在线查看</a>-->
        <br/>
    </c:forEach>
  </body>
</html>