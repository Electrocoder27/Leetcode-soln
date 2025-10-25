class Solution {
    public int totalMoney(int n) {
        int totalsum = 0 ;
        int weekstart = 1;
        int day =0;
        while(day<n){
            for(int i =0;i<7 && day<n;i++){
                totalsum += weekstart + i ;
                day++ ;
            }
            weekstart++ ;
        }
        return totalsum ;
    }
}