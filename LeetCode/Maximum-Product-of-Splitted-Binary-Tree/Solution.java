1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17
18    long maxProduct = 0;
19    long totalSum = 0;
20    static final int MOD = 1_000_000_007;
21
22    // 1️⃣ Compute total sum of tree
23    private long totalSum(TreeNode root) {
24        if (root == null) return 0;
25
26        return root.val + totalSum(root.left) + totalSum(root.right);
27    }
28
29    // 2️⃣ Compute subtree sums & max product
30    private long dfs(TreeNode root) {
31        if (root == null) return 0;
32
33        long left = dfs(root.left);
34        long right = dfs(root.right);
35
36        long subtreeSum = root.val + left + right;
37
38        long remaining = totalSum - subtreeSum;
39        maxProduct = Math.max(maxProduct, subtreeSum * remaining);
40
41        return subtreeSum;
42    }
43
44    public int maxProduct(TreeNode root) {
45        totalSum = totalSum(root);
46        dfs(root);
47        return (int)(maxProduct % MOD);
48    }
49}