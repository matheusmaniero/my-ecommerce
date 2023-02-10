package com.myecommerce.myecommercesite.model;

public class Camera extends Product {
    private Integer opticalZoom;
    private String recordingResolution;
    private Double screenSize;
    private ConnectionEnum connection;
    private String videoResolution;
    private Integer storage;

    public Camera(Integer id, String name, String sku, Double weight, Double width, Double height, Double depth,
                  String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean, Integer opticalZoom, String recordingResolution,
                  Double screenSize, ConnectionEnum connection, String videoResolution, Integer storage) {
        super(id,  name, sku, weight, width, height, depth, manufacturer, category, price, color, model, quantity, ean);
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
