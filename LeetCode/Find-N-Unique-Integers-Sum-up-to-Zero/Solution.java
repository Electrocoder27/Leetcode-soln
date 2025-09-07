class Solution {
    public int[] sumZero(int n) {
        int res[] = new int[n] ;
        int idx = 0 ;
        if(n%2 != 0) {
            res[idx++] = 0 ;
        }
        for(int i =1;idx<n;i++) {
            res[idx++] = -i ;
            res[idx++] = i;
        }


        return res ;
    }
}