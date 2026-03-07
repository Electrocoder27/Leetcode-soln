1class Solution {
2    public int minFlips(String s) {
3        int n = s.length() ;
4        String ss = s+s ;
5        int alt1 = 0;
6        int alt2 = 0 ;
7        int res = Integer.MAX_VALUE ;
8        for(int i =0;i<ss.length();i++){
9            //identifiying patterns..........
10            char exp1 = i%2 == 0? '0': '1' ;
11            char exp2 = i%2 == 0? '1' : '0' ;
12
13            //checking for values..
14            if(ss.charAt(i) !=exp1) {
15                alt1++ ;
16            }
17            if(ss.charAt(i) != exp2) {
18                alt2++ ;
19            }
20
21            if(i>=n){
22                char prev1 = (i-n)%2 ==0 ? '0':'1' ;
23                char prev2 = (i-n)%2 ==0 ? '1':'0' ;
24
25                if(ss.charAt(i-n) != prev1) {
26                    alt1-- ;
27                } 
28                if(ss.charAt(i-n) != prev2){
29                    alt2-- ;
30                }
31            }
32            if(i>=n-1){
33                res = Math.min(res,Math.min(alt1,alt2)) ;
34            }
35        } 
36        return res ;
37    } 
38}