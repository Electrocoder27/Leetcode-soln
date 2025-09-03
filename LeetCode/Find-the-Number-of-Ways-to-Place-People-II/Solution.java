class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int xa = points[i][0];
            int ya = points[i][1];

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xb = points[j][0];
                int yb = points[j][1];

                // Alice must be upper-left, Bob must be lower-right
                if (xa <= xb && ya >= yb) {
                    boolean valid = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int xk = points[k][0];
                        int yk = points[k][1];

                        if (xk >= xa && xk <= xb && yk <= ya && yk >= yb) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) result++;
                }
            }
        }
        return result;
    }
}