<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
</head>
<body>
    <div id="main" style="width: 600px;height: 400px"></div>
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
</body>
</html>
