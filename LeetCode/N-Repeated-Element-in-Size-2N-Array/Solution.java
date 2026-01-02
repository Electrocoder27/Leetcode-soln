1class Solution {
2    public int repeatedNTimes(int[] nums) {
3        int tar = nums.length/2 ;
4        HashMap<Integer,Integer> map = new HashMap<>() ;
5        for(int num: nums) {
6            map.put(num,map.getOrDefault(num,0)+1) ;
7        }
8        for(int key: map.keySet()) {
9            if(map.get(key)==tar){
10                return key ;
11            }
12        }
13        return -1 ;
14    }
15}