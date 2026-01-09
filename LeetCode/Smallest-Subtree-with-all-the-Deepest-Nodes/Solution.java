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
17    int maxd = 0 ;
18    HashMap<Integer,Integer> map ;
19    private TreeNode LCA(TreeNode root){
20        if(root == null || map.get(root.val) == maxd){
21            return root ;
22        }
23
24        TreeNode l = LCA(root.left) ;
25        TreeNode r =  LCA(root.right) ;
26
27        if(l != null && r != null){
28            return root ;
29        }
30
31        if(l!= null){
32            return l ;
33        }
34
35        return r ;
36    }
37    private void depth(TreeNode root,int d){
38        if(root == null) {
39            return ;
40        }
41        maxd = Math.max(maxd,d) ;
42        map.put(root.val,d) ;
43        depth(root.left,d+1) ;
44        depth(root.right,d+1) ;
45    }
46    public TreeNode subtreeWithAllDeepest(TreeNode root) {
47        map = new HashMap<>() ;
48        depth(root,0) ;
49        
50        return LCA(root) ;
51    }
52}