package com.baoding.utils;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

//生成随机球
public class BallUtils {
    public static String randomRedBall(){
         Set<Integer> set =new TreeSet();
        Random random = new Random();
        while (set.size()<6){
            int i = random.nextInt(33)+1;
            set.add(i);
        }
        String str="";
        for (Integer i : set) {
             str=str+","+ String.format("%02d", i);
        }
        String s = str.substring(1);
        return s;
    }

    public static String randomBlueBall(){
        int i = new Random().nextInt(16) + 1;
        return  String.format("%02d", i);
    }
}
