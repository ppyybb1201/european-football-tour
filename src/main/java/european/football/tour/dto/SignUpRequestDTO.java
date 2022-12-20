package european.football.tour.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpRequestDTO {
	
	@NotBlank
	@Email
	private String memberEmail;
	
	@NotBlank
	private String memberPassword;

	@NotBlank
	private String memberPhone;

}
