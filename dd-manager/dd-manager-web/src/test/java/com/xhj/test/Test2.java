package com.xhj.test;

import com.xhj.dddrug.dao.ProteinMapper;
import com.xhj.dddrug.pojo.Protein;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/23
 * Time: 12:02
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class Test2 {

    @Autowired
    public ProteinMapper proteinDao;
    @Test
    public void testListByPage(){
        List<Protein> list = proteinDao.selectProteins(1);
        if(list!=null){
            for (Protein protein: list) {
                System.out.println(protein);
            }
        }else{
            System.out.println("数据没有找到");
        }
    }

    @Test
    public void test(){

    }
}
