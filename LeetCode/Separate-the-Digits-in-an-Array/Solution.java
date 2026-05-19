1class Solution {
2
3    private void digitmaking(int num, ArrayList<Integer> list) {
4
5        ArrayList<Integer> temp = new ArrayList<>();
6
7        while(num > 0){
8            int rem = num % 10;
9            temp.add(rem);
10            num = num / 10;
11        }
12
13        // reverse adding
14        for(int i = temp.size() - 1; i >= 0; i--){
15            list.add(temp.get(i));
16        }
17    }
18
19    public int[] separateDigits(int[] nums) {
20
21        ArrayList<Integer> list = new ArrayList<>();
22
23        for(int i = 0; i < nums.length; i++) {
24            digitmaking(nums[i], list);
25        }
26
27        int[] res = new int[list.size()];
28
29        for(int i = 0; i < list.size(); i++){
30            res[i] = list.get(i);
31        }
32
33        return res;
34    }
35}