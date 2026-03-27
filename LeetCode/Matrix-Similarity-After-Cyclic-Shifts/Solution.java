1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length ;
4        int n = mat[0].length ;
5
6        k = k%n ;
7        for(int i =0;i<m;i++){
8            for(int j =0;j<n;j++){
9
10                if(i%2==0){
11                    if(mat[i][j] != mat[i][(j+k)%n]){
12                        return false ;
13                    }
14                }
15                else{
16                    if(mat[i][j] != mat[i][(j-k+n)%n]){
17                        return false ;
18                    }
19                }
20            }
21        }
22        return true ;
23    }
24}