package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
@PrimaryKeyJoinColumn(name = "fk_product_id")
public class Laptop extends Product {
    @Column(name="processor")
    private String processor;
    @Column(name="ram")
    private Integer ram;
    @Column(name="storage")
    private Integer storage;
    @Column(name="screen_size")
    private Double screenSize;
    @Column(name="operating_system")
    private String operatingSystem;

    public Laptop(){};

    public Laptop(String generalDescription, String technicalDescription, String name, String sku, Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean, String processor, Integer ram, Integer storage, Double screenSize, String operatingSystem) {
        super(generalDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
    }



    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}