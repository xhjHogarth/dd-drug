package com.xhj.test;

/**
 * User: asus
 * Date: 2018/2/4
 * Time: 12:34
 * Version:V1.0
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
//public class JxlTest {
//
//
//    //写excel
////    @Test
////    public void test1(){
////        File file = new File("d:/jxl_test.xls");
////        String[] title = {"id","name","gender"};
////        try {
////            file.createNewFile();
////            //创建工作簿
////            WritableWorkbook workbook = Workbook.createWorkbook(file);
////            //创建sheet页
////            WritableSheet sheet1 = workbook.createSheet("sheet1",0);
////            Label label = null;
////            for(int i = 0;i<title.length;i++){
////                label = new Label(i,0,title[i]);
////                sheet1.addCell(label);
////            }
////            for (int i = 1;i<10;i++){
////                label = new Label(0,i,""+i);
////                sheet1.addCell(label);
////                label = new Label(1,i,"xhj"+i);
////                sheet1.addCell(label);
////                label = new Label(2,i,i+10+"");
////                sheet1.addCell(label);
////            }
////            workbook.write();
////            workbook.close();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    //解析excel
////    @Test
////    public void test2(){
////        ProteinService proteinService = new ProteinServieImpl();
////        try {
////            Workbook workbook = Workbook.getWorkbook(new File("d:/jxl_test.xls"));
////            Sheet sheet = workbook.getSheet(0);
////            for (int i = 0;i<sheet.getRows();i++){
////                for(int j = 0;j<sheet.getColumns();j++){
////                    Cell cell = sheet.getCell(j,i);
////                    //System.out.print(cell.getContents() + " ");
////                }
////                ProteinEnzymeVo proteinEnzymeVo = new ProteinEnzymeVo();
////                Cell cell1 = sheet.getCell(0,i);
////                proteinEnzymeVo.setPname(cell1.getContents());
////                Cell cell2 = sheet.getCell(1,i);
////                proteinEnzymeVo.setPname_e(cell2.getContents());
////                System.out.println(proteinEnzymeVo);
////                //判断是否已经存在该蛋白-蛋白的关系
////                System.out.println(proteinService.existsProtein(proteinEnzymeVo));
//////                if(proteinService.existsProtein(proteinEnzymeVo)<=0){
//////
//////                }
////            }
////            workbook.close();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//}
