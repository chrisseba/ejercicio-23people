package io.people.utils;

public class ValidationUtils {
	
	public static boolean codeValidate( String code  ) {
		
		if( code.length() > 4  ) 
			return false;
		else 
			return true;
	}
	
	

}
