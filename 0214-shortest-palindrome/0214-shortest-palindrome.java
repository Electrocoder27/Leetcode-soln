class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rev;

        int[] lps = new int[t.length()];
        int j = 0;

        for (int i = 1; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = lps[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        int palLen = lps[t.length() - 1];
        String suffix = s.substring(palLen);

        return new StringBuilder(suffix).reverse().toString() + s;
    }
}