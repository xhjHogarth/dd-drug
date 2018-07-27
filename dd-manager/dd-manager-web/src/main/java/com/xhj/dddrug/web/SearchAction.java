package com.xhj.dddrug.web;

import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/4/23
 * Time: 21:54
 * Version:V1.0
 */
@Controller
public class SearchAction {

    @Autowired
    public SearchService searchService;

    @RequestMapping("dNameSearch.action")
    public String dnameSearch(HttpServletRequest request){
        String drugName = request.getParameter("drugName").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("drugName",drugName);
        map.put("type",type);
        Drug drug = searchService.selectDrugByDrugName(map);
        if(drug == null){
            return "error";
        }
        return "redirect:drugDetail.action?drugName="+drugName+"&type="+type;
    }

    @RequestMapping("drugbankSearch.action")
    public String drugbankSearch(HttpServletRequest request){
        String drugbank = request.getParameter("drugbank").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("drugbank",drugbank);
        map.put("type",type);
        Drug drug = searchService.selectDrugByDrugbank(map);
        if(drug == null){
            return "error";
        }
        String drugName = drug.getDname();
        return "redirect:drugDetail.action?drugName="+drugName+"&type="+type;
    }

    @RequestMapping("pnameSearch.action")
    public String pnameSearch(HttpServletRequest request){
        String pname = request.getParameter("pname").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("pname",pname);
        map.put("type",type);
        Protein protein = searchService.selectProteinByPname(map);
        if(protein == null){
            return "error";
        }
        String gene_symbol = protein.getGene_symbol();
        return "redirect:proteinDetail.action?gene_symbol="+gene_symbol+"&type="+type;
    }

    @RequestMapping("geneSymbolSearch.action")
    public String geneSymbolSearch(HttpServletRequest request){
        String gene_symbol = request.getParameter("gene_symbol").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("gene_symbol",gene_symbol);
        map.put("type",type);
        Protein protein = searchService.selectProteinByGeneSymbol(map);
        if(protein == null){
            return "error";
        }
        return "redirect:proteinDetail.action?gene_symbol="+gene_symbol+"&type="+type;
    }

    @RequestMapping("egidSearch.action")
    public String egidSearch(HttpServletRequest request){
        String gene_id = request.getParameter("gene_id").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("gene_id",gene_id);
        map.put("type",type);
        Protein protein = searchService.selectProteinByGeneId(map);
        if(protein == null){
            return "error";
        }
        String gene_symbol = protein.getGene_symbol();
        return "redirect:proteinDetail.action?gene_symbol="+gene_symbol+"&type="+type;
    }

    @RequestMapping("upkbSearch.action")
    public String upkbSearch(HttpServletRequest request){
        String upkb = request.getParameter("upkb").trim();
        String type = request.getParameter("type").trim();
        Map<String,Object> map = new HashMap<>();
        map.put("upkb",upkb);
        map.put("type",type);
        Protein protein = searchService.selectProteinByUpkb(map);
        if(protein == null){
            return "error";
        }
        String gene_symbol = protein.getGene_symbol();
        return "redirect:proteinDetail.action?gene_symbol="+gene_symbol+"&type="+type;
    }

    @RequestMapping("mnameSearch.action")
    public String mnameSearch(HttpServletRequest request){
        String mname = request.getParameter("mname");
        String type = request.getParameter("type");
        Map<String,Object> map = new HashMap<>();
        map.put("mname",mname);
        map.put("type",type);
        Metabolite metabolite = searchService.selectMetaboliteByMname(map);
        if(metabolite == null){
            return "error";
        }
        return "redirect:metaboliteDetail.action?mname="+mname+"&type="+type;
    }

    @RequestMapping("kcSearch.action")
    public String kcSearch(HttpServletRequest request){
        String kc = request.getParameter("kc");
        String type = request.getParameter("type");
        Map<String,Object> map = new HashMap<>();
        map.put("kc",kc);
        map.put("type",type);
        Metabolite metabolite = searchService.selectMetaboliteByKc(map);
        if(metabolite == null){
            return "error";
        }
        String mname = metabolite.getMname();
        return "redirect:metaboliteDetail.action?mname="+mname+"&type="+type;
    }

    @RequestMapping("hmdbSearch.action")
    public String hmdbSearch(HttpServletRequest request){
        String hmdb = request.getParameter("hmdb");
        String type = request.getParameter("type");
        Map<String,Object> map = new HashMap<>();
        map.put("hmdb",hmdb);
        map.put("type",type);
        Metabolite metabolite = searchService.selectMetaboliteByHmdb(map);
        if(metabolite == null){
            return "error";
        }
        String mname = metabolite.getMname();
        return "redirect:metaboliteDetail.action?mname="+mname+"&type="+type;
    }
}
