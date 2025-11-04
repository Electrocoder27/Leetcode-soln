class Solution {
    // Helper function to calculate x-sum of window [l, r]
    private int getXSum(int[] nums, int l, int r, int x) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies in the window
        for (int i = l; i <= r; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // Create a list of pairs {value,frequency}
        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            list.add(new int[]{e.getKey(), e.getValue()});
        }

        // Sort by frequency (desc), if tie -> value (desc)
        Collections.sort(list, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1];
            return b[0] - a[0];
        });

        // Sum the top x elements (value * frequency)
        int sum = 0;
        int count = 0;
        for (int[] p : list) {
            if (count == x) break;
            sum += p[0] * p[1];
            count++;
        }
        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int l = 0, r = 0, idx = 0;

        while (r < n) {
            if (r - l + 1 == k) {
                ans[idx++] = getXSum(nums, l, r, x);
                l++; // slide the window
            }
            r++;
        }
        return ans;
    }
}
