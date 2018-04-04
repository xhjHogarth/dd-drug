package com.xhj.dddrug.utils;

/**
 * User: asus
 * Date: 2018/4/3
 * Time: 17:23
 * Version:V1.0
 */
public class RandomXY {

    public static double[][] getXY(int size){
        double[][] XY = new double[size][2];
        for(int i=0;i<size;i++){
            double x = 150*Math.cos(2*Math.PI/size*(i+1));
            double y = 150*Math.sin(2*Math.PI/size*(i+1));
            XY[i][0] = x;
            XY[i][1] = y;
        }
        return XY;
    }

}
