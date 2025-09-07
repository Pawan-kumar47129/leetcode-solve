# Write your MySQL query statement below

/*
SELECT (SELECT salary 
FROM Employee
GROUP BY salary
ORDER BY salary DESC
LIMIT 1
OFFSET 1) as SecondHighestSalary;
*/

SELECT MAX(salary) as SecondHighestSalary
FROM Employee
WHERE salary<(SELECT MAX(salary) FROM Employee);