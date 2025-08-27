class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //forming the DP array...........
        int n = str1.length() ;
        int m = str2.length() ;

        int dp[][] = new int[n+1][m+1] ;

        for(int i=0;i<n+1;i++) {
            for(int j = 0;j<m+1;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<n+1;i++) {
            for(int j =1;j<m+1;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] =1+ dp[i-1][j-1] ;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) ;
                }
            }
        }

        String ans = "" ;
        int i =n;
        int j = m ;

        while(i>0 && j>0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans += str1.charAt(i-1) ;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                ans += str1.charAt(i-1) ;
                i-- ;
            }
            else{
                ans += str2.charAt(j-1) ;
                j--;
            }
        }
        
        while(i>0) {
            ans += str1.charAt(i-1) ;
            i--;
        }
        while(j>0) {
            ans +=str2.charAt(j-1) ;
            j-- ;
        }

        String res = new StringBuilder(ans).reverse().toString() ;

        return res ;
    }
}