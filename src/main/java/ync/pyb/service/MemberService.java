package ync.pyb.service;


import ync.pyb.dto.ApiResponseDTO;
import ync.pyb.dto.MemberDTO;
import ync.pyb.dto.SignUpRequestDTO;
import ync.pyb.entity.Member;
import ync.pyb.security.MemberPrincipal;

public interface MemberService {

	MemberDTO register(SignUpRequestDTO signupDTO);

	MemberDTO get(Long memberId);

	void remove(Long memberId);

	ApiResponseDTO checkEmailAvailability(String memberEmail);



	default MemberDTO entityToDTO(Member entity) {
		return MemberDTO.builder().memberId(entity.getMemberId()).memberEmail(entity.getMemberEmail()).memberCreated(entity.getMemberCreated())
				.memberPhone(entity.getMemberPhone())
				.build();
	}

}
