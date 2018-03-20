package com.xhj.dddrug.web;

import com.xhj.dddrug.dto.Order;
import com.xhj.dddrug.dto.Page;
import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.Reference;
import com.xhj.dddrug.service.DrugService;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String listProtein(QueryVo vo,HttpServletRequest request){
        if(vo==null){
            vo = new QueryVo();
        }
        if(vo.getPageNow()<=0){
            vo.setPageNow(1);
        }
        //vo.setPageNow((vo.getPageNow()-1)*5);
        vo.setRowNumber((vo.getPageNow()-1)*10);
        vo.setPageSize(10);
        PageBean<Protein> pageBean = proteinService.selectProteins(vo);
        request.setAttribute("pageBean",pageBean);
        return "proteinList";
    }

    @RequestMapping("/listMe.action")
    public String listMe(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        request.setAttribute("drugName",drugName);
        return "metabolitesList";
    }

    @ResponseBody
    @RequestMapping(value = "items/{drugName}",method = RequestMethod.GET)
    public Result<Metabolite> listMetabolites(@PathVariable("drugName") String drugName, Page page, Order order){
        Result<Metabolite> result = null;
        try {
           result = drugService.listMetabolites(drugName,page,order);
           //System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/listReference.action")
    public String listRef(HttpServletRequest request){
        String drugName = request.getParameter("drugName");
        request.setAttribute("drugName",drugName);
        return "reference";
    }

    @ResponseBody
    @RequestMapping(value = "references/{drugName}",method = RequestMethod.GET)
    public Result<Reference> listReferences(@PathVariable("drugName") String drugName,Page page,Order order){
        Result<Reference> result = null;
        try {
            result = drugService.listReferences(drugName,page,order);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
