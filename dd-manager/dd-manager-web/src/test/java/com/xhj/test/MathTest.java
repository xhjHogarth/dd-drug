package com.xhj.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: asus
 * Date: 2018/3/12
 * Time: 16:45
 * Version:V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})
public class MathTest {

    public int zuhe(int a,int b){
        int result = 0;
        int c = 1,d = 1;
        for(int i = 1;i<=a;i++){
            c = c*i;
        }
        for (int j = b;j>=(b-a);j--){
            d = d*j;
        }
        result = d/c;
        return result;
    }

    @Test
    public void test1(){
        double p = 0;
        for(int i=0;i<8;i++){
            p = zuhe(i,8)*zuhe(10-i,113)/zuhe(10,121);
        }
        System.out.println(1-p);
    }
}
