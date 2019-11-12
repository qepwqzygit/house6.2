<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/31
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="vue.js"></script>
    <script>
        var app=new vue({
            el:"#app",
            message: 'Hello Vue!'

        })

    </script>
</head>
<body>
<div id="app1">
    {{ message }}
</div>
        <div id="app"></div>
        <h2>hello!</h2>

</body>
</html>
