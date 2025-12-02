1class Solution {
2    public int minOperations(int[] nums, int k) {
3        int sum = 0 ;
4        for(int num: nums){
5            sum += num ;
6        }
7
8
9        return sum%k ;
10    }
11}