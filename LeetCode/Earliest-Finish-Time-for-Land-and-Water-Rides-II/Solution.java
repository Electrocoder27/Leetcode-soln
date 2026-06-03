1class Solution {
2    private int finishtime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
3        int finish1 = Integer.MAX_VALUE;
4        for(int i =0;i<landStartTime.length;i++){
5            finish1 = Math.min(finish1,landStartTime[i]+landDuration[i]) ;
6        }
7
8        int finish2 = Integer.MAX_VALUE;
9        for(int i =0;i<waterStartTime.length;i++){
10            finish2 = Math.min(finish2,Math.max(finish1,waterStartTime[i])+waterDuration[i]) ;
11        }
12
13        return finish2 ;
14    }
15    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
16        int res1 = finishtime(landStartTime,landDuration,waterStartTime,waterDuration) ;
17        int res2 = finishtime(waterStartTime,waterDuration,landStartTime,landDuration) ;
18
19        return Math.min(res1,res2) ;
20    }
21}