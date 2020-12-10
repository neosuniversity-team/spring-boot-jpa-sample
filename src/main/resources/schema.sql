DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  ROL_ID INT NULL

);

DROP TABLE IF EXISTS TBL_ROL;

CREATE TABLE TBL_ROL (
  ID INT NOT NULL AUTO_INCREMENT,
  ROL_NAME VARCHAR(100) NULL,
  PRIMARY KEY (ID));


ALTER TABLE TBL_EMPLOYEES
ADD CONSTRAINT ROL_ID_FK
  FOREIGN KEY (ROL_ID)
  REFERENCES TBL_ROL (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



  INSERT INTO TBL_EMPLOYEES  (first_name, last_name, email) VALUES ('Cristian', 'Hernandez', 'abc@gmail.com');
INSERT INTO TBL_EMPLOYEES  (first_name, last_name, email)  VALUES ('Erika', 'Dominguez', 'xyz@email.com');
INSERT INTO TBL_EMPLOYEES  (first_name, last_name, email)  VALUES   ('Jorge', 'Mendoza', 'cap@marvel.com');


select emp.*, rol.ROL_NAME
from rh.TBL_EMPLOYEES as emp, rh.TBL_ROL as rol
WHERE emp.ROL_ID = rol.id;