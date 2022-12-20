package european.football.tour.security;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtExceptionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response); // go to 'JwtAuthenticationFilter'
		} catch (JwtException ex) {
			log.info("JwtExceptionFilter : " + ex.getMessage());
			setErrorResponse(HttpStatus.UNAUTHORIZED, response, ex);
		}
	}

	public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("message", ex.getMessage());
		response.getWriter().write(mapper.writeValueAsString(map));
	}

}
