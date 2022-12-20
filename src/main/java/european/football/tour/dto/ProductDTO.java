package european.football.tour.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import european.football.tour.entity.Detail;
import european.football.tour.entity.Hotel;
import european.football.tour.entity.Manager;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // NULL 필드는 표시 X
public class ProductDTO {

    private Long productId;
    private String productTitle;
    private String productDeparture;
    private String productArrival;
    private String productCostAdultBasic;
    private String productCostAdultFuel;
    private String productCostChildBasic;
    private String productCostChildFuel;
    private String productCostBabyBasic;
    private String productCostBabyFuel;
    private int productCount;
    private Detail detail;
    private Manager manager;
    private Hotel hotel;


}
