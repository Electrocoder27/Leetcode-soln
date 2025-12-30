/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void parents(TreeNode root,HashMap<TreeNode,TreeNode> parentstrack,TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>() ;
        q.offer(root) ;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll() ;
            if(curr.left != null) {
                parentstrack.put(curr.left,curr) ;
                q.offer(curr.left) ;
            }
            if(curr.right != null) {
                parentstrack.put(curr.right,curr) ;
                q.offer(curr.right) ;
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap <TreeNode,TreeNode> parentstrack = new HashMap<>() ;
        parents(root,parentstrack,root) ;
        HashMap<TreeNode,Boolean> vis = new HashMap<>() ;

        Queue<TreeNode> q = new LinkedList<>() ;
        q.offer(target) ;
        vis.put(target,true) ;

        int currlevel = 0 ;

        while(!q.isEmpty()) {
            int size = q.size() ;
            if(currlevel == k) {
                break ;
            }
            currlevel++ ;

            for(int i =0;i<size;i++) {
                TreeNode curr = q.poll() ;
                if(curr.left != null && vis.get(curr.left) == null) {
                    q.offer(curr.left) ;
                    vis.put(curr.left,true) ;
                }
                if(curr.right != null && vis.get(curr.right) == null) {
                    q.offer(curr.right) ;
                    vis.put(curr.right,true) ;
                }
                if(parentstrack.get(curr) != null && vis.get(parentstrack.get(curr)) == null){
                    q.offer(parentstrack.get(curr)) ;
                    vis.put(parentstrack.get(curr),true) ;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>() ;

        while(!q.isEmpty()) {
            TreeNode curr = q.poll() ;
            res.add(curr.val) ;
        }

        return res ;
    }
}