class Solution {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        
        // Count vowels
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        
        // If no vowels, Alice cannot make a move
        return count > 0;
    }
}