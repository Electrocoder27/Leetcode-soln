1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder sb = new StringBuilder("") ;
4        for(String word:words){
5            int sum = 0;
6            int n = word.length() ;
7            for(int i =0;i<n;i++) {
8                char ch = word.charAt(i) ;
9                sum += weights[ch -'a'] ;
10            } 
11            int idx = sum%26 ;
12            char toappend = (char) ('z' - idx) ;
13            sb.append(toappend) ;           
14        } 
15        return sb.toString() ;
16    }
17}