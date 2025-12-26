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
17    private void rightview(TreeNode root,int level,ArrayList<Integer> res) {
18        if(root == null) {
19            return ;
20        }
21
22        if(res.size() == level){
23            res.add(root.val) ;
24        }
25
26        rightview(root.right,level+1,res) ;
27        rightview(root.left,level+1,res) ;
28    }
29    public List<Integer> rightSideView(TreeNode root) {
30        ArrayList <Integer> ans = new ArrayList<>() ;
31
32        rightview(root,0,ans) ;
33
34        return ans ;
35    }
36}