class Solution {
    public int findFinalValue(int[] nums, int original) {
         HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        // Keep doubling as long as original is present
        while (set.contains(original)) {
            original *= 2;
        }
        
        return original;
    }
}