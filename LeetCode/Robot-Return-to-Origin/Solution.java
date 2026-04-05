1class Solution {
2    public boolean judgeCircle(String moves) {
3        int disph = 0 ;
4        int dispv = 0;
5        for(char ch : moves.toCharArray()){
6            if(ch == 'R'){
7                disph++ ;
8            }
9            else if(ch == 'L'){
10                disph-- ;
11            }
12            else if(ch == 'D'){
13                dispv++ ;
14            }
15            else{
16                dispv-- ;
17            }
18        }
19        if(disph != 0 || dispv != 0){
20            return false ;
21        }
22        return true ;
23    }
24}