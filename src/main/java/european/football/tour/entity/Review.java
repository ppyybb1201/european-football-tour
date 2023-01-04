package european.football.tour.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(value = {AuditingEntityListener.class})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    private Long reviewId;

    @Column(columnDefinition = "TEXT", nullable = false)
    @JsonProperty("reviewContents")
    private String reviewContents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime reviewCreated;

    @LastModifiedDate
    private LocalDateTime reviewUpdated;

    public void save(Product product, Member member){
        this.product = product;
        this.member = member;

    }

    public void update(String reviewContents){
        this.reviewContents = reviewContents;
        this.reviewUpdated = LocalDateTime.now();
    }
}
