class Solution {
    public String largestGoodInteger(String num) {
        String ans = "" ;
        for(int i =0;i<=num.length()-3 ;i++) {
            char c = num.charAt(i) ;
            if(num.charAt(i+1)==c && num.charAt(i+2) == c) {
                String cand = num.substring(i,i+3) ;
                if(cand.compareTo(ans)>0) {
                    ans = cand ;
                }
            }
        }
        return ans ;
    }
}