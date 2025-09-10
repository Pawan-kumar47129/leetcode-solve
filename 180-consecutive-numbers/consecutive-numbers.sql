# Write your MySQL query statement below
/*
SELECT distinct(l1.num) as ConsecutiveNums
FROM Logs l1,Logs l2,Logs l3
WHERE l1.id =l2.id-1 and l2.id = l3.id-1 
        and l1.num=l2.num and l2.num=l3.num;
*/

#2nd ways
with laggedLogs as(
    SELECT 
        num,
        lag(num,1) over(ORDER BY id) as prev1,
        lag(num,2) over(ORDER BY id) as prev2
    FROM logs
)
SELECT distinct(num) as ConsecutiveNums
FROM laggedLogs
WHERE num=prev1 and num=prev2;