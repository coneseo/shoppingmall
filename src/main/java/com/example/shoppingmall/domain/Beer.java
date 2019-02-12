package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "beers")
@Getter
@Setter
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column
    private Long price;
    @Column
    private Long amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "beer")
    private List<Cart> carts;

    @OneToMany(mappedBy = "beer")
    private List<Wish> wishes;

    @OneToMany(mappedBy = "beer")
    private List<OrderProduct> orderProducts;

}
