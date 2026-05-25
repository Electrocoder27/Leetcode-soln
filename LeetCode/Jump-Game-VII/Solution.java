1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length();
4        if (s.charAt(n - 1) != '0') return false;
5
6        Queue<Integer> q = new LinkedList<>();
7        q.add(0);
8
9        int farthest = 0;
10
11        while (!q.isEmpty()) {
12            int i = q.poll();
13
14            // Try jumping from i to j in the range [i + minJump, i + maxJump]
15            for (int j = Math.max(i + minJump, farthest + 1); j <= Math.min(i + maxJump, n - 1); j++) {
16                if (s.charAt(j) == '0') {
17                    if (j == n - 1) return true; // Reached last index
18                    q.add(j);
19                }
20            }
21
22            // Mark how far we’ve already explored
23            farthest = Math.min(i + maxJump, n - 1);
24        }
25
26        return false;
27    }
28}
29