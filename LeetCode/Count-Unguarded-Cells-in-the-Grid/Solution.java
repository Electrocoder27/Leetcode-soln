class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        // 0 = empty, 1 = guard, 2 = wall, 3 = guarded

        // Place guards
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }

        // Place walls
        for (int[] w : walls) {
            grid[w[0]][w[1]] = 2;
        }

        // Mark guarded cells
        for (int[] g : guards) {
            int r = g[0], c = g[1];

            // up
            for (int i = r - 1; i >= 0; i--) {
                if (grid[i][c] == 1 || grid[i][c] == 2) break;
                grid[i][c] = 3;
            }
            // down
            for (int i = r + 1; i < m; i++) {
                if (grid[i][c] == 1 || grid[i][c] == 2) break;
                grid[i][c] = 3;
            }
            // left
            for (int j = c - 1; j >= 0; j--) {
                if (grid[r][j] == 1 || grid[r][j] == 2) break;
                grid[r][j] = 3;
            }
            // right
            for (int j = c + 1; j < n; j++) {
                if (grid[r][j] == 1 || grid[r][j] == 2) break;
                grid[r][j] = 3;
            }
        }

        // Count unguarded empty cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
