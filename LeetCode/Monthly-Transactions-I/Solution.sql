1SELECT 
2    DATE_FORMAT(t.trans_date, '%Y-%m') AS month,
3    t.country,
4    COUNT(t.id) AS trans_count,
5    SUM(CASE WHEN t.state = 'approved' THEN 1 ELSE 0 END) AS approved_count,
6    SUM(t.amount) AS trans_total_amount,
7    SUM(CASE WHEN t.state = 'approved' THEN t.amount ELSE 0 END) AS approved_total_amount
8FROM Transactions AS t
9GROUP BY month, t.country;