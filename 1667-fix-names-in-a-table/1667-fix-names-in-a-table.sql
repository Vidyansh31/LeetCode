# Write your MySQL query statement below
Select user_id , CONCAT(UPPER(SUBSTR(name,1,1)),LOWER(SUBSTR(name,2))) AS name
from Users order by user_id;

