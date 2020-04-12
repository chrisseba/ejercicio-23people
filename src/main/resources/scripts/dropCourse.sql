use school;

DROP procedure IF exists dropCourse;

DELIMITER $$
CREATE PROCEDURE dropCourse
(
	_code varchar( 4 )
)
BEGIN
	
    set @code = null;
    set @name = null;
    
	SELECT 
		 code
        ,name
	INTO
		 @code 
        ,@name 
    FROM course
    WHERE code =_code;
    
    IF(  @code IS NOT NULL  )
    THEN
		DELETE FROM course
		WHERE ( code =_code   );
    END IF;
    
    SELECT 
		 @code as code
        ,@name as name;
	
    
END $$
DELIMITER ;









