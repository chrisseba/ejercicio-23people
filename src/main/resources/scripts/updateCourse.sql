use school;

DROP procedure IF exists updateCourse;

DELIMITER $$
CREATE  PROCEDURE updateCourse
(
	_code varchar( 4 ),
    _name varchar( 30 )
)
BEGIN
		
	update course 
	set	 name = _name
	WHERE ( code = _code ); 
    
    select 	code,
			name
	from course
    where code = _code;
    
END$$
DELIMITER ;