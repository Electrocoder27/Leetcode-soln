1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4
5        long prefix = 0L;
6        long[] minPrefix = new long[k];
7
8        // initialize to +infinity
9        Arrays.fill(minPrefix, Long.MAX_VALUE / 4);
10        // prefix at index 0 (no elements) is 0 and index 0 % k = 0
11        minPrefix[0] = 0L;
12
13        long ans = Long.MIN_VALUE;
14        // i will be the current prefix index after adding nums[i-1]
15        for (int i = 1; i <= n; ++i) {
16            prefix += nums[i - 1];
17            int idxMod = i % k; // key: index modulo k
18
19            // If we have seen some prefix with same index mod, consider it
20            if (minPrefix[idxMod] < Long.MAX_VALUE / 4) {
21                ans = Math.max(ans, prefix - minPrefix[idxMod]);
22            }
23            // update minimum prefix sum for this index-mod class
24            minPrefix[idxMod] = Math.min(minPrefix[idxMod], prefix);
25        }
26
27        return ans;
28    }
29}