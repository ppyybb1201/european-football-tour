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
    
    @ManyToOne
    @JoinColumn(name = "managerId")
    private Manager manager;
    
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;


    @Column(length = 50, nullable = false)
    private String productCostAdultBasic;

    @Column(length = 50, nullable = false)
    private String productCostAdultFuel;

    @Column(length = 50, nullable = false)
    private String productCostChildBasic;

    @Column(length = 50, nullable = false)
    private String productCostChildFuel;

    @Column(length = 50, nullable = false)
    private String productCostBabyBasic;

    @Column(length = 50, nullable = false)
    private String productCostBabyFuel;




}
