class Solution {
    public int numSub(String s) {
        long MOD = 1000000007;
        long ans = 0;
        long run = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                run++;  // extend current block of 1s
            } else {
                // block ended, add contribution
                ans = (ans + run * (run + 1) / 2) % MOD;
                run = 0;
            }
        }

        // last block (if string ends with '1')
        ans = (ans + run * (run + 1) / 2) % MOD;

        return (int) ans;
    }
}