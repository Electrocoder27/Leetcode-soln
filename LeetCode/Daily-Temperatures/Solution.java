class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> s = new Stack<>() ;
        int n = temperatures.length ;
        int [] ans = new int[n] ;

        for(int i =0;i<n;i++) {
            while(!s.isEmpty() && temperatures[i] >temperatures[s.peek()]) {
                int previdx = s.pop() ;
                ans[previdx]  = i-previdx ;
            }
            s.push(i) ;
        }

        return ans ;
    }
}