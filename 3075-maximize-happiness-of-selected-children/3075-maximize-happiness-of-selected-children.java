class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int n = happiness.length ;
        Arrays.sort(happiness);
        int dec = 0;

        for(int i =n-1;i>=0 && k>0;i--,k--) {
            if(happiness[i]-dec>0) {
                ans += happiness[i]-dec ;
                dec++ ;
            }
        }
        return ans ;
    }
}