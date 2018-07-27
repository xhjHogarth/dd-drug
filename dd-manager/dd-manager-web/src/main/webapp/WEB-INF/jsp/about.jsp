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
                    <dt>
                        About HNepTox
                    </dt>
                    <hr>
                        <p style="word-wrap: break-word;text-indent: 2em;">
                            The Hepatotoxicity or Nephrotoxicity (HNepTox) database is an online platform that focuses on
                            providing the related proteins and differential metabolites of drug-induced hepatotoxicity or
                            nephrotoxicity. HNepTox currently collects the related proteins and metabolites of 180 drugs
                            with known hepatotoxicity or 55 drugs with known nephrotoxicity. All the data in HNepTox is
                            manually extracted from the related PubMed literatures. It is fully searchable by drug name,
                            DrugBank ID, protein name, gene symbol, UniProtKB ID, Gene ID, metabolite name, HMDB ID or KEGG
                            ID. The entire data in HNepTox may be freely downloadable. In HNepTox, a molecular network of
                            drug-related protein-metabolic enzyme-metabolite may be represented based on the entered drug,
                            related protein or metabolite. HNepTox allows you to submit the relevant uncollected data or
                            valuable suggestions.
                        </p>
                    <dt>
                        Database Statistics
                    </dt>
                    <hr>
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
                            <td rowspan="4">Hepatotoxicity</td>
                            <td>Medicine</td>
                            <td>159</td>
                        </tr>
                        <tr>
                            <td>Herb</td>
                            <td>21</td>
                        </tr>
                        <tr>
                            <td>Related Protein</td>
                            <td>262</td>
                        </tr>
                        <tr>
                            <td>Metabolite</td>
                            <td>122</td>
                        </tr>
                        <tr>
                            <td rowspan="4">Nephrotoxicity</td>
                            <td>Medicine</td>
                            <td>41</td>
                        </tr>
                        <tr>
                            <td>Herb</td>
                            <td>14</td>
                        </tr>
                        <tr>
                            <td>Related Protein</td>
                            <td>145</td>
                        </tr>
                        <tr>
                            <td>Metabolite</td>
                            <td>113</td>
                        </tr>
                        </tbody>
                    </table>
                    <dt>
                        Contact us
                    </dt>
                    <hr>
                    <dd>
                        <ul style="word-wrap: break-word">
                            <li>
                                School of Pharmaceutical Sciences, Wenzhou Medical University, Ouhai District, Wenzhou, Zhejiang Province, China.
                                <br>
                                E-mail address: XZH007@126.com
                            </li>
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
    <div style="text-align: center;margin-top: 100px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</div>
</body>
</html>
