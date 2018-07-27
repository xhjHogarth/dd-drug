<%--
  User: asus
  Date: 2018/4/23
  Time: 17:54
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
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
        function myClick1() {
            var drugName = $("#drugName").val();
            var drugbank = $("#drugbank").val();
            var type = $("#type1").val();
//            alert(type);
            $('#label2').css("visibility","hidden");
            $('#label2').css("visibility","hidden");
            if(drugName == "" && drugbank==""){
                $('#label1').css("visibility","visible");
                $('#label2').css("visibility","visible");
            }else{
                if(drugName != "" && drugbank == ""){
                    window.location.href = "${pageContext.request.contextPath}/dNameSearch.action?drugName="+drugName+"&type="+type;
                }
                if(drugName == "" && drugbank != ""){
                    window.location.href = "${pageContext.request.contextPath}/drugbankSearch.action?drugbank="+drugbank+"&type="+type;
                }
                if(drugName != "" && drugbank != ""){
                    alert("Please choose one fields to search!");
                }
            }
        }
        function myClick2() {
            var pname = $('#pname').val();
            var gene_symbol = $('#gene_symbol').val();
            var gene_id = $('#gene_id').val();
            var upkb = $('#upkb').val();
            var type = $('#type2').val();
            $('#label3').css("visibility","hidden");
            $('#label4').css("visibility","hidden");
            $('#label5').css("visibility","hidden");
            $('#label6').css("visibility","hidden");
            if(pname =="" && gene_symbol =="" && gene_id =="" && upkb==""){
                $('#label3').css("visibility","visible");
                $('#label4').css("visibility","visible");
                $('#label5').css("visibility","visible");
                $('#label6').css("visibility","visible");
            }else{
                if(pname !="" && gene_symbol =="" && gene_id =="" && upkb ==""){
                    window.location.href = "${pageContext.request.contextPath}/pnameSearch.action?pname="+pname+"&type="+type;
                }
                if(pname =="" && gene_symbol !="" && gene_id =="" && upkb ==""){
                    window.location.href = "${pageContext.request.contextPath}/geneSymbolSearch.action?gene_symbol="+gene_symbol+"&type="+type;
                }
                if(pname =="" && gene_symbol =="" && gene_id !="" && upkb ==""){
                    window.location.href = "${pageContext.request.contextPath}/egidSearch.action?gene_id="+gene_id+"&type="+type;
                }
                if(pname =="" && gene_symbol =="" && gene_id =="" && upkb !=""){
                    window.location.href = "${pageContext.request.contextPath}/upkbSearch.action?upkb="+upkb+"&type="+type;
                }
            }
        }
        function myClick3() {
            var mname = $('#mname').val();
            var kc = $('#kc').val();
            var hmdb = $('#hmdb').val();
            var type = $('#type3').val();
            $('#label7').css("visibility","hidden");
            $('#label8').css("visibility","hidden");
            $('#label9').css("visibility","hidden");
            if(mname == "" && kc =="" && hmdb ==""){
                $('#label7').css("visibility","visible");
                $('#label8').css("visibility","visible");
                $('#label9').css("visibility","visible");
            }else{
                if(mname != "" && kc =="" && hmdb ==""){
                    window.location.href = "${pageContext.request.contextPath}/mnameSearch.action?mname="+mname+"&type="+type;
                }
                if(mname == "" && kc !="" && hmdb ==""){
                    window.location.href = "${pageContext.request.contextPath}/kcSearch.action?kc="+kc+"&type="+type;
                }
                if(mname == "" && kc =="" && hmdb !=""){
                    window.location.href = "${pageContext.request.contextPath}/hmdbSearch.action?hmdb="+hmdb+"&type="+type;
                }
            }
        }
    </script>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="margin: 0 auto;width: 940px;height: 40px;margin-top: 20px;">
        <span style="font-size: 25px;color: #C55A11;">Search</span>
    </div>
    <div style="margin: 20px auto;width: 500px;">
        <h4 style="font-weight: bold;color: #C55A11;">Search by Drug</h4>
        <hr style="margin-top: 10px;margin-bottom: 10px">
        <form id="drugForm">
            <label style="width: 150px;margin-left: 50px">Drug Name:</label>
            <input type="text" style="width: 200px" id="drugName" name="drugName">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label1">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">DrugBank ID:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="drugbank" name="drugbank">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label2">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">Toxicity Type:</label>
            <select style="margin-top: 10px;font-size: 14px" id="type1">
                <option value="hepatotoxicity">Hepatotoxicity</option>
                <option value="nephrotoxicity">Nephrotoxicity</option>
            </select><br>
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="button" value="Search" onclick="myClick1()">
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="reset" value="Clear">
        </form>

        <h4 style="font-weight: bold;color: #C55A11;margin-top: 30px">Search by Related Protein</h4>
        <hr style="margin-top: 10px;margin-bottom: 10px">
        <form id="proteinForm">
            <label style="width: 150px;margin-left: 50px">Protein Name:</label>
            <input type="text" style="width: 200px" id="pname" name="pname">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label3">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">Gene Symbol:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="gene_symbol" name="gene_symbol">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label4">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">Gene ID:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="gene_id" name="gene_id">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label5">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">UniProtKB ID:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="upkb" name="upkb">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label6">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">Toxicity Type:</label>
            <select style="margin-top: 10px;font-size: 14px" id="type2">
                <option value="hepatotoxicity">Hepatotoxicity</option>
                <option value="nephrotoxicity">Nephrotoxicity</option>
            </select><br>
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="button" value="Search" onclick="myClick2()">
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="reset" value="Clear">
        </form>

        <h4 style="font-weight: bold;color: #C55A11;margin-top: 30px">Search by Metabolite</h4>
        <hr style="margin-top: 10px;margin-bottom: 10px">
        <form id="metaboliteForm">
            <label style="width: 150px;margin-left: 50px">Metabolite Name:</label>
            <input type="text" style="width: 200px" id="mname" name="mname">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label7">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">KEGG ID:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="kc" name="kc">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label8">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">HMDB ID:</label>
            <input type="text" style="width: 200px;margin-top: 10px" id="hmdb" name="hmdb">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label9">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px">Toxicity Type:</label>
            <select style="margin-top: 10px;font-size: 14px" id="type3">
                <option value="hepatotoxicity">Hepatotoxicity</option>
                <option value="nephrotoxicity">Nephrotoxicity</option>
            </select><br>
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="button" value="Search" onclick="myClick3()">
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="reset" value="Clear">
        </form>
    </div>
    <div style="text-align: center;margin-top: 100px">
        <img src="${pageContext.request.contextPath}/images/bottom.png">
    </div>
</body>
</html>
