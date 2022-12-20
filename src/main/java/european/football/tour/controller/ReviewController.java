package european.football.tour.controller;

import european.football.tour.dto.ReviewDTO;
import european.football.tour.repository.MemberRepo;
import european.football.tour.security.CurrentMember;
import european.football.tour.security.MemberPrincipal;
import european.football.tour.service.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/review/*")
public class ReviewController {

    private final ReviewServiceImpl reviewService;
    private final MemberRepo memberRepo;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("{productId}/reply/register")
    public ResponseEntity save(@RequestBody ReviewDTO reviewDTO, @PathVariable Long productId,  @CurrentMember MemberPrincipal currentMember) {

        return new ResponseEntity<>(reviewService.reviewSave(productId, reviewDTO, currentMember), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PutMapping("{reviewId}/modify")
    public ResponseEntity modify(@PathVariable Long reviewId, @RequestBody ReviewDTO reviewDTO) {

        return new ResponseEntity<>(reviewService.reviewUpdate(reviewId, reviewDTO), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("{reviewId}/remove")
    public String remove(@PathVariable Long reviewId){

        reviewService.reviewDelete(reviewId);

        return reviewId +" 번댓글이 삭제되었습니다.";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("{reviewId}")
    public ResponseEntity read(@PathVariable Long reviewId){

        return new ResponseEntity<>(reviewService.reviewGet(reviewId), HttpStatus.OK);
    }

}
