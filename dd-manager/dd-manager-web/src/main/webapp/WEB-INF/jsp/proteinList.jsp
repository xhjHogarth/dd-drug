<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proteins</title>
    <%@include file="quote.jsp"%>
    <script>
        function to_page(page) {
            if(page){
                $("#page").val(page);
            }
            document.listForm.submit();
        }
    </script>
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
        <h3 style="display: inline;margin-left: 250px;font-size: 30px;color: #C55A11">Related proteins</h3>
        <hr>
    </div>
    <form id="listForm" name="listForm">
        <table border="1px" align="center" style="margin-top: 2%;" cellspacing="0">
            <tr style="background-color: #DDEBF7;border: 10px;text-align: center">
                <td>Num.</td>
                <td>Protein Name</td>
                <td>Gene Symbol</td>
                <td>Entrez Gene</td>
                <td>UniProKB</td>
            </tr>
            <c:forEach items="${pageBean.data}" var="protein" varStatus="vs">
                <tr>
                    <td>${protein.pid}</td>
                    <td>${protein.pname}</td>
                    <td>${protein.gene_symbol}</td>
                    <td><a href="https://www.ncbi.nlm.nih.gov/gene/?term=${protein.eg_id}">${protein.eg_id}</a></td>
                    <td><a href="http://www.uniprot.org/uniprot/${protein.upkb}">${protein.upkb}</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" align="center">
                    <a href="javascript:to_page(1)">&lt;&lt;First</a>&nbsp;&nbsp;
                    <c:if test="${pageBean.pageNow>1}">
                        <a href="javascript:to_page(${pageBean.pageNow-1})">&lt;Previous</a>&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${pageBean.pageNow<=1}">
                        <a href="">&lt;Previous</a>&nbsp;&nbsp;
                    </c:if>
                    Page ${pageBean.pageNow} of ${pageBean.pageCount} &nbsp;&nbsp;
                    <c:if test="${pageBean.pageNow<pageBean.pageCount}">
                        <a href="javascript:to_page(${pageBean.pageNow+1})">Next&gt;</a>&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${pageBean.pageNow>=pageBean.pageCount}">
                        <a href="">Next&gt;</a>&nbsp;&nbsp;
                    </c:if>
                    <input type="hidden" id="page" name="pageNow" value="${pageBean.pageNow}"/>
                    <input type="hidden" id="page" name="drugName" value="${pageBean.serachKey}"/>
                    <a href="javascript:to_page(${pageBean.pageCount})">Last&gt;&gt;</a>
                </td>
            </tr>
        </table>
        <div style="width: 700px;margin: 0 auto;text-align: right;margin-top: 15px">
            <span>Total amount:${pageBean.dataCount}</span>
        </div>
    </form>
    <div style="text-align: center;margin-top: 50px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
