/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void rightview(TreeNode root,int level,ArrayList<Integer> res) {
        if(root == null) {
            return ;
        }

        if(res.size() == level){
            res.add(root.val) ;
        }

        rightview(root.right,level+1,res) ;
        rightview(root.left,level+1,res) ;
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList <Integer> ans = new ArrayList<>() ;

        rightview(root,0,ans) ;

        return ans ;
    }
}