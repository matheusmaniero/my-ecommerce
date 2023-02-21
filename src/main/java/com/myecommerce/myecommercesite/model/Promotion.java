package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
@Entity
@Table(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="discount_rate")
    private Double discountRate;
    @Column(name="start_date")
    private ZonedDateTime startDate;
    @Column(name="end_date")
    private ZonedDateTime endDate;

    public Promotion() {
    }

    public Promotion(Integer id, String name, String description, Double discountRate, ZonedDateTime startDate, ZonedDateTime endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.discountRate = discountRate;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }
}
