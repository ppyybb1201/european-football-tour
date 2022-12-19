package ync.pyb.exception;


import ync.pyb.dto.ApiResponseDTO;

public class AccessDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private ApiResponseDTO apiResponse;

	private String message;

	public AccessDeniedException(ApiResponseDTO apiResponse) {
		super();
		this.apiResponse = apiResponse;
	}

	public AccessDeniedException(String message) {
		super(message);
		this.message = message;
	}

	public AccessDeniedException(String message, Throwable cause) {
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
