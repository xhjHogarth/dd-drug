<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Home</title>
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
        <div style="text-align: center;margin-top: 20px">
            <form>
                <div style="margin: 0 auto;text-align: center;width: 940px;height: 50px">
                    <div style="float: left;margin-left: 150px">
                        <input type="text" placeholder="Search by Drug,Protein,Metabolite"
                               style="width: 300px;height: 40px;font-size: 15px;">
                    </div>
                    <div style="float: left;margin-left: 20px">
                        <input type="button" style="width: 135px;height: 40px;
                                background-image: url(${pageContext.request.contextPath}/images/search.png);">
                    </div>
                </div>
            </form>
        </div>
        <div style="width: 940px;height: 30px;margin: 0 auto;">
            <span style="margin-left: 150px">e.g. Acetaminophen,GOT1,Glycine</span>
        </div>
        <div class="container" style="width: 940px;height: 30px;margin: 0 auto;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <dl>
                        <dt style="font-size: 20px">
                            Introduction
                        </dt>
                        <hr>
                        <dd style="font-size: 18px">
                            HNepTox is an online database that focuses on providing the related proteins and differential metabolites of<br>
                            drug hepatotoxicity or nephrotoxicity. The related proteins or metabolites were derived from text mining for<br>
                            related PubMed references. The database may serve as a tool for exploring the molecular mechanism or<br>
                            predicting the diagnostic biomarkers of liver or renal toxicity.
                        </dd>
                    </dl>
                    <dl>
                        <dt style="font-size: 20px">
                            Highlights of HNepTox
                        </dt>
                        <hr>
                        <dd style="font-size: 18px">
                            <ul>
                                <li>
                                    Providing related proteins and differential metabolites of drug-induced liver or kidney injury.
                                </li>
                                <li>
                                    Supporting pathway enrichment of related proteins and differential metabolites of drug-induced liver or<br>
                                    kidney injury.
                                </li>
                                <li>
                                    Constructing a molecular network of drug-related protein-metabolic enzyme-metabolite which is based on<br>
                                    the interaction of protein and protein. The network is able to predict the related proteins and differential<br>
                                    metabolites of drug-induced liver or kidney injury.
                                </li>
                            </ul>
                        </dd>
                    </dl>
                    <dl>
                        <dt style="font-size: 20px">
                            History
                        </dt>
                        <hr>
                        <dd style="font-size: 18px">
                            <ul>
                                <li>
                                    December,2017,HNepTox was released.
                                </li>
                            </ul>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
        <div style="text-align: center">
            <img src="${pageContext.request.contextPath}/images/bottom.png">
        </div>
    </div>
</body>
</html>
