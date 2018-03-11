package com.xhj.test;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileOutputStream;

/**
 * User: asus
 * Date: 2018/2/4
 * Time: 13:55
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class POITest {

    @Test
    public void test1(){
        String[] title = {"id","name","gender"};
        //创建excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet();
        //创建第一行
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = null;
        for (int i = 0;i<title.length;i++){
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        for(int i = 1;i<10;i++){
            HSSFRow nextRow = sheet.createRow(i);
            HSSFCell cell2 = nextRow.createCell(0);
            cell2.setCellValue(i+10);
            cell2 = nextRow.createCell(1);
            cell2.setCellValue("xhj"+i);
            cell2 = nextRow.createCell(2);
            cell2.setCellValue("male");
        }
        File file = new File("d:/poi_test.xls");
        try {
            file.createNewFile();
            FileOutputStream fos = FileUtils.openOutputStream(file);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
