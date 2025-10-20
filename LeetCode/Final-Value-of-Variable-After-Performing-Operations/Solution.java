class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int finalval = 0;
        for(String s: operations){
            if(s.charAt(0) =='-' || s.charAt(s.length()-1)=='-'){
                finalval -= 1;
            }
            else{
                finalval += 1 ;
            }
        }

        return finalval  ;
    }
}