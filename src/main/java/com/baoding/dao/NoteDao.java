package com.baoding.dao;

import com.baoding.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<Note,String>{
    Note findTopByOrderByTimeDesc();
}
