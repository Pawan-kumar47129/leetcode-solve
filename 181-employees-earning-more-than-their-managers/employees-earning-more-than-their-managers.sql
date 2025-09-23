# Write your MySQL query statement below
SELECT e1.name as Employee
FROM employee e1
INNER JOIN employee e2 ON e1.managerId=e2.id
Where e1.salary>e2.salary;