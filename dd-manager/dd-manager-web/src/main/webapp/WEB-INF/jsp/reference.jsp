<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reference</title>
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
            margin-left: 70px;
        }
    </style>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="width: 940px;margin: 0 auto">
        <img src="${pageContext.request.contextPath}/images/Hepatotoxicity.png" style="display: inline">
        <h3 style="display: inline;vertical-align: bottom;margin-left: 250px;font-size: 30px;color: #C55A11">References</h3>
        <hr>
    </div>
    <div style="width:400px;height:auto;margin: 20px auto;">
        <table id="dgItems"></table>
        <input type="hidden" id="drugName" value="${drugName}">
    </div>
    <script>
        $("#dgItems").datagrid({
            rownumbers:true,
            //允许多列排序
            multiSort:true,
            //在设置分页属性的时候，初始化页面大小选择列表
            pageList:[10,20,50],
            //请求服务器端数据
            url:'references/'+$('#drugName').val(),
            //请求方式，默认是POST
            method:'get',
            //是否显示分页工具栏
            pagination: true,
            fit: false,
            //只能选中一个
            singleSelect:true,
            //列属性
            columns:[[
                {field:'pmid',title:'PMID',width:370,sortable:true}
            ]]
        });
    </script>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
