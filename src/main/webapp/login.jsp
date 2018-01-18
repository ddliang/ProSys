<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DaiLiang
  Date: 2018/1/13
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css" rel="stylesheet" type="text/css" media="all">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.all.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
    <title>登录</title>
</head>
<body>
<div>
    <form class="layui-form" action="${pageContext.request.contextPath}/user/login.do" method="post" id="myform">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-block">
                <input type="text" name="title" lay-verify="name" autocomplete="off" placeholder="请输入用户名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码:</label>
            <div class="layui-input-block">
                <input type="text" name="title" lay-verify="pass" autocomplete="off" placeholder="请输入密码" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;
        //自定义验证规则
        form.verify({
            name: function(value){
                if(value.length < 5){
                    return '请输入用户名';
                }
            }
            //,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,pass:function(value){
                if(value.length<6){
                    return "密码必须6到12位";
                }
            }

        });
        //监听提交
        form.on('submit(demo1)', function(data){

             //return false;
        });
    });

   /* function  ajaxSumbit() {
        $.ajax({
            url:"user/login.do",
            type:"post",
            data:{username:1},
            success:function(data){
                window.location.href="/us";
            },
            error:function(e){
                alert("错误！！");

            }
        });
    }*/
</script>

</body>
</html>
