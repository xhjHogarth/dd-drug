<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NetWork</title>
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
        <h3 style="display: inline;vertical-align: bottom;margin-left: 300px;font-size: 30px;color: #C55A11">NetWork</h3>
        <hr>
    </div>
    <div id="main" style="width: 940px;height: 800px;margin: 0 auto;margin-top: 30px"></div>
    <script type="text/javascript">
        //基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var graph = ${graph};
        myChart.hideLoading();
        var categories = [{name:'Drug'},{name:'Protein'},{name:'Enzyme'},{name:'Metabolite'}];
        graph.nodes.forEach(function (node) {
            node.itemStyle = null;
            node.symbolSize = node.size;
            node.x = node.y = null;
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
                layout:'force',
                data:graph.nodes,
                links:graph.links,
                categories:categories,
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
    <div style="width: 940px;margin: 0 auto">
        <input type="hidden" id="drugName" value="${drugName}">
        <input type="button" style="background-image: url(${pageContext.request.contextPath}/images/Data.jpg);
                margin-left: 300px;width: 110px;height: 35px;" onclick="">
        <input type="button" style="background-image: url(${pageContext.request.contextPath}/images/Analysis.png);
                margin-left: 100px;width: 140px;height: 35px;" onclick="">
    </div>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
