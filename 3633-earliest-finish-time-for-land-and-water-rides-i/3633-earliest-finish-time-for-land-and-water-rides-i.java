class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minfinishtime = Integer.MAX_VALUE ;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){

                int landfinish = landStartTime[i] + landDuration[i] ;
                int totalfinish1 = Math.max(landfinish,waterStartTime[j]) + waterDuration[j] ;

                int waterfinish = waterStartTime[j] + waterDuration[j] ;
                int totalfinish2  = Math.max(waterfinish,landStartTime[i]) + landDuration[i] ;

                minfinishtime = Math.min(minfinishtime,Math.min(totalfinish1,totalfinish2)) ;
            }
        }

        return minfinishtime ;
    }
}