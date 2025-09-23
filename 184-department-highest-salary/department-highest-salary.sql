# Write your MySQL query statement below
WITH maxSalary as(
    select d.id, d.name,max(e.salary)as maxS
    FROM Employee e
    INNER JOIN Department d
    ON d.id=e.departmentId
    GROUP BY d.id
)
SELECT d.name as Department, e.name as Employee ,e.salary as Salary
FROM employee e
INNER JOIN maxSalary d
ON e.departmentId=d.id
WHERE e.salary=d.maxS;
