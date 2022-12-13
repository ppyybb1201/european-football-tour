package ync.pyb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ync.pyb.entity.Product;

import java.util.Optional;

@SpringBootTest
public class ProductRepoTests {

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void testGet(){

        Optional<Product> product = productRepo.findById(1L);
        Product product1  = product.get();
//
//        System.out.println(product1);


//        System.out.println(productRepo.get(1L));

//        System.out.println(productRepo.findById(1L));

//        System.out.println(productRepo.entityToDTO(product1));
    }








}
