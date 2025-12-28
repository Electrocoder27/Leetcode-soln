1class Solution {
2    public int countNegatives(int[][] grid) {
3        int count = 0;
4        int m = grid.length ;
5        int n = grid[0].length ;
6        for(int i =0 ;i<m;i++){
7            for(int j =0;j<n;j++) {
8                if(grid[i][j] <0) {
9                    count += n-j ;
10                    break ;
11                }
12            }
13        }
14        return count ;
15    }
16}