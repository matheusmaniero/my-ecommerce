package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cameras")
@PrimaryKeyJoinColumn(name = "fk_product_id")
public class Camera extends Product {
    @Column(name = "optical_zoom")
    private Integer opticalZoom;
    @Column(name = "recording_resolution")
    private String recordingResolution;
    @Column(name = "screen_size")
    private Double screenSize;
    @Enumerated(EnumType.STRING)
    @Column(name = "connection_type")
    private ConnectionEnum connection;
    @Column(name = "video_resolution")
    private String videoResolution;
    @Column(name = "storage")
    private Integer storage;

    public Camera() {

    }

    public Camera(String generalDescription, String technicalDescription, String name, String sku, Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean, Integer opticalZoom, String recordingResolution, Double screenSize, ConnectionEnum connection, String videoResolution, Integer storage) {
        super(generalDescription, technicalDescription, name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
        this.opticalZoom = opticalZoom;
        this.recordingResolution = recordingResolution;
        this.screenSize = screenSize;
        this.connection = connection;
        this.videoResolution = videoResolution;
        this.storage = storage;
    }

    public Integer getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(Integer opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public String getRecordingResolution() {
        return recordingResolution;
    }

    public void setRecordingResolution(String recordingResolution) {
        this.recordingResolution = recordingResolution;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public ConnectionEnum getConnection() {
        return connection;
    }

    public void setConnection(ConnectionEnum connection) {
        this.connection = connection;
    }

    public String getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(String videoResolution) {
        this.videoResolution = videoResolution;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }


}

