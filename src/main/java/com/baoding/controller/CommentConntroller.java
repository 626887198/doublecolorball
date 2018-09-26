package com.baoding.controller;

import com.baoding.bean.Comment;
import com.baoding.bean.User;
import com.baoding.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentConntroller {
    @Autowired
    private CommentService service;
    @PostMapping("/add")
    public  String add(Comment comment, HttpServletRequest request, HttpSession session){
         comment.setAddr(request.getRemoteAddr());
        User user = (User) session.getAttribute("user");
        comment.setUsername(user.getUsername());
        comment.setTime(new Date().toLocaleString());
        service.save(comment);
        return "redirect:/note/detail?nid="+comment.getNid();
    }
}
