package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가.
    private Long id;
    @Column(length = 255)
    private String name;
    @Column(length = 255)
    private String passwd;
    @Lob
    private String content;
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;

    public Comment(){
        createDate = new Date();
    }
}