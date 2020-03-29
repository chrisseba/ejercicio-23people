use school;

DROP procedure IF exists updateStudent;

DELIMITER $$
CREATE  PROCEDURE updateStudent
(
	_rut varchar( 10 ),
    _name varchar( 50 ),
	_lastname varchar( 50 ),
    _age int,
    _fk_course varchar( 4 )
)
BEGIN
		
	update student 
	set	 rut =  _rut
		,name =  _name
		,lastname =  _lastname
		,age  = _age
		,fk_course  =  _fk_course
	WHERE ( rut =  _rut ); 
    
    select 	rut 
			,name
			,lastname 
			,age  
			,fk_course 
	from student
    where rut = _rut;
    
END$$
DELIMITER ;