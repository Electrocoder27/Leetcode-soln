1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length ;
4        int sum = 0 ; 
5        for(int num:nums){
6            sum += num ;
7        }
8        int [] ans  = new int[n] ;
9        int leftsum = 0;
10        for(int i=0;i<n;i++) {
11            int rightsum = sum-leftsum - nums[i] ;
12            ans[i] = Math.abs(leftsum-rightsum) ;
13
14            leftsum += nums[i] ;
15        }
16        return ans ;
17    }
18}