<%--
  User: asus
  Date: 2018/2/6
  Time: 23:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1px" align="center" style="margin-top: 2%">
    <tr>
        <td align="center" width="100px">Related Protein</td>
        <td width="300px"><a href=""></a></td>
    </tr>
    <tr>
        <td colspan="2" style="background-color: darksalmon" align="center">Drugs</td>
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
        <td colspan="2" style="background-color: darksalmon" align="center">Metabolites</td>
    </tr>
    <c:forEach items="${resultDrug.metabolites}" var="metabolite" varStatus="vs2">
        <tr>
            <td colspan="2" align="left">${vs2.index+1}.${metabolite}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2"><a href="${pageContext.request.contextPath}/">(more......)</a></td>
    </tr>
</table>
</body>
</html>
