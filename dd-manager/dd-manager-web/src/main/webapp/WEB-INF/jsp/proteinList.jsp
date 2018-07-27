<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Protein</title>
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
    <img id="typeImg" style="display: inline">
    <h3 style="display: inline;vertical-align: bottom;margin-left: 150px;font-size: 25px;color: #C55A11">Related Proteins - ${drugName}</h3>
    <hr>
</div>
<div style="width:800px;height:auto;margin: 20px auto;">
    <table id="dgItems" style="width: 800px;"></table>
    <input type="hidden" id="drugName" value="${drugName}">
    <input type="hidden" id="type" value="${type}">
</div>
<script>
    $("#dgItems").datagrid({
        //允许多列排序
        multiSort:true,
        //在设置分页属性的时候，初始化页面大小选择列表
        pageList:[10,20,50],
        //请求服务器端数据
        url:'proteins/'+$('#drugName').val()+'/'+$('#type').val(),
        //请求方式，默认是POST
        method:'get',
        //是否显示分页工具栏
        pagination: true,
        fit: false,
        //只能选中一个
        singleSelect:true,
        //列属性
        columns:[[
            {field:'pname',title:'Protein Name',width:290,sortable:true},
            {field:'gene_symbol',title:'Gene Symbol',width:170,sortable:true},
            {field:'eg_id',title:'Gene ID',width:170,sortable:true},
            {field:'upkb',title:'UniProtKB',width:170,sortable:true}
        ]],
        onClickRow: function (rowIndex, rowData) {
            $(this).datagrid('unselectRow', rowIndex);
        }
    });
</script>
<div style="text-align: center;margin-top: 50px">
    <img src="${pageContext.request.contextPath}/images/bottom.png">
</div>
<script>
    var type = $('#type').val();
    if("hepatotoxicity" == type){
        $('#typeImg').attr("src","images/Hepatotoxicity.png");
    }
    if("nephrotoxicity" == type){
        $('#typeImg').attr("src","images/Nephrotoxicity.jpg");
    }
</script>
</body>
</html>
