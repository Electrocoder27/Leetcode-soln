1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        // int totalsum = 0;
4        // for(int num:asteroids){
5        //     totalsum += num ;
6        // }
7        int n = asteroids.length ;
8        Arrays.sort(asteroids) ;
9        long currmass = mass ;
10        for(int i =0;i<n;i++){
11            if(currmass>=asteroids[i]){
12                currmass += asteroids[i] ;
13            }
14            else{
15                return false ;
16            }
17        }
18        return true ;
19    }
20}