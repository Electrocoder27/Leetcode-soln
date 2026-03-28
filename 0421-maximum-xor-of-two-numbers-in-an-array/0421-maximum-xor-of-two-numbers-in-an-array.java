class TrieNode{
    TrieNode child[] = new TrieNode[2] ;
}
class Solution {
    TrieNode root = new TrieNode() ;
    private void insert(int num){
        TrieNode node = root ;

        for(int i =31;i>=0;i--){
            int bit = (num>>i) &1 ;
            if(node.child[bit] == null){
                node.child[bit] = new TrieNode() ;
            }
            node = node.child[bit] ;
        }
    }
    private int getmax(int num){
        TrieNode node = root ;
        int maxnum = 0;
        for(int i=31;i>=0;i--){
            int bit = (num >> i) & 1 ;
            if(node.child[1-bit] != null){
                maxnum = maxnum | (1<<i) ;
                node = node.child[1-bit];
            }
            else{
                node = node.child[bit] ;
            }
        }
        return maxnum ;
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode node = root ;
        int n = nums.length ;

        for(int i =0;i<n;i++){
            insert(nums[i]) ;
        }

        int max = 0;
        for(int i =0;i<n;i++){
            max = Math.max(max,getmax(nums[i])) ;
        }

        return max ;
    }
}