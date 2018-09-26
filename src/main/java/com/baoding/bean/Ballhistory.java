package com.baoding.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Ballhistory {
   @Id
    private String code;
    private String name;
    private String date;
    private String week;
    private String red;
    private String blue;
    private String sales;
    private String poolmoney;
    private String content;
    @OneToMany(mappedBy = "code")
    List<Prizegrade> prizegrades;

  
}
