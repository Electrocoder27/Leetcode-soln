import java.util.Arrays;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxFruits = 0;
        int n = fruits.length;

        int currentFruits = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentFruits += fruits[right][1];

            // Calculate the cost to collect fruits in the window [left, right]
            // We have two possible paths: left-turn-right or right-turn-left.
            // We take the one that costs fewer steps.
            while (left <= right) {
                // Distance from startPos to the left end of the window
                long distLeft = Math.abs((long)startPos - fruits[left][0]);
                // Distance from startPos to the right end of the window
                long distRight = Math.abs((long)startPos - fruits[right][0]);
                // Total length of the fruit window
                long windowLength = (long)fruits[right][0] - fruits[left][0];

                long steps;
                if (startPos >= fruits[right][0]) { // startPos is to the right of the window
                    steps = distLeft;
                } else if (startPos <= fruits[left][0]) { // startPos is to the left of the window
                    steps = distRight;
                } else { // startPos is inside the window
                    steps = Math.min(distLeft, distRight) + windowLength;
                }

                if (steps <= k) {
                    maxFruits = Math.max(maxFruits, currentFruits);
                    break;
                }

                // If the current window is too large, shrink it from the left.
                currentFruits -= fruits[left][1];
                left++;
            }
        }
        return maxFruits;
    }
}