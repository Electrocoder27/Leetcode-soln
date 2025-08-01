class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        boolean[] vowels = new boolean[128] ;

        vowels['a'] = vowels['e'] = vowels['i'] = vowels['o'] = vowels['u'] = true ;

        //first window...........

        for(int i =0;i<k;i++) {
            if(vowels[s.charAt(i)]) {
                count++ ;
            }
        }

        max = count ;

        for(int i =k;i<s.length();i++) {
            if(vowels[s.charAt(i)]) {
                count++ ;
            }
            if(vowels[s.charAt(i-k)]) {
                count-- ;
            }
            max = Math.max(max,count) ;
        }

        return max ;
    }
}