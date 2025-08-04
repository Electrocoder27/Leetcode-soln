class Solution {
    public int brokenCalc(int startValue, int target) {
        //using reerse greddy approach
       int ops = 0;
       while(target> startValue) {

        if(target%2 ==0) {
            target /= 2 ;
        }
        else{
            target +=1 ;
        }
        ops++ ;
       }
       return ops + (startValue-target) ;
    }
}