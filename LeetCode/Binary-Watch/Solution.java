1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        ArrayList <String> result =  new ArrayList<>() ;
4
5        for(int h=0;h<12;h++){
6            for(int min =0;min<60;min++){
7                int totalBits = Integer.bitCount(h) + Integer.bitCount(min);
8                
9                if (totalBits == turnedOn) {
10                    result.add(h + ":" + String.format("%02d", min));
11                }
12            }
13        }
14        return result;
15    }
16}