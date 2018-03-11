<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Help</title>
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
        <span style="font-size: 25px;color: #C55A11;">Help</span>
    </div>
    <div class="container" style="width: 940px;margin: 0 auto;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <dl>
                    <dt>
                        1. Where are the data from?
                    </dt>
                    <dd>
                        The drugs, related proteins, or differential metabolites were derived from text mining for related<br>
                        PubMed references. Besides, the molecular network of  drug hepatotoxicity or nephrotoxicity is made<br>
                        by the BisoGenet and MetScape which  are both the plugins of Cytoscape software.
                    </dd>
                    <dt>
                        2. How can I download the data? Is it free ?
                    </dt>
                    <dd>
                        The  data of HNepTox is freely downable. But the registration is required for user before downloading<br>
                        the data. The database allows user to download the full dataset by the Download page or selected<br>
                        records by embed download function in formats like CSV, TXT, and XLX.
                    </dd>
                    <dt>
                        3. How to search the data ?
                    </dt>
                    <dd>
                        The search box accepts different keywords, including drug name, DrugBank ID, protein name, gene<br>
                        symbol, UniProt ID, gene ID, metabolite name, HMDB ID and KEGG ID. Users  also use the few<br>
                        letters followed by * for a wild searching, e.g. aceto*. To match a string exactly, please place quotes<br>
                        around your search term. e.g. ”acetosalicylic acid ”. Users can browse the data through drug.
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
