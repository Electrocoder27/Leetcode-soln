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
    private void inorder(TreeNode root,ArrayList<Integer> l){
        if(root == null){
            return ;
        }
        inorder(root.left,l) ;
        l.add(root.val) ;
        inorder(root.right,l) ;
    }
    private TreeNode constructbst(int l,int r,ArrayList<Integer> list){
        if(l>r){
            return null ;
        }
        int mid = l+(r-l)/2 ;

        TreeNode root = new TreeNode(list.get(mid)) ;
        root.left = constructbst(l,mid-1,list) ;
        root.right = constructbst(mid+1,r,list) ;

        return root ;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>() ;
        inorder(root,list) ;
        int l =0;
        int r = list.size()-1 ;
        return constructbst(l,r,list) ;
    }
}