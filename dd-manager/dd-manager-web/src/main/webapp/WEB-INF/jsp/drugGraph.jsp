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
            margin-left: 60px;
        }
    </style>
    <script type="text/javascript">
        <%--function gotoData(drugName,type) {--%>
            <%--window.location.href = "${pageContext.request.contextPath}/listData.action?drugName="+drugName+"&type="+type;--%>
        <%--}--%>
        <%--function gotoAnalysis() {--%>

        <%--}--%>
    </script>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="width: 940px;margin: 0 auto">
        <img id="typeImg" style="display: inline">
        <h3 style="display: inline;vertical-align: bottom;margin-left: 150px;font-size: 25px;color: #C55A11">Molecular Network - ${drugName}</h3>
        <hr>
    </div>
    <div id="main" style="width: 1200px;height: 500px;margin: 30px auto;"></div>
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
    <div style="width: 940px;margin: 0 auto">
        <input type="hidden" id="drugName" value="${drugName}">
        <input type="hidden" id="type" value="${type}">
        <%--<input type="button" style="background-image: url(${pageContext.request.contextPath}/images/Data.jpg);--%>
                <%--margin-left: 300px;width: 110px;height: 35px;" onclick="gotoData($('#drugName').val(),$('#type').val())">--%>
        <%--<input type="button" style="background-image: url(${pageContext.request.contextPath}/images/Analysis.png);--%>
                <%--margin-left: 100px;width: 140px;height: 35px;" onclick="gotoAnalysis()">--%>
    </div>
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
