<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
    <%@include file="quote.jsp"%>
    <style>
        .top_ul{
            list-style-type: none;
            margin: 0px;
            padding: 0px;
        }
        .top_a{
            text-decoration: none;
            font-size: 18px;
            color: white;
            margin-left: 60px;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="width: 940px;margin: 0 auto">
        <img src="${pageContext.request.contextPath}/images/Hepatotoxicity.png" style="display: inline">
        <h3 style="display: inline;vertical-align: bottom;margin-left: 300px;font-size: 30px;color: #C55A11">Data</h3>
        <hr>
        <h3 style="font-size: 20px;color: #C55A11">Edge Information</h3>
    </div>
    <div style="width: 600px;margin: 0 auto">
        <input type="hidden" id="drugName" value="${drugName}">
        <input type="hidden" id="type" value="${type}">
        <table id="dgItems"></table>
    </div>
    <script>
        $('#dgItems').datagrid({
            rownumbers:true,
            pageList:[10,20],
            url:'listEdges/'+$('#drugName').val()+'/'+$('#type').val(),
            method:'get',
            singleSelect:true,
            pagination: true,
            columns:[[
                {field:'source',title:'Node1',width:300},
                {field:'target',title:'Node2',width:300}
            ]]
        });
    </script>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
