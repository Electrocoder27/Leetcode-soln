1class Solution {
2    private int digitsum(int num){
3        int sum = 0 ;
4        while(num>0){
5            sum += num%10 ;
6            num = num/10 ;
7        }
8        return sum ;
9    }
10    public int minElement(int[] nums) {
11        int n = nums.length ;
12        for(int i =0;i<n;i++){
13            nums[i] = digitsum(nums[i]) ;
14        }
15        Arrays.sort(nums) ;
16        return nums[0] ;
17    }
18}