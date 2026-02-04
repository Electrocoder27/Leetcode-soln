1class Solution {
2    public int minimumPairRemoval(int[] nums) {
3        List<Integer> list = new ArrayList<>();
4        for (int num : nums) list.add(num);
5
6        int operations = 0;
7
8        while (!isNonDecreasing(list)) {
9            int minSum = Integer.MAX_VALUE;
10            int index = 0;
11
12            // find leftmost adjacent pair with minimum sum
13            for (int i = 0; i < list.size() - 1; i++) {
14                int sum = list.get(i) + list.get(i + 1);
15                if (sum < minSum) {
16                    minSum = sum;
17                    index = i;
18                }
19            }
20
21            // replace the pair with their sum
22            list.set(index, minSum);
23            list.remove(index + 1);
24            operations++;
25        }
26
27        return operations;
28    }
29
30    private boolean isNonDecreasing(List<Integer> list) {
31        for (int i = 1; i < list.size(); i++) {
32            if (list.get(i) < list.get(i - 1)) {
33                return false;
34            }
35        }
36        return true;
37    }
38}