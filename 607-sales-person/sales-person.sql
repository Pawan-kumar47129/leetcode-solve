# Write your MySQL query statement below
/*
SELECT name FROM SalesPerson
WHERE sales_id NOT IN(
    SELECT sales_id 
    FROM Orders
    WHERE com_id IN(
        SELECT com_id FROM Company
        WHERE name ="RED"
    )
);*/

SELECT name FROM SalesPerson
WHERE sales_id NOT IN (
    SELECT o.sales_id FROM
    Orders o
    INNER JOIN Company c ON o.com_id=c.com_id
    WHERE c.name='RED'
    
);