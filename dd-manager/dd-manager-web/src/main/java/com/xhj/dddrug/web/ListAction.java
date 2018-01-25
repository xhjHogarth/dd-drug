package com.xhj.dddrug.web;

import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.service.ProteinService;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/listProtein.action")
    public String listProtein(QueryVo vo,HttpServletRequest request){
        if(vo==null){
            vo = new QueryVo();
        }
        if(vo.getPageNow()<=0){
            vo.setPageNow(1);
        }
        PageBean<Protein> pageBean = proteinService.selectProteins(vo.getPageNow());
        request.setAttribute("pageBean",pageBean);
        return  "list";
    }
}
