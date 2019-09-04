package ar.com.jorgerojasdeveloper.sysoneapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomJsonParseException extends Exception {

	public static ResponseEntity<?> getResponse() {
		return new ResponseEntity<>("Json parse exception", HttpStatus.NOT_FOUND);
	}
}
