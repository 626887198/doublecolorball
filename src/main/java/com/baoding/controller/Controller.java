package com.baoding.controller;

import com.baoding.bean.Ballhistory;
import com.baoding.service.BcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    BcService service;

    @GetMapping("/")
    public String index(Model model, Integer pageNumber) {
        if(pageNumber==null||pageNumber<1){
            pageNumber=1;
        }

        //每页显示的数量
        int size=10;
        //创建一个排序的对象
        Sort sort=new Sort(Sort.Direction.DESC,"code");
        Pageable pageable=new PageRequest(pageNumber-1,size,sort);
        Page<Ballhistory> balls = service.findByPage(pageable);
        model.addAttribute("balls", balls);
        return "index.html";

    }

    @GetMapping("/details")
    public String details(String code,Model model){
      Ballhistory ball=  service.findBy(code);
      model.addAttribute("ball",ball);
        return "details.html";

    }




}
