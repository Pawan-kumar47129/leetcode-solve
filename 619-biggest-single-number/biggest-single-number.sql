SELECT MAX(num) AS num FROM (
    SELECT num , COUNT(*) AS cnt
    FROM MyNumbers
    GROUP BY num
    HAVING cnt <= 1
) as t;
