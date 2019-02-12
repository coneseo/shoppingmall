package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "remain_address")
    private String remainAddress;

    @Column(name = "post_number")
    private String postNumber;

    @Column()
    private String receiver;

    @Column()
    private String depositor;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
