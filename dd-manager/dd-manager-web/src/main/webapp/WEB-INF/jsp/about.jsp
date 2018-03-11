<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>About</title>
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .top_ul{
            list-style-type: none;
            margin: 0px;
            padding: 0px;
        }
        a{
            text-decoration: none;
            font-size: 18px;
            color: white;
            margin-left: 70px;
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
    <div style="text-align: center">
        <img src="${pageContext.request.contextPath}/images/top.png">
    </div>
    <div style="background-color: #B87B57;width: 940px;
        height: 30px;margin: 0 auto;">
        <ul class="top_ul">
            <li style="display: inline"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li style="display: inline"><a href="#">Browse</a></li>
            <li style="display: inline"><a href="#">Download</a></li>
            <li style="display: inline"><a href="#">Submit</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/help">Help</a></li>
            <li style="display: inline"><a href="${pageContext.request.contextPath}/about">About</a></li>
        </ul>
    </div>
    <div style="margin: 0 auto;width: 940px;height: 40px;margin-top: 20px;">
        <span style="font-size: 25px;color: #C55A11;">About</span>
    </div>
    <div class="container" style="width: 940px;margin: 0 auto;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <dl>
                    <dt>
                        Dabase statistics
                    </dt>
                    <hr>
                    <table class="table">
                        <thead>
                        <tr class="info">
                            <th>Data type</th>
                            <th>Drug(hepatotoxicity)</th>
                            <th>Herb(hepatotoxicity)</th>
                            <th>Drug(nephrotoxicity)</th>
                            <th>Herb(nephrotoxicity)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Drug</td>
                            <td>261</td>
                            <td>21</td>
                            <td>59</td>
                            <td>14</td>
                        </tr>
                        <tr>
                            <td>Related Protein</td>
                            <td>374</td>
                            <td>31</td>
                            <td>287</td>
                            <td>29</td>
                        </tr>
                        <tr>
                            <td>Enzyme</td>
                            <td>440</td>
                            <td>221</td>
                            <td>437</td>
                            <td>422</td>
                        </tr>
                        <tr>
                            <td>Metabolite</td>
                            <td>132</td>
                            <td>47</td>
                            <td>136</td>
                            <td>132</td>
                        </tr>
                        <tr>
                            <td>Drugs-related protein pairs</td>
                            <td>978</td>
                            <td>57</td>
                            <td>394</td>
                            <td>64</td>
                        </tr>
                        <tr>
                            <td>Protein-protein pairs</td>
                            <td>2102</td>
                            <td>515</td>
                            <td>2056</td>
                            <td>1214</td>
                        </tr>
                        <tr>
                            <td>Enzyme-metabolite pairs</td>
                            <td>1641</td>
                            <td>282</td>
                            <td>868</td>
                            <td>715</td>
                        </tr>
                        </tbody>
                    </table>
                    <dt>
                        Contact us
                    </dt>
                    <hr>
                    <dd>
                        School of Pharmaceutical Sciences, Wenzhou Medical University, Ouhai District, Wenzhou, Zhejiang Province, China.<br>
                        E-mail address: appo@wmu.edu.cn<br>
                        Tel: 86-0592-2182897<br>
                        Website: http://bioinf.wmu.edu.cn<br>
                    </dd>
                </dl>
            </div>
        </div>
    </div>
    <div style="text-align: center;margin-top: 100px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</div>
</body>
</html>
