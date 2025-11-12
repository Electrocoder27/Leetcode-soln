class Solution {
    private int gcd(int a,int b){
        while(b != 0){
            int temp = b ;
            b = a%b ;
            a = temp ;
        }
        return a ;
    }
    public int minOperations(int[] nums) {
        int n = nums.length ;
        int ones = 0;
        for(int x: nums){
            if(x==1){
                ones++ ;
            }
        }

        if(ones>0){
            return (n-ones) ;
        }

        int minlen = Integer.MAX_VALUE ;

        for(int i =0;i<n;i++){
            int currgcd = nums[i] ;
            for(int j = i+1;j<n;j++){
                currgcd = gcd(currgcd,nums[j]) ;
                if(currgcd == 1){
                    minlen = Math.min(minlen,j-i+1) ;
                    break ;
                }
            }
        }

        if(minlen == Integer.MAX_VALUE) {
            return -1 ;
        }

        return (minlen-1) + (n-1) ;
    }
}