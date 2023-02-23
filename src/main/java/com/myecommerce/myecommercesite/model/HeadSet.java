package com.myecommerce.myecommercesite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "headsets")
@PrimaryKeyJoinColumn(name = "fk_product_id")
public class HeadSet extends Product {
    @Column(name = "speaker_dimensions")
    private Integer speakerDimensions;
    @Column(name = "cable_length")
    private Double cableLength;
    @Column(name = "bluetooth")
    private String isBluetooth;
    @Column(name = "microphone_dimensions")
    private String microphoneDimensions;

    public HeadSet() {
    }

    public HeadSet(String generalDescription, String technicalDescription, String name, String sku, Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean,Integer sold, Integer speakerDimensions, Double cableLength, String isBluetooth, String microphoneDimensions) {
        super(generalDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean, sold );
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


}
