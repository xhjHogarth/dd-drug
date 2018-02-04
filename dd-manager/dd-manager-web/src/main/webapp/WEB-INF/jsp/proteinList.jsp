<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
    <script>
        function to_page(page) {
            if(page){
                $("#page").val(page);
            }
            document.listForm.submit();
        }
    </script>
</head>
<body>
    <form id="listForm" name="listForm">
        <table border="1px" align="center" style="margin-top: 2%">
            <tr>
                <td colspan="5" align="center">查询结果</td>
            </tr>
            <tr>
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
    </form>
</body>
</html>