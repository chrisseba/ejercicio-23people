"# ejercicio-23people" 
Crear una Api Rest que permita mantener un listado cursos y alumnos utilizando
Spring según la siguiente definición:
- course:
         - name
         - code (max 4 chars)
- student:
      -  rut (valid rut with verification digit)
      - name
      - lastName
      - age ( > 18)
 course:
- La api debe validar el json requerido para la creación de cursos y alumnos
- La api debe requerir un token de validación JWT utilizando Spring Security
