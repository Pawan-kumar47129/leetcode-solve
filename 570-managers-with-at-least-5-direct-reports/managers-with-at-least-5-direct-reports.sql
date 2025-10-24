# Write your MySQL query statement below
SELECT e1.name as name 
FROM Employee e1
INNER JOIN Employee e2
ON e1.id=e2.managerId
GROUP BY e2.managerId
Having count(e2.managerId)>=5;