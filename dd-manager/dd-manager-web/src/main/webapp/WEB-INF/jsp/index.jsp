<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home</title>
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
    <script type="text/javascript">
        function tohelp() {
            window.location.href = "${pageContext.request.contextPath}/help";
        }
    </script>
</head>
<body>
    <div>
        <jsp:include page="top.jsp"/>
        <%--<div style="text-align: center;margin-top: 50px">--%>
            <%--<form>--%>
                <%--<div style="margin: 0 auto;text-align: center;width: 940px;height: 50px;">--%>
                    <%--<div style="float: left;margin-left: 100px">--%>
                        <%--<input type="text" placeholder="Search by Drug,Protein,Metabolite"--%>
                               <%--style="width: 300px;height: 40px;font-size: 15px;">--%>
                    <%--</div>--%>
                    <%--<div style="float: left;margin-left: 20px">--%>
                        <%--<select style="width: 150px;height: 40px;font-size: 15px;" name="type">--%>
                            <%--<option value="hepatotoxicity">Hepatotoxicity</option>--%>
                            <%--<option value="nephrotoxicity">Nephrotoxicity</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>
                    <%--<div style="float: left;margin-left: 20px">--%>
                        <%--<input type="button" style="width: 135px;height: 40px;--%>
                                <%--background-image: url(${pageContext.request.contextPath}/images/search.png);">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
        <%--<div style="width: 940px;height: 30px;margin: 0 auto;">--%>
            <%--<span style="margin-left: 150px">e.g. <a href="${pageContext.request.contextPath}/drugDetail.action?drugName=Acetaminophen&type=hepatotoxicity">Acetaminophen</a>--%>
                <%--,GOT1,Glycine--%>
                <%--<input type="button" style="width: 20px;height: 20px;border: 0px;padding: 0px;vertical-align: middle;--%>
                        <%--background-image: url(${pageContext.request.contextPath}/images/wenhao.jpg)" --%>
                       <%--onclick="tohelp()"></span>--%>
        <%--</div>--%>
        <div class="container" style="width: 940px;height: 30px;margin: 20px auto;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <dl>
                        <dt style="font-size: 25px;margin-top: 10px">
                            Introduction
                        </dt>
                        <hr style="margin-top: 10px;margin-bottom: 10px">
                        <dd style="font-size: 18px;word-wrap: break-word">
                            HNepTox is an online database that focuses on providing the related proteins and differential metabolites
                            of drug-induced hepatotoxicity or nephrotoxicity. The related proteins or metabolites are derived from text
                            mining in related PubMed references. The database may serve as a tool for exploring the molecular mechanism
                            or predicting the diagnostic biomarkers of hepatotoxicity or nephrotoxicity.
                        </dd>
                    </dl>
                    <dl>
                        <dt style="font-size: 22px;margin-top: 10px">
                            Highlights of HNepTox
                        </dt>
                        <hr style="margin-top: 10px;margin-bottom: 10px">
                        <dd style="font-size: 18px;word-wrap: break-word">
                            <ul>
                                <li>
                                    Providing related proteins and differential metabolites of drug-induced liver or kidney injury.
                                </li>
                                <li>
                                    Constructing a molecular network of drug - related protein - metabolic enzyme - metabolite
                                    based on the interaction among proteins.
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt style="font-size: 22px;margin-top: 10px">
                            Database Statistics
                        </dt>
                        <hr style="margin-top: 10px;margin-bottom: 10px">
                        <table class="table">
                            <thead>
                            <tr class="info">
                                <th>Toxicity Type</th>
                                <th>Item</th>
                                <th>Amount</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td rowspan="4" style="padding: 4px;font-size: large">Hepatotoxicity</td>
                                <td style="padding: 4px;font-size: large">Medicine</td>
                                <td style="padding: 4px;font-size: large">159</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Herb</td>
                                <td style="padding: 4px;font-size: large">21</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Related Protein</td>
                                <td style="padding: 4px;font-size: large">262</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Metabolite</td>
                                <td style="padding: 4px;font-size: large">122</td>
                            </tr>
                            <tr>
                                <td rowspan="4" style="padding: 4px;font-size: large">Nephrotoxicity</td>
                                <td style="padding: 4px;font-size: large">Medicine</td>
                                <td style="padding: 4px;font-size: large">41</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Herb</td>
                                <td style="padding: 4px;font-size: large">14</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Related Protein</td>
                                <td style="padding: 4px;font-size: large">145</td>
                            </tr>
                            <tr>
                                <td style="padding: 4px;font-size: large">Metabolite</td>
                                <td style="padding: 4px;font-size: large">113</td>
                            </tr>
                            <tr><td></td><td></td><td></td></tr>
                            </tbody>
                        </table>
                    </dl>

                    <dl>
                        <dt style="font-size: 20px">
                            History
                        </dt>
                        <hr style="margin-top: 10px;margin-bottom: 10px">
                        <dd style="font-size: 18px">
                            <ul>
                                <li>
                                    May, 2018, HNepTox was released.
                                </li>
                            </ul>
                        </dd>
                    </dl>
                </div>
            </div>
            <div style="text-align: center">
                <img src="${pageContext.request.contextPath}/images/bottom.png">
            </div>
        </div>

    </div>
</body>
</html>
