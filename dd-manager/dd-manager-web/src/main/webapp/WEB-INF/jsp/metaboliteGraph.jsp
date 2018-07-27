<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Graph</title>
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
        <h3 style="display: inline;vertical-align: bottom;margin-left: 200px;font-size: 25px;color: #C55A11">Molecular Network - ${mname}</h3>
        <hr>
    </div>
    <div id="main" style="width: 1200px;height: 500px;margin: 30px auto;"></div>
    <%--<div style="margin: 0 auto;width: 600px">--%>
        <%--<h3 style="font-size: 25px;color: #C55A11">Information in the molecular network</h3>--%>
        <%--<table id="dgItems" style="width: 600px;"></table>--%>
    <%--</div>--%>
    <input type="hidden" id="mname" value="${mname}">
    <input type="hidden" id="type" value="${type}">
    <script type="text/javascript">
        //基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var graph = ${graph};
        myChart.hideLoading();
        var categories = [
            {name:'Drug',itemStyle:{normal:{color:"#0000FF"}}},
            {name:'Related Protein',itemStyle:{normal:{color:"#CD1076"}}},
            {name:'Enzyme',itemStyle:{normal:{color:"#00FF00"}}},
            {name:'Metabolite',itemStyle:{normal:{color:"#EE0000"}}}
            ];
        graph.nodes.forEach(function (node) {
            node.itemStyle = null;
            node.symbolSize = node.size;
            node.x = node.attributes.x;
            node.y = node.attributes.y;
            node.draggable = true;
        });
        var option = {
            tooltip:{},
            legend:[{
                data:categories.map(function (a) {
                    return a.name;
                })
            }],
            animation:false,
            series:[{
                name:'',
                type:'graph',
                layout:'none',
                data:graph.nodes,
                links:graph.links,
                categories:categories,
                focusNodeAdjacency:true,
                roam:true,
                label:{
                    normal:{
                        show:'false',
                        position:'right'
                    }
                },
                force:{
                    repulsion:100
                }
            }]
        }
        myChart.setOption(option);
    </script>
    <%--<script type="text/javascript">--%>
        <%--$("#dgItems").datagrid({--%>
            <%--//允许多列排序--%>
            <%--multiSort:true,--%>
            <%--//在设置分页属性的时候，初始化页面大小选择列表--%>
            <%--pageList:[10,20,50],--%>
            <%--//请求服务器端数据--%>
            <%--url:'listEdges3/'+$('#mname').val()+'/'+$('#type').val(),--%>
            <%--//请求方式，默认是POST--%>
            <%--method:'get',--%>
            <%--//是否显示分页工具栏--%>
            <%--pagination: true,--%>
            <%--fit: false,--%>
            <%--//只能选中一个--%>
            <%--singleSelect:true,--%>
            <%--//列属性--%>
            <%--columns:[[--%>
                <%--{field:'source',title:'Node 1',width:300},--%>
                <%--{field:'target',title:'Node 2',width:300}--%>
            <%--]]--%>
        <%--});--%>
    <%--</script>--%>
    <script>
        var type = $('#type').val();
        if("hepatotoxicity" == type){
            $('#typeImg').attr("src","images/Hepatotoxicity.png");
        }
        if("nephrotoxicity" == type){
            $('#typeImg').attr("src","images/Nephrotoxicity.jpg");
        }
    </script>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
