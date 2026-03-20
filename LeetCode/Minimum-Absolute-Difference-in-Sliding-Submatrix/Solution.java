1import java.util.*;
2
3class Solution {
4    public int[][] minAbsDiff(int[][] grid, int k) {
5        int m = grid.length;
6        int n = grid[0].length;
7
8        int[][] ans = new int[m - k + 1][n - k + 1];
9
10        for (int i = 0; i <= m - k; i++) {
11            for (int j = 0; j <= n - k; j++) {
12
13                List<Integer> list = new ArrayList<>();
14
15                // Collect elements
16                for (int x = i; x < i + k; x++) {
17                    for (int y = j; y < j + k; y++) {
18                        list.add(grid[x][y]);
19                    }
20                }
21
22                Collections.sort(list);
23
24                int minDiff = Integer.MAX_VALUE;
25
26                for (int p = 1; p < list.size(); p++) {
27                    // Skip duplicates
28                    if (list.get(p).equals(list.get(p - 1))) continue;
29
30                    minDiff = Math.min(minDiff,
31                        list.get(p) - list.get(p - 1));
32                }
33
34                // If all elements same OR only one distinct value
35                if (minDiff == Integer.MAX_VALUE) minDiff = 0;
36
37                ans[i][j] = minDiff;
38            }
39        }
40
41        return ans;
42    }
43}