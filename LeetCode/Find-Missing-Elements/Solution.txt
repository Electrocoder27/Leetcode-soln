class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>() ;
        HashSet<Integer> set = new HashSet<>() ;
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;

        for(int i = 0;i<nums.length ;i++){
            max = Math.max(nums[i],max) ;
            min = Math.min(min,nums[i]) ;
            set.add(nums[i]) ;
        }

        for(int i = min ;i<=max;i++){
            if(!set.contains(i)){
                ans.add(i) ;
            }
        }

        return ans ;
    }
}