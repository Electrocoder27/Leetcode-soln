1class Solution {
2    public int countTriples(int n) {
3        int count = 0;
4        for(int a = 1;a<=n;a++) {
5            for(int b = 1;b<= n;b++) {
6                int c2 = a*a + b*b ;
7                int c = (int)Math.sqrt(c2) ;
8                if(c*c == c2 && c<= n){
9                    count++ ;
10                }
11            }
12        }
13
14        return count ;
15    }
16}