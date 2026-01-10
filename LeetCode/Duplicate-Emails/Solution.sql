1# Write your MySQL query statement below
2SELECT email
3 FROM Person 
4 GROUP BY email
5 HAVING count(email) > 1 ;