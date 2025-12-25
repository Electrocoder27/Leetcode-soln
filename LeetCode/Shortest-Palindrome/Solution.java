1class Solution {
2    public String shortestPalindrome(String s) {
3        String rev = new StringBuilder(s).reverse().toString();
4        String t = s + "#" + rev;
5
6        int[] lps = new int[t.length()];
7        int j = 0;
8
9        for (int i = 1; i < t.length(); i++) {
10            while (j > 0 && t.charAt(i) != t.charAt(j)) {
11                j = lps[j - 1];
12            }
13            if (t.charAt(i) == t.charAt(j)) {
14                j++;
15            }
16            lps[i] = j;
17        }
18
19        int palLen = lps[t.length() - 1];
20        String suffix = s.substring(palLen);
21
22        return new StringBuilder(suffix).reverse().toString() + s;
23    }
24}