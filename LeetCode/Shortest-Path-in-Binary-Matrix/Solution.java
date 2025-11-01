class tuple{
    int first;
    int second ;
    int third ;
    tuple(int _first ,int _second,int _third){
        this.first = _first ;
        this.second = _second ;
        this.third = _third ;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length ;
        if(grid[0][0] ==1 || grid[n-1][n-1] ==1){
            return -1 ;
        }
        if(n == 1){
            return 1 ;
        }
        Queue<tuple> q = new LinkedList<>() ;
        int dis[][] = new int[n][n] ;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                dis[i][j] = (int)(1e9) ;
            }
        }

        dis[0][0] = 1 ;
        q.add(new tuple(1,0,0)) ;
        int dr[] = {-1,0,+1,0,+1,-1,+1,-1} ;
        int dc[] = {0,+1,0,-1,+1,+1,-1,-1} ;

        while(!q.isEmpty()){
            tuple it = q.peek() ;
            q.remove() ;
            int dist = it.first ;
            int r = it.second ;
            int c = it.third ;

            for(int i =0;i<8;i++){
                int nr = r + dr[i] ;
                int nc =  c + dc[i] ;

                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 0 && dist +1 < dis[nr][nc]) {
                    dis[nr][nc] = 1 + dist ;
                    if(nr == n-1 && nc == n-1){
                        return 1 + dist ;
                    }
                    q.add(new tuple(1+dist,nr,nc)) ;
               }
            }
        }
        return -1 ;
    }
}