package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinTable (
            name = "promotion_category",
            joinColumns = @JoinColumn(name="fk_category_id"),
            inverseJoinColumns = @JoinColumn(name="fk_promotion_id")
    )
    private Promotion promotion;

    public Category(){};

    public Category(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
