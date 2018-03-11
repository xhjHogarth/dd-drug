package com.xhj.dddrug.web;

import com.xhj.dddrug.service.ProteinService;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * User: asus
 * Date: 2018/2/6
 * Time: 23:36
 * Version:V1.0
 */
@Controller
public class ProteinAction {

    @Autowired
    public ProteinService proteinService;

    @RequestMapping("/proteinDetail.action")
    public String proteinDetail(HttpServletRequest request){

        return "proteinDetail";
    }

    @RequestMapping("/enterData.action")
    public void enterData(){
        try {
            Workbook workbook = Workbook.getWorkbook(new File("d:/jxl_test.xls"));
            Sheet sheet = workbook.getSheet(0);
//            for (int i = 0;i<sheet.getRows();i++){
//                EnzymeMetVo enzymeMetVo = new EnzymeMetVo();
//                Cell cell1 = sheet.getCell(0,i);
//                enzymeMetVo.setEname(cell1.getContents());
//                Cell cell2 = sheet.getCell(1,i);
//                enzymeMetVo.setMname(cell2.getContents());
//                System.out.println(enzymeMetVo);
//                //判断是否已经存在该蛋白-蛋白的关系
//                //System.out.println(proteinService.existsProtein(proteinEnzymeVo));
//                int exists1 = proteinService.existsEnzymeMet(enzymeMetVo);
//                //System.out.println(exists1);
//                if(exists1==0){
//                    proteinService.enterEnzymeMet(enzymeMetVo);
//                }
//            }
//            for(int i = 0;i<sheet.getRows();i++){
//                Cell cell = sheet.getCell(0,i);
//                String protein = cell.getContents();
//                //System.out.println(protein);
//                int exists = proteinService.existProtein(protein);
//                //System.out.println(exists);
//                if(exists == 0){
//                    proteinService.enterProtein(protein);
//                }
//            }
//            for(int i=0;i<sheet.getRows();i++){
//                Cell cell = sheet.getCell(0,i);
//                String enzyme = cell.getContents();
//                //System.out.println(enzyme);
//                int exists = proteinService.existsEnzyme(enzyme);
//                //System.out.println(exists);
//                if(exists == 0){
//                    proteinService.enterEnzyme(enzyme);
//                }
//            }
//            for(int i=0;i<sheet.getRows();i++){
//                Cell cell = sheet.getCell(0,i);
//                String metabolites = cell.getContents();
//                //System.out.println(metabolites);
//                int exists = proteinService.existsMetabolites(metabolites);
//                //System.out.println(exists);
//                if(exists==0){
//                    proteinService.enterMetabolites(metabolites);
//                }
//            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
