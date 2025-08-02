class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] > threshold) {
                l = r + 1;
                continue;
            }

            if (r == l) {
                if (nums[r] % 2 != 0) {
                    l++;
                }
            } else {
                if (nums[r] % 2 == nums[r - 1] % 2) {
                    if (nums[r] % 2 == 0) l = r;
                    else l = r + 1;
                }
            }

            if (r >= l) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }
}
