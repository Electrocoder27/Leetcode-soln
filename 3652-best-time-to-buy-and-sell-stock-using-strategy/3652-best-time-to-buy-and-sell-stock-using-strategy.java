class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length ;
        long [] prefixprofit = new long[n+1] ;
        for(int i = 0;i<n;i++) {
            prefixprofit[i+1] = prefixprofit[i] + (long)prices[i]*strategy[i] ;
        }
        long [] first = new long[n] ;
        long [] second = new long[n] ;

        for(int i =0;i<n;i++) {
            first[i] = (long) (0-strategy[i])*prices[i] ;
            second[i] = (long) (1-strategy[i])*prices[i] ;
        }

        int half = k/2 ;
        //1st window.........
        long currgain  = 0;
        for(int i=0;i<half;i++) {
            currgain += first[i] ;
        }
        for(int i =half;i<k;i++) {
            currgain += second[i] ;
        }
        long maxgain = currgain ;
        for(int l = 1;l+k-1<n;l++) {
            int r = l+k-1 ;
            //remove previous...........
            currgain -= first[l-1] ;
            currgain -= second[l-1+half] ;

            //adding...........
            currgain += first[l+half-1] ;
            currgain += second[r] ;

            maxgain = Math.max(maxgain,currgain) ;
        }
        maxgain = Math.max(maxgain,0) ;
        return (prefixprofit[n]+maxgain) ;
    }
}