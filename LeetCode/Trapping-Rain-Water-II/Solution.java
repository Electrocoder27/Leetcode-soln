class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;

        // Min-heap to always process the lowest height boundary first
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        boolean[][] visited = new boolean[m][n];

        // Step 1: Add all border cells into heap (they form the initial boundary)
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        // Directions for neighbors (up, down, left, right)
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int water = 0;

        // Step 2: Process heap
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            // Expand to neighbors
            for (int[] d : dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];

                // Skip if out of bounds or already visited
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) continue;
                visited[r][c] = true;

                // If neighbor is lower, water can be trapped
                water += Math.max(0, cell.height - heightMap[r][c]);

                // Push neighbor with updated boundary height
                pq.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
            }
        }

        return water;
    }
}

// Helper class for heap
class Cell {
    int row, col, height;
    Cell(int r, int c, int h) {
        row = r;
        col = c;
        height = h;
    }
}