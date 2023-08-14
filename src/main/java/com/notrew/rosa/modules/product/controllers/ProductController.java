package com.notrew.rosa.modules.product.controllers;


import com.notrew.rosa.modules.product.dtos.ProductDTO;
import com.notrew.rosa.modules.product.usecases.ListProductsUseCase;
import com.notrew.rosa.modules.product.usecases.RemoveProductUseCase;
import com.notrew.rosa.modules.product.usecases.SaveProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final SaveProductUseCase saveProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final RemoveProductUseCase removeProductUseCase;


    @Autowired
    public ProductController(SaveProductUseCase saveProductUseCase, ListProductsUseCase listProductsUseCase, RemoveProductUseCase removeProductUseCase) {
        this.saveProductUseCase = saveProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.removeProductUseCase = removeProductUseCase;
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping("/create")
    public String processForm(@ModelAttribute(value = "product") ProductDTO product) {
        saveProductUseCase.call(product);
        return "redirect:/products/";
    }

    @GetMapping("/")
    public String listProducts(Model model) {
        final var products = listProductsUseCase.call();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable String id, Model model) {
        removeProductUseCase.call(id);
        return "redirect:/products/";
    }

}
