1class Solution {
2    public int binaryGap(int n) {
3        int currpos = 0;
4        int prevpos = -1 ;
5        int maxlen = 0;
6        while(n>0){
7            if((n & 1) == 1){
8                if(prevpos != -1){
9                    maxlen = Math.max(maxlen,currpos-prevpos) ;
10                }
11                prevpos = currpos ;
12            }
13            n = n>>1 ;
14            currpos++ ;
15        }
16        return maxlen ;
17    }
18}