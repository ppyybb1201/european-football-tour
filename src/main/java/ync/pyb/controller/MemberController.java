package ync.pyb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;
import ync.pyb.dto.ApiResponseDTO;
import ync.pyb.dto.MemberDTO;
import ync.pyb.service.MemberService;


@RestControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/api/member/*")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/checkEmail")
	public ResponseEntity<ApiResponseDTO> checkEmailAvailability(@RequestParam(value = "memberEmail") String memberEmail) {
		ApiResponseDTO emailIdentityAvailability = memberService.checkEmailAvailability(memberEmail);
		return new ResponseEntity<>(emailIdentityAvailability, HttpStatus.OK);
	}
	
	@GetMapping("/{memberId}/profile")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<MemberDTO> getMemberProfile(@PathVariable(value = "memberId") Long memberId) {
		MemberDTO member = memberService.get(memberId);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@DeleteMapping("/{memberId}/remove")
	@PreAuthorize("hasRole('USER')")
	public String remove(@PathVariable(value = "memberId") Long memberId){
		memberService.remove(memberId);
		return "성공적으로 삭제되었습니다.";
	}
}
