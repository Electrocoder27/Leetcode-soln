class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>() ;
        int n = s.length() ;
        
        int count = 0;

        for(int i =0;i<n;i++) {
            char ch = s.charAt(i) ;
            map.put(ch,map.getOrDefault(ch,0)+1) ;    
        }
        boolean hasOdd = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1; // take even part
                hasOdd = true;
            }
        }

        if (hasOdd) count += 1;
        return count ;
    }
}