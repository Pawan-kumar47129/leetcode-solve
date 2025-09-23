# Write your MySQL query statement below
SELECT distinct(p1.email) as Email 
FROM person p1
INNER JOIN person p2 ON
p1.email=p2.email and p1.id<>p2.id;