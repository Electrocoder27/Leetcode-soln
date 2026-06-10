import java.util.PriorityQueue;

class Solution {
    // Sparse Tables for O(1) Range Queries
    private int[][] stMax;
    private int[][] stMin;
    private int[] lg;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Precompute logarithms for Sparse Table
        lg = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            lg[i] = lg[i / 2] + 1;
        }

        int maxLog = lg[n] + 1;
        stMax = new int[n][maxLog];
        stMin = new int[n][maxLog];

        // 2. Initialize Sparse Tables
        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }

        // 3. Priority Queue stores array configuration: [value, l, r]
        // Ordered as a Max-Heap based on the subarray value
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        // Push the maximal window (l, n-1) for every starting position l
        for (int l = 0; l < n; l++) {
            long val = queryValue(l, n - 1);
            pq.offer(new long[]{val, l, n - 1});
        }

        long totalValue = 0;

        // 4. Extract the top k maximum unique values
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            
            long[] curr = pq.poll();
            long val = curr[0];
            int l = (int) curr[1];
            int r = (int) curr[2];

            totalValue += val;

            // If the window can shrink further from the right, push the next best candidate
            if (r > l) {
                long nextVal = queryValue(l, r - 1);
                pq.offer(new long[]{nextVal, l, r - 1});
            }
        }

        return totalValue;
    }

    // Helper method to query subarray value in O(1) time
    private long queryValue(int l, int r) {
        int j = lg[r - l + 1];
        int maxVal = Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
        int minVal = Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
        return (long) maxVal - minVal;
    }
}