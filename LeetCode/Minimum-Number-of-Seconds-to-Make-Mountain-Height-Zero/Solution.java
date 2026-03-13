1class Solution {
2    
3    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
4        long left = 0;
5        long right = (long)1e18;
6        long ans = right;
7        
8        while (left <= right) {
9            long mid = left + (right - left) / 2;
10            
11            if (canFinish(mid, mountainHeight, workerTimes)) {
12                ans = mid;
13                right = mid - 1;
14            } else {
15                left = mid + 1;
16            }
17        }
18        
19        return ans;
20    }
21    
22    private boolean canFinish(long time, int height, int[] workerTimes) {
23        long total = 0;
24        
25        for (int t : workerTimes) {
26            
27            long val = (2 * time) / t;
28            
29            long x = (long)((Math.sqrt(1 + 4 * val) - 1) / 2);
30            
31            total += x;
32            
33            if (total >= height) return true;
34        }
35        
36        return false;
37    }
38}