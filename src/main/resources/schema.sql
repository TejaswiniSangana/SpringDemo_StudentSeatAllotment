CREATE TABLE DEPARTMENT(
DEPARTMENT_ID INT NOT NULL PRIMARY KEY,
DEPARTMENT_NAME VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE STUDENT(
STUDENT_ID INT  NOT NULL PRIMARY KEY,
STUDENT_NAME VARCHAR(20) ,
DEPARTMENT_ID INT NOT NULL
);

ALTER TABLE STUDENT ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID);

CREATE TABLE SEATS(
SEAT_ID INT NOT NULL PRIMARY KEY ,
STUDENT_ID INT NOT NULL,
DEPARTMENT_ID INT NOT NULL
);

ALTER TABLE SEATS ADD FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT(STUDENT_ID);
ALTER TABLE SEATS ADD FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(DEPARTMENT_ID);





