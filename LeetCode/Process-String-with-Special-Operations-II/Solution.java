1class Solution {
2    public char processStr(String s, long k) {
3        int n = s.length() ;
4        Long [] len =  new Long[n] ;
5        long curr =0L ;
6        
7        for(int i =0;i<n;i++){
8            char ch = s.charAt(i) ;
9            if(ch >='a' && ch <= 'z'){
10                curr++ ;
11            }
12            else if(ch == '#'){
13                curr = curr*2 ;
14            }
15            else if(ch == '*'){
16                if(curr>0){
17                    curr-- ;
18                }
19            }
20            else{
21                //no length change........
22                //continue ;
23            }
24            len[i] = curr ;
25        }
26
27        if(len[n-1] <= k){
28            return '.' ;
29        }
30        for(int i =n-1;i>=0;i--){
31            long currlen = len[i] ;
32            long prevlen = (i==0)?0:len[i-1] ;
33            
34            char ch = s.charAt(i) ;
35            
36            if(ch == '#'){
37                if(prevlen>0){
38                    k= k%prevlen ;
39                }
40                
41            }
42            else if(ch == '%'){
43                k = currlen -1-k ;
44            }
45            else if(ch == '*'){
46                continue ;
47            }
48            else{
49                if(k == currlen-1){
50                    return ch ;
51                }
52            }
53        }
54        return '.' ;
55        
56    }
57}