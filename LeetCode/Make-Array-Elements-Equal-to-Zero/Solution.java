class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int valid = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try both directions: left (-1) and right (+1)
                if (simulate(nums.clone(), i, 1)) valid++;
                if (simulate(nums.clone(), i, -1)) valid++;
            }
        }

        return valid;
    }

    private boolean simulate(int[] arr, int curr, int dir) {
        int n = arr.length;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir; // move in same direction
            } else {
                arr[curr]--; // decrement and reverse direction
                dir = -dir;
                curr += dir;
            }
        }

        // check if all are zero
        for (int x : arr) {
            if (x != 0) return false;
        }
        return true;
    }
    
}