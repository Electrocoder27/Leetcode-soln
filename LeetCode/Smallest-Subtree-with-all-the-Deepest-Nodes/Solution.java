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
17    class Pair{
18        TreeNode node;
19        int depth ;
20        Pair(TreeNode n,int d){
21            node = n ;
22            depth = d ;
23        }
24    }
25    private Pair dfs(TreeNode root){
26        if(root == null){
27            return new Pair(null,0) ;
28        }
29        Pair left = dfs(root.left) ;
30        Pair right = dfs(root.right) ;
31
32        if(left.depth>right.depth){
33            return new Pair(left.node,left.depth+1) ;
34        }
35        else if(left.depth<right.depth){
36            return new Pair(right.node,right.depth+1) ;
37        }
38        else{
39            return new Pair(root,left.depth+1) ;
40        }
41    }
42    public TreeNode subtreeWithAllDeepest(TreeNode root) {
43       return dfs(root).node ;
44    }
45}