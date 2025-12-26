class Solution {
    public int candy(int[] ratings) {
        int can  = 1;
        int n =  ratings.length ;
        int i = 1;
        while(i<n) {    
            if(ratings[i] == ratings[i-1]) {
                can += 1;
                i++ ;
                continue ;
            }
            int peak = 1;
            while(i<n && ratings[i] > ratings[i-1]){
                peak +=1 ;
                can += peak ;
                i++ ;
            }
            int down  =  1 ;
            while(i<n && ratings[i]<ratings[i-1]) {
                can += down ;
                down += 1 ;
                i++ ;
            }
            if(down > peak) {
                can += (down-peak) ;
            }
        }

        return can ;
    }
}