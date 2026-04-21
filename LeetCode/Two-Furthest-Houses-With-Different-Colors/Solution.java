1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length;
4        int maxDist = 0;
5
6        // Strategy 1: Compare the first house with houses from the right
7        for (int i = n - 1; i >= 0; i--) {
8            if (colors[i] != colors[0]) {
9                maxDist = Math.max(maxDist, i);
10                break;
11            }
12        }
13
14        // Strategy 2: Compare the last house with houses from the left
15        for (int i = 0; i < n; i++) {
16            if (colors[i] != colors[n - 1]) {
17                maxDist = Math.max(maxDist, (n - 1) - i);
18                break;
19            }
20        }
21
22        return maxDist;
23    }
24}