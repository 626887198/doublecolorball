package com.baoding.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Prizegrade {
    @Id
    private String pid;
    private String code;
    private String type;
    private String typenum;
    private String typemoney;
}
