class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length() ;
        int[] even = new int[26] ;
        int[] odd = new int[26];
        for(int i =0;i<n;i++){
            char ch1 = s1.charAt(i) ;
            char ch2 = s2.charAt(i) ;
            if(i%2 == 0){
                even[ch1-'a']++ ;
                even[ch2 -'a']-- ;
            }
            else{
                odd[ch1-'a']++ ;
                odd[ch2-'a']-- ;
            }
        }
        for(int i =0;i<26;i++){
            if(even[i] !=0 || odd[i] != 0){
                return false ;
            }
        }
        return true ;
    }
}