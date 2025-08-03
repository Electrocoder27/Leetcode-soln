class Solution {
    private int LCS(int[] arr1,int[] arr2) {
        int n = arr1.length ;
        int m = arr2.length ;

        int dp[][] = new int[n+1][m+1] ;
        //intialisation..............
        for(int i =0;i<n+1;i++) {
            dp[i][0] = 0 ; 
        }
        for(int j =0;j<m+1;j++) {
            dp[0][j] = 0;
        }
        for(int i =1;i<n+1;i++) {
            for(int j =1;j<m+1;j++) {
                if(arr1[i-1]==arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] +1  ;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) ;
                }
            }
        }
        return dp[n][m] ;
    }
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>() ;
        for(int num: nums) {
            set.add(num) ;
        }

        int [] nums1 = new int[set.size()] ;
        int i =0;
        for(int x : set) {
            nums1[i] = x ;
            i++ ;
        }

        Arrays.sort(nums1) ;
        return LCS(nums,nums1) ;


    }
}