1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5
6        boolean[] sorted = new boolean[n - 1];
7        int deletions = 0;
8
9        for (int col = 0; col < m; col++) {
10            boolean needDelete = false;
11
12            // Step 1: check if this column breaks order
13            for (int row = 0; row < n - 1; row++) {
14                if (!sorted[row] &&
15                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
16                    needDelete = true;
17                    break;
18                }
19            }
20
21            // Step 2: delete or keep
22            if (needDelete) {
23                deletions++;
24            } else {
25                // update sorted pairs
26                for (int row = 0; row < n - 1; row++) {
27                    if (!sorted[row] &&
28                        strs[row].charAt(col) < strs[row + 1].charAt(col)) {
29                        sorted[row] = true;
30                    }
31                }
32            }
33        }
34
35        return deletions;
36    }
37}