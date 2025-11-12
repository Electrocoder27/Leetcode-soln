class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE ;
        for(int x:nums){
            max = Math.max(max,x) ;
        }
        int n = nums.length ;
        int count = 0;
        for(int i =0;i<n;i++){
            count += max- nums[i] ;
        }


        return count ;
    }
}