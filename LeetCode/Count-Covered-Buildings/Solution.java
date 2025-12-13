1class Solution {
2    public int countCoveredBuildings(int n, int[][] buildings) {
3        HashMap<Integer,ArrayList<Integer>> rows = new HashMap<>() ;
4        HashMap<Integer,ArrayList<Integer>> cols = new HashMap<>() ;
5
6        for(int [] b: buildings) {
7            int x = b[0] ;
8            int y = b[1] ;
9
10            rows.computeIfAbsent(x,k -> new ArrayList<>()).add(y) ;
11            cols.computeIfAbsent(y,k -> new ArrayList<>()).add(x) ;
12        }
13
14        // for min and max values...................
15
16        HashMap<Integer,int []> rowminmax = new HashMap<>() ;
17        for(int x: rows.keySet()) {
18            ArrayList<Integer> ys= rows.get(x) ;
19            int min = Integer.MAX_VALUE ;
20            int max = Integer.MIN_VALUE ;
21            for(int y: ys) {
22                min = Math.min(y,min) ;
23                max = Math.max(y,max) ;
24            }
25            rowminmax.put(x,new int []{min,max}) ;
26        }
27        HashMap<Integer,int []> colminmax = new HashMap<>() ;
28        for(int y: cols.keySet()) {
29            ArrayList<Integer> rs= cols.get(y) ;
30            int min = Integer.MAX_VALUE ;
31            int max = Integer.MIN_VALUE ;
32            for(int r: rs) {
33                min = Math.min(r,min) ;
34                max = Math.max(r,max) ;
35            }
36            colminmax.put(y,new int[]{min,max}) ;
37        }
38
39        int covered = 0;
40
41        for(int [] b : buildings) {
42            int x = b[0] ;
43            int y = b[1] ;
44
45            int r[] = rowminmax.get(x) ;//minmax y..........
46            int c[]  = colminmax.get(y) ;//minmax x..................
47            
48            boolean hasleft =y>r[0] ;
49            boolean hasright = y<r[1] ;
50            boolean hasdown = x>c[0] ;
51            boolean hasup = x<c[1] ;
52            if(hasup && hasdown && hasleft && hasright) {
53                covered++ ;
54            }
55        }
56        return covered ;
57    }
58}