1class Solution {
2    public int latestDayToCross(int row, int col, int[][] cells) {
3        int l = 0;
4        int r = cells.length ;
5        int ans = 0;
6        while(l<=r) {
7            int mid = l + (r-l)/2 ;
8            if(canwalk(row,col,cells,mid)) {
9                ans = mid ;
10                l = mid+1 ;
11            }
12            else{
13                r = mid-1 ;
14            }
15        }
16
17        return ans ;
18    }
19
20    private boolean canwalk(int row,int col,int[][] cells,int day) {
21        int [][] grid = new int[row][col] ;
22
23
24        for(int i =0;i<day;i++) {
25            int r = cells[i][0] -1 ;
26            int c = cells[i][1] - 1 ;
27            grid[r][c] =  1 ;
28        }
29
30        boolean [][] vis = new boolean[row][col] ;
31        Queue<int[]> q = new LinkedList<>() ;
32
33        for(int c = 0;c<col;c++) {
34            if(grid[0][c] == 0) {
35                q.offer(new int[] {0,c}) ;
36                vis[0][c] = true ;
37            } 
38        }
39
40        int [][] dir = {{1,0},{-1,0},{0,-1},{0,1}} ;
41        while(!q.isEmpty()) {
42            int [] curr = q.poll() ;
43            int r = curr[0] ;
44            int c =  curr[1] ;
45
46            if(r == row-1) {
47                return true ;
48            }
49
50            for(int [] d: dir) {
51                int nr = r +d[0] ;
52                int nc = c +d[1] ;
53
54                if(nr >=0 && nr< row && nc >=0 && nc < col && !vis[nr][nc] && grid[nr][nc] == 0) {
55                    vis[nr][nc] = true ;
56                    q.offer(new int[] {nr,nc}) ;
57                }
58            }
59        }
60
61        return false ;
62    }
63}