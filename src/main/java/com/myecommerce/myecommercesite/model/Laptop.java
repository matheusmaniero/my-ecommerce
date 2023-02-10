package com.myecommerce.myecommercesite.model;

public class Laptop extends Product {
    private String processor;
    private Integer ram;
    private Integer storage;
    private Double screenSize;
    private String operatingSystem;

    public Laptop(Integer id, String name, String sku, Double weight, Double width, Double height, Double depth,
                  String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean, String processor, Integer ram, Integer storage, Double screenSize, String operatingSystem) {
        super(id,  name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
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