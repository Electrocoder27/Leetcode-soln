class Solution {
    public int maxArea(int[] height) {
        int maxwater =0;
        int lp=0;
        int rp = height.length-1 ;
        while(lp<rp){
            int ht = Math.min(height[rp],height[lp]) ;
            int width = rp-lp ;
            int curr =  width*ht ;
            maxwater = Math.max(curr,maxwater) ;
            if(height[lp]<height[rp]) {
                lp++ ;
            }
            else{
                rp-- ;
            }
        }
        return maxwater ;
    }
}