class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target) ;
        int sum = 0;
        int moves = 0;
        while(sum<target || (target-sum) %2 != 0) {
            moves++ ;
            sum += moves ;
        }


        return moves ;
    }
}