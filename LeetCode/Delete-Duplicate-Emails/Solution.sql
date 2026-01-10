1# Write your MySQL query statement below
2DELETE p1 
3FROM Person p1
4JOIN Person p2
5ON p1.email = p2.email 
6AND p1.id>p2.id ;
7