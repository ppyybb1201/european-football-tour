package european.football.tour.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import european.football.tour.dto.ProductDTO;
import european.football.tour.entity.Product;
import european.football.tour.repository.ProductRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public ProductDTO productDetailGet(Long productId) {
        Optional<Product> result = productRepo.findById(productId);
        Product product = result.get();

        return ProductDTO.builder()
                .productTitle(product.getProductTitle())
                .productId(product.getProductId())
                .productArrival(product.getProductArrival())
                .productDeparture(product.getProductDeparture())
                .productCount(product.getProductCount())
                .productCostAdultBasic(product.getProductCostAdultBasic())
                .productCostAdultFuel(product.getProductCostAdultFuel())
                .productCostChildBasic(product.getProductCostChildBasic())
                .productCostChildFuel(product.getProductCostChildFuel())
                .productCostBabyBasic(product.getProductCostBabyBasic())
                .productCostBabyFuel(product.getProductCostBabyFuel())
                .detail(product.getDetail()).build();
    }

    @Override
    public ProductDTO productManagerGet(Long productId) {
        Optional<Product> result = productRepo.findById(productId);
        Product product = result.get();

        return ProductDTO.builder()
                .productTitle(product.getProductTitle())
                .productId(product.getProductId())
                .productArrival(product.getProductArrival())
                .productDeparture(product.getProductDeparture())
                .productCount(product.getProductCount())
                .productCostAdultBasic(product.getProductCostAdultBasic())
                .productCostAdultFuel(product.getProductCostAdultFuel())
                .productCostChildBasic(product.getProductCostChildBasic())
                .productCostChildFuel(product.getProductCostChildFuel())
                .productCostBabyBasic(product.getProductCostBabyBasic())
                .productCostBabyFuel(product.getProductCostBabyFuel())
                .manager(product.getManager()).build();
    }

    @Override
    public ProductDTO productHotelGet(Long productId) {
        Optional<Product> result = productRepo.findById(productId);
        Product product = result.get();

        return ProductDTO.builder()
                .productTitle(product.getProductTitle())
                .productId(product.getProductId())
                .productArrival(product.getProductArrival())
                .productDeparture(product.getProductDeparture())
                .productCount(product.getProductCount())
                .productCostAdultBasic(product.getProductCostAdultBasic())
                .productCostAdultFuel(product.getProductCostAdultFuel())
                .productCostChildBasic(product.getProductCostChildBasic())
                .productCostChildFuel(product.getProductCostChildFuel())
                .productCostBabyBasic(product.getProductCostBabyBasic())
                .productCostBabyFuel(product.getProductCostBabyFuel())
                .hotel(product.getHotel()).build();
    }

}
