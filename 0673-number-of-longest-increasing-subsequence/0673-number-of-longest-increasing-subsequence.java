class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length ;

        int dp[] = new int[n] ;
        int count[] = new int[n] ;

        Arrays.fill(dp,1) ;
        Arrays.fill(count,1) ;
        int maxi = 1 ;
        for(int i =0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[j]<nums[i] && 1+dp[j] >dp[i]) {
                    dp[i] = dp[j] +1 ;
                    //inherit as new mila hai............
                    count[i]  = count[j] ;
                }
                else if(nums[j] <nums[i] &&  1+ dp[j] == dp[i]) {
                    //increase the count kyuki same length ka mila hai........
                    count[i] += count[j] ;
                }
            }

            maxi = Math.max(maxi,dp[i]) ;
        }

        int nos =0;
        for(int i =0;i<n;i++) {
            if(dp[i] == maxi) {
                nos += count[i] ;
            }
        }

        return nos ;
    }
}