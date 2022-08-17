# Write your MySQL query statement below
UPDATE Salary SET 
sex = CASE sex
when 'm' then 'f'
else 'm'
end;