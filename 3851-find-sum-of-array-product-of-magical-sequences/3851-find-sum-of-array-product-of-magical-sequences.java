class Solution {
    static final long MOD = 1_000_000_007L;

    // fast pow
    static long modPow(long a, int e) {
        long r = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    // modular inverse via Fermat (MOD is prime)
    static long inv(long x) {
        return modPow(x, (int)(MOD - 2));
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // Precompute factorials and inverse factorials up to m
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[m] = inv(fact[m]);
        for (int i = m - 1; i >= 0; i--) invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;

        // Precompute nums[i]^c for c = 0..m
        long[][] powNum = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            powNum[i][0] = 1;
            for (int c = 1; c <= m; c++) powNum[i][c] = (powNum[i][c - 1] * nums[i]) % MOD;
        }

        // Bound for ones dimension: bit-length <= n + floor(log2(m)) approximately.
        // Use a safe margin.
        int maxOnes = n + 60;
        if (maxOnes > m + n) maxOnes = m + n; // further safe cap

        int maxCarry = m; // safe upper bound for carry

        // dp arrays: dp[carry][used][ones] = sum of products of (nums^c * invFact[c]) for processed indices
        long[][][] dpCur = new long[maxCarry + 1][m + 1][maxOnes + 1];
        long[][][] dpNext = new long[maxCarry + 1][m + 1][maxOnes + 1];
        dpCur[0][0][0] = 1L;

        for (int i = 0; i < n; i++) {
            // zero dpNext
            for (int c = 0; c <= maxCarry; c++)
                for (int u = 0; u <= m; u++)
                    Arrays.fill(dpNext[c][u], 0L);

            for (int carry = 0; carry <= maxCarry; carry++) {
                for (int used = 0; used <= m; used++) {
                    for (int ones = 0; ones <= maxOnes; ones++) {
                        long curVal = dpCur[carry][used][ones];
                        if (curVal == 0) continue;

                        // choose c occurrences of index i (0..m-used)
                        int maxChoose = m - used;
                        for (int c = 0; c <= maxChoose; c++) {
                            int newUsed = used + c;
                            int s = c + carry;
                            int bit = s & 1;
                            int newCarry = s >> 1;
                            if (newCarry > maxCarry) continue; // should not happen but safe
                            int newOnes = ones + bit;
                            if (newOnes > maxOnes) continue;

                            // multiply by nums[i]^c * invFact[c]
                            long mult = (powNum[i][c] * invFact[c]) % MOD;
                            long add = (curVal * mult) % MOD;
                            dpNext[newCarry][newUsed][newOnes] += add;
                            if (dpNext[newCarry][newUsed][newOnes] >= MOD) dpNext[newCarry][newUsed][newOnes] -= MOD;
                        }
                    }
                }
            }

            // swap
            long[][][] tmp = dpCur;
            dpCur = dpNext;
            dpNext = tmp;
        }

        // After processing all indices, account for remaining carry bits (they add their own set bits)
        long ans = 0L;
        for (int carry = 0; carry <= maxCarry; carry++) {
            int carryOnes = Integer.bitCount(carry);
            for (int ones = 0; ones <= maxOnes; ones++) {
                int totalOnes = ones + carryOnes;
                if (totalOnes != k) continue;
                long val = dpCur[carry][m][ones]; // must have used == m
                if (val == 0) continue;
                // multiply by m! to convert product of invFact[c] denominators into multinomial count
                long contrib = (val * fact[m]) % MOD;
                ans += contrib;
                if (ans >= MOD) ans -= MOD;
            }
        }

        return (int) ans;
    }
}