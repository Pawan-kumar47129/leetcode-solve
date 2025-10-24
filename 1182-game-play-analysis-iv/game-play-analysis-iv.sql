# Write your MySQL query statement below
WITH first_login as(
    SELECT player_id ,min(event_date) as first_play
    FROM Activity 
    GROUP BY player_id
),second_login as(
    SELECT count(A1.player_id)as total_num_log
    FROM first_login  A1
    INNER JOIN Activity A2
    ON A1.player_id=A2.player_id
    AND A1.first_play=DATE_SUB(A2.event_date,INTERVAL 1 DAY)
)
SELECT 
    round((SELECT total_num_log from second_login)
    /(SELECT count(DISTINCT(player_id)) from Activity)
    ,2) as fraction;