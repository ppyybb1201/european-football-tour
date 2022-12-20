package european.football.tour.exception;

import org.springframework.http.HttpStatus;

public class SampleAPIException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	private final String message;

	public SampleAPIException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public SampleAPIException(HttpStatus status, String message, Throwable exception) {
		super(exception);
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
}
