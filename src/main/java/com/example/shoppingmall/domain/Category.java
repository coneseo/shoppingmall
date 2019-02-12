package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;
    private int ordering;

    @OneToMany(mappedBy = "category")
    private List<Beer> beers;

    public Category(){
        beers = new ArrayList<>();
    }
}
