package com.baoding.service.impl;

import com.baoding.bean.Note;
import com.baoding.dao.NoteDao;
import com.baoding.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao dao;
    @Override
    public List<Note> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Note note) {
        dao.save(note);
    }

    @Override
    public Note findByNid(String nid) {
        return dao.getOne(nid);
    }

    @Override
    public Note findTopByOrderByTimeDesc() {
        return dao.findTopByOrderByTimeDesc();
    }


}
