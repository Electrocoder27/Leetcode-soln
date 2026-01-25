1class Solution {
2    public int minimumDifference(int[] nums, int k) {
3        int mindiff = Integer.MAX_VALUE ;
4        int n = nums.length ;
5        Arrays.sort(nums) ;
6        for(int i =0;i+k-1<n;i++) {
7            mindiff = Math.min(mindiff,nums[i+k-1]-nums[i]) ;
8        }
9        return mindiff ;
10    }
11}