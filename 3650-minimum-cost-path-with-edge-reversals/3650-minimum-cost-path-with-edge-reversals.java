class Solution {
    static class Pair {
        int node ;
        int dist ;

        Pair(int d,int n){
            this.dist = d ;
            this.node = n ;
        }
    }
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,ArrayList<Pair>> adj = new HashMap<>() ;

        for(int [] edge : edges) {
            int u = edge[0] ;
            int v = edge[1] ;
            int wt = edge[2] ;


            adj .computeIfAbsent(u,k -> new ArrayList<>()).add(new Pair(wt,v)) ;

            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(new Pair(2*wt,u)) ;
        }


         PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist) ;

        int [] dist = new int[n] ;

        Arrays.fill(dist,Integer.MAX_VALUE) ;

        dist[0]= 0 ;

        pq.offer(new Pair(0,0)) ;


        while(!pq.isEmpty()) {
            Pair curr = pq.poll() ;
            int d = curr.dist ;
            int node = curr.node ;



            if(d> dist[node]) {
                continue ;
            }

            if(node == n-1){
                return dist[n-1] ;
            }


            if(!adj.containsKey(node)){
                continue ;
            }


            for(Pair p : adj.get(node)){
                int nn = p.node ;
                int wt = p.dist ;

                if(d+wt <dist[nn]){
                    dist[nn] = d + wt ;
                    pq.offer(new Pair(dist[nn],nn)) ;
                }
            }
        }
        return -1 ;       
    }
}