class Solution {
    public double new21Game(int n, int k, int maxPts) {
        //if she never needs to stop or max score cannot exceeds................
        if(k==0 || n>=k + maxPts){
            return 1.0 ;
        }
        
        double[] dp = new double[n+1] ;

        dp[0] = 1.0 ;

        double windowsum = 1.0 ; // dp[i] = prob of getting exactly i points.........

        double result = 0.0 ;

        for(int i =1;i<= n;i++) {
            dp[i] = windowsum/ maxPts ;

            if(i<k) {
                windowsum += dp[i] ;
            }
            else{
                result += dp[i] ;
            }

            //maintaining sliding window............

            if(i-maxPts >= 0) {
                windowsum -= dp[i- maxPts] ;
            }
        }
        return result ;
    }
}