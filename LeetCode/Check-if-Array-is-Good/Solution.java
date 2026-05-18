1class Solution {
2    public boolean isGood(int[] nums) {
3        Arrays.sort(nums) ;
4        int n  = nums.length;
5        int max = nums[n-1] ;
6        if(n!= max+1){
7            return false ;
8        }
9        for(int i =0;i<n-1;i++) {
10            if(nums[i]!= i+1){
11                return false ;
12            }
13        }
14        return nums[n-1] == max && nums[n-2] == max ; 
15    }
16}