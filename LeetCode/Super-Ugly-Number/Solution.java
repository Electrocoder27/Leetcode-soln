class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        long[] ugly = new long[n];
        int[] idx = new int[k];
        long[] val = new long[k];

        ugly[0] = 1; // first super ugly number is 1

        for (int i = 0; i < k; i++) {
            val[i] = primes[i]; // initial multiples
        }

        for (int i = 1; i < n; i++) {
            long next = Long.MAX_VALUE;

            // Find the next smallest candidate
            for (int j = 0; j < k; j++) {
                next = Math.min(next, val[j]);
            }

            ugly[i] = next;

            // Increment all indices that produced 'next'
            for (int j = 0; j < k; j++) {
                if (val[j] == next) {
                    idx[j]++;
                    val[j] = ugly[idx[j]] * primes[j];
                }
            }
        }

        return (int) ugly[n - 1];
    }
}