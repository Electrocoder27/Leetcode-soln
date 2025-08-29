class Solution {
    public long flowerGame(int n, int m) {
        long odd_n = (long)(n+1)/2 ;
        long even_n = (long) n/2  ;

        long odd_m = (long) (m+1)/2 ;
        long even_m = (long) m/2 ;


        long ans = odd_n*even_m + odd_m*even_n ;


        return ans ;
    }
}