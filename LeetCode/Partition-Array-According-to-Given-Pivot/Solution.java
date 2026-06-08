1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        ArrayList<Integer> ls = new ArrayList<>() ;
4        ArrayList<Integer> lg = new ArrayList<>() ;
5        ArrayList<Integer> le = new ArrayList<>() ;
6        int n = nums.length ;
7        for(int i =0;i<n;i++){
8            if(nums[i]<pivot){
9                ls.add(nums[i]) ;
10            }
11            else if(nums[i]>pivot) {
12                lg.add(nums[i]) ;
13            }
14            else{
15                le.add(nums[i]) ;
16            }
17        }
18
19        int [] res = new int[n] ;
20        int i =0;
21        int j =0;
22        int k = 0;
23        while(i<ls.size()){
24            res[i] = ls.get(i) ;
25            i++ ;
26        }
27        while(j<le.size()){
28            res[i++] = le.get(j) ;
29            j++ ;
30        }
31        while(k<lg.size()){
32            res[i++] = lg.get(k) ;
33            k++ ;
34        }
35
36        return res ;
37    }
38}