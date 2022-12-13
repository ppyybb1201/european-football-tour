package ync.pyb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ync.pyb.dto.ProductDTO;
import ync.pyb.entity.Product;
import ync.pyb.repository.ProductRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public ProductDTO get(Long productId) {
        Optional<Product> result = productRepo.findById(productId);

        Product product  = result.get();

        return entityToDTO(product);
    }
}
