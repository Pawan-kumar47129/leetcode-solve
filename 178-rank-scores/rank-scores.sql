# Write your MySQL query statement below
SELECT round(score,2)as score,
DENSE_RANK() over(ORDER BY score DESC) as 'rank'
FROM Scores 
ORDER BY score DESC;