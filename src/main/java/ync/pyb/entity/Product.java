package ync.pyb.entity;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    @Column(nullable = false)
    private int productCostAdultBasic;

    @Column(nullable = false)
    private int productCostAdultFuel;

    @Column(nullable = false)
    private int productCostChildBasic;

    @Column(nullable = false)
    private int productCostChildFuel;

    @Column(nullable = false)
    private int productCostBabyBasic;

    @Column(nullable = false)
    private int productCostBabyFuel;

    @Column(nullable = true)
    private String productImage1Path;

    @Column(nullable = true)
    private String productImage2Path;

    @Column(nullable = true)
    private String productImage3Path;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int productCount;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Detail> details;
}
