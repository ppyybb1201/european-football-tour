package ync.pyb.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Getter;
import ync.pyb.entity.Member;

@Getter
public class MemberPrincipal implements UserDetails {

	private static final long serialVersionUID = -3938948583663245575L;
	
	private Long memberId;
	private String memberEmail;


	@JsonIgnore
	private String memberPassword;

	private Collection<? extends GrantedAuthority> authorities;

	public MemberPrincipal(Long memberId, String memberEmail, String memberPassword,
			Collection<? extends GrantedAuthority> authorities) {
		this.memberId = memberId;
		this.memberEmail = memberEmail;
		this.memberPassword = memberPassword;
		
		if (authorities == null) {
			this.authorities = null;
		} else {
			this.authorities = new ArrayList<>(authorities);
		}
	}
	
	public static MemberPrincipal create(Member member) {
		List<GrantedAuthority> authorities = member.getRoleSet().stream().map(role ->new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toList());
		return new MemberPrincipal(member.getMemberId(), member.getMemberEmail(),member.getMemberPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities == null ? null : new ArrayList<>(authorities);
	}

	@Override
	public String getPassword() {
		return memberPassword;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
