# Write your MySQL query statement below
WITH newTable as(
    SELECT
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        DENSE_RANK() OVER(PARTITION BY d.name ORDER BY e.salary DESC) as ranking
        from Employee e
        INNER JOIN Department d
        ON e.departmentId=d.id

)
SELECT Department, Employee,Salary
FROM newTable
WHERE ranking<=3;