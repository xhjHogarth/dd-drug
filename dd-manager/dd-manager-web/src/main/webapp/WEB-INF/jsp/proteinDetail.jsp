<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Protein</title>
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
        a{
            color: #CF5A11;
        }
        td{
            height: 30px;
        }
    </style>
    <script>
        function showNetWork() {
            var pname = $('#pname').val();
            var type = $('#type').val();
            window.location.href="${pageContext.request.contextPath}/proteinGraph.action?pname="+pname+"&type="+type;
        }
    </script>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="width: 940px;margin: 0 auto;">
        <img src="${pageContext.request.contextPath}/images/Hepatotoxicity.png">
    </div>
    <table border="1px" align="center" style="margin-top: 2%;width: 600px">
        <tr>
            <td align="center" width="100px" style="font-weight: bold">Related Protein</td>
            <td width="300px"><a href="https://www.ncbi.nlm.nih.gov/gene/?term=${resultProtein.protein.eg_id}">
                ${resultProtein.protein.pname}</a></td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Drugs</td>
        </tr>
        <c:forEach items="${resultProtein.drugs}" var="drug" varStatus="vs1">
            <tr>
                <td colspan="2" align="left"><a href="https://www.drugbank.ca/drugs/${drug.drugbank}">
                        ${vs1.index+1}.${drug.dname}</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/listDrugs.action?pname=${resultProtein.protein.gene_symbol}&type=${resultProtein.protein.type}">(more......)</a></td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Metabolites</td>
        </tr>
        <c:forEach items="${resultProtein.metabolites}" var="metabolite" varStatus="vs2">
            <tr>
                <td colspan="2" align="left"><a href="http://www.hmdb.ca/metabolites/${metabolite.hmdb}">
                        ${vs2.index+1}.${metabolite.mname}</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><a href="${pageContext.request.contextPath}/listMetabolites.action?pname=${resultProtein.protein.gene_symbol}&type=${resultProtein.protein.type}">(more......)</a></td>
        </tr>
    </table>
    <div style="margin: 0 auto;width: 250px;margin-top: 20px">
        <input type="button" onclick="showNetWork()" style="background-image: url(${pageContext.request.contextPath}/images/ShowNetWork.png);
                width: 185px;height: 40px">
        <input type="hidden" value="${resultProtein.protein.type}" id="type">
        <input type="hidden" value="${resultProtein.protein.gene_symbol}" id="pname">
    </div>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
