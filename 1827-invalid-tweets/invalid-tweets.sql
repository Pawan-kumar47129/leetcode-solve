-- Write your PostgreSQL query statement below
SELECT tweet_id
FROM tweets
WHERE Length(content)>15;