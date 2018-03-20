<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Browse</title>
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
<div>
    <jsp:include page="top.jsp"/>
    <div style="width: 940px;height: 140px;margin: 20px auto">
        <img src="${pageContext.request.contextPath}/images/Browse.png">
    </div>
    <div style="width: 940px;margin: 0 auto">
        <form>

        </form>
    </div>
</div>
</body>
</html>
