class Solution {
    private static int lowerBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
    private static int upperBound(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;

        // frequency of exact values
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) freq.put(v, freq.getOrDefault(v, 0) + 1);

        int ans = 1;

        // 1) Consider targets x that are equal to one of the array values
        // For each distinct value v, count how many nums are within [v-k, v+k]
        // and compute min(count_within, count_equal_v + numOperations)
        for (Integer vObj : freq.keySet()) {
            int v = vObj;
            int left = lowerBound(nums, v - k);
            int right = upperBound(nums, v + k); // first index > v+k
            int countWithin = right - left;
            int countEqual = freq.get(v);
            int candidate = Math.min(countWithin, countEqual + numOperations);
            if (candidate > ans) ans = candidate;
        }

        // 2) Consider targets x that may not be present.
        // The maximum number of elements that can be covered by any interval of length 2k:
        int l = 0, maxWindow = 0;
        for (int r = 0; r < n; r++) {
            while (l <= r && (long)nums[r] - nums[l] > 2L * k) l++;
            maxWindow = Math.max(maxWindow, r - l + 1);
        }
        // If x is not present, count_equal_x = 0 => freq = min(count_within_x, numOperations)
        ans = Math.max(ans, Math.min(maxWindow, numOperations));

        return ans;
    }
}