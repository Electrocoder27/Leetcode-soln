1class Solution {
2    // private int maxmin(int[] nums,int l,int r,){
3    //     int max = Integer.MIN_VALUE ;
4    //     int min = Integer.MAX_VALUE ;
5    //     for(int i =l;i<=r;i++) {
6    //         if(nums[i]>max){
7    //             max = Math.max(max,nums[i]) ;
8    //         }
9    //         else if(nums[i] < min){
10    //             min = Math.min(min,nums[i]) ;
11    //         }
12    //     }
13
14    //     return (max-min) ;
15    // }
16    public long maxTotalValue(int[] nums, int k) {
17        int n = nums.length ;
18        
19        Arrays.sort(nums) ;
20        long diff =  nums[n-1] - nums[0] ;
21        // int diff = nums[n-1] -nums[0] ;
22        return k*diff ;
23
24    }
25}