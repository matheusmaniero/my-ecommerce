package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.SmartPhone;
import com.myecommerce.myecommercesite.service.AdminServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final private AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @GetMapping("/new-smartphone")
    public String showSmartphoneForm(Model model){

        SmartPhone smartphone = new SmartPhone();
        model.addAttribute("smartphone",smartphone);
        return "new-smartphone.html";

    }

    @PostMapping("/new-smartphone")
    public String createSmartPhone(@ModelAttribute @Valid SmartPhone smartPhone, BindingResult result, Model model,
                                   @RequestParam("image1")MultipartFile image1, @RequestParam("image2")MultipartFile image2,
                                   @RequestParam("image3")MultipartFile image3){

        if (!image1.isEmpty()){
            System.out.println("hola!");
        }

        Category cat = new Category("Smartphone");
        cat.setId(2);
        smartPhone.setCategory(cat);

        if(result.hasErrors()){
            List<FieldError> errors = result.getFieldErrors();
            model.addAttribute("errors",errors);
            model.addAttribute("smartphone",smartPhone);
            return "new-smartphone";


        }

        this.adminServices.createNewSmartphone(smartPhone,image1,image2,image3);
        return "redirect:/admin/new-smartphone";




    }


}
