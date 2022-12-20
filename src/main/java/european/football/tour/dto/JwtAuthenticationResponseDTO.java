package european.football.tour.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationResponseDTO {
	private String accessToken;
	private String tokenType; //jwt 혹은 OAuth
 
	public JwtAuthenticationResponseDTO(String accessToken) {
		this.tokenType = "Bearer";
		this.accessToken = accessToken;
	}
}
