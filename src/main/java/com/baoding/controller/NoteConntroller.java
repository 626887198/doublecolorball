package com.baoding.controller;

import com.baoding.bean.Note;
import com.baoding.bean.User;
import com.baoding.service.NoteService;
import com.baoding.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteConntroller {
    @Autowired
    private NoteService service;
    @RequestMapping("/noteUI")
    public String noteui(Model model){
         List<Note> notes= service.findAll();
         Collections.reverse(notes);
         model.addAttribute("notes",notes);
         return "bbs_index";
    }


    @PostMapping("/add")
    public String add(Note note, HttpSession session, HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        note.setTime(new Date().toLocaleString());
        note.setUsername(user.getUsername());
        note.setAddr(request.getRemoteAddr());
        note.setNid(UUIDUtils.getId());
        
       service.save(note);
       return "redirect:/note/noteUI"  ;
    }
    @GetMapping("/detail")
    public String details(Model model,String nid){
        Note note = service.findByNid(nid);
        model.addAttribute("note",note);
        return "bbs_detail";
    }
}
