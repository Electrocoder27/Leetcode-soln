class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>() ;
        Deque<Integer> minDeque = new ArrayDeque<>() ;
        int n = nums.length ;
        int l =0;
        int r = 0;
        int maxlen =0;
        while(r<n) {
            //Maintaing decreasing maxDeque...........
            while(!maxDeque.isEmpty() && nums[r] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[r]) ;

            //Maintaing increasing minDeque........
            while(!minDeque.isEmpty() && nums[r] < minDeque.peekLast()) {
                minDeque.pollLast() ;
            }
            minDeque.addLast(nums[r]) ;


            //shrink window............
            while(maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if(nums[l] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst() ;
                }

                if(nums[l] == minDeque.peekFirst()) {
                    minDeque.pollFirst() ;
                }
                l++ ;
            }

            maxlen = Math.max(maxlen,r-l+1) ;
            r++ ;
        }

        return maxlen ;
    }
}