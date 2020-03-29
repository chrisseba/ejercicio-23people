use school;

DROP procedure IF exists dropStudent;

DELIMITER $$
CREATE PROCEDURE dropStudent
(
	 _rut varchar( 10 )
)
BEGIN
	DELETE FROM student  
    where 
    (		
		rut =_rut
    );
    
END $$
DELIMITER ;