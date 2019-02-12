package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String nickname;

    @Column(length = 20)
    private String phoneNum1;

    @Column(length = 20)
    private String phoneNum2;

    @Column(length = 20)
    private String phoneNum3;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Wish> wishes;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User(){
        createDate = new Date();
        roles = new HashSet<>();
        wishes = new ArrayList<>();
        carts = new ArrayList<>();
        orders = new ArrayList<>();
    }
}
