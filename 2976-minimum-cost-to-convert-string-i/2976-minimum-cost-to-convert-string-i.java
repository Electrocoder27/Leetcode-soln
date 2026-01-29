class Solution {
    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        // Number of characters ('a' to 'z')
        int N = 26;
        long INF = (long) 1e18;

        // Distance matrix
        long[][] dist = new long[N][N];

        // Initialize distances
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        // Build graph (take minimum cost if multiple edges exist)
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall Algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Calculate total minimum cost
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);

            if (s == t) continue;

            long c = dist[s - 'a'][t - 'a'];
            if (c == INF) return -1;

            totalCost += c;
        }

        return totalCost;
    }
}
