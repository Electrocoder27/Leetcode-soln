class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> ls = new ArrayList<>() ;
        ArrayList<Integer> lg = new ArrayList<>() ;
        ArrayList<Integer> le = new ArrayList<>() ;
        int n = nums.length ;
        for(int i =0;i<n;i++){
            if(nums[i]<pivot){
                ls.add(nums[i]) ;
            }
            else if(nums[i]>pivot) {
                lg.add(nums[i]) ;
            }
            else{
                le.add(nums[i]) ;
            }
        }

        int [] res = new int[n] ;
        int i =0;
        int j =0;
        int k = 0;
        while(i<ls.size()){
            res[i] = ls.get(i) ;
            i++ ;
        }
        while(j<le.size()){
            res[i++] = le.get(j) ;
            j++ ;
        }
        while(k<lg.size()){
            res[i++] = lg.get(k) ;
            k++ ;
        }

        return res ;
    }
}