1class Solution {
2    public int[] plusOne(int[] digits) {
3        int n = digits.length;
4        
5        // Traverse from the last digit
6        for (int i = n - 1; i >= 0; i--) {
7            if (digits[i] < 9) {
8                digits[i]++;
9                return digits;  // Return early if no carry is needed
10            }
11            digits[i] = 0;  // Set current digit to 0 if it was 9
12        }
13        
14        // If all digits were 9, we need an extra digit
15        int[] res = new int[n + 1];
16        res[0] = 1;  // Set the first digit to 1
17        return res;
18    }
19}
20