1class Solution {
2    public int findMaxConsecutiveOnes(int[] nums){
3        int maxcount = 0;
4        int currentcount = 0 ;
5        for(int i = 0;i<nums.length;i++){
6            if(nums[i]==1){
7                currentcount++ ;
8            }
9            else{
10                maxcount = Math.max(maxcount,currentcount) ;
11                currentcount = 0 ;
12            }
13        }
14        maxcount = Math.max(maxcount,currentcount) ;
15        return maxcount ;
16    }
17
18}