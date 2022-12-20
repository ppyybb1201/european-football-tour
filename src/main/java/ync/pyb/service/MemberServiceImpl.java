package ync.pyb.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import ync.pyb.dto.ApiResponseDTO;
import ync.pyb.dto.MemberDTO;
import ync.pyb.dto.SignUpRequestDTO;
import ync.pyb.entity.Member;
import ync.pyb.entity.MemberRole;
import ync.pyb.exception.SampleAPIException;
import ync.pyb.repository.MemberRepo;
import ync.pyb.security.MemberPrincipal;
import ync.pyb.util.AppConstants;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepo memberRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public ApiResponseDTO checkEmailAvailability(String email) {
		if (Boolean.TRUE.equals(memberRepo.existsByMemberEmail(email))) {
			throw new SampleAPIException(HttpStatus.BAD_REQUEST, "이미 사용 중인 이메일 주소입니다.");
		}
		return new ApiResponseDTO(AppConstants.RESPONSE_SUCCESS, "사용 가능한 이메일 주소입니다.");
	}



	@Override
	public MemberDTO get(Long memberId) {
		Member member = memberRepo.findById(memberId).orElseThrow(() -> new SampleAPIException(HttpStatus.NOT_FOUND, ""));
		return entityToDTO(member);
	}

	@Override
	public void remove(Long memberId) {
			memberRepo.deleteById(memberId);
	}

	@Override
	public MemberDTO register(SignUpRequestDTO signupDTO) {
		if (Boolean.TRUE.equals(memberRepo.existsByMemberEmail(signupDTO.getMemberEmail()))) {
			throw new SampleAPIException(HttpStatus.BAD_REQUEST, "이미 사용 중인 이메일 주소입니다.");
		}
		Member member = Member.builder()
				.memberEmail(signupDTO.getMemberEmail())
				.memberPassword(passwordEncoder.encode(signupDTO.getMemberPassword()))
				.memberPhone(signupDTO.getMemberPhone())
				.build();
		member.addMemberRole(MemberRole.USER);
		memberRepo.save(member);
		return entityToDTO(member);
	}
	
	
}
