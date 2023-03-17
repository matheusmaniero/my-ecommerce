package com.myecommerce.myecommercesite.controller;

import com.myecommerce.myecommercesite.model.Category;
import com.myecommerce.myecommercesite.model.Product;
import com.myecommerce.myecommercesite.service.CategoryService;
import com.myecommerce.myecommercesite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class StoreController {
    final private ProductService productService;
    final private CategoryService categoryService;

    private List<Category> allCategories;

    private HashMap<String,Boolean> map = new HashMap<>();

    @Autowired
    public StoreController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/store/{category}")
    public String showProducts(@PathVariable String category ,@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "9") int max,
                               @RequestParam(defaultValue = "unsorted") String sortingType, Model model,@RequestParam(required = false) Double priceMax,
                               @RequestParam (required = false) Double priceMin){

        Page<Product> bestSellersPaginated = this.productService.getBestSellers(1,3);

        Page<Product> productsPaginated = this.productService.serviceProductHandler(page,max,category,sortingType,priceMax,priceMin);
         allCategories = this.categoryService.getAllCategories();

        if (productsPaginated == null) return "error";

        String sortingDisplayName = new String();

        if (sortingType.equals("unsorted")) sortingDisplayName = "Any";
        else if (sortingType.equals("asc")) sortingDisplayName = "Lowest Prices";
        else if (sortingType.equals("desc")) sortingDisplayName = "Highest Prices";
        else if (sortingType.equals("relevance")) sortingDisplayName = "Best Sellers";

        String priceRangeFilter = "";
        if (priceMax != null & priceMin != null) priceRangeFilter = "&priceMin="+priceMin+"&priceMax="+priceMax;


        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());
        model.addAttribute("selectedMax",max);
        model.addAttribute("sortingType",sortingType);
        model.addAttribute("sortingDisplayName",sortingDisplayName);
        model.addAttribute("allCategories",allCategories);
        model.addAttribute("priceRangeFilter",priceRangeFilter);
        model.addAttribute("priceMaxParam",priceMax);
        model.addAttribute("priceMinParam",priceMin);
        model.addAttribute("bestSellerPage",bestSellersPaginated);

        return "store";
    }
    @GetMapping("/store")
    public String showProductsWithMultipleCategories(@RequestParam(required = false,name = "Laptops") boolean laptops, @RequestParam(required = false,name = "Cameras") boolean cameras,
                                                     @RequestParam(required = false,name = "Headsets") boolean headsets, @RequestParam(required = false,name = "Smartphones") boolean smartphones,
                                                     Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "9") int max, @RequestParam(required = false) Double priceMax,
                                                     @RequestParam (required = false) Double priceMin, @RequestParam(defaultValue = "unsorted") String sortingType){

        map.put("Laptops",laptops);
        map.put("Cameras",cameras);
        map.put("Headsets",headsets);
        map.put("Smartphones",smartphones);

        StringBuilder sb = new StringBuilder();

        map.forEach((key,value) -> {
            if (value){
                sb.append("&").append(key).append("=on");
            }
        });

        String filtersOn  = sb.toString();

        String sortingDisplayName = new String();

        if (sortingType.equals("unsorted")) sortingDisplayName = "Any";
        else if (sortingType.equals("asc")) sortingDisplayName = "Lowest Prices";
        else if (sortingType.equals("desc")) sortingDisplayName = "Highest Prices";
        else if (sortingType.equals("relevance")) sortingDisplayName = "Best Sellers";

        if(this.allCategories == null){
            this.allCategories = this.categoryService.getAllCategories();
        }

        for(Category cat : this.allCategories){
            if (cat.isChecked() != map.get(cat.getName())) cat.setChecked(map.get(cat.getName()));
        }
        Page<Product> bestSellersPaginated = this.productService.getBestSellers(1,3);
        Page<Product> productsPaginated = this.productService.getProductsByMultipleCategories(page,max,this.allCategories,sortingType,priceMax,priceMin);

        String priceRangeFilter = "";
        if (priceMax != null & priceMin != null) priceRangeFilter = "&priceMin="+priceMin+"&priceMax="+priceMax;

        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());
        model.addAttribute("selectedMax",max);
        model.addAttribute("sortingType",sortingType);
        model.addAttribute("sortingDisplayName",sortingDisplayName);
        model.addAttribute("allCategories",this.allCategories);
        model.addAttribute("cameras",cameras);
        model.addAttribute("laptops",laptops);
        model.addAttribute("headsets",headsets);
        model.addAttribute("smartphones",smartphones);
        model.addAttribute("filtersOn",filtersOn);
        model.addAttribute("priceRangeFilter",priceRangeFilter);
        model.addAttribute("priceMaxParam",priceMax);
        model.addAttribute("priceMinParam",priceMin);
        model.addAttribute("bestSellerPage",bestSellersPaginated);
        return "store";

    }

    @GetMapping("/search")
    public String search(@RequestParam String searchTerm, @RequestParam String category,
                         @RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "9") int max,
                         Model model, @RequestParam(defaultValue = "unsorted") String sortingType,
                         @RequestParam(required = false) Double priceMax,
                         @RequestParam (required = false) Double priceMin){

        Page<Product> productsPaginated = this.productService.search(searchTerm,category,page,max, priceMax,priceMin, sortingType);

        if (productsPaginated == null) return "error";

        Page<Product> bestSellersPaginated = this.productService.getBestSellers(1,3);

        String sortingDisplayName = new String();

        if (sortingType.equals("unsorted")) sortingDisplayName = "Any";
        else if (sortingType.equals("asc")) sortingDisplayName = "Lowest Prices";
        else if (sortingType.equals("desc")) sortingDisplayName = "Highest Prices";
        else if (sortingType.equals("relevance")) sortingDisplayName = "Best Sellers";

        String priceRangeFilter = "";
        if (priceMax != null & priceMin != null) priceRangeFilter = "&priceMin="+priceMin+"&priceMax="+priceMax;

        String searchConcat = "&category="+category+"&searchTerm="+searchTerm;

        model.addAttribute("productsPaginated",productsPaginated);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",productsPaginated.getTotalPages());
        model.addAttribute("selectedMax",max);
        model.addAttribute("sortingType",sortingType);
        model.addAttribute("sortingDisplayName",sortingDisplayName);
        model.addAttribute("allCategories",allCategories);
        model.addAttribute("priceRangeFilter",priceRangeFilter);
        model.addAttribute("priceMaxParam",priceMax);
        model.addAttribute("priceMinParam",priceMin);
        model.addAttribute("bestSellerPage",bestSellersPaginated);
        model.addAttribute("searchConcat",searchConcat);
        model.addAttribute("searchTerm",searchTerm);
        model.addAttribute("category",category);

        return "store";

    }








}
