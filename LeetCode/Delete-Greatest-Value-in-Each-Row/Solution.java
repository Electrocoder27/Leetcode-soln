class Solution {
    public int deleteGreatestValue(int[][] grid) {
        // Step 1: Sort each row in ascending order
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        
        int m = grid.length;    // number of rows
        int n = grid[0].length; // number of columns
        int ans = 0;
        
        // Step 2: For each column (from last to first after sorting)
        // the maximum value among all rows at that column position is added
        for (int col = n - 1; col >= 0; col--) {
            int maxVal = 0;
            for (int row = 0; row < m; row++) {
                maxVal = Math.max(maxVal, grid[row][col]);
            }
            ans += maxVal;
        }
        
        return ans;
    }
}