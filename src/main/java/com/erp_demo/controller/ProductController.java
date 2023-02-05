package com.erp_demo.controller;

import com.erp_demo.entity.ProductEntity;
import com.erp_demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductRepository productRepository;


    // constructor
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // displaying all products
    @GetMapping("")
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }


    // display product chosen by id
    @GetMapping("/{id}")
    public Optional<ProductEntity> getProduct(@PathVariable("id") UUID id) {
        return productRepository.findById(id);
    }


    record NewProductRequest(
            String brand,
            String category,
            String definitionState, // 1 - new, 2 - approved, 3 - canceled, 4 - archival
            String measureUnit,
            String description
    ) {}


    // add new product
    @PostMapping("")
    public ProductEntity addProduct(@RequestBody NewProductRequest request) {
        ProductEntity product = new ProductEntity();

        product.setBrand(request.brand);
        product.setCategory(request.category);
        product.setDefinitionState(request.definitionState);
        product.setMeasureUnit(request.measureUnit);
        product.setDescription(request.description);

        productRepository.save(product);
        return product;
    }


    // delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void ProductEntity(@PathVariable("id") UUID id,
                              @RequestBody NewProductRequest request) {
        ProductEntity product = productRepository.getById(id);

        product.setBrand(request.brand);
        product.setCategory(request.category);
        product.setDefinitionState(request.definitionState);
        product.setMeasureUnit(request.measureUnit);
        product.setDescription(request.description);

        productRepository.save(product);
    }
}
