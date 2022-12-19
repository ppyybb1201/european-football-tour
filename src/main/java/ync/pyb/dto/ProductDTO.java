package ync.pyb.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;
import ync.pyb.entity.Detail;
import ync.pyb.entity.Hotel;
import ync.pyb.entity.Manager;


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
