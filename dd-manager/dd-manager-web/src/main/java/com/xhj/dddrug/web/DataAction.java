package com.xhj.dddrug.web;

import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.service.DataService;
import com.xhj.dddrug.vo.DrugMetVo;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                Cell cell3 = sheet.getCell(2,i);
                String dname = cell1.getContents().trim();
                String kc = cell2.getContents().trim();
                String type = cell3.getContents().trim();
                DrugMetVo drugMetVo = new DrugMetVo();
                drugMetVo.setDname(dname);
                drugMetVo.setKc(kc);
                drugMetVo.setType(type);
                drugMetVo.setDrugType("nephrotoxicity");
                dataService.enterDrugMet(drugMetVo);
            }
            workbook.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("writeData.action")
    public void writeData(){
        File file = new File("d:/test.xls");
        String[] title = {"药物","代谢物"};
        List<Drug> drugs = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("type","hepatotoxicity");
        drugs = dataService.selectDrugs(map);
        //查出所有的药物和代谢物的步骤
        List<List<DrugMetVo>> drugMetVos = new ArrayList<>();
        for(int i =0;i<drugs.size();i++){
            List<DrugMetVo> drugMetVo = new ArrayList<>();
            drugMetVo = dataService.selectDrugMetVo(drugs.get(i));
            if (drugMetVo.size()==0 || drugMetVo == null){
                continue;
            }
            drugMetVos.add(drugMetVo);
        }
//        List<DrugMetVo> list = new ArrayList<>();
//        for(int i =0;i<drugMetVos.size();i++){
//            for (int j=0;j<drugMetVos.get(i).size();j++){
//                list.add(drugMetVos.get(i).get(j));
//            }
//        }
        try {
            file.createNewFile();
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet页
            WritableSheet sheet1 = workbook.createSheet("sheet1",0);
            Label label = null;
            for(int i = 0;i<title.length;i++){
                label = new Label(i,0,title[i]);
                sheet1.addCell(label);
            }
            for (int i = 0;i<drugs.size();i++){
                Drug drug = drugs.get(i);
                label = new Label(0,i+1,drug.getDname());
                sheet1.addCell(label);
                label = new Label(1,i+1,drug.getDrugbank());
                sheet1.addCell(label);
            }
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("download.action")
    public void downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String fileNameType = request.getParameter("fileName");
        String child = "";
        if("proteinH".equals(fileNameType)){
            child = "Related Protein_Hepatotoxicity.xlsx";
        }else if("proteinN".equals(fileNameType)){
            child = "Related Protein_Nephrotoxicity.xlsx";
        }else if("metaboliteH".equals(fileNameType)){
            child = "Metabolite_Hepatotoxicity.xlsx";
        }else if("metaboliteN".equals(fileNameType)){
            child = "Metabolite_Nephrotoxicity.xlsx";
        }
        String path = request.getServletContext().getRealPath("/download");
        File file = new File(path,child);
        InputStream is = new FileInputStream(file);
        //设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //设置文件头:最后一个设置下载文件名
        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
        try {
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int lenth;
            while((lenth=is.read(b))>0){
                os.write(b,0,lenth);
            }
            os.flush();
            os.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
