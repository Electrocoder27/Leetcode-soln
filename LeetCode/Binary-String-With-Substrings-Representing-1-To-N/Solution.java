public class Solution {
    public boolean queryString(String s, int n) {
        HashSet<Integer> set = new HashSet<>();
        int maxlen = Integer.toBinaryString(n).length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') continue;

            int val = 0;
            for (int j = i; j < s.length() && j - i <= maxlen; j++) {
                val = (val << 1) | (s.charAt(j) - '0');
                if (val > n) break;
                set.add(val);
            }
        }

        return set.size() == n;
    }
}
