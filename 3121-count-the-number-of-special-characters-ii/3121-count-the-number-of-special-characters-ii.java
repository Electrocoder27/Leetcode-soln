class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        int lastlower[] = new int[26] ;
        int firstupper[] = new int[26] ;
        Arrays.fill(lastlower,-1) ;
        Arrays.fill(firstupper,-1) ;
        for(int i =0;i<word.length();i++){
            char ch = word.charAt(i) ;
            if(Character.isLowerCase(ch)){
                lastlower[ch-'a'] = i ;
            }
            else{
                if(firstupper[ch-'A'] == -1){
                    firstupper[ch-'A'] = i ; 
                }
            }
        }
        for(int i =0;i<26;i++){
            if(lastlower[i] != -1 && firstupper[i] != -1 && lastlower[i] < firstupper[i]){
                count++ ;
            }
        }
        return count ;
    }
}