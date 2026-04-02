class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length ;
        int n = coins[0].length ;

        int dp[][][] = new int[m][n][3] ;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                for(int k = 0;k<3;k++){
                    dp[i][j][k] = Integer.MIN_VALUE ;
                }
            }
        }

        if(coins[0][0] >=0){
            dp[0][0][0] = coins[0][0] ;//accepts if positive.......
        }
        else{
            dp[0][0][0] = coins[0][0] ;//takes -ve value..........
            dp[0][0][1] = 0 ;//after 1 neutralisation........
        }

        //filling the table........
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                for(int k = 0;k<3;k++){
                    if(dp[i][j][k] == Integer.MIN_VALUE){
                        continue ;
                    }
                    //moving down.............
                    if(i+1<m){
                        int val = coins[i+1][j] ;
                        //if val>=0
                        dp[i+1][j][k] = Math.max(dp[i+1][j][k],dp[i][j][k]+val) ;
                        if(val<0 && k<2){
                            dp[i+1][j][k+1] = Math.max(dp[i+1][j][k+1],dp[i][j][k]) ; 
                        }
                    }
                    //moving right..............
                    if(j+1<n){
                        int val = coins[i][j+1] ;
                        dp[i][j+1][k] = Math.max(dp[i][j+1][k],dp[i][j][k]+val) ;
                        if(val<0 && k<2){
                            dp[i][j+1][k+1] = Math.max(dp[i][j+1][k+1],dp[i][j][k]) ;
                        }
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE ;
        for(int i =0;i<3;i++){
            ans = Math.max(ans,dp[m-1][n-1][i]) ;
        }
        return ans ;
    }
}