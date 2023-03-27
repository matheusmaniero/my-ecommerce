package com.myecommerce.myecommercesite.service;

import com.myecommerce.myecommercesite.model.ProductPhoto;
import com.myecommerce.myecommercesite.model.SmartPhone;
import com.myecommerce.myecommercesite.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminServices {

    final static String imagePath = "/home/matheuz/resizedimages/";

    final public ProductRepository productRepository;

    public AdminServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createNewSmartphone(SmartPhone smartPhone, MultipartFile image1, MultipartFile image2, MultipartFile image3){

        List<MultipartFile> images = Arrays.asList(image1,image2,image3);

        addPhotos(smartPhone, images);

        this.productRepository.save(smartPhone);


    }

    private static void addPhotos(SmartPhone smartPhone, List<MultipartFile> images) {
        for (MultipartFile file : images){
            if (!file.isEmpty()){
                String originalFileName = file.getOriginalFilename();
                String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
                String newFileName = smartPhone.getCategory().getName()+System.currentTimeMillis()+extension;
                createProductPhoto(smartPhone, newFileName);
                writeFile(file,newFileName);
            }
        }
    }

    private static void writeFile(MultipartFile file, String newFileName)  {

        Path path = Paths.get(imagePath+newFileName);
        try {
            Files.write(path,file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void createProductPhoto(SmartPhone smartPhone, String newFileName) {
        ProductPhoto pp = new ProductPhoto();
        pp.setProduct(smartPhone);

        pp.setFileName(newFileName);
        if (smartPhone.getProductPhotos() == null){
            smartPhone.setProductPhotos(new ArrayList<>());
        }
        smartPhone.getProductPhotos().add(pp);
    }


}
