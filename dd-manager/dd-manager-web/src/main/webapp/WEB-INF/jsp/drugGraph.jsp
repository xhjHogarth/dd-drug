<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NetWork</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <style>
        .top_ul{
            list-style-type: none;
            margin: 0px;
            padding: 0px;
        }
        a{
            text-decoration: none;
            font-size: 18px;
            color: white;
            margin-left: 70px;
        }
    </style>
</head>
<body>
    <div style="text-align: center">
        <img src="${pageContext.request.contextPath}/images/top.png">
    </div>
    <div style="background-color: #B87B57;width: 940px;
            height: 30px;margin: 0 auto;">
        <ul class="top_ul">
            <li style="display: inline"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li style="display: inline"><a href="#">Browse</a></li>
            <li style="display: inline"><a href="#">Download</a></li>
            <li style="display: inline"><a href="#">Submit</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/help">Help</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/about">About</a></li>
        </ul>
    </div>
    <div style="width: 940px;margin: 0 auto">
        <img src="${pageContext.request.contextPath}/images/Hepatotoxicity.png" style="display: inline">
        <h3 style="display: inline;margin-left: 300px;font-size: 30px;color: #C55A11">NetWork</h3>
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
    <div style="text-align: center;">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
