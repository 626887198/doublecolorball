package com.baoding.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    /*
     *  总金额
     *
     *  增加
     *  删除指定
     *  清空的功能
     */
    //定义一个map保存所有的购物项  key为red-blue的字符串 value是购物项
    private Map<String, CartItem> carts = new HashMap<>();

    //增加的功能
    public void add(CartItem cartItem){
        //1.拼接一个特殊key
        String key=cartItem.getRed()+"-"+cartItem.getBlue();

        if (carts.containsKey(key)){
            //如果购物车里有这一注
            CartItem cartItem1 = carts.get(key);
            int count = cartItem1.getCount();
            //注数加1
            cartItem1.setCount(count+1);
        }else {
            carts.put(key,cartItem);
        }
    }


    //删除单个的功能
    public void remove(String key){
        carts.remove(key);
    }
    //清空的功能
    public void clear(){
        carts.clear();
    }

    // 计算总价
    public double total(){
        Collection<CartItem> values = carts.values();
        double total=0;
        for (CartItem value : values) {
           total += value.getSubtotal();
        }
        return total;
    }

    //获取购物车中彩票的数量
    public int count(){
        Collection<CartItem> values = carts.values();
        int count=0;
        for (CartItem value : values) {
            count += value.getCount();
        }
        return count;
    }

    /**
     * 对外提供方法: 获取所有的CartItem
     */
    public Collection<CartItem> getCartItems(){
        return carts.values();
    }

}