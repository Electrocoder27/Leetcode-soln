class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean removed = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                if (removed) return false; // already removed one
                removed = true;

                // Try removing nums[i-1], only if possible
                if (i == 1 || nums[i] > nums[i - 2]) {
                    // remove nums[i-1], do nothing
                } else {
                    // remove nums[i], so force nums[i] to nums[i-1]
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }
}