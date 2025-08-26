class Solution {
    public int minInsertions(String s) {
        String t= new StringBuilder(s).reverse().toString() ;
        int n = s.length() ;

        int dp[][] = new int[n+1][n+1] ;

        for(int i =0;i<n+1;i++) {
            for(int j =0;j<n+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0 ;
                }
            }
        }

        for(int i =1;i<n+1;i++) {
            for(int j =1 ;j<n+1;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1 ;
                }
                else{
                    int ans1 = dp[i-1][j] ;
                    int ans2  = dp[i][j-1] ;
                    dp[i][j] = Math.max(ans1,ans2) ;
                }
            } 
        }


        return (n-dp[n][n]) ;
    }
}