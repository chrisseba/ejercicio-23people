use school;


create table course(
	
	code varchar( 4 ) NOT NULL UNIQUE,
    name varchar( 50 ) NOT NULL,
	CONSTRAINT course_pk PRIMARY KEY ( code ) 
);










