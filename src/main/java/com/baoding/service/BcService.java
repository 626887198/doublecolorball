package com.baoding.service;

import com.baoding.bean.Ballhistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BcService {
    List<Ballhistory> findAll();

    Ballhistory findBy(String code);

    Page<Ballhistory> findByPage(Pageable pageable);
}
