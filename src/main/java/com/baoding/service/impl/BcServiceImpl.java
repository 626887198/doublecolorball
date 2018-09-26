package com.baoding.service.impl;

import com.baoding.bean.Ballhistory;
import com.baoding.dao.BcDao;
import com.baoding.service.BcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BcServiceImpl implements BcService {
    @Autowired
    BcDao dao;

    @Override
    public List<Ballhistory> findAll() {
        return dao.findAll();
    }

    @Override
    public Ballhistory findBy(String code) {
        return dao.getOne(code);
    }

    // 分页查询
    public Page<Ballhistory> findByPage(Pageable pageable){
         return dao.findAll(pageable);
    }
}
