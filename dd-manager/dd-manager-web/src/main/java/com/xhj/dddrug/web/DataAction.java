package com.xhj.dddrug.web;

import com.xhj.dddrug.service.DataService;
import com.xhj.dddrug.vo.DrugRefVo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * User: asus
 * Date: 2018/3/25
 * Time: 22:16
 * Version:V1.0
 */
@Controller
public class DataAction {

    @Autowired
    public DataService dataService;

    @RequestMapping("dealData.action")
    public String dealData(){

        try {
            Workbook workbook = Workbook.getWorkbook(new File("d:/jxl_test.xls"));
            Sheet sheet = workbook.getSheet(0);
            for(int i = 0;i<sheet.getRows();i++){
                Cell cell1 = sheet.getCell(0,i);
                Cell cell2 = sheet.getCell(1,i);
                String dname = cell1.getContents().trim();
                String pmid = cell2.getContents().trim();
                DrugRefVo drugRefVo = new DrugRefVo();
                drugRefVo.setDname(dname);
                drugRefVo.setPmid(pmid);
                drugRefVo.setType("nephrotoxicity");
                dataService.enterDrugRef(drugRefVo);
            }
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
