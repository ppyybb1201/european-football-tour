package european.football.tour.service;

import org.hibernate.validator.internal.util.logging.Log;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import european.football.tour.dto.ProductDTO;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    // 상품을 클릭 했을 때 맨 처음 보여짐
    // 버튼 별로 다른 화면 노출 화면 상단에는 출발, 도착일 가격을 표시 하기때문에 매번 불러옴
    @Test
    public void testGetDetail() {
        ProductDTO productDTO = productService.productDetailGet(1L);
        System.out.println(productDTO);

    }
    
    @Test
    public void testGetManager() {
        ProductDTO productDTO = productService.productManagerGet(1L);
        System.out.println(productDTO);

    }

    @Test
    public void testGetHotel() {
        ProductDTO productDTO = productService.productHotelGet(1L);
        System.out.println(productDTO);

    }







}
