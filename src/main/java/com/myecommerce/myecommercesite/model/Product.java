package com.myecommerce.myecommercesite.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")

public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="general_description")
    @NotNull(message = "This field can't be empty.")
    private String generalDescription;
    @Column(name="technical_description")
    @NotNull(message = "This field can't be empty.")
    private String technicalDescription;
    @Column(name="name")
    @NotNull(message = "This field can't be empty.")
    @Size(message = "Only max 25 characters are acceptable",max = 25)
    private String name;
    @Column(name="sku")
    @NotNull(message = "This field can't be empty.")
    private String sku;
    @Column(name="weight")
    @NotNull(message = "This field can't be empty.")
    private Double weight;
    @Column(name="width")
    @NotNull(message = "This field can't be empty.")
    private Double width;
    @Column(name="height")
    @NotNull(message = "This field can't be empty.")
    private Double height;
    @Column(name="depth")
    @NotNull(message = "This field can't be empty.")
    private Double depth;
    @Column(name="manufacturer")
    @NotNull(message = "This field can't be empty.")
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private Category category;
    @Column(name="price")
    @NotNull(message = "This field can't be empty.")
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(name="color")
    @NotNull(message = "This field can't be empty.")
    private ColorEnum color;
    @Column(name="model")
    @NotNull(message = "This field can't be empty.")
    private String model;
    @Column(name="quantity")
    @NotNull(message = "This field can't be empty.")
    private Integer quantity;
    @Column(name="ean")
    @NotNull(message = "This field can't be empty.")
    private Long ean;
    @Column(name="sold")
    private Integer sold;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
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


    public void setProductPhotos(List<ProductPhoto> productPhotos) {
        this.productPhotos = productPhotos;
    }
};



