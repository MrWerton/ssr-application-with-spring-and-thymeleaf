package com.notrew.rosa.modules.product.controllers;


import com.notrew.rosa.modules.product.dtos.ChangeStatusDto;
import com.notrew.rosa.modules.product.dtos.ProductDTO;
import com.notrew.rosa.modules.product.usecases.ChangeStatusProductUseCase;
import com.notrew.rosa.modules.product.usecases.ListProductsUseCase;
import com.notrew.rosa.modules.product.usecases.RemoveProductUseCase;
import com.notrew.rosa.modules.product.usecases.SaveProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Tag(name = "rosa")
public class ProductController {

    private final SaveProductUseCase saveProductUseCase;
    private final ChangeStatusProductUseCase changeStatusProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final RemoveProductUseCase removeProductUseCase;


    @Autowired
    public ProductController(SaveProductUseCase saveProductUseCase, ChangeStatusProductUseCase changeStatusProductUseCase, ListProductsUseCase listProductsUseCase, RemoveProductUseCase removeProductUseCase) {
        this.saveProductUseCase = saveProductUseCase;
        this.changeStatusProductUseCase = changeStatusProductUseCase;
        this.listProductsUseCase = listProductsUseCase;
        this.removeProductUseCase = removeProductUseCase;
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        return "form";
    }

    @Operation(method = "post", description = "insert new products")

    @PostMapping("/create")
    public String processForm(@ModelAttribute(value = "product") ProductDTO product) {

        saveProductUseCase.call(product);
        return "redirect:/";
    }

    @Operation(method = "get", description = "update product status")
    @GetMapping("/update/{id}/{status}")
    public String processForm(@PathVariable("id") String id, @PathVariable("status") String status) {
        final var newData = new ChangeStatusDto(id, status);
        changeStatusProductUseCase.call(newData);
        return "redirect:/";
    }

    @Operation(method = "get", description = "List all the products")

    @GetMapping("/")
    public String listProducts(Model model) {
        final var products = listProductsUseCase.call();
        model.addAttribute("products", products);
        return "products";
    }

    @Operation(method = "get", description = "delete product")
    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable String id, Model model) {
        removeProductUseCase.call(id);
        return "redirect:/";
    }

}
