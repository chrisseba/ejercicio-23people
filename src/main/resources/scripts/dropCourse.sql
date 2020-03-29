use school;

DROP procedure IF exists dropCourse;

DELIMITER $$
CREATE PROCEDURE dropCourse
(
	_code varchar( 4 )
)
BEGIN
	DELETE FROM course  
    where 
    (		
		code =_code
    );
    
END $$
DELIMITER ;









