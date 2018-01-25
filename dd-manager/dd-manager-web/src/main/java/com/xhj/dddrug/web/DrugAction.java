package com.xhj.dddrug.web;

import com.xhj.dddrug.pojo.ResultDrug;
import com.xhj.dddrug.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:06
 * Version:V1.0
 */
@Controller
public class DrugAction {

    @Autowired
    private DrugService drugService;

    @RequestMapping("/drugDetail.action")
    public String drugDetail(HttpServletRequest request){
        ResultDrug resultDrug = new ResultDrug();
        resultDrug.setDrugName("Methotrexate");
        List<String> proteins = drugService.selectProteins(resultDrug.getDrugName());
        resultDrug.setProteins(proteins);
        List<String> metabolites = drugService.selectMetabolites(resultDrug.getDrugName());
        resultDrug.setMetabolites(metabolites);
        List<String> references = drugService.selectReference(resultDrug.getDrugName());
        resultDrug.setReferences(references);
        request.setAttribute("resultDrug",resultDrug);
        System.out.println("-----------------------");
        System.out.println(resultDrug);
        System.out.println("-----------------------");
        return "drugdetail";
    }
}
