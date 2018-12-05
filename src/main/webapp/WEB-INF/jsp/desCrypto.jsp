<%--
  Created by IntelliJ IDEA.
  User: mxp
  Date: 2018/12/3
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-2.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/desCrypto.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <style>

        #exampleTextarea {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
    .string { color: green; }
    .number { color: darkorange; }
    .boolean { color: blue; }
    .null { color: magenta; }
    .key { color: red; }
    </style>
</head>
<body>
<div class="container" style="overflow-x:visible;overflow-y:visible;margin-top: 10px">
    <div class="starter-template">
        <pre id="result">

        </pre>
        <div class="row">
            <div class="col-md-12">
                <div class="form-group" >
                    <label for="exampleInput">密匙</label>
                    <input type="text" value="ch67rl1lzsri4bd6xuckwzk0" style="margin-bottom: 10px" class="form-control" id="exampleInput">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group" class="col-md-6">
                    <label for="exampleTextarea">输入域</label>
                    <textarea id="exampleTextarea" onblur="formatJson()"  style="resize:none;height: 500px;overflow-y:auto" class="form-control" rows="3"></textarea>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group" class="col-md-6">
                    <label for="exampleTextareas">结果</label>
                    <textarea id="exampleTextareas" style="resize:none;height: 500px;overflow-y:auto" class="form-control" rows="3"></textarea>
                </div>
            </div>
        </div>
        <button type="submit" onclick="enDes()" style="margin-top: 10px;width: 80px" class="btn btn-primary">加密</button>
        <button type="submit" style="margin-top: 10px;width: 80px" class="btn btn-primary">解密</button>
        <button type="submit" style="margin-top: 10px;width: 80px" class="btn btn-danger">清空</button>

    </div>
</div>
<input type="hidden" id="pageContext" value="${pageContext.request.contextPath}">
</body>
</html>
