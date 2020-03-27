package io.people.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
	
	public static ResponseEntity responseOK(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.OK);
	  }

	 
	  public static ResponseEntity responseCreated(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.CREATED);
	  }

	 
	  public static ResponseEntity responseNotContent(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.NO_CONTENT);
	  }

	  
	  public static ResponseEntity responseBadRequest(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
	  }

	  
	  public static ResponseEntity responseUnauthorized(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.UNAUTHORIZED);
	  }

	  
	  public static ResponseEntity responseConflict(Object body) {
	    return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
	  }

}
