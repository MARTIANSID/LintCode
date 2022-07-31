# Write your MySQL query statement below
select distinct w2.id AS Id
from Weather as w1
inner join Weather as w2
on datediff(w2.recordDate,w1.recordDate)=1
where w2.temperature > w1.temperature
