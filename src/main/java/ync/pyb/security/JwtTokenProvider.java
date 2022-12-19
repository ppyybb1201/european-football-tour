package ync.pyb.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtTokenProvider {

	@Value(value = "${app.jwtSecret}")
	private String jwtSecret; // 암호화 키

	@Value(value = "${app.jwtExpirationInMs}")
	private int jwtExpirationInMs; // 만료일

	public String generateToken(Authentication authentication) {
		MemberPrincipal memberPrincipal = (MemberPrincipal) authentication.getPrincipal();

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);	// 만료 시간 설정

		return Jwts.builder().setSubject(Long.toString(memberPrincipal.getMemberId())).setIssuedAt(new Date())
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	private Claims getClaimsFormToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

	public String getSubject(String token) {
		return getClaimsFormToken(token).getSubject();
	}

	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();

		return Long.valueOf(claims.getSubject());
	}

	public boolean validateToken(String authToken) throws IOException {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			log.error("Invalid JWT signature");
			throw new JwtException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token");
			throw new JwtException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token");
			throw new JwtException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token");
			throw new JwtException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty");
			throw new JwtException("JWT claims string is empty");
		} 
	}
	

}
