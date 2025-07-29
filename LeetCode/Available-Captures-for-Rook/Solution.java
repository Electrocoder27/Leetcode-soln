class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1, rookCol = -1;

        // Find the rook position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
        }

        int count = 0;

        // 4 directions: up, down, left, right
        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        for (int[] dir : directions) {
            int r = rookRow + dir[0];
            int c = rookCol + dir[1];

            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == 'B') break;
                if (board[r][c] == 'p') {
                    count++;
                    break;
                }
                r += dir[0];
                c += dir[1];
            }
        }

        return count;
    }
}
