1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        int max = 0;
4        for(int num:costs){
5            max = Math.max(max,num) ;
6        }
7        int [] freq = new int[max+1] ;
8
9        for(int cost:costs){
10            freq[cost]++ ;
11        }
12        int count = 0;
13        for(int p=1;p<=max;p++){
14            if(coins > (long)p*freq[p]){
15                coins -= p*freq[p] ;
16                count += freq[p] ;
17            }
18            else{
19                int canbuy = coins/p ;
20                count += canbuy ;
21                break ;
22            }
23        }
24        return count ;
25    }
26}