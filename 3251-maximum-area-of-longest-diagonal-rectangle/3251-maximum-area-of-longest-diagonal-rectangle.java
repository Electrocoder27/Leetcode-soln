class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long bestDiag2 = -1; // squared diagonal
        int bestArea = 0;

        for (int[] d : dimensions) {
            long l = d[0], b = d[1];
            long diag2 = l * l + b * b;      // squared diagonal
            int area = (int) (l * b);

            if (diag2 > bestDiag2) {
                bestDiag2 = diag2;
                bestArea = area;
            } else if (diag2 == bestDiag2 && area > bestArea) {
                bestArea = area;             // tie → keep max area
            }
        }
        return bestArea;
    }
}