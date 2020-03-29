use school;

DROP procedure IF exists insertStudent;

DELIMITER $$
CREATE  PROCEDURE insertStudent
(
    _rut varchar( 10 ),
    _name varchar( 50 ),
	_lastname varchar( 50 ),
    _age int,
    _fk_course varchar( 4 )
)
BEGIN

	INSERT INTO student
	(
		rut,
		name,
		lastname,
		age,
		fk_course
	)
	VALUES
	(
		 _rut
		,_name
		,_lastname
		,_age
		,_fk_course
	);
    
END$$
DELIMITER ;