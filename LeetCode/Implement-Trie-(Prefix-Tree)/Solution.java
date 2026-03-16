1class TrieNode{
2    TrieNode [] child = new TrieNode[26] ;
3    boolean isEnd ;
4    TrieNode() {
5        for(int i = 0;i<26;i++){
6            child[i] = null ;
7        }
8        isEnd = false ;
9    }
10}
11class Trie {
12    TrieNode root ;
13    public Trie() {
14        root = new TrieNode() ;
15    }
16    public void insert(String word) {
17        TrieNode node = root ;
18
19        for(int i =0;i<word.length();i++){
20            char ch = word.charAt(i) ;
21            int idx = ch -'a' ;
22
23            if(node.child[idx] == null){
24                node.child[idx] = new TrieNode() ;
25            }
26            node = node.child[idx] ;
27        }
28        node.isEnd = true ;
29    } 
30    public boolean search(String word) {
31        TrieNode node = root ;
32        for(int i =0;i<word.length();i++){
33            char ch = word.charAt(i) ;
34            int idx = ch - 'a' ;
35            if(node.child[idx] == null){
36                return false ;
37            }
38            node = node.child[idx] ;
39        }
40        return node.isEnd ;
41    }
42    
43    public boolean startsWith(String prefix) {
44        TrieNode node = root ;
45        
46        for(int i=0;i<prefix.length() ;i++){
47            char ch = prefix.charAt(i) ;
48            int idx = ch -'a' ;
49
50            if(node.child[idx] == null){
51                return false ;
52            }
53
54            node = node.child[idx] ;
55        }
56        return true ;
57    }
58}
59
60/**
61 * Your Trie object will be instantiated and called as such:
62 * Trie obj = new Trie();
63 * obj.insert(word);
64 * boolean param_2 = obj.search(word);
65 * boolean param_3 = obj.startsWith(prefix);
66 */