package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String name;
    private long length;

    @Column(length = 255)
    private String saveFileName;

    @Column(length = 255)
    private String mimeType;

    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;


}
