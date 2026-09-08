class Solution {
    public int distinctSubseqII(String s) {
        int M = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] lastSeen = new int[26];
        
        java.util.Arrays.fill(lastSeen, 0);
        dp[0] = 1; // Base case: empty subsequence
        
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            int prev = lastSeen[idx];
            
            // Total subsequences formed so far by doubling the previous count
            long total = (2L * dp[i - 1]) % M;
            
            // If the character has appeared before, subtract the subsequences
            // that were already counted when it last appeared
            if (prev > 0) {
                total = (total - dp[prev - 1] + M) % M;
            }
            
            dp[i] = (int) total;
            lastSeen[idx] = i; // 1-based indexing
        }
        
        // Subtract 1 to exclude the empty subsequence
        return (dp[n] - 1 + M) % M;
    }
}