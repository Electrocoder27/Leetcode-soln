class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> r1 = new ArrayList<>(); 
        ArrayList<Integer> r2 = new ArrayList<>() ;
        int sum = 0;
        for(int num:nums){
            sum += num ;

            if(num%3 ==1){
                r1.add(num) ;
            }
            if(num%3 == 2){
                r2.add(num) ;
            }
        }

        Collections.sort(r1) ;
        Collections.sort(r2) ;

        if(sum%3 == 1){
            int remove = Integer.MAX_VALUE ;
            if(r1.size() >=1) {
                remove = r1.get(0) ;
            }
            if(r2.size()>=2){
                remove = Math.min(remove,r2.get(0)+r2.get(1)) ;
            }
                sum-= remove ;
        }
        if(sum%3 == 2){
            int remove = Integer.MAX_VALUE ;
            if(r2.size() >=1){
                remove = r2.get(0) ;
            }
            if(r1.size() >=2) {
                remove = Math.min(remove,r1.get(1)+r1.get(0)) ;
            }
        
            sum -= remove ;
        }
        return sum ;
    }
}