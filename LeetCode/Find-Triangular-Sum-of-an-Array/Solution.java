class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        // simulate reducing until 1 element left
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--; // one less element each round
        }
        return nums[0];
    }
}