<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center">
    <img src="${pageContext.request.contextPath}/images/top.png">
</div>
<style>
    /* 容器 <div> - 需要定位下拉内容 */
    .dropdown {
        position: absolute;
        display: none;
    }
    ul li:hover ul{
        display: block;
        list-style: none;
        font-size: 18px;
        padding: 0;
        margin-left: 60px;
        background-color: #B87B57;
    }
    a:link {
        text-decoration: none;
    }
    a:visited {
        text-decoration: none;
    }
    a:hover {
        text-decoration: none;
    }
    a:active {
        text-decoration: none;
    }
</style>
<div style="background-color: #B87B57;width: 940px;
                    height: 30px;margin: 0 auto;align-items: center;display: flex">
    <ul class="top_ul">
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/" class="top_a">Home</a></li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/search" class="top_a">Search</a></li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/" class="top_a">Browse</a>
            <ul class="dropdown">
                <li><a href="${pageContext.request.contextPath}/drugBrowse.action?type=hepatotoxicity" style="padding: 0;margin: 0">Hepatotoxicity</a></li>
                <li><a href="${pageContext.request.contextPath}/drugBrowse.action?type=nephrotoxicity" style="padding: 0;margin: 0">Nephrotoxicity</a></li>
            </ul>
        </li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/download" class="top_a">Download</a></li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/submit" class="top_a">Submit</a></li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/help" class="top_a">Help</a></li>
        <li style="display: inline-block;"><a href="${pageContext.request.contextPath}/contact" class="top_a">Contact</a></li>
    </ul>
</div>
