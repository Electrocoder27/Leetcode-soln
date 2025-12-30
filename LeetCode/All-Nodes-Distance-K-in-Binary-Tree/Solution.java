1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    private void parents(TreeNode root,HashMap<TreeNode,TreeNode> parentstrack,TreeNode target) {
12        Queue<TreeNode> q = new LinkedList<>() ;
13        q.offer(root) ;
14        while(!q.isEmpty()) {
15            TreeNode curr = q.poll() ;
16            if(curr.left != null) {
17                parentstrack.put(curr.left,curr) ;
18                q.offer(curr.left) ;
19            }
20            if(curr.right != null) {
21                parentstrack.put(curr.right,curr) ;
22                q.offer(curr.right) ;
23            }
24        }
25    }
26    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
27        HashMap <TreeNode,TreeNode> parentstrack = new HashMap<>() ;
28        parents(root,parentstrack,root) ;
29        HashMap<TreeNode,Boolean> vis = new HashMap<>() ;
30
31        Queue<TreeNode> q = new LinkedList<>() ;
32        q.offer(target) ;
33        vis.put(target,true) ;
34
35        int currlevel = 0 ;
36
37        while(!q.isEmpty()) {
38            int size = q.size() ;
39            if(currlevel == k) {
40                break ;
41            }
42            currlevel++ ;
43
44            for(int i =0;i<size;i++) {
45                TreeNode curr = q.poll() ;
46                if(curr.left != null && vis.get(curr.left) == null) {
47                    q.offer(curr.left) ;
48                    vis.put(curr.left,true) ;
49                }
50                if(curr.right != null && vis.get(curr.right) == null) {
51                    q.offer(curr.right) ;
52                    vis.put(curr.right,true) ;
53                }
54                if(parentstrack.get(curr) != null && vis.get(parentstrack.get(curr)) == null){
55                    q.offer(parentstrack.get(curr)) ;
56                    vis.put(parentstrack.get(curr),true) ;
57                }
58            }
59        }
60
61        ArrayList<Integer> res = new ArrayList<>() ;
62
63        while(!q.isEmpty()) {
64            TreeNode curr = q.poll() ;
65            res.add(curr.val) ;
66        }
67
68        return res ;
69    }
70}