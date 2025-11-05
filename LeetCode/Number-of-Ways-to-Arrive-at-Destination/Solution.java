import java.util.*;

class Solution {
    static class Pair {
        int node;
        long time;
        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Step 1: Build adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new Pair(v, t));
            graph.get(v).add(new Pair(u, t));
        }

        // Step 2: Distance and ways arrays
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[n];

        // Step 3: Dijkstra’s initialization
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        // Step 4: Dijkstra’s Algorithm to count ways
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            long timeSoFar = cur.time;

            if (timeSoFar > dist[u]) continue;

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.node;
                long newTime = timeSoFar + neighbor.time;

                // Case 1: Better (shorter) path found
                if (newTime < dist[v]) {
                    dist[v] = newTime;
                    ways[v] = ways[u];   // inherit the number of ways
                    pq.add(new Pair(v, newTime));
                }
                // Case 2: Another shortest path found
                else if (newTime == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1] % MOD;
    }
}
