1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        int m1 = Integer.MAX_VALUE;
4        int m2 = Integer.MIN_VALUE;
5        for (int x : nums) {
6            m1 = Math.min(m1, x);
7            m2 = Math.max(m2, x);
8        }
9        return (long) (m2 - m1) * k;
10
11    }
12}