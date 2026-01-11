1class Solution {
2    private int[] getNSR(int [] height){
3        Stack<Integer> st = new Stack<>() ;
4        int n = height.length ;
5
6        int [] NSR = new int[n] ;
7        for(int i = n-1;i>=0;i--) {
8            if(st.isEmpty()){
9                NSR[i] = n ;
10            }
11            else{
12                while(!st.isEmpty() && height[st.peek()] >= height[i]){
13                    st.pop() ;
14                }
15                if(st.isEmpty()){
16                    NSR[i] = n ;
17                }
18                else{
19                    NSR[i] = st.peek() ;
20                }
21            }
22
23            st.push(i) ;
24        }
25        return NSR ;
26    }
27    private int[] getNSL(int [] height){
28        Stack<Integer> st = new Stack<>() ;
29        int n = height.length ;
30
31        int [] NSL = new int[n] ;
32        for(int i =0;i<n;i++) {
33            if(st.isEmpty()){
34                NSL[i] = -1;
35            }
36            else{
37                while(!st.isEmpty() && height[st.peek()] >= height[i]){
38                    st.pop() ;
39                }
40                if(st.isEmpty()){
41                    NSL[i] =-1 ;
42                }
43                else{
44                    NSL[i] = st.peek() ;
45                }
46            }
47
48            st.push(i) ;
49        }
50        return NSL ;
51    }
52    private int findmaxarea(int [] height ){
53        int [] NSR = getNSR(height) ;
54        int [] NSL = getNSL(height) ;
55        int ar = 0;
56        int n = height.length ;
57        for(int i =0;i<n;i++){
58            int w = NSR[i]-NSL[i] -1 ;
59
60            int h = height[i] ;
61            ar = Math.max(ar,w*h) ;
62        }
63
64        return ar ;
65    }
66    public int maximalRectangle(char[][] matrix) {
67        int n = matrix.length ;
68        int m = matrix[0].length ;
69
70        int height[] = new int[m] ;
71        
72        for(int i =0;i<m;i++){
73            height[i] = (matrix[0][i] == '1')? 1:0 ;
74        }
75
76        int maxarea = findmaxarea(height) ;
77        for(int row = 1;row<n;row++){
78            for(int col=0;col<m;col++){
79                if(matrix[row][col] == '0'){
80                    height[col] = 0 ;
81                }
82                else{
83                    height[col] +=1 ;
84                }
85            }
86            maxarea = Math.max(maxarea,findmaxarea(height)) ; 
87        }
88
89         
90        return maxarea ;
91    }
92}