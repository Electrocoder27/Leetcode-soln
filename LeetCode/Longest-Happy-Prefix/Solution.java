1class Solution {
2    public String longestPrefix(String s) {
3        int n = s.length() ;
4        int len = 0;
5        int lps[] = new int[n] ;
6        lps[0] = 0 ;
7        int i =1 ;
8        while(i<n) {
9            if(s.charAt(i) == s.charAt(len)){
10                len++;
11                lps[i] = len;
12                i++;
13            }
14            else{
15                if(len>0) {
16                    len = lps[len-1] ;
17                }
18                else{
19                    lps[i] = 0;
20                    i++ ;
21                }
22            }
23        }
24        return s.substring(0,lps[n-1]) ;
25    }
26}