class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length ;
        if(n==1){
            return 0 ;
        }
        Arrays.sort(nums) ;

        int l = 0;
        int maxlen = 0;
        for (int r = 0; r < n; r++) {
            while ((long) nums[l] * k < nums[r]) {
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return n-maxlen ;
    }
}