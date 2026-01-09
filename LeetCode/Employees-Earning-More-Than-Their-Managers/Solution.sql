1# Write your MySQL query statement below
2SELECT e.name AS Employee
3From Employee e
4JOIN Employee m
5ON e.managerId = m.id 
6WhERE e.salary > m.salary ;