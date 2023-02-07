package com.erp_demo.controller;

import com.erp_demo.dto.ProductDTO;
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

    // for add and update product
    ProductDTO newProduct = new ProductDTO();

    // add new product
    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDTO newProduct) {
        ProductEntity product = new ProductEntity();

        product.setBrand(newProduct.getBrand());
        product.setCategory(newProduct.getCategory());
        product.setDefinitionState(newProduct.getDefinitionState());
        product.setMeasureUnit(newProduct.getMeasureUnit());
        product.setDescription(newProduct.getDescription());

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
                              @RequestBody ProductDTO newProduct) {
        ProductEntity product = productRepository.getById(id);

        product.setBrand(newProduct.getBrand());
        product.setCategory(newProduct.getCategory());
        product.setDefinitionState(newProduct.getDefinitionState());
        product.setMeasureUnit(newProduct.getMeasureUnit());
        product.setDescription(newProduct.getDescription());

        productRepository.save(product);
    }
}
