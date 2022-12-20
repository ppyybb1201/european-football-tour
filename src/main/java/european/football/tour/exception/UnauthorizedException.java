package european.football.tour.exception;

import european.football.tour.dto.ApiResponseDTO;


public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ApiResponseDTO apiResponse;

	private String message;

	public UnauthorizedException(ApiResponseDTO apiResponse) {
		super();
		this.apiResponse = apiResponse;
	}

	public UnauthorizedException(String message) {
		super(message);
		this.message = message;
	}

	public UnauthorizedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiResponseDTO getApiResponse() {
		return apiResponse;
	}

	public void setApiResponse(ApiResponseDTO apiResponse) {
		this.apiResponse = apiResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
