class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length ;
        int nums1[] = new int[n+2] ;

        nums1[0] = 1;
        nums1[n+1] = 1;

        for(int i =0;i<n;i++) {
            nums1[i+1] = nums[i] ;
        }

        int dp[][] = new int[n+2][n+2] ;

        for(int i=0;i<n+2;i++) {
            Arrays.fill(dp[i],0) ;
        }

        for(int i =n;i>=1;i--) {
            for(int j =1;j<=n;j++) {
                if(i>j) {
                    continue ;
                }
                int max = Integer.MIN_VALUE ;
                for(int idx=i;idx<=j;idx++) {
                    int cost = nums1[i-1]*nums1[idx]*nums1[j+1] + dp[i][idx-1] + dp[idx+1][j] ;
                    max = Math.max(max,cost) ;
                }
                dp[i][j] = max ;
            }
        }

        return dp[1][n] ;
    }
}