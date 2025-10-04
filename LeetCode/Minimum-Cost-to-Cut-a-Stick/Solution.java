class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length ;
        int newcuts[] = new int[c+2] ;

        newcuts[0] = 0;
        newcuts[c+1] = n ;
        for(int i=0;i<c;i++) {
            newcuts[i+1] = cuts[i];
        }

        int dp[][] = new int[c+2][c+2] ;
        

        for(int i =0;i<c+2;i++) {
            Arrays.fill(dp[i],0) ;
        }

        Arrays.sort(newcuts) ;

        for(int i = c;i>=1;i--) {
            for(int j =1;j<=c;j++) {
                if(i>j) {
                    continue ;
                }
                int min = Integer.MAX_VALUE ;
                for(int idx = i;idx<=j;idx++) {
                    int cost = (newcuts[j+1]-newcuts[i-1]) + dp[i][idx-1] + dp[idx+1][j] ;
                    min = Math.min(min,cost) ;
                }
                dp[i][j] = min ;
            }
        }
        return dp[1][c];
    }
}