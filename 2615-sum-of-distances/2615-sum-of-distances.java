class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        
        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Calculate sum of distances for each unique value group
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            if (size <= 1) continue;

            // Total sum of all indices in this group
            long totalSum = 0;
            for (int index : indices) {
                totalSum += index;
            }

            long prefixSum = 0;
            for (int m = 0; m < size; m++) {
                int i_m = indices.get(m);
                
                // Sum of indices to the right
                long suffixSum = totalSum - prefixSum - i_m;
                
                // Count of elements to the left and right
                long leftCount = m;
                long rightCount = size - 1 - m;

                // Apply the formula: (left_diffs) + (right_diffs)
                res[i_m] = (leftCount * i_m - prefixSum) + (suffixSum - rightCount * i_m);

                // Update prefixSum for the next element in the list
                prefixSum += i_m;
            }
        }

        return res;
    }
}