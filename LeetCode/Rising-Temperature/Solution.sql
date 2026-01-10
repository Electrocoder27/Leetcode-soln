1# Write your MySQL query statement below
2SELECT w1.id 
3FROM Weather w1
4JOIN Weather w2
5ON w1.recordDate = DATE_ADD(w2.recordDate,INTERVAL 1 DAY)
6AND w1.temperature>w2.temperature ;