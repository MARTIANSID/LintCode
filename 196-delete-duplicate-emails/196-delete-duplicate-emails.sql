# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
delete p1 from 
Person p1 join Person p2
on p1.Email=p2.Email
where p1.id>p2.id