use school;

DROP procedure IF exists getCourse;

DELIMITER $$
CREATE PROCEDURE getCourse(

	_code varchar( 4 )
)
BEGIN
	select 
		code,
        name
	from course 
    where 
    (
		code = _code or _code is null
    );
    
END$$
DELIMITER ;
