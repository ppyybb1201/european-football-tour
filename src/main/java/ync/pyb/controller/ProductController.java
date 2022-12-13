package ync.pyb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ync.pyb.dto.ProductDTO;
import ync.pyb.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> get(@PathVariable("productId") Long productId){
        return new ResponseEntity<>(productService.get(productId), HttpStatus.OK);
    }
}
