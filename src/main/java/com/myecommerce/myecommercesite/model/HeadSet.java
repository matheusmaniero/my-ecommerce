package com.myecommerce.myecommercesite.model;

public class HeadSet extends Product {

    private Integer speakerDimensions;

    private Double cableLength;

    private String isBluetooth;

    private String microphoneDimensions;

    public HeadSet(Integer id, String name, String sku,
                   Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean,
                   Integer speakerDimensions, Double cableLength, String isBluetooth, String microphoneDimensions) {
        super(id, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
        this.speakerDimensions = speakerDimensions;
        this.cableLength = cableLength;
        this.isBluetooth = isBluetooth;
        this.microphoneDimensions = microphoneDimensions;
    }

    public Integer getSpeakerDimensions() {
        return speakerDimensions;
    }

    public void setSpeakerDimensions(Integer speakerDimensions) {
        this.speakerDimensions = speakerDimensions;
    }

    public Double getCableLength() {
        return cableLength;
    }

    public void setCableLength(Double cableLength) {
        this.cableLength = cableLength;
    }

    public String getIsBluetooth() {
        return isBluetooth;
    }

    public void setIsBluetooth(String isBluetooth) {
        this.isBluetooth = isBluetooth;
    }

    public String getMicrophoneDimensions() {
        return microphoneDimensions;
    }

    public void setMicrophoneDimensions(String microphoneDimensions) {
        this.microphoneDimensions = microphoneDimensions;
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
