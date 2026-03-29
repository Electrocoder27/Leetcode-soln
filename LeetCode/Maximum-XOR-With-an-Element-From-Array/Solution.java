1class TrieNode{
2    TrieNode child[] = new TrieNode[2] ;
3}
4class Solution {
5    TrieNode root = new TrieNode() ;
6    private void insert(int num){
7        TrieNode node = root ;
8
9        for(int i =31;i>=0;i--){
10            int bit = (num>>i) &1 ;
11            if(node.child[bit] == null){
12                node.child[bit] = new TrieNode() ;
13            }
14            node = node.child[bit] ;
15        }
16    }
17    private int getmax(int num){
18        TrieNode node = root ;
19        int maxnum = 0;
20        for(int i=31;i>=0;i--){
21            int bit = (num>>i)&1 ;
22            if(node.child[1-bit] != null){
23                maxnum = maxnum | (1<<i);
24                node = node.child[1-bit] ;
25            }
26            else{
27                node = node.child[bit] ;
28            }
29        }
30        return maxnum ;
31    }
32    public int[] maximizeXor(int[] nums, int[][] queries) {
33        int n = nums.length ;
34        Arrays.sort(nums) ;
35        int m = queries.length ;
36        int [][] q = new int[m][3] ;
37        int res[] = new int[m] ;
38        //offline queries.............
39        for(int i=0;i<m;i++){
40            q[i][0] = queries[i][0] ;
41            q[i][1] = queries[i][1] ;
42            q[i][2] = i ;
43        }
44        Arrays.sort(q,(a,b)->a[1]-b[1]) ;
45        int ind = 0;
46        for(int i =0;i<m;i++){
47            int ai = q[i][0] ;
48            int mi = q[i][1] ;
49            int idx = q[i][2] ;
50
51            while(ind<n && nums[ind]<=mi){
52                insert(nums[ind]) ;
53                ind++ ;
54            }
55            if(ind==0){
56                res[idx] =-1 ;
57            }
58            else{
59                res[idx] = getmax(ai) ;
60            }
61        }
62        return res ;
63    }
64}