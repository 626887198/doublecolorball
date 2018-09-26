package com.baoding.dao;

import com.baoding.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,String> {
}
