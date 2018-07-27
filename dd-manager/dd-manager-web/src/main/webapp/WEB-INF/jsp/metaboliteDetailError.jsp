<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Metabolite</title>
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
        a{
            color: #CF5A11;
        }
        td{
            height: 30px;
        }
    </style>
    <script>
        function showNetWork() {
            var mname = $('#mname').val();
            var type = $('#type').val();
            window.location.href = "${pageContext.request.contextPath}/metaboliteGraph.action?mname="+mname+"&type="+type;
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
            <td align="center" width="100px" style="font-weight: bold">Metabolite</td>
            <td width="300px"><a href="http://www.hmdb.ca/metabolites/${resultMetabolite.metabolite.hmdb}">${resultMetabolite.metabolite.mname}</a></td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Drugs</td>
        </tr>
        <%--<c:forEach items="${resultMetabolite.drugs}" var="drug" varStatus="vs1">--%>
            <%--<tr>--%>
                <%--<td colspan="2" align="left"><a href="https://www.drugbank.ca/drugs/${drug.drugbank}">${vs1.index+1}.${drug.dname}</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <tr>
            <%--<td colspan="2"><a href="${pageContext.request.contextPath}/listDrugs2.action?mname=${resultMetabolite.metabolite.mname}&type=${resultMetabolite.metabolite.type}">(more......)</a></td>--%>
            <td colspan="2">None</td>
        </tr>
        <tr>
            <td colspan="2" style="background-color: #DEEBF7;font-weight: bold" align="center">Related Protein</td>
        </tr>
        <%--<c:forEach items="${resultMetabolite.proteins}" var="protein" varStatus="vs2">--%>
            <%--<tr>--%>
                <%--<td colspan="2" align="left"><a href="https://www.ncbi.nlm.nih.gov/gene/?term=${protein.eg_id}">${vs1.index+1}.${protein.gene_symbol}</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <tr>
            <%--<td colspan="2"><a href="${pageContext.request.contextPath}/listProtein2.action?mname=${resultMetabolite.metabolite.mname}&type=${resultMetabolite.metabolite.type}">(more......)</a></td>--%>
            <td colspan="2">None</td>
        </tr>
    </table>
    <div style="margin: 0 auto;width: 250px;margin-top: 20px">
        <input type="button" onclick="showNetWork()" style="background-image: url(${pageContext.request.contextPath}/images/ShowNetWork.png);
                width: 185px;height: 40px">
        <input type="hidden" value="${resultMetabolite.metabolite.type}" id="type">
        <input type="hidden" value="${resultMetabolite.metabolite.mname}" id="mname">
    </div>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
