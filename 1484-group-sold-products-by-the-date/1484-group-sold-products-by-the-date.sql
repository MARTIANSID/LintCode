# Write your MySQL query statement below


select sell_date ,Count(distinct product) as num_sold ,
Group_Concat(distinct product order by product) as products
from Activities
group by sell_date
order by sell_date