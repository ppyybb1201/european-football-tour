package ync.pyb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ync.pyb.dto.ProductDTO;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    public void testGet() {
        ProductDTO productDTO = productService.productDetailGet(1L);
        System.out.println(productDTO);
    }


}
