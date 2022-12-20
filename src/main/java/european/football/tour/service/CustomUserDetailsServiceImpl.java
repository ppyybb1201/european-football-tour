package european.football.tour.service;

import javax.transaction.Transactional;

import european.football.tour.security.MemberPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import european.football.tour.entity.Member;
import european.football.tour.repository.MemberRepo;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

	private final MemberRepo memberRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String memberEmail) {
		Member member = memberRepo.findByMemberEmail(memberEmail).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User not found with this email: %s", memberEmail)));
		return MemberPrincipal.create(member);
	}

	@Override
	@Transactional
	public UserDetails loadUserByMno(Long memberId) {
		Member member = memberRepo.findByMemberId(memberId)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with id: %s", memberId)));
		return MemberPrincipal.create(member);
	}

}
