class Solution {
    public int numberOfBeams(String[] bank) {
        int totallaser = 0;
        int prev = 0 ;
        for(String s : bank){
            int curr = 0;
            for(char ch : s.toCharArray()){
                if(ch == '1'){
                    curr++ ;
                }
            }
            if(curr >0) {
                totallaser += curr*prev ;
                prev = curr ;
            }
        }
        return totallaser ;
    }
}