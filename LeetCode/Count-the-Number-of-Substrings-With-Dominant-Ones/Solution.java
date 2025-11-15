class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        // collect zero positions
        java.util.ArrayList<Integer> pos = new java.util.ArrayList<>();
        for (int i = 0; i < n; ++i) if (s.charAt(i) == '0') pos.add(i);

        long ans = 0;

        // k = 0 case: substrings with zero zeros (all ones)
        long run = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') run++;
            else {
                ans += run * (run + 1) / 2;
                run = 0;
            }
        }
        ans += run * (run + 1) / 2;

        int zCount = pos.size();
        if (zCount == 0) return (int)ans; // all ones already counted

        int ZMAX = (int) Math.sqrt(n) + 1;

        // iterate k = number of zeros inside substring
        for (int k = 1; k <= ZMAX; ++k) {
            if (k > zCount) break;
            long needLen = 1L * k * k + k; // minimal total length L >= k^2 + k

            // slide window of k zeros on pos[]
            for (int i = 0; i + k - 1 < zCount; ++i) {
                int j = i + k - 1;
                int leftZero = pos.get(i);
                int rightZero = pos.get(j);

                int prevZeroPos = (i == 0) ? -1 : pos.get(i - 1);
                int nextZeroPos = (j == zCount - 1) ? n : pos.get(j + 1);

                // how many ones we can extend on each side (counts of positions)
                int availLeft = leftZero - prevZeroPos - 1;
                int availRight = nextZeroPos - rightZero - 1;

                long baseLen = rightZero - leftZero + 1; // span covering the k zeros and internal ones
                long extraNeeded = Math.max(0L, needLen - baseLen);

                long totalPairs = 1L * (availLeft + 1) * (availRight + 1);

                if (extraNeeded == 0) {
                    // all extensions valid
                    ans += totalPairs;
                    continue;
                }

                // if it's impossible to reach required length even by using all available extents
                if (extraNeeded > availLeft + availRight) {
                    // no valid substrings for this (i,j)
                    continue;
                }
                long A = availLeft;
                long B = availRight;
                long E = extraNeeded;
                long Bad = 0L;
                long t0 = Math.max(0L, E - (B + 1)); // for a < t0, E - a > B+1 => cnt = B+1
                long upto = Math.min(A, E - 1); // a runs 0..upto contributes positive counts

                if (t0 > 0) {
                    long take = Math.min(t0 - 1, upto);
                    if (take >= 0) {
                        Bad += (take + 1) * (B + 1);
                    }
                }

                if (t0 <= upto) {
                    long first = Math.max(t0, 0L);
                    long last = upto;
                    long r = last - first + 1;
                    // sum_{a=first..last} (E - a) = r*E - sum_{a=first..last} a
                    long sumA = (first + last) * r / 2;
                    Bad += r * E - sumA;
                }

                long valid = totalPairs - Bad;
                ans += valid;
            }
        }

        return (int)ans;
    }
}