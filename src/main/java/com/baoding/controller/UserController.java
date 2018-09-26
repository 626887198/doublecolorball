package com.baoding.controller;

import com.aliyuncs.exceptions.ClientException;
import com.baoding.bean.Note;
import com.baoding.bean.User;
import com.baoding.service.UserService;
import com.baoding.utils.BallUtils;
import com.baoding.utils.SMSutils;
import com.baoding.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
  private UserService service;

    @GetMapping("/sendSms")
    @ResponseBody
    public String sendSms(String phone, HttpSession session){
        try {
            String ServerCode = SMSutils.sendSms(phone);
            session.setAttribute("serverCode",ServerCode);
        } catch (ClientException e) {
            e.printStackTrace();
            return "fail";
        }
        return "success"; //直接输出到浏览器
    }

    @GetMapping("/registerUI")
    public String registerUI(){

        return "register";
    }

    @GetMapping("/loginUI")
    public  String login(){
        return "login";
    }

    /**
     * 注册逻辑
     */
    @PostMapping("/register")
    public String register(User user,String yanzhengcode,HttpSession session,Model model){
         String serverCode = (String) session.getAttribute("serverCode");
         if (!serverCode.equals(yanzhengcode)){  //校验失败
             System.out.println(serverCode);
             System.out.println(yanzhengcode);
             model.addAttribute("msg","验证码不正确！");
             return "register";
         }
        //1.接收参数,封装剩余参数
        user.setUid(UUIDUtils.getId());
        user.setState(1);
        user.setMoney(100);

        //2.调用业务
        service.doRegister(user);   //密码加盐

        //3.重定向去登录页面
        return "redirect:/user/loginUI";
    }
     @PostMapping("/dologin")
    public String dologin(String phone,String password,HttpSession session,Model model){
       User user = service.doLogin(phone,password);
       if (user==null){
           model.addAttribute("loginmsg","帐号或者密码不正确");
           return "login";
       }
       session.setAttribute("user",user);
         return "redirect:/";
    }

//    我的页面
    @GetMapping("/myUI")
    public String myUI(Model model){
        String redBall = BallUtils.randomRedBall();
        model.addAttribute("red",redBall);
        String blueBall = BallUtils.randomBlueBall();
        model.addAttribute("blue",blueBall);

        return "my";
    }

    //重置密码

   @RequestMapping("/resetpassword")
    public String resetPassword(){
        return "resetpassword";
    }

    @PostMapping("/reset")
    public String reset(String phone,String password,String yanzhengcode,HttpSession session,Model model){
        String serverCode = (String) session.getAttribute("serverCode");
        if (!Objects.equals(yanzhengcode, serverCode)){
           model.addAttribute("msge","验证码错误！");
           return "/resetpassword";
        }else {
          User user=  service.findByPhone(phone);
          user.setPassword(password);
          service.doRegister(user);
        }
       return "/user/loginUI" ;
    }

    
}
