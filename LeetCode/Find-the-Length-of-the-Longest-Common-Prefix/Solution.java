1class Solution {
2    public int longestCommonPrefix(int[] arr1, int[] arr2) {
3        int maxlen = 0;
4        HashSet<Integer> set = new HashSet<>() ;
5        for(int val: arr1) {
6            while(val>0){
7                set.add(val);
8                val /= 10 ;
9            }
10        }
11        for(int val: arr2) {
12            while(val>0){
13                if(set.contains(val)){
14                    int len = (int) Math.log10(val) +1 ;
15                    maxlen = Math.max(maxlen,len);
16                    break ;
17                }
18                val /= 10 ;
19            }
20        }
21
22        return maxlen ;
23    }
24}