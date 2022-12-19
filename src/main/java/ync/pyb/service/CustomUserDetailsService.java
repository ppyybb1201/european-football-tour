package ync.pyb.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {
	UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
	UserDetails loadUserByMno(Long mno);
}