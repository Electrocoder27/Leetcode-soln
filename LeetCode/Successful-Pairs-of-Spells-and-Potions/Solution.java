import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            long required = (success + spells[i] - 1) / spells[i]; // ceil division
            int idx = binarySearch(potions, required);
            res[i] = m - idx; // remaining potions are successful
        }
        
        return res;
    }

    // Find the first index in potions where potion >= required
    private int binarySearch(int[] potions, long required) {
        int l = 0, r = potions.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (potions[mid] < required) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
