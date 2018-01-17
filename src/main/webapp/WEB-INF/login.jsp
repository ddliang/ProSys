<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaiLiang
  Date: 2018/1/13
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" href="${baseUrl}/layui/css/layui.css"  media="all">
    <script src="${baseUrl}/layui/layui.all.js" charset="utf-8"></script>
    <script src="${baseUrl}/layui/layui.js" charset="utf-8"></script>
    <title>登录</title>
</head>
<body>
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名:</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码:</label>
        <div class="layui-input-block">
            <input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
        </div>
    </div>
</form>
</body>
</html>
