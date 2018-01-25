<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>首页</title>
    <style>
        .div1{
            border: 0px;
            font-weight: bold;
            font-size: 25px;
            background-color: white;
            margin-left: 30px;
            margin-top: 20px;
        }
        a{
            text-decoration: none;
            font-size: 25px;
            color: black;
            font-weight: bold;
        }
    </style>
    <script>
        function  aboutClick() {

        }
    </script>
</head>
<body>
<div style="margin-left: 5%;margin-top: 30px">
    <div style="float: left">
        <img src="images/1.png">
    </div>
    <div style="float: left;margin-top: 40px;">
        <button class="div1">HOME</button>
    </div>
    <div style="float: left;margin-top: 40px;">
        <ul style="list-style: none">
            <li>
                <a href="">BROWSE</a>
                <ul style="list-style: none">
                    <li><a href="">Drugs</a></li>
                    <li><a href="">Related Proteins</a></li>
                    <li><a href="">Metabolites</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div style="float: left;margin-top: 40px;">
        <button class="div1">DOWNLOAD</button>
    </div>
    <div style="float: left;margin-top: 40px;">
        <button class="div1">HELP</button>
    </div>
    <div style="float: left;margin-top: 40px;">
        <button class="div1" onclick="aboutClick()">ABOUT</button>
    </div>
    <div style="float: left;margin-top: 40px;">
        <input placeholder="Search by Drug,Protein or Metabolite" style="width: 250px;height: 60px;text-align: center;margin-left: 30px">
    </div>
    <div style="float: left;margin-top: 40px;">
        <input type="image" src="images/3.jpg">
    </div>
    <div>aaaa</div>
</div>

</body>
</html>
