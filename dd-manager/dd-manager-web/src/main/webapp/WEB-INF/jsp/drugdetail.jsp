<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drug</title>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        a{
            color: #CF5A11;
        }
        td{
            height: 30px;
        }
    </style>
    <script>
        function showNetWork() {
            var drugName = $("#drugName").val();
            window.location.href="${pageContext.request.contextPath}/drugGraph.action?drugName="+drugName;
        }
    </script>
</head>
<body>
    <div style="text-align: center">
        <img src="${pageContext.request.contextPath}/images/top.png">
    </div>
    <div style="background-color: #B87B57;width: 940px;
            height: 30px;margin: 0 auto;">
        <ul class="top_ul">
            <li style="display: inline"><a href="${pageContext.request.contextPath}/" class="top_a">Home</a></li>
            <li style="display: inline"><a href="#" class="top_a">Browse</a></li>
            <li style="display: inline"><a href="#" class="top_a">Download</a></li>
            <li style="display: inline"><a href="#" class="top_a">Submit</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/help" class="top_a">Help</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/about" class="top_a">About</a></li>
        </ul>
    </div>
    <div style="width: 940px;margin: 0 auto;">
        <img src="${pageContext.request.contextPath}/images/Hepatotoxicity.png">
    </div>
    <table border="1px" align="center" style="margin-top: 2%;width: 600px">
        <tr>
            <td align="center" width="100px" style="font-weight: bold">Drug Name</td>
            <td width="300px"><a href="https://www.drugbank.ca/drugs/${resultDrug.drugBank}" style="margin-left: 50px">${resultDrug.drugName}</a></td>
            <input type="hidden" value="${resultDrug.drugName}" id="drugName">
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Related Proteins</td>
        </tr>
        <c:forEach items="${resultDrug.proteins}" var="protein" varStatus="vs1">
            <tr>
                <td colspan="2" align="left">${vs1.index+1}.${protein}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/listProtein.action?drugName=${resultDrug.drugName}">(more......)</a></td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Metabolites</td>
        </tr>
        <c:forEach items="${resultDrug.metabolites}" var="metabolite" varStatus="vs2">
            <tr>
                <td colspan="2" align="left">${vs2.index+1}.${metabolite}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/">(more......)</a></td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Reference(PubMed)</td>
        </tr>
        <tr>
            <td colspan="2">
                <c:forEach items="${resultDrug.references}" var="reference" varStatus="vs3">
                    ${reference},
                </c:forEach><a href="${pageContext.request.contextPath}/">(more......)</a>
            </td>
        </tr>
    </table>
    <div style="margin: 0 auto;width: 250px;margin-top: 20px">
        <input type="button" onclick="showNetWork()" style="background-image: url(${pageContext.request.contextPath}/images/ShowNetWork.png);
                width: 185px;height: 40px">
    </div>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
