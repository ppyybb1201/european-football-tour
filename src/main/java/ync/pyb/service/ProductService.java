package ync.pyb.service;

import ync.pyb.dto.ProductDTO;
import ync.pyb.entity.Product;

public interface ProductService {

    ProductDTO productDetailGet(Long productId);

    ProductDTO productManagerGet(Long productId);
    
    ProductDTO productHotelGet(Long productId);
}
