package com.xhj.dddrug.web;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.Reference;
import com.xhj.dddrug.pojo.ResultDrug;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/1/18
 * Time: 16:59
 * Version:V1.0
 */
@Controller
public class ListAction {

    @Autowired
    public ProteinService proteinService;
    @Autowired
    public DrugService drugService;

    @RequestMapping("/listProtein.action")
    public String listProtein(HttpServletRequest request){
//        if(vo==null){
//            vo = new QueryVo();
//        }
//        if(vo.getPageNow()<=0){
//            vo.setPageNow(1);
//        }
//        //vo.setPageNow((vo.getPageNow()-1)*5);
//        vo.setRowNumber((vo.getPageNow()-1)*10);
//        vo.setPageSize(10);
//        PageBean<Protein> pageBean = proteinService.selectProteins(vo);
//        request.setAttribute("pageBean",pageBean);
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        request.setAttribute("drugName",drugName);
        request.setAttribute("type",type);
        return "proteinList";
    }

    //这是药物的详细页面跳转到显示所有相关蛋白的界面的方法
    @ResponseBody
    @RequestMapping(value = "proteins/{drugName}/{type}",method = RequestMethod.GET)
    public Result<Protein> listProteins(@PathVariable("drugName")String drugName,@PathVariable("type")String type,Page page,Order order){
        Result<Protein> result = new Result<>();
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("order",order);
        map.put("drugName",drugName);
        map.put("type",type);
        result = drugService.listProteins(map);
        return  result;
    }

    @RequestMapping("/listMe.action")
    public String listMe(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        request.setAttribute("drugName",drugName);
        request.setAttribute("type",type);
        return "metabolitesList";
    }

    //这是药物的详细页面跳转到显示所有代谢物的方法
    @ResponseBody
    @RequestMapping(value = "items/{drugName}/{type}",method = RequestMethod.GET)
    public Result<Metabolite> listMetabolites(@PathVariable("drugName") String drugName,@PathVariable("type") String type,
                                              Page page, Order order, ResultDrug resultDrug){
        Result<Metabolite> result = null;
        try {
            resultDrug.setDrugName(drugName);
            resultDrug.setType(type);
            result = drugService.listMetabolites(resultDrug,page,order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/listReference.action")
    public String listRef(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        request.setAttribute("drugName",drugName);
        request.setAttribute("type",type);
        return "reference";
    }

    @ResponseBody
    @RequestMapping(value = "references/{drugName}/{type}",method = RequestMethod.GET)
    public Result<Reference> listReferences(@PathVariable("drugName") String drugName,@PathVariable("type") String type,
                                            Page page,Order order,ResultDrug resultDrug){
        Result<Reference> result = null;
        try {
            resultDrug.setDrugName(drugName);
            resultDrug.setType(type);
            result = drugService.listReferences(resultDrug,page,order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/listData.action")
    public String listData(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        String type = request.getParameter("type");
        request.setAttribute("drugName",drugName);
        request.setAttribute("type",type);
        //System.out.println(drugName);
        return "data";
    }

    @ResponseBody
    @RequestMapping(value = "listEdges/{drugName}/{type}",method = RequestMethod.GET)
    public Result<Link> listEdges(@PathVariable("drugName") String drugName,@PathVariable("type") String type,
                                  Page page,ResultDrug resultDrug){
        Result<Link> result = null;
        try {
            resultDrug.setDrugName(drugName);
            resultDrug.setType(type);
            result = drugService.listEdges(resultDrug,page);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0;i<result.getRows().size();i++){
            System.out.println(result.getRows().get(i));
        }
        return result;
    }


}
