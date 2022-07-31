# Write your MySQL query statement below

Select name from SalesPerson where sales_id not in
(
Select o.sales_id
from Orders as o
inner join Company as c
on o.com_id = c.com_id
where c.name='RED')