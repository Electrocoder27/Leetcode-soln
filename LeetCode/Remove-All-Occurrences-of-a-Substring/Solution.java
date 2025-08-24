class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder("") ;

        int plen =  part.length() ;
        for(char ch : s.toCharArray()) {
            sb.append(ch) ;
            
            if(sb.length() >= plen && sb.substring(sb.length()-plen).equals(part)) {
                sb.delete(sb.length()-plen,sb.length()) ;
            }
        }


        return sb.toString() ;
    }
}