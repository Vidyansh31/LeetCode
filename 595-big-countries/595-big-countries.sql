# Write your MySQL query statement below
select name, population, area from world where population >= 25000000
union
select name, population, area from world where area >= 3000000;
