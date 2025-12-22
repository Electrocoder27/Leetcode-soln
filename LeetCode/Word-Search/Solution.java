1class Solution {
2    private boolean dfs(char[][] board,String word,int i,int j,int idx) {
3        if(idx == word.length()) {
4            return true ;
5        }
6        if(i<0 || j<0 || i>= board.length || j>=board[0].length) {
7            return false ;
8        }
9
10        if(board[i][j] != word.charAt(idx)) {
11            return false ;
12        }
13
14
15        char temp = board[i][j] ;
16        board[i][j] = '#' ;
17
18        boolean found = dfs(board,word,i-1,j,idx+1) ||
19                        dfs(board,word,i+1,j,idx+1) ||
20                        dfs(board,word,i,j-1,idx+1) ||
21                        dfs(board,word,i,j+1,idx+1) ;
22
23        board[i][j] = temp ;//backtrack ;
24
25        return found ; 
26    }
27    public boolean exist(char[][] board, String word) {
28        int n = board.length ;
29        int m = board[0].length ;
30
31        for(int i =0;i<n;i++) {
32            for(int j =0;j<m;j++) {
33                char ch = board[i][j] ;
34                if(dfs(board,word,i,j,0)){
35                    return true ;
36                }
37            }
38        }
39        return false ;
40    }
41}