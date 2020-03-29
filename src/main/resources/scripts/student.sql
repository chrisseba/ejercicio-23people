use school;


create table student(
	
	rut varchar( 10 ) NOT NULL UNIQUE,
    name varchar( 50 ) NOT NULL,
	lastname varchar( 50 ) NOT NULL,
    age int NOT NULL,
    fk_course varchar( 4 ) NOT NULL,
	PRIMARY KEY ( rut ),
    FOREIGN KEY ( fk_course  ) REFERENCES course( code )
);


