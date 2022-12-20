package european.football.tour.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ 
		"success", // 1 PropertyOrder
		"message" // 2 PropertyOrder
})
public class ApiResponseDTO {

	@JsonProperty("success")
	private String success;

	@JsonProperty("message")
	private String message;

	@JsonIgnore
	private HttpStatus status;

	public ApiResponseDTO() {

	}

	public ApiResponseDTO(String success, String message) {
		this.success = success;
		this.message = message;
	}

	public ApiResponseDTO(String success, String message, HttpStatus httpStatus) {
		this.success = success;
		this.message = message;
		this.status = httpStatus;
	}
}
