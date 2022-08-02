# Write your MySQL query statement below

select u.user_id as buyer_id,u.join_date,count(CASE WHEN YEAR(o.order_date)=2019 THEN 1 ELSE null END) as orders_in_2019
from Users as u
left join Orders as o
on u.user_id = o.buyer_id
group by u.user_id