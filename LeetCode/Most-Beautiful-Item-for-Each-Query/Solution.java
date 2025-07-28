class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items by price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Step 2: Preprocess - store increasing prices and corresponding max beauties
        List<Integer> prices = new ArrayList<>();
        List<Integer> beauties = new ArrayList<>();
        int maxBeauty = 0;

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];

            if (prices.isEmpty() || price != prices.get(prices.size() - 1)) {
                maxBeauty = Math.max(maxBeauty, beauty);
                prices.add(price);
                beauties.add(maxBeauty);
            } else {
                // if price is same as previous, update the max beauty
                maxBeauty = Math.max(maxBeauty, beauty);
                beauties.set(beauties.size() - 1, maxBeauty);
            }
        }

        // Step 3: Answer each query using binary search
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int idx = upperBound(prices, q);
            res[i] = idx >= 0 ? beauties.get(idx) : 0;
        }

        return res;
    }

    // Binary search: find rightmost index where price <= query
    private int upperBound(List<Integer> prices, int query) {
        int left = 0, right = prices.size() - 1;
        int res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (prices.get(mid) <= query) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
