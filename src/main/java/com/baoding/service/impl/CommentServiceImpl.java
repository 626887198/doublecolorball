package com.baoding.service.impl;

import com.baoding.bean.Comment;
import com.baoding.dao.CommentDao;
import com.baoding.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao dao;
    @Override
    public void save(Comment comment) {
          dao.save(comment);
    }
}
