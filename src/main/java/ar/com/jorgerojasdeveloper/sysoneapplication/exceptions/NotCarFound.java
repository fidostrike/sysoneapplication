package ar.com.jorgerojasdeveloper.sysoneapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotCarFound extends Exception {

	public static ResponseEntity<?> getResponse() {
		return new ResponseEntity<>("Not valid card id", HttpStatus.NOT_FOUND);
	}
}
