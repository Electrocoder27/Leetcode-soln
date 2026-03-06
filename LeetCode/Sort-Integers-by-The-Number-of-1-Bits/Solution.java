1class Solution {
2    public int[] sortByBits(int[] arr) {
3        int n = arr.length ;
4        Integer [] nums = new Integer[n] ;
5        for(int i =0;i<n;i++){
6            nums[i] = arr[i] ;
7        }
8
9        Arrays.sort(nums,(a,b)->{
10            int bita = Integer.bitCount(a);
11            int bitb = Integer.bitCount(b) ;
12
13            if(bita == bitb){
14                return a-b ;
15            }
16            return bita-bitb ;
17        }) ;
18
19        for(int i=0;i<n;i++){
20            arr[i] = nums[i] ;
21        }
22
23        return arr;
24    }
25}