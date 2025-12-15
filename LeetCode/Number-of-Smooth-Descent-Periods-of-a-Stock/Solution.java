1class Solution {
2    public long getDescentPeriods(int[] prices) {
3        long ans = 1 ;
4        long len = 1 ;
5        for(int i =1;i<prices.length;i++) {
6            if(prices[i-1]-prices[i] == 1) {
7                len++ ;
8            }
9            else{
10                len = 1 ;
11            }
12            ans += len ;
13        }
14
15        return ans ;
16    }
17}