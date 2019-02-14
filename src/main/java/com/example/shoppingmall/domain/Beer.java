package com.example.shoppingmall.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "beers")
@Getter
@Setter
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Long price;
    @Column
    private Long amount;
    @Column(name = "create_date")
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "beer")
    private List<Cart> carts;

    @OneToMany(mappedBy = "beer")
    private List<Wish> wishes;

    @OneToMany(mappedBy = "beer")
    private List<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "beer")
    private List<ImageFile> imageFiles;

    public Beer(){
        createDate = new Date();
        carts = new ArrayList<>();
        wishes = new ArrayList<>();
        orderProducts = new ArrayList<>();
        imageFiles = new ArrayList<>();
    }

    public void addImageFile(ImageFile imageFile){
        if(imageFile == null)
            imageFiles = new ArrayList<>();
        imageFile.setBeer(this);
        imageFiles.add(imageFile);
    }

    

}
