<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download</title>
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
<div>
    <jsp:include page="top.jsp"/>
    <div style="margin: 0 auto;width: 940px;height: 40px;margin-top: 20px;">
        <span style="font-size: 25px;color: #C55A11;">Download</span>
    </div>
    <div class="container" style="width: 900px;margin: 0 auto;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table">
                    <thead>
                    <tr class="info">
                        <th>Category</th>
                        <th>Description</th>
                        <th>File</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td rowspan="2" style="vertical-align: middle">Related proteins</td>
                        <td>Drug-included hepatotoxicity</td>
                        <td><a href="${pageContext.request.contextPath}/download.action?fileName=proteinH">Download</a></td>
                    </tr>
                    <tr>
                        <td>Drug-included nephrotoxicity</td>
                        <td><a href="${pageContext.request.contextPath}/download.action?fileName=proteinN">Download</a></td>
                    </tr>
                    <tr>
                        <td rowspan="2" style="vertical-align: middle">Differential metabolites</td>
                        <td>Drug-included hepatotoxicity</td>
                        <td><a href="${pageContext.request.contextPath}/download.action?fileName=metaboliteH">Download</a></td>
                    </tr>
                    <tr>
                        <td>Drug-included nephrotoxicity</td>
                        <td><a href="${pageContext.request.contextPath}/download.action?fileName=metaboliteN">Download</a></td>
                    </tr>
                    <tr><td></td><td></td><td></td></tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div style="text-align: center;margin-top: 200px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</div>
</body>
</html>
