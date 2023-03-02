package com.erp_demo.controller;

import com.erp_demo.dto.ProductDto;
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
    public ProductDto newProduct = new ProductDto();


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

    // add new product
    @PostMapping("")
    public ProductEntity addProduct(@RequestBody ProductDto productDto) {
        ProductEntity newProduct = new ProductEntity();

        newProduct.setCategory(productDto.getCategory());
        newProduct.setBrand(productDto.getBrand());
        newProduct.setModel(productDto.getModel());
        newProduct.setDefinitionState(productDto.getDefinitionState());
        newProduct.setMeasureUnit(productDto.getMeasureUnit());
        newProduct.setDescription(productDto.getDescription());

        productRepository.save(newProduct);
        return newProduct;
    }


    // delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ProductEntity ProductEntity(@PathVariable("id") UUID id,
                              @RequestBody ProductDto productDto) {
        ProductEntity editedProduct = productRepository.getById(id);

        editedProduct.setCategory(productDto.getCategory());
        editedProduct.setBrand(productDto.getBrand());
        editedProduct.setModel(productDto.getModel());
        editedProduct.setDefinitionState(productDto.getDefinitionState());
        editedProduct.setMeasureUnit(productDto.getMeasureUnit());
        editedProduct.setDescription(productDto.getDescription());

        productRepository.save(editedProduct);
        return editedProduct;
    }
}
