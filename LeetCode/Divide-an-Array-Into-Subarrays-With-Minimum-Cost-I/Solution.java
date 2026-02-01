1class Solution {
2    public int minimumCost(int[] nums) {
3        int cost = nums[0] ;
4        int minele = Integer.MAX_VALUE ;
5        int minele1 = Integer.MAX_VALUE ;
6
7        for(int i =1;i<nums.length ;i++){
8            if(nums[i] < minele){
9                minele1 = minele ;
10                minele = nums[i] ;
11            }
12            else if(nums[i] < minele1){
13                minele1 = nums[i] ;
14            }
15        }
16        cost += minele + minele1 ;
17
18        return cost ;
19    }
20}