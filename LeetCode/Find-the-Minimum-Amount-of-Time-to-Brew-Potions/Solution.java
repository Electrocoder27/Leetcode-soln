class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        if (n == 0 || m == 0) return 0L;

        long[] prefixPrev = new long[n + 1];
        long[] prefixCurr = new long[n + 1];
        long[] S = new long[m];
        S[0] = 0L;

        // prefix for the first potion
        for (int i = 1; i <= n; i++) {
            prefixPrev[i] = prefixPrev[i - 1] + (long) skill[i - 1] * mana[0];
        }

        for (int j = 1; j < m; j++) {
            // compute prefix for current potion j
            prefixCurr[0] = 0L;
            for (int i = 1; i <= n; i++) {
                prefixCurr[i] = prefixCurr[i - 1] + (long) skill[i - 1] * mana[j];
            }

            long best = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                // candidate = S[j-1] + prefixPrev[i+1] - prefixCurr[i]
                long candidate = S[j - 1] + prefixPrev[i + 1] - prefixCurr[i];
                if (candidate > best) best = candidate;
            }
            S[j] = Math.max(0L, best);

            // move current prefix to previous for next iteration
            long[] temp = prefixPrev;
            prefixPrev = prefixCurr;
            prefixCurr = temp;
        }

        return S[m - 1] + prefixPrev[n];  // total time = start of last + its full processing
    }
}
