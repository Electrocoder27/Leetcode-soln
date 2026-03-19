1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5
6        int[][] sum = new int[n][m];
7        int[][] countX = new int[n][m];
8
9        int result = 0;
10
11        for (int i = 0; i < n; i++) {
12            for (int j = 0; j < m; j++) {
13
14                int val = 0;
15                int x = 0;
16
17                if (grid[i][j] == 'X') {
18                    val = 1;
19                    x = 1;
20                } else if (grid[i][j] == 'Y') {
21                    val = -1;
22                }
23
24                sum[i][j] = val;
25                countX[i][j] = x;
26
27                if (i > 0) {
28                    sum[i][j] += sum[i - 1][j];
29                    countX[i][j] += countX[i - 1][j];
30                }
31
32                if (j > 0) {
33                    sum[i][j] += sum[i][j - 1];
34                    countX[i][j] += countX[i][j - 1];
35                }
36
37                if (i > 0 && j > 0) {
38                    sum[i][j] -= sum[i - 1][j - 1];
39                    countX[i][j] -= countX[i - 1][j - 1];
40                }
41
42                // Check conditions for submatrix (0,0) → (i,j)
43                if (sum[i][j] == 0 && countX[i][j] > 0) {
44                    result++;
45                }
46            }
47        }
48
49        return result;
50    }
51}