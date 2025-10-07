class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length ;
        int[] ans = new int[n] ;

        HashMap<Integer,Integer> full = new HashMap<>() ;
        TreeSet <Integer> dryDays = new TreeSet<>() ;

        for(int i =0;i< n;i++) {
            if(rains[i] == 0) {
                dryDays.add(i) ;
                ans[i] = 1 ;
            }
            else{
                ans[i] = -1 ;
                int lake = rains[i] ;
                if(full.containsKey(lake)) {
                    Integer dryday = dryDays.higher(full.get(lake)) ;
                    if(dryday == null) {
                        return new int[0] ;
                    }
                    ans[dryday] = lake ;
                    dryDays.remove(dryday) ;
                }
                full.put(lake,i) ;
            }
        }

        return ans ;
    }
}