1class Solution {
2    public int minimumDeletions(String s) {
3        int dp = 0;
4        int countB = 0;
5
6        for(char c: s.toCharArray()) {
7            if(c== 'a') {
8                dp = Math.min(dp+1,countB) ;
9            }
10            else{
11                countB++ ;
12            }
13        }
14
15        return dp ;
16    }
17}