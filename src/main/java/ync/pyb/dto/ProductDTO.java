package ync.pyb.dto;

import lombok.*;
import ync.pyb.entity.Detail;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long productId;
    private String productTitle;
    private String productDeparture;
    private String productArrival;
    private int productCount;
    private Detail detail;
}
