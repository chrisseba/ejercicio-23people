package io.people;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.SystemException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.people.exception.ClientErrorException;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler({SystemException.class, Exception.class})
    public ResponseEntity<Object> handleGenericException( Exception ex ) {
		
        Map<String, Object> body = new LinkedHashMap<>();
        body.put( "message", ex.getMessage() );
        
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR );
    }
	
	@ExceptionHandler(ClientErrorException.class)
    public 	 ResponseEntity<Object> handleClientErrorException(ClientErrorException ex ) {
		
        Map<String, Object> body = new LinkedHashMap<>();
        body.put( "message", ex.getMessage() );
		
        return  new ResponseEntity<>( body, HttpStatus.NOT_FOUND   );
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    public 	 ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex ) {
		
        Map<String, Object> body = new LinkedHashMap<>();
        body.put( "message", ex.getMessage() );
		
        return  new ResponseEntity<>( body, HttpStatus.resolve( 400 )  );
    }
	

	
	
}
