1class TrieNode{
2    TrieNode[] child = new TrieNode[26] ;
3    boolean isEnd ;
4    TrieNode(){ // constructor............
5        for(int i =0;i<26;i++){
6            child[i] = null ;
7        }
8        isEnd = false ;
9
10    }
11}
12class Solution {
13    TrieNode root = new TrieNode() ;
14    public void insert(String word){
15        TrieNode node = root ;
16        for(int i =0;i<word.length();i++){
17            char ch = word.charAt(i) ;
18            int idx = ch - 'a' ;
19            if(node.child[idx] == null){
20                node.child[idx] = new TrieNode() ;
21            }
22            node = node.child[idx] ;
23        }
24        node.isEnd = true ; 
25    }
26    public  boolean searchprefix(String word){
27        TrieNode node = root ;
28        for(int i = 0;i<word.length();i++){
29            char ch = word.charAt(i) ;
30            int idx = ch - 'a' ;
31            node = node.child[idx] ;
32            if(node == null ||node.isEnd == false ){
33                return false ;
34            }
35
36        }
37        return true ;
38    }
39    public String longestWord(String[] words) {
40        int n= words.length ;
41        for(int i =0;i<n;i++){
42            insert(words[i]) ;
43        }
44
45        String res = "" ;
46        for(int i =0;i<n;i++){
47            if(searchprefix(words[i])){
48                if(res.length() <words[i].length()){
49                    res = words[i];
50                }
51                else if(res.length() == words[i].length() &&  words[i].compareTo(res) < 0){
52                    res = words[i] ;
53                }
54            }
55        }
56
57        return res ;
58    }
59}