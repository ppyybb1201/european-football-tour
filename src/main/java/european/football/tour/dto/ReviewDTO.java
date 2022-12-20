package european.football.tour.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import european.football.tour.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long reviewId;

    private String reviewContents;

    private String writer;

    public static ReviewDTO toDto(Review review) {
        return new ReviewDTO(
                review.getReviewId(),
                review.getReviewContents(),
                review.getMember().getMemberEmail()
        );
    }



}
