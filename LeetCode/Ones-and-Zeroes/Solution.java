class Solution {
    private int countzeros(String s){
        int count = 0;
        for(char ch :s.toCharArray()){
            if(ch == '0'){
                count++ ;
            }
        }

        return count ;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m+1][n+1] ;

        for(String s: strs){
            int z =  countzeros(s) ;
            int o = s.length() -z ;

            for(int i =m;i>=z;i--){
                for(int j = n;j>=o;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-z][j-o]+1) ;
                }
            }
        }


        return dp[m][n] ;
    }
}