class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int num: nums) {
            sum += num ;
        }
        if((target+sum) %2 != 0 || sum<Math.abs(target)) { // agar target aur sum ka sum odd hua toh non integer sum ayega..........
            return 0 ;
        }
        int subset = (target+sum)/2 ;
        int dp[] = new int[subset+1] ;
        dp[0] = 1;// only one way to have subset sum 0..............

        for(int num: nums) {
            for(int j = subset;j>=num;j--) {
                dp[j] += dp[j-num] ;// addition with adjacent ones...........
            }
        }
        return dp[subset] ;
    }
}