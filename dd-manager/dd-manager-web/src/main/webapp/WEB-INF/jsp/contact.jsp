<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>About</title>
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
        dt{
            font-size: 20px;
        }
        dl{
            font-size: 18px;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="top.jsp"/>
    <div style="margin: 0 auto;width: 940px;height: 40px;margin-top: 20px;">
        <span style="font-size: 25px;color: #C55A11;">About</span>
    </div>
    <div class="container" style="width: 940px;margin: 0 auto;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <dl>
                    <dt style="font-size: 25px;text-align: center;">
                        Contact Information
                    </dt>
                    <hr>
                    <dd>
                        <ul style="word-wrap: break-word">
                            <li>
                                School of Pharmaceutical Sciences, Wenzhou Medical University, Wenzhou, Zhejiang Province, China.
                                <br>
                                E-mail address: XZH007@126.com
                            </li>
                            <br>
                            <li>
                                Institute for Precision Medicine and Innovative Drug, School of Chinese Medicine, Hong Kong Baptist University, Hong Kong, SAR, People’s Republic of China.
                                <br>
                                E-mail address: aipinglu@hkbu.edu.hk
                            </li>
                        </ul>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
    <div style="text-align: center;margin-top: 150px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</div>
</body>
</html>
