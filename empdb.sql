DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(ID INT NOT NULL,NAME VARCHAR(255)NOT NULL, DOB VARCHAR(55) NOT NULL  ,QUALIFICATION VARCHAR(55)NOT NULL,SALARY VARCHAR(55)NOT NULL, ADDRESS VARCHAR(255)NOT NULL,pic LONGBLOB NOT NULL,getpic VARCHAR(255));
INSERT INTO Employee VALUES( 1,'poonra','1988-2-20','MTECH','12000.00','hyderabad', '22','p');
SELECT * FROM Employee;