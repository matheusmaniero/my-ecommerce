package com.myecommerce.myecommercesite.model;

import jakarta.persistence.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Entity
@Table(name="product_photos")
public class ProductPhoto {

    final static String imagePath = "/home/matheuz/resizedimages/";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_product_id")
    private Product product;

    @Column(name = "file_name")
    private String fileName;
    @Transient
    private String photo;

    public ProductPhoto() {
    }

    public ProductPhoto(Product product, String fileName) {
        this.product = product;
        this.fileName = fileName;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPhoto() {
        return photo;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @PostLoad
    public void loadByteArray()  {
        File imageFile = new File(imagePath+this.fileName);
        try {
            byte[] bArray =  Files.readAllBytes(imageFile.toPath());
            this.photo = Base64.getEncoder().encodeToString(bArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("cheguei aki");

    }
}
