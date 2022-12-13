package ync.pyb.service;

import ync.pyb.dto.ProductDTO;
import ync.pyb.entity.Product;

public interface ProductService {

    ProductDTO get(Long productId);


    default ProductDTO entityToDTO(Product product){

        ProductDTO productDTO = ProductDTO.builder()
                .productTitle(product.getProductTitle())
                .productId(product.getProductId())
                .productArrival(product.getProductArrival())
                .productDeparture(product.getProductDeparture())
                .productCount(product.getProductCount())
                .detail(product.getDetail()).build();
        return productDTO;

    }
}
