1class Solution {
2    public int concatenatedBinary(int n) {
3        long res = 0;
4        int MOD = 1000000007 ;
5        for(int i =1;i<=n;i++){
6            int bits = Integer.toBinaryString(i).length() ;
7            res = ((res<< bits) + i)%MOD ;
8        }
9
10        return (int)res ;
11    }
12}