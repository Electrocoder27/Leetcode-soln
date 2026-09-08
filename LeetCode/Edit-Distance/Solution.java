1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n = word1.length() ;
4        int m = word2.length() ;
5        int [][] dp = new int[n+1][m+1] ;
6        //initialisation................
7        for(int i =0;i<n+1;i++) {
8            for(int j =0;j<m+1;j++) {
9                //agar ek hi cheez zero hai toh aur duisra kuch value hai toh utn aoper. kr ke usko balance kr lenge........
10                if(i==0) {
11                    dp[i][j] =j ;
12                } 
13                if(j==0) {
14                    dp[i][j] = i ;
15                }
16            }
17        }
18        for(int i =1;i<n+1;i++) {
19            for(int j = 1;j<m+1;j++) {
20                if(word1.charAt(i-1) == word2.charAt(j-1)) {
21                    dp[i][j] = dp[i-1][j-1] ;
22                }
23                else{
24                    //add.......
25                    int ans1 = dp[i][j-1] +1 ;
26                    //delete......
27                    int ans2 = dp[i-1][j] + 1 ;
28                    //replace.......
29                    int ans3 = dp[i-1][j-1] +1 ;
30                    dp[i][j] = Math.min(ans1,Math.min(ans2,ans3)) ;
31                }
32            }
33        }
34        return dp[n][m] ;
35    }
36}