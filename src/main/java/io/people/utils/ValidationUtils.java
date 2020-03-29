package io.people.utils;

public class ValidationUtils {
	
	public static boolean codeValidate( String code  ) {
		
		if( code.length() > 4  ) 
			return false;
		else 
			return true;
	}
	
	 public static boolean rutValidate(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {

        }
        return validacion;
    }
	
	 public static boolean ageValidate( Integer age ) {
		 
		 if( age.intValue() > 18  )
			 return true;
		 else
			 return false;
		 
	 }
	 
	 
	 
	 
	 

}
