<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>eCharts测试</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.js"></script>
</head>
<body>
    <%--为Echarts准备一个具备大小(宽高)的DOM--%>
    <div id="main" style="width: 600px;height: 400px"></div>
    <script type="text/javascript">
        //基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        //指定图标的配置项和数据
        var option = {
            title:{
                text:'Echats 入门示例'
            },
            tooltip:{},
            legend:{
                data:['销量']
            },
            xAxis:{
                data:["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis:{},
            series:[{
                name:'销量',
                type:'bar',
                data:[5,20,36,10,10,20]
            }]
        };
        var option2 = {
            legend:{},
            tooltip:{},
            dataset:{
                //提供一份数据
                source:[
                    ['product','2015','2016','2017'],
                    ['Matcha Latte', 43.3, 85.8, 93.7],
                    ['Milk Tea', 83.1, 73.4, 55.1],
                    ['Cheese Cocoa', 86.4, 65.2, 82.5],
                    ['Walnut Brownie', 72.4, 53.9, 39.1]
                ]
            },
            //声明一个x轴，类目轴(category)，默认情况下,类目轴对应到dataset第一列
            xAxis:{type:'category'},
            //声明一个y轴，数值轴
            yAxis:{},
            //声明多个bar系列，默认情况下，每个系列会自动对应到dataset的每一列
            series:[
                {type:'bar'},
                {type:'bar'},
                {type:'bar'}
            ]
        };
        var option3 = {
            legend:{},
            tooltip:{},
            dataset:{
                //这里指定了维度名的顺序，从而可以利用默认的维度到坐标轴的映射
                //如果不指定dimensions，也可以通过制定series.encod完成映射
                dimensions:['product','2015','2016','2017'],
                source:[
                    {product: 'Matcha Latte', '2015': 43.3, '2016': 85.8, '2017': 93.7},
                    {product: 'Milk Tea', '2015': 83.1, '2016': 73.4, '2017': 55.1},
                    {product: 'Cheese Cocoa', '2015': 86.4, '2016': 65.2, '2017': 82.5},
                    {product: 'Walnut Brownie', '2015': 72.4, '2016': 53.9, '2017': 39.1}
                ]
            },
            xAxis:{type:'category'},
            yAxis:{},
            series:[
                {type:'bar'},
                {type:'bar'},
                {type:'bar'}
            ]
        };
        var option4 = {
            legend: {},
            tooltip: {},
            dataset: {
                source: [
                    ['product', '2012', '2013', '2014', '2015'],
                    ['Matcha Latte', 41.1, 30.4, 65.1, 53.3],
                    ['Milk Tea', 86.5, 92.1, 85.7, 83.1],
                    ['Cheese Cocoa', 24.1, 67.2, 79.5, 86.4]
                ]
            },
            xAxis:[
                {type:'category',gridIndex:0},
                {type:'category',gridIndex:1}
            ],
            yAxis:[
                {gridIndex:0},
                {gridIndex:1}
            ],
            grid:[
                {bottom:'55%'},
                {top:'55%'}
            ],
            series:[
                //这几个系列会在第一个直角坐标系中，每个系列对应到dataset的每一行
                {type:'bar',seriesLayoutBy:'row'},
                {type:'bar',seriesLayoutBy:'row'},
                {type:'bar',seriesLayoutBy:'row'},
                //这几个系列会在第二个直角坐标系中，每个系列对应到dataset的每一列
                {type:'bar',xAxisIndex:1,yAxisIndex:1},
                {type:'bar',xAxisIndex:1,yAxisIndex:1},
                {type:'bar',xAxisIndex:1,yAxisIndex:1},
                {type:'bar',xAxisIndex:1,yAxisIndex:1}
            ]
        };
        var option5 = {
            dataset:{
                source: [
                    ['score', 'amount', 'product'],
                    [89.3, 58212, 'Matcha Latte'],
                    [57.1, 78254, 'Milk Tea'],
                    [74.4, 41032, 'Cheese Cocoa'],
                    [50.1, 12755, 'Cheese Brownie'],
                    [89.7, 20145, 'Matcha Cocoa'],
                    [68.1, 79146, 'Tea'],
                    [19.6, 91852, 'Orange Juice'],
                    [10.6, 101852, 'Lemon Juice'],
                    [32.7, 20112, 'Walnut Brownie']
                ]
            },
            xAxis: {},
            yAxis: {type: 'category'},
            series:[
                {
                    type:'bar',
                    encode:{
                        x:'amount',
                        y:'product'
                    }
                }
            ]
        };
        var option6 = {
            xAxis:{type:'value'},
            yAxis:{type:'value'},
            dataZoom:[
                {
                    //这个dataZoom组件，默认控制x轴
                    type:'slider',//这个dataZoom组件是slider型dataZoom组件
                    xAxisIndex:0,
                    start:10,//左边在10%的位置
                    end:60//右边在60%的位置
                },
                {
                    //这个dataZoom组件，默认控制x轴
                    type:'inside',//这个dataZoom组件是inside型dataZoom组件
                    xAxisIndex:0,
                    start:10,//左边在10%的位置
                    end:60//右边在60%的位置
                },
                {
                    //这个dataZoom组件，默认控制x轴
                    type:'slider',//这个dataZoom组件是slider型dataZoom组件
                    yAxisIndex:0,
                    start:10,//左边在10%的位置
                    end:60//右边在60%的位置
                },
                {
                    //这个dataZoom组件，默认控制x轴
                    type:'inside',//这个dataZoom组件是inside型dataZoom组件
                    yAxisIndex:0,
                    start:10,//左边在10%的位置
                    end:60//右边在60%的位置
                }
            ],
            series:[
                {
                    type:'scatter',//这个是散点图
                    itemStyle:{
                        opacity:0.8
                    },
                    symbolSize:function (val) {
                        return val[2]*40;
                    },
                    data: [["14.616","7.241","0.896"],["3.958","5.701","0.955"],["2.768","8.971","0.669"],
                        ["9.051","9.710","0.171"],["14.046","4.182","0.536"],["12.295","1.429","0.962"],
                        ["4.417","8.167","0.113"],["0.492","4.771","0.785"],["7.632","2.605","0.645"],
                        ["14.242","5.042","0.368"]]
                }
            ]
        };
        var option7 = {
            xAxis:{
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis:{},
            series:[{
                name:'销量',
                type:'bar',
                data:[5,20,36,10,10,20]
            }]
        };
        var symbolSize = 20;
        var data = [[15, 0], [-50, 10], [-56.5, 20], [-46.5, 30], [-22.1, 40]];
//        myChart.setOption({
//            xAxis:{
//                min:-100,
//                max:80,
//                type:'value',
//                axisLine:{onZero:false}
//            },
//            yAxis:{
//                min:-30,
//                max:60,
//                type:'value',
//                axisLine:{onZero:false}
//            },
//            series:[
//                {
//                    id:'a',
//                    type:'line',
//                    smooth:true,
//                    symbolSize:symbolSize,
//                    data:data
//                }
//            ]
//        });
//        myChart.setOption({
//            graphic:echarts.util.map(data,function (dataItem,dataIndex) {
//                return{
//                    type:'circle',
//                    shape:{
//                        r:symbolSize
//                    },
//                    position:myChart.convertToPixel('grid',dataItem),
//                    invisible:true,
//                    draggable:true,
//                    z:100,
//                    ondrag:echarts.util.curry(onPointDragging,dataIndex)
//                }
//            })
//        });
//        function onPointDragging(dataIndex) {
//            data[dataIndex] = myChart.convertFromPixel('grid',this.position);
//            myChart.setOption({
//                series:[{
//                    id:'a',
//                    data:data
//                }]
//            });
//        }
//        window.addEventListener('resize',function () {
//            myChart.setOption({
//                graphic:echarts.util.map(data,function (item,dataIndex) {
//                    return{
//                        position:myChart.convertToPixel('grid',item)
//                    };
//                })
//            });
//        });
        var graph = {
            "nodes":[
                {
                    'name':'节点1',
                    'attributes':{},
                    'id':'node1',
                    'size':20,
                    'category':0
                },
                {
                    'name':'节点2',
                    'attributes':{},
                    'id':'node2',
                    'size':20,
                    'category':1
                },
                {
                    'name':'节点3',
                    'attributes':{},
                    'id':'node3',
                    'size':20,
                    'category':1
                },
                {
                    'name':'节点4',
                    'attributes':{},
                    'id':'node4',
                    'size':20,
                    'category':1
                },
                {
                    'name':'节点5',
                    'attributes':{},
                    'id':'node5',
                    'size':20,
                    'category':2
                },
                {
                    'name':'节点6',
                    'attributes':{},
                    'id':'node6',
                    'size':20,
                    'category':2
                },
                {
                    'name':'节点7',
                    'attributes':{},
                    'id':'node7',
                    'size':20,
                    'category':2
                }
            ],
            "links":[
                {
                    'source':'node1',
                    'target':'node2'
                },
                {
                    'source':'node1',
                    'target':'node3'
                },
                {
                    'source':'node1',
                    'target':'node4'
                },
                {
                    'source':'node2',
                    'target':'node3'
                },
                {
                    'source':'node2',
                    'target':'node3'
                },
                {
                    'source':'node3',
                    'target':'node5'
                },
                {
                    'source':'node3',
                    'target':'node6'
                },
                {
                    'source':'node2',
                    'target':'node6'
                },
                {
                    'source':'node2',
                    'target':'node7'
                },
                {
                    'source':'node5',
                    'target':'node7'
                },
                {
                    'source':'node6',
                    'target':'node7'
                }
            ]
        };
        myChart.hideLoading();
        var categories = [];
        for(var i = 0;i<3;i++){
            categories[i] = {
                name:'类型'+i
            };
        }
        graph.nodes.forEach(function (node) {
            node.itemStyle = null;
            node.symbolSize = node.size;
            node.x = node.y = null;
            node.draggable = true;
        });
        var option8 = {
            title:{
                text:'demo',
                subtext:'Default layout',
                top:'bottom',
                left:'right'
            },
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
        };
        myChart.setOption(option8);
    </script>
</body>
</html>
