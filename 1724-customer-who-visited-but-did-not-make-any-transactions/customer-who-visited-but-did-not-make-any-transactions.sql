SELECT 
    v.customer_id,
    count(v.customer_id) as count_no_trans
FROM 
    visits as v 
    LEFT JOIN transactions as t
    ON v.visit_id = t.visit_id
WHERE 
    t.visit_id IS NULL 
GROUP BY 
    v.customer_id 
ORDER BY 
    v.customer_id ; 


