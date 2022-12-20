package european.football.tour.service;

import european.football.tour.dto.ReviewDTO;
import european.football.tour.entity.Member;
import european.football.tour.entity.Product;
import european.football.tour.entity.Review;
import european.football.tour.exception.SampleAPIException;
import european.football.tour.repository.MemberRepo;
import european.football.tour.repository.ProductRepo;
import european.football.tour.repository.ReviewRepo;

import european.football.tour.security.MemberPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private final ReviewRepo reviewRepo;
    @Autowired
    private final ProductRepo productRepo;
    @Autowired
    private final MemberRepo memberRepo;


    @Transactional
    public ReviewDTO reviewSave(Long productId, ReviewDTO reviewDTO, MemberPrincipal currentMember) {
        Review review = new Review();
        review.setReviewContents(reviewDTO.getReviewContents());

        Product product = productRepo.findById(productId).orElseThrow(() -> {
            return new IllegalArgumentException("게시판을 찾을 수 없습니다.");
        });

        Member member = memberRepo.findById(currentMember.getMemberId()).orElseThrow(() -> new SampleAPIException(HttpStatus.NOT_FOUND, ""));

        review.setMember(member);
        review.setProduct(product);
        reviewRepo.save(review);

        return ReviewDTO.toDto(review);

    }

    @Transactional
    public ReviewDTO reviewUpdate(Long reviewId, ReviewDTO reviewDTO) {
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> {
            return new IllegalArgumentException("리뷰를 찾을 수 없습니다.");
        });

        review.update(reviewDTO.getReviewContents());


        return ReviewDTO.toDto(review);

    }

    @Transactional
    public void reviewDelete(Long reviewId){
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> {
            return new IllegalArgumentException("리뷰를 찾을 수 없습니다.");
        });

        reviewRepo.delete(review);
    }

    @Transactional
    public ReviewDTO reviewGet(Long reviewId){
        Review review = reviewRepo.findById(reviewId).orElseThrow(() -> {
            return new IllegalArgumentException("리뷰를 찾을 수 없습니다.");
        });


        return ReviewDTO.toDto(review);
    }


}

