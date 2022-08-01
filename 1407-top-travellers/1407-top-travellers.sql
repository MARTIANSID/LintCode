# Write your MySQL query statement below
select u.name,sum(if(r.distance is null,0,r.distance)) as travelled_distance
from Users as u
left join Rides as r
on u.id=r.user_id
group by r.user_id
order by travelled_distance desc , name asc