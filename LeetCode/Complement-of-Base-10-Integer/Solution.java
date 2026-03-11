1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) return 1;
4
5        int mask = 0;
6        int temp = n;
7
8        while (temp > 0) {
9            mask = (mask << 1) | 1;  
10            temp >>= 1;
11        }
12
13        return n ^ mask; 
14    }
15}