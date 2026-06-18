1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double minangle = 0;
4        double hourangle = 0;
5        minangle = 6*minutes ;
6        hourangle = 30*(hour%12)+0.5*minutes;
7
8        double totalangle = Math.abs(minangle-hourangle) ;
9
10        return totalangle <=180? totalangle:Math.abs(360-totalangle) ;
11    }
12}