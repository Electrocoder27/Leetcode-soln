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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>() ;
        if(root == null) {
            return ans ;
        }
        Queue<TreeNode> q = new LinkedList<>() ;
        boolean lr = true ;

        q.add(root) ;
        while(!q.isEmpty()) {
            int size = q.size() ;
            ArrayList<Integer> row = new ArrayList<>() ;
            for(int i =0;i<size;i++) {
                TreeNode curr = q.poll() ;
                if(lr) {
                    row.add(curr.val) ;
                }
                else{
                    row.add(0,curr.val) ;
                }
                if(curr.left != null) {
                    q.add(curr.left) ;
                }
                if(curr.right != null) {
                    q.add(curr.right) ;
                }            
            }
            ans.add(row) ;
            lr = !lr ;
        }
        return ans ;
    }
}