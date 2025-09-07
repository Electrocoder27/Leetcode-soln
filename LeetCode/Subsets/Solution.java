class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length ;
        List<List<Integer>>  ans = new ArrayList<>() ;
        int subset = 1<<n ;
        
        for(int num =0;num<=subset-1;num++) {
            List<Integer> list = new ArrayList<>() ;
            for(int i =0;i<=n-1;i++) {
                if((num & (1<<i)) != 0) {
                    list.add(nums[i]) ;
                }
            }
            ans.add(list) ;
        }
        return ans ;
    }
}