1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int MOD = 1000000007 ;
4        for(int [] q: queries){
5            int l = q[0] ;
6            int r = q[1] ;
7            int k = q[2] ;
8            int v = q[3] ;
9            while(l<=r){
10                nums[l] = (int)((1L*nums[l]*v)%MOD) ;
11                l += k ;
12            }
13        }
14        int res = 0;
15        for(int i=0;i<nums.length;i++){
16            res = res^nums[i] ;
17        }
18        return res ;
19    }
20}