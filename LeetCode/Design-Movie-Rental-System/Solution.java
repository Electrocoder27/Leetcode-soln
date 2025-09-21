import java.util.*;

class MovieRentingSystem {
    // (shop,movie) -> price
    private Map<String, Integer> price;
    // movie -> TreeSet of [price, shop]
    private Map<Integer, TreeSet<int[]>> available;
    // rented movies TreeSet of [price, shop, movie]
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        price = new HashMap<>();
        available = new HashMap<>();
        
        // comparator for rented: price asc, shop asc, movie asc
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], p = e[2];
            price.put(key(shop, movie), p);

            available.computeIfAbsent(movie, k -> 
                new TreeSet<>((x, y) -> {
                    if (x[0] != y[0]) return x[0] - y[0]; // price asc
                    return x[1] - y[1]; // shop asc
                })
            ).add(new int[]{p, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        int count = 0;
        for (int[] entry : available.get(movie)) {
            res.add(entry[1]);
            count++;
            if (count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int p = price.get(key(shop, movie));
        // remove from available
        TreeSet<int[]> ts = available.get(movie);
        ts.remove(new int[]{p, shop}); // must remove exact object by comparator
        // Add to rented
        rented.add(new int[]{p, shop, movie});
    }

    public void drop(int shop, int movie) {
        int p = price.get(key(shop, movie));
        // remove from rented
        rented.remove(new int[]{p, shop, movie});
        // add back to available
        available.get(movie).add(new int[]{p, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            res.add(Arrays.asList(entry[1], entry[2])); // shop, movie
            count++;
            if (count == 5) break;
        }
        return res;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}


/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */