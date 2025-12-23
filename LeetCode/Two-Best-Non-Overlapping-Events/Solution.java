1class Solution {
2    public int maxTwoEvents(int[][] events) {
3        int n = events.length ;
4        int ans = 0;
5        Arrays.sort(events,(a,b) -> a[0]-b[0]) ;
6
7        int maxform[] = new int[n] ;
8        maxform[n-1] = events[n-1][2] ;
9
10        for(int i = n-2;i>=0;i--) {
11            maxform[i] = Math.max(maxform[i+1],events[i][2]) ;
12        }
13
14        for(int i =0;i<n;i++) {
15            int val = events[i][2] ;
16            int endtime = events[i][1] ;
17
18            //binary search...........
19            int left = i+1 ;
20            int right = n-1 ;
21            int idx = -1 ;
22
23            while(left <= right) {
24                int mid = left + (right-left)/2 ;
25
26                if(events[mid][0] >= endtime+1){
27                    idx = mid ;
28                    right = mid -1 ;
29                }
30                else{
31                    left = mid+1 ;
32                }
33            }
34
35            if(idx != -1) {
36                val += maxform[idx] ;
37            }
38
39            ans = Math.max(ans,val) ;
40        }
41        return ans ;
42    }
43}