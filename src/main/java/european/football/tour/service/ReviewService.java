package european.football.tour.service;

import european.football.tour.dto.ReviewDTO;
import european.football.tour.security.MemberPrincipal;

public interface ReviewService {

    ReviewDTO reviewSave(Long productId, ReviewDTO reviewDTO, MemberPrincipal currentMember);

    ReviewDTO reviewUpdate(Long reviewId, ReviewDTO reviewDTO);

    void reviewDelete(Long reviewId);

    ReviewDTO reviewGet(Long reviewId);
}
