class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int res = 0 ;
        int countl = 0;
        int countr = 0;
        int count_ = 0 ;
        for(int i =0;i<moves.length();i++){
            char ch = moves.charAt(i) ;
            if(ch == 'L'){
                countl++ ;
            }
            else if(ch == 'R'){
                countr++ ;
            }
            else{
                count_++ ;
            }
        }
        res += Math.abs(countl-countr) + count_ ;

        return res ;
    }
}