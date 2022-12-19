package ync.pyb.service;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ync.pyb.entity.Member;
import ync.pyb.repository.MemberRepository;
import ync.pyb.security.MemberPrincipal;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService, CustomUserDetailsService {

	private final MemberRepository memberRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String memberEmail) {
		Member member = memberRepository.findByMemberEmail(memberEmail).orElseThrow(
				() -> new UsernameNotFoundException(String.format("User not found with this email: %s", memberEmail)));
		return MemberPrincipal.create(member);
	}

	@Override
	@Transactional
	public UserDetails loadUserByMno(Long memberId) {
		Member member = memberRepository.findByMemberId(memberId)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with id: %s", memberId)));
		return MemberPrincipal.create(member);
	}

}
