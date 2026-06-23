1class Solution {
2    public int[] getConcatenation(int[] nums) {
3        int n =nums.length ;
4        int res[] = new int[2*n] ;
5
6        for(int i =0;i<n;i++){
7            res[i] = nums[i] ;
8            res[i+n] = nums[i] ;
9        }
10
11        return res ;
12    }
13}