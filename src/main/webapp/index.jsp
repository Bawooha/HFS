<%@ page import="com.hfs.Tools" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>HFS</title>
</head>
<body>

<form action="FileReceiverServlet" enctype="multipart/form-data" method="post">
    <input type="file" name="up">
    <input type="submit">
</form>
<%
    //查询系统中已存在的文件列表
    String[] files = Tools.alreadyExistFiles();
    pageContext.setAttribute("files",files);
%>

<h2>查询系统中存在的文件</h2>
<form method="get">
    <input type="text" name="fileName">
    <button type="submit">搜索</button>
</form>

<h2>系统中已存在的文件如下</h2>

<c:forEach items="${pageScope.files}" var="fileName" varStatus="status">
    <a href="download?fileName=${fileName}">${fileName}</a>
    <br>
</c:forEach>


</body>
</html>
