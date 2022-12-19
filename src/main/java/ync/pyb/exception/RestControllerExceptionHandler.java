package ync.pyb.exception;

import java.util.ArrayList;
import java.util.List;

import javax.naming.AuthenticationException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import ync.pyb.dto.ApiResponseDTO;
import ync.pyb.dto.ExceptionResponseDTO;
import ync.pyb.util.AppConstants;

@RestController
@ControllerAdvice
@Log4j2
public class RestControllerExceptionHandler {

	@ExceptionHandler(SampleAPIException.class)
	public ResponseEntity<ApiResponseDTO> resolveException(SampleAPIException exception) {
		log.info(exception.getMessage());
		String message = exception.getMessage();
		HttpStatus status = exception.getStatus();

		ApiResponseDTO apiResponse = new ApiResponseDTO();

		apiResponse.setSuccess(AppConstants.RESPONSE_FAIL);
		apiResponse.setMessage(message);

		return new ResponseEntity<>(apiResponse, status);
	}

	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ApiResponseDTO> resolveException(UnauthorizedException exception) {
		ApiResponseDTO apiResponse = exception.getApiResponse();
		return new ResponseEntity<>(apiResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ApiResponseDTO> resolveException(AccessDeniedException exception) {
		ApiResponseDTO apiResponse = exception.getApiResponse();
		return new ResponseEntity<>(apiResponse, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResponseDTO> methodArgsException(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<String> messages = new ArrayList<>(fieldErrors.size());
		for (FieldError error : fieldErrors) {
			messages.add(error.getField() + " - " + error.getDefaultMessage());
		}
		return new ResponseEntity<>(new ExceptionResponseDTO(messages, HttpStatus.BAD_REQUEST.getReasonPhrase(),
				HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<ExceptionResponseDTO> resolveException(HttpRequestMethodNotSupportedException ex) {
		String message = "Request method '" + ex.getMethod() + "' not supported. List of all supported methods - "
				+ ex.getSupportedHttpMethods();
		List<String> messages = new ArrayList<>(1);
		messages.add(message);
		return new ResponseEntity<>(new ExceptionResponseDTO(messages, HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(),
				HttpStatus.METHOD_NOT_ALLOWED.value()), HttpStatus.METHOD_NOT_ALLOWED);
	}

}
