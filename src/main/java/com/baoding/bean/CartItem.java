package com.baoding.bean;

import lombok.Data;

@Data
public class CartItem {
    //红球
    private String red;
    //蓝球
    private String blue;
    //注数
    private int  count=1;
    //单价
    private double price=2;
    //小计
    private double subtotal;

    public double getSubtotal(){
        return count*price;
    }
    
}
