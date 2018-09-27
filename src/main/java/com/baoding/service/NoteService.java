package com.baoding.service;

import com.baoding.bean.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll();

    void save(Note note);

    Note findByNid(String nid);

    Note findTopByOrderByTimeDesc();
}
