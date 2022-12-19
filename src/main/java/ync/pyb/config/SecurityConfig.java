package ync.pyb.config;

// 보안의 설정파일

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import lombok.RequiredArgsConstructor;
import ync.pyb.security.JwtAuthenticationEntryPoint;
import ync.pyb.security.JwtAuthenticationFilter;
import ync.pyb.security.JwtExceptionFilter;
import ync.pyb.service.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorize, @PostAuthorize
@RequiredArgsConstructor
public class SecurityConfig {
	private final CustomUserDetailsServiceImpl customUserDetailsService;
	private final JwtAuthenticationEntryPoint unauthorizedHandler;

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final JwtExceptionFilter jwtExceptionFilter;

	/**
	 * Spring Security 5.7.x 부터 WebSecurityConfigurerAdapter 는 Deprecated. ->
	 * SecurityFilterChain, WebSecurityCustomizer 를 상황에 따라 빈으로 등록해 사용한다.
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and() // Jwt
																													// 예외처리
																													// 설정
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 스프링 시큐리티 X, JWT O
				.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").permitAll() // GET : /api/** 요청 허용
				.antMatchers(HttpMethod.POST, "/api/auth/**").permitAll() // POST : /api/auth/** 요청 허용
				.antMatchers(HttpMethod.GET, "/api/member/checkEmailAvailability").permitAll() // 허용
				.anyRequest().authenticated(); // 인증 요청
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		// UsernamePasswordAuthenticationFilter 앞에 jwtAuthenticationFilter 추가
		http.addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
