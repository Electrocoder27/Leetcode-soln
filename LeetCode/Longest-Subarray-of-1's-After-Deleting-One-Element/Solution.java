class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, z = 0, ans = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) z++; 

            while (z > 1) { 
                if (nums[l] == 0) z--;
                l++;
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}