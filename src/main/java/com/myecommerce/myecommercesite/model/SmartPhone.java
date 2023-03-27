package com.myecommerce.myecommercesite.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "smartphones")
@PrimaryKeyJoinColumn(name = "fk_product_id")
public class SmartPhone extends Product {
    @Column(name = "storage")
    @NotNull(message = "This field can't be empty.")
    private Integer storage;
    @Column(name = "screen_size")
    @NotNull(message = "This field can't be empty.")
    private Double screenSize;
    @Column(name = "operating_system")
    @NotNull(message = "This field can't be empty.")
    private String operatingSystem;
    @Column(name = "camera_resolution")
    @NotNull(message = "This field can't be empty.")
    private Integer cameraResolution;

    public SmartPhone() {
    }

    public SmartPhone(String generalDescription, String technicalDescription, String name, String sku, Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean,Integer sold, Integer storage, Double screenSize, String operatingSystem, Integer cameraResolution) {
        super(generalDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean, sold );
        this.storage = storage;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.cameraResolution = cameraResolution;
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

    public Integer getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(Integer cameraResolution) {
        this.cameraResolution = cameraResolution;
    }


}



