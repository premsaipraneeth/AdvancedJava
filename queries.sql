
CREATE TABLE Employee(first_name varchar(30),
last_name varchar(30),
job_start_date date,
salary bigint);

ALTER TABLE Employee ADD COLUMN department varchar(30);


INSERT INTO Employee (first_name, last_name, job_start_date, salary)
VALUES ('Jane', 'Smith', '2021-06-15', 60000);

INSERT INTO Employee (first_name, last_name, job_start_date, salary)
VALUES ('Jane', 'Smith', '2023-06-15', 60000);


SELECT MAX(Salary) as max_salary from employee;

SELECT * FROM Employee
WHERE job_start_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);



INSERT INTO Employee (first_name, last_name, job_start_date,
 salary,department)
VALUES ('Praneeth', 'Kalipindi', '2022-01-01', 50000,'CS');

INSERT INTO Employee (first_name, last_name, job_start_date,
 salary,department)
VALUES ('Jeff', 'K', '2022-01-01', 50000,'CS');

SELECT department, COUNT(*) as count FROM employee group by department;


/*2*/

UPDATE consultant_detail set email_address='praneethk@gmail.com' where 
first_name='Praneeth';

/*3*/

SELECT c.first_name,COUNT(*) as no_of_submissions from submission s join consultant_detail c on s.consultant_id=c.id where 
submission_status='Approved' group by 
consultant_id;

Select * from consultant_detail;
select * FROM SUBMISSION;
/*4*/

SELECT consultant_id, submission_date, COUNT(*) AS total_submissions
FROM submission
GROUP BY consultant_id, submission_date;

/*5*/

delete FROM submission WHERE rate=null;

INSERT INTO consultant_detail (lead_id, first_name, last_name, email_address, phone_number)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', '123-456-7890');

INSERT INTO consultant_detail (lead_id, first_name, last_name, email_address, phone_number)
VALUES (2, 'Jane', 'Smith', 'jane.smith@example.com', '987-654-3210');

INSERT INTO lead_detail (first_name, last_name, email_address, phone_number)
VALUES ('Michael', 'Johnson', 'michael.johnson@example.com', '555-123-4567');

INSERT INTO lead_detail (first_name, last_name, email_address, phone_number)
VALUES ('Sarah', 'Anderson', 'sarah.anderson@example.com', '111-222-3333');

INSERT INTO submission_update (submission_id, update_text, created_date)
VALUES (1, 'Updated submission status to "In Progress"', '2023-01-15');

INSERT INTO submission_update (submission_id, update_text, created_date)
VALUES (2, 'Client requested additional documents', '2023-02-20');

INSERT INTO submission (consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address, vendor_phone_number, 
implementation_partner, client_name, pay_rate, submission_status, submission_type, city, state, zip)
VALUES (1, '2023-01-10', 'ABC Inc.', 'John Smith', 'john@abc.com', '555-123-4567', 'XYZ Corp', 'Client A', 100.00, 'Pending', 'New', 'New York', 'NY', '12345');

INSERT INTO submission (consultant_id, submission_date, vendor_company, vendor_name, vendor_email_address, vendor_phone_number, implementation_partner, client_name, pay_rate, submission_status, submission_type, city, state, zip)
VALUES (2, '2023-02-05', 'DEF Corp', 'Jane Doe', 'jane@def.com', '555-987-6543', 'PQR Ltd', 'Client B', 120.00, 'Approved', 'Extension', 'Los Angeles', 'CA', '98765');


/*6*/

SELECT * FROM lead_detail;
SELECT * FROM submission;

ALTER TABLE submission ADD COLUMN lead_id INT;
ALTER TABLE submission ADD CONSTRAINT fk_submission_lead FOREIGN KEY (lead_id) REFERENCES lead_detail(id);

SELECT *
FROM submission
WHERE lead_id IN (
  SELECT id
  FROM lead_detail
  WHERE first_name='Michael'
)
AND submission_date ='2023-02-05' ;

/*7*/

SELECT 
l.first_name, COUNT(*) AS no_ofsubmissions from submission s join lead_detail l on s.lead_id=l.id group by lead_id
