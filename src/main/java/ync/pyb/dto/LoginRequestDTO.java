package ync.pyb.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
	@NotBlank
	private String memberEmail;
	@NotBlank
	private String memberPassword;
}
