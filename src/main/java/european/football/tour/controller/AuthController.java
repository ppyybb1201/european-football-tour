package european.football.tour.controller;

import javax.validation.Valid;

import european.football.tour.dto.JwtAuthenticationResponseDTO;
import european.football.tour.dto.LoginRequestDTO;
import european.football.tour.dto.MemberDTO;
import european.football.tour.dto.SignUpRequestDTO;
import european.football.tour.security.JwtTokenProvider;
import european.football.tour.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;
	private final MemberService memberService;

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponseDTO> authenticateUser(
			@Valid @RequestBody LoginRequestDTO loginRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getMemberEmail(), loginRequest.getMemberPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenProvider.generateToken(authentication);
		return new ResponseEntity<>(new JwtAuthenticationResponseDTO(jwt), HttpStatus.OK);
	}

	// signup
	@PostMapping("/signup")
	public ResponseEntity<MemberDTO> registerUser(@Valid @RequestBody SignUpRequestDTO signupRequest) {
		return new ResponseEntity<>(memberService.register(signupRequest), HttpStatus.OK);
	}
	
}
