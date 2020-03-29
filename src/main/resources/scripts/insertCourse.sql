use school;

DROP procedure IF exists insertCourse;

DELIMITER $$
CREATE  PROCEDURE insertCourse
(
	_code varchar( 4 ),
    _name varchar( 30 )
)
BEGIN

	INSERT INTO course
	(
		 code
		,name
	)
	VALUES
	(
		 _code
		,_name
	);
    
END$$
DELIMITER ;





