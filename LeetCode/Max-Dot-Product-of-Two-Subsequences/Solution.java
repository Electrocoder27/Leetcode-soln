1class Solution {
2    int n ;
3    int m ;
4    int dp[][] ;
5    private int solve(int []nums1,int[] nums2,int i ,int j) {
6        if(i ==n || j==m) {
7            return Integer.MIN_VALUE/2 ;
8        }
9
10        if(dp[i][j] != Integer.MIN_VALUE){
11            return dp[i][j] ;
12        }
13        int val = nums1[i]*nums2[j] ;
14        int takeij = val + Math.max(0,solve(nums1,nums2,i+1,j+1)) ;
15        int takei = solve(nums1,nums2,i,j+1) ;
16        int takej = solve(nums1,nums2,i+1,j) ;
17
18        return  dp[i][j] = Math.max(takeij,Math.max(takei,takej)) ;
19    }
20    public int maxDotProduct(int[] nums1, int[] nums2) {
21        n = nums1.length ;
22        m = nums2.length ;
23        dp= new int[n][m] ;
24        for(int i =0;i<n;i++){
25            for(int j =0;j<m;j++){
26                dp[i][j] = Integer.MIN_VALUE ;
27            }
28        }
29        return solve(nums1,nums2,0,0) ;        
30    }
31}