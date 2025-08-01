class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) != '0') return false;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int farthest = 0;

        while (!q.isEmpty()) {
            int i = q.poll();

            // Try jumping from i to j in the range [i + minJump, i + maxJump]
            for (int j = Math.max(i + minJump, farthest + 1); j <= Math.min(i + maxJump, n - 1); j++) {
                if (s.charAt(j) == '0') {
                    if (j == n - 1) return true; // Reached last index
                    q.add(j);
                }
            }

            // Mark how far we’ve already explored
            farthest = Math.min(i + maxJump, n - 1);
        }

        return false;
    }
}
