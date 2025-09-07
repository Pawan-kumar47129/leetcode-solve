-- Write your PostgreSQL query statement below

/*SELECT MAX(salary) as SecondHighestSalary
FROM employee
WHERE salary !=(SELECT MAX(salary) from employee);*/

SELECT (
    SELECT salary 
    FROM Employee
    GROUP BY salary
    ORDER BY salary DESC
    LIMIT 1
    OFFSET 1) as SecondHighestSalary;