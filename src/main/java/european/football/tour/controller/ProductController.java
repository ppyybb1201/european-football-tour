package european.football.tour.controller;

import european.football.tour.dto.ProductDTO;
import european.football.tour.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("detail/{productId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProductDTO> getDetail(@PathVariable("productId") Long productId) {
        return new ResponseEntity<>(productService.productDetailGet(productId), HttpStatus.OK);
    }

    @GetMapping("manager/{productId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProductDTO> getManager(@PathVariable("productId") Long productId) {
        return new ResponseEntity<>(productService.productManagerGet(productId), HttpStatus.OK);
    }

    @GetMapping("hotel/{productId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ProductDTO> getHotel(@PathVariable("productId") Long productId) {
        return new ResponseEntity<>(productService.productHotelGet(productId), HttpStatus.OK);
    }

}
