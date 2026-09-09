1class Solution {
2    public long countCommas(long n) {
3        long res = 0;
4        int c= 1;
5        long lo = 1000;
6        while(n>=lo){
7            long up = lo*1000 -1;
8            if(up>n){
9                up = n;
10            }
11
12            long cno = (up-lo)+1;
13            res += (cno*c) ;
14
15            lo = lo*1000 ;
16            c++;
17        }
18        return res ;
19    }
20}