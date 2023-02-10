package com.myecommerce.myecommercesite.model;

public class SmartPhone extends Product {
    private Integer storage;
    private Double screenSize;
    private String operatingSystem;
    private Integer cameraResolution;


    public SmartPhone(Integer id, String name, String sku, Double weight,
                      Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean,
                      Integer storage, Double screenSize, String operatingSystem,  Integer cameraResolution) {
        super(id, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
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

    public void setTechnicalDescription(String description){
        super.setTechnicalDescription(description);
    }

    public String getTechnicalDescription(){
        return super.getTechnicalDescription();
    }

    public void setGeneralDescription(String description){
        super.setGeneralDescription(description);
    }

    public String getGeneralDescription(){
        return super.getGeneralDescription();
    }
}
