package com.baoding.bean;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Note {
    //帖子的编号
    @Id
    private String nid;
    //帖子的标题
    private String title;
    //帖子的内容
    private String content;
    //发帖的时间
    private String time;
    //谁发的帖子
    private String username;
    //发帖人的ip地址
    private String addr;

    //配置一个一对多的关系
    @OneToMany(mappedBy = "nid")
    private List<Comment> comments;
}
