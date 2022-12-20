package european.football.tour.service;

import european.football.tour.dto.ProductDTO;

public interface ProductService {

    ProductDTO productDetailGet(Long productId);

    ProductDTO productManagerGet(Long productId);

    ProductDTO productHotelGet(Long productId);

    ProductDTO productReview(Long productId);
}
