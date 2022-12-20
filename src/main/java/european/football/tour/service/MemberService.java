package european.football.tour.service;


import european.football.tour.dto.ApiResponseDTO;
import european.football.tour.dto.MemberDTO;
import european.football.tour.dto.SignUpRequestDTO;
import european.football.tour.entity.Member;

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
