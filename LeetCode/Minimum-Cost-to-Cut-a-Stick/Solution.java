class Solution {
    private int f(int i,int j ,int[] cuts,int [][]dp) {
        if(i>j){
            return 0 ;
        }
        if(dp[i][j] != -1) {
            return dp[i][j] ;
        }
        int min = Integer.MAX_VALUE ;
        for(int idx=i;idx<=j;idx++) {
            int cost = (cuts[j+1]-cuts[i-1]) + f(i,idx-1,cuts,dp) + f(idx+1,j,cuts,dp) ;
            min = Math.min(min,cost) ;        
        }
        return dp[i][j] = min ;
    }
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
            Arrays.fill(dp[i],-1) ;
        }

        Arrays.sort(newcuts) ;

        return f(1,c,newcuts,dp) ;
    }
}