<%--
  User: asus
  Date: 2018/5/24
  Time: 23:51
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit</title>
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
    <script>
        function myClick() {
            var drug = $('#drug').val();
            var protein = $('#protein').val();
            var metabolite = $('#metabolite').val();
            var pmid = $('#pmid').val();
            var suggestions = $('#suggestions').val();
            var type = $('#type').val();
            $('#label2').css("visibility","hidden");
            $('#label2').css("visibility","hidden");
            $('#label3').css("visibility","hidden");
            $('#label4').css("visibility","hidden");
            if(drug == ""){
                $('#label1').css("visibility","visible");
                return;
            }
            if(protein == ""){
                $('#label2').css("visibility","visible");
                return;
            }
            if(metabolite == ""){
                $('#label3').css("visibility","visible");
                return;
            }
            if(pmid == ""){
                $('#label4').css("visibility","visible");
                return;
            }
            alert("Submitted successfully");
        }
    </script>
</head>
<body>
    <jsp:include page="top.jsp"/>
    <div style="margin: 0 auto;width: 940px;height: 40px;margin-top: 20px;">
        <span style="font-size: 25px;color: #C55A11;margin-left: 50px">Submit</span>
    </div>
    <div style="width: 600px;margin: 0 auto">
        <form id="submitForm" style="margin-top: 20px">
            <label style="width: 150px;margin-left: 50px">Drug</label>
            <input type="text" style="width: 200px" id="drug" name="drug">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label1">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px;margin-top: 15px">Related Protein</label>
            <input type="text" style="width: 200px" id="protein" name="protein">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label2">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px;margin-top: 15px">Metabolite</label>
            <input type="text" style="width: 200px" id="metabolite" name="metabolite">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label3">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px;margin-top: 15px">PMID</label>
            <input type="text" style="width: 200px" id="pmid" name="pmid">
            <label style="color: red;margin-left: 10px;visibility:hidden" id="label4">Please enter any fields!</label>
            <br>
            <label style="width: 150px;margin-left: 50px;margin-top: 15px">Suggestions</label>
            <input type="text" style="width: 200px;" id="suggestions" name="suggestions">
            <br>
            <label style="width: 150px;margin-left: 50px;margin-top: 20px">Toxicity Type</label>
            <select style="margin-top: 10px;font-size: 20px" id="type">
                <option value="hepatotoxicity">Hepatotoxicity</option>
                <option value="nephrotoxicity">Nephrotoxicity</option>
            </select>
            <br>
            <input style="width: 80px;margin-left: 100px;margin-top: 60px" type="button" value="Submit" onclick="myClick()">
            <input style="width: 80px;margin-left: 100px;margin-top: 20px" type="reset" value="Clear">
        </form>
    </div>
</body>
</html>
