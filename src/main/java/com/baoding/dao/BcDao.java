package com.baoding.dao;

import com.baoding.bean.Ballhistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BcDao extends JpaRepository<Ballhistory ,String>{
}
