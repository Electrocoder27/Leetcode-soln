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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<int[]>> colMap = new TreeMap<>() ;

        Queue<Object[]> q = new LinkedList<>() ;

        q.add(new Object[] {root,0,0}) ;// node,row,col..........

        while(!q.isEmpty()) {
            Object [] curr = q.poll() ;
            TreeNode node = (TreeNode) curr[0] ;
            int row = (int) curr[1] ;
            int col  = (int) curr[2] ;

            colMap.putIfAbsent(col,new ArrayList<>()) ;
            colMap.get(col).add(new int[] {row,node.val}) ;

            if(node.left != null) {
                q.add(new Object[]{node.left,row+1,col-1}) ;
            }
            if(node.right != null) {
                q.add(new Object[]{node.right,row+1,col+1}) ;
            }
        }

        List<List<Integer>> res = new ArrayList<>() ;

        for(int col: colMap.keySet()) {
            List<int[]> nodes = colMap.get(col) ;
            //sort by row first............
            Collections.sort(nodes,(a,b) -> {if(a[0] == b[0]) return a[1]-b[1] ; return a[0]-b[0];}) ;


            List<Integer> colvals = new ArrayList<>() ;
            for(int[] entry : nodes) {
                colvals.add(entry[1]) ;
            }


            res.add(colvals) ;
        }
        return res ;
    }
}