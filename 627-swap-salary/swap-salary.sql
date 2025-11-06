# Write your MySQL query statement below
UPDATE Salary set sex=char(ASCII('f') ^ ASCII('m') ^ ASCII(sex));