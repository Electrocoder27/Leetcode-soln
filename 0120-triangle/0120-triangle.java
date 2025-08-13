class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start from second-last row upwards
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                int down = triangle.get(i + 1).get(j);
                int downRight = triangle.get(i + 1).get(j + 1);
                int minPath = curr + Math.min(down, downRight);
                triangle.get(i).set(j, minPath);
            }
        }

        return triangle.get(0).get(0);
    }
}