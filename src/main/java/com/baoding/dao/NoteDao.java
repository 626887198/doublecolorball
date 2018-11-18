package com.baoding.dao;

import com.baoding.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note,String>{
    Note findTopByOrderByTimeDesc();
}
