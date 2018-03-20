<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tables</title>
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
        <h3 style="display: inline;margin-left: 300px;font-size: 30px;color: #C55A11">Edge Information</h3>
        <hr>
    </div>
</body>
</html>
