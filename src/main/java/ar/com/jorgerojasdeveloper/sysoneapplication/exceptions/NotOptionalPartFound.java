package ar.com.jorgerojasdeveloper.sysoneapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotOptionalPartFound extends Exception {

	public static ResponseEntity<?> getResponse() {
		return new ResponseEntity<>("Not valid optional part", HttpStatus.NOT_FOUND);
	}
	
}
