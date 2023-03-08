package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="general_description")
    private String generalDescription;
    @Column(name="technical_description")
    private String technicalDescription;
    @Column(name="name")
    private String name;
    @Column(name="sku")
    private String sku;
    @Column(name="weight")
    private Double weight;
    @Column(name="width")
    private Double width;
    @Column(name="height")
    private Double height;
    @Column(name="depth")
    private Double depth;
    @Column(name="manufacturer")
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private Category category;
    @Column(name="price")
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name="color")
    private ColorEnum color;
    @Column(name="model")
    private String model;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="ean")
    private Long ean;
    @Column(name="sold")
    private Integer sold;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPhoto> productPhotos;


    public Product(){
    }

    public Product(String generalDescription, String technicalDescription, String name, String sku, Double weight, Double width, Double height, Double depth, String manufacturer, Category category, Double price, ColorEnum color, String model, Integer quantity, Long ean, Integer sold) {

        this.generalDescription = generalDescription;
        this.technicalDescription = technicalDescription;
        this.name = name;
        this.sku = sku;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.color = color;
        this.model = model;
        this.quantity = quantity;
        this.ean = ean;
        this.sold = sold;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }

    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getEan() {
        return ean;
    }

    public void setEan(Long ean) {
        this.ean = ean;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public List<ProductPhoto> getProductPhotos() {
        return productPhotos;
    }
};



