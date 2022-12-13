package ync.pyb.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private Long productId;

    @Column(length = 500, nullable = false)
    private String productTitle;

    @Column(length = 50, nullable = false)
    private String productDeparture;

    @Column(length = 50, nullable = false)
    private String productArrival;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int productCount;

    @ManyToOne
    @JoinColumn(name = "detailId")
    private Detail detail;


//    @Column(nullable = false)
//    private int productCostAdultBasic;
//
//    @Column(nullable = false)
//    private int productCostAdultFuel;
//
//    @Column(nullable = false)
//    private int productCostChildBasic;
//
//    @Column(nullable = false)
//    private int productCostChildFuel;
//
//    @Column(nullable = false)
//    private int productCostBabyBasic;
//
//    @Column(nullable = false)
//    private int productCostBabyFuel;




}
