1class Solution {
2    public int maxSubArray(int[] nums) {
3        int cs = 0;
4        int ms = Integer.MIN_VALUE ;
5        for(int num:nums) {
6            cs += num;
7            ms = Math.max(cs,ms) ;
8            if(cs<0) {
9                cs=0;
10            }
11        }
12        return ms;
13    }
14}