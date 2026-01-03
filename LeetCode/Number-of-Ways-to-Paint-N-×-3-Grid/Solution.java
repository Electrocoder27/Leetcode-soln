1class Solution {
2    private int solve(int i,int n,int mod,int prev1,int prev2,int prev3,int dp[][][][]){
3        if(i==n) {
4            return 1 ;
5        }
6
7        if(dp[i][prev1][prev2][prev3] != -1) {
8            return dp[i][prev1][prev2][prev3] ;
9        }
10
11        int ans  = 0;
12        for(int col1 =1 ;col1<4;col1++) {
13            if(prev1 == col1) {
14                continue ;
15            }
16            for(int col2 = 1;col2<4;col2++) {
17                if(col2 == col1 || col2 ==prev2) {
18                    continue ;
19                }
20                for(int col3 = 1 ;col3<4;col3++) {
21                    if(col3 == col2 || col3 == prev3) {
22                        continue ;
23                    }
24
25                    ans = (ans + solve(i+1,n,mod,col1,col2,col3,dp)) % mod ;
26                }
27            }
28        }
29
30        return dp[i][prev1][prev2][prev3] = ans ;
31    }
32    public int numOfWays(int n) {
33        int mod = 1000000007 ;
34        int dp[][][][] =  new int[n][4][4][4] ;
35
36        for (int i = 0; i < n; i++)
37            for (int a = 0; a < 4; a++)
38                for (int b = 0; b < 4; b++)
39                    for (int c = 0; c < 4; c++)
40                        dp[i][a][b][c] = -1;
41
42
43        return solve(0,n,mod,0,0,0,dp) ;
44
45    }
46}