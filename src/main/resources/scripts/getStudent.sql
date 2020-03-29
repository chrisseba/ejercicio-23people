use school;

DROP procedure IF exists getStudent;

DELIMITER $$
CREATE PROCEDURE getStudent
(
	 _rut varchar( 10 )
)
BEGIN
	select 
		rut,
		name,
		lastname,
		age,
		fk_course
	from student 
    where 
    (
		rut = _rut or _rut is null
    );
    
END$$
DELIMITER ;
