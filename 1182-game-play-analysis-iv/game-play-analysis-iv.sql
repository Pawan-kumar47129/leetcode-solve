# Write your MySQL query statement below
WITH first_logins as (
    SELECT player_id, min(event_date) as first_login
    FROM Activity
    GROUP BY player_id
), consec_logins AS(
    SELECT COUNT(F.player_id) as num_logins
    FROM 
        first_logins F
        INNER JOIN Activity A 
        ON F.player_id=A.player_id
        AND F.first_login=DATE_SUB(A.event_date,INTERVAL 1 DAY) 
) 
SELECT 
    ROUND(
        (SELECT C.num_logins from consec_logins C)
        / (SELECT COUNT(F.player_id) from first_logins F)
    ,2) as fraction;      