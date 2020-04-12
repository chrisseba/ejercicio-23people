use school;

DROP procedure IF exists dropStudent;

DELIMITER $$
CREATE PROCEDURE dropStudent
(
	 _rut varchar( 10 )
)
BEGIN

	SET @rut = null;
    SET @name = null;
	SET @lastname = null;
	SET @age = null;
	SET @fk_course = null;
    
    SELECT 
		 rut
        ,name
		,lastname
		,age
		,fk_course
    INTO 
		 @rut
        ,@name
		,@lastname
		,@age
		,@fk_course
	FROM student
	WHERE rut = _rut;

	IF( @rut IS NOT NULL  )
	THEN
		DELETE FROM student  
		WHERE (	rut =_rut );
    END IF;

	SELECT 	 @rut as rut
			,@name as name
			,@lastname as lastname
			,@age as age
			,@fk_course as fk_course;
    
END $$
DELIMITER ;