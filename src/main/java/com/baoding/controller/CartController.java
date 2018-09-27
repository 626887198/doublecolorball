package com.baoding.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baoding.bean.Cart;
import com.baoding.bean.CartItem;
import com.baoding.utils.BallUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    //选号页面
    @RequestMapping("/select")
    public String select(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
        }
        session.setAttribute("cart",cart);
        return "selectnum";
    }
    //购物车
    @GetMapping("/")
    public String cart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
        }
        session.setAttribute("cart",cart);
        return "cart";
    }

    //添加购物项
    @RequestMapping("/add")
    @ResponseBody      //不跳转页面 只需要给前端响应一个条数
    public int add(String keys,HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
        }
        List<String> keyArr = JSON.parseArray(keys,String.class);
        for (String key : keyArr) {
            CartItem cartItem=new CartItem();
            String[] ball = key.split("-");
            cartItem.setRed(ball[0]);
            cartItem.setBlue(ball[1]);
            cart.add(cartItem);
        }
        session.setAttribute("cart",cart);
//        System.out.println(cart.count());
        return cart.count();
    }


    //机选一注
    @RequestMapping("/addOne")
   public String addOne(HttpSession session){
        String blueBall = BallUtils.randomBlueBall();
        String redBall = BallUtils.randomRedBall();

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            cart=new Cart();
        }
            CartItem cartItem=new CartItem();
            cartItem.setRed(redBall);
            cartItem.setBlue(blueBall);
            cart.add(cartItem);

        session.setAttribute("cart",cart);
        return "redirect:/cart/";
    }
    //清空
    @RequestMapping("/clear")
    public String clear(HttpSession session){
        Cart cart=new Cart();
        session.setAttribute("cart",cart);
        return "redirect:/cart/";
    }
    //删除单个
    @GetMapping("/removeOne")
    public String removeOne(String key,HttpSession session){
        Cart cart=(Cart) session.getAttribute("cart");
        cart.remove(key);
        session.setAttribute("cart",cart);
        return "redirect:/cart/";
    }
}
