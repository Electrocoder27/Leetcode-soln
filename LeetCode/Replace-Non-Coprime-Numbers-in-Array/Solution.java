class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        
        for (int num : nums) {
            // push current number
            stack.add(num);
            
            // merge while top two are non-coprime
            while (stack.size() > 1) {
                int n = stack.size();
                int a = stack.get(n - 1);
                int b = stack.get(n - 2);
                
                int g = gcd(a, b);
                if (g == 1) break; // coprime, stop
                
                // remove last two
                stack.remove(n - 1);
                stack.remove(n - 2);
                
                long lcm = (long) a / g * b; // avoid overflow
                // push the lcm back
                stack.add((int) lcm);
            }
        }
        
        return stack;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}