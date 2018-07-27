<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Help</title>
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
        <span style="font-size: 25px;color: #C55A11;">Help</span>
    </div>
    <div class="container" style="width: 940px;margin: 0 auto;">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <dl>
                    <dt style="margin-top: 10px">
                        1. Where are the data derived from?
                    </dt>
                    <dd style="word-wrap: break-word">
                        The drugs, related proteins, or differential metabolites were derived from text mining in related PubMed references. Based on the protein-protein or metabolic enzyme-metabolite interactions, a molecular network of drug-induced hepatotoxicity or nephrotoxicity is constructed. According to the molecular network, some metabolites are speculated for an interested drug with hepatotoxicity or nephrotoxicity.
                    </dd>
                    <dt style="margin-top: 15px">
                        2. How to search the data ?
                    </dt>
                    <dd style="word-wrap: break-word">
                        HNepTox is fully searchable by the drug name, DrugBank ID, protein name, gene symbol, UniProt ID, gene ID, metabolite name, HMDB ID or KEGG ID. Users also use the few letters followed by * for a wild searching, e.g. aceto*. To match a string exactly, please place quotes around your search term. e.g. “acetosalicylic acid”. HNepTox may also be browsed.
                    </dd>
                    <dt style="margin-top: 15px">
                        3. How to obtain and manipulate the molecular network？
                    </dt>
                    <dd style="word-wrap: break-word">
                        The user can obtain a molecular network about the query object by clicking on "Show Network". By clicking on the buttons of "Drug", "Related Protein", "Enzyme" or "Metabolite" in the top of network, the corresponding substance will be displayed or hidden. In the network, clicking a node will highlight all its adjacent nodes.
                    </dd>
                    <dt style="margin-top: 15px">
                        4. How to download the data? Is it free ?
                    </dt>
                    <dd style="word-wrap: break-word">
                        The data in HNepTox is freely downloadable. But the registration is required for user before downloading the data. The database allows user to download the full dataset by the “Download” page or selected records by the embed download function in xlsx format.
                    </dd>
                    <dt style="margin-top: 15px">
                        5. How to submit the data or suggestions？
                    </dt>
                    <dd style="word-wrap: break-word">
                        In the “Submit” page, you firstly choose “Hepatotoxicity” or “Nephrotoxicity”, then fill the drug, related protein or differential metabolite, then provide the PMID of the reference which the data derived from, and finally click “Submit” to submit data. You can directly fill and submit your suggestions. According to the data or suggestions submitted by you, we will improve the HNepTox database as soon as possible.
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
