1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        char res = letters[0] ;
4        int l = 0;
5        int r = letters.length -1 ;
6        while(l<=r){
7            int mid = l + (r-l)/2 ;
8            if(letters[mid] > target){
9                res = letters[mid] ;
10                r = mid-1 ;
11            }
12            else{
13                l = mid +1 ;
14            }
15        }
16        return res ;
17    }
18}