class Solution {
    public int largestAltitude(int[] gain) {
        int maxht = 0 ;
        int sum = 0;
        for(int num:gain){
            sum += num ;
            maxht = Math.max(maxht,sum) ;
        }

        return maxht;
    }
}