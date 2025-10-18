class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n  = nums.length ;
        int [][] intervals = new int[n][2] ;

        for(int i =0;i<n;i++){
            intervals[i][0] = nums[i] -k ;
            intervals[i][1] = nums[i] +k ;
        }

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1])) ;

        int count =0;
        int lastused = Integer.MIN_VALUE ;

        for(int range[] : intervals ){
            int start = range[0] ;
            int end = range[1] ;


            int assign = Math.max(start,lastused+1) ;

            if(assign <= end) {
                count++ ;
                lastused = assign ;
            }
        }

        return count ;
    }
}