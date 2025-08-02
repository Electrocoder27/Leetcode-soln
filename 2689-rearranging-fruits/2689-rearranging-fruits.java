import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int minElement = Integer.MAX_VALUE;

        for (int num : basket1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            minElement = Math.min(minElement, num);
        }
        for (int num : basket2) {
            freq.put(num, freq.getOrDefault(num, 0) - 1);
            minElement = Math.min(minElement, num);
        }

        ArrayList<Integer> excess = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count % 2 != 0) return -1;

            for (int i = 0; i < Math.abs(count) / 2; i++) {
                excess.add(val); // drop if (count > 0) condition
            }
        }

        Collections.sort(excess);

        long cost = 0;
        int n = excess.size();
        for (int i = 0; i < n / 2; i++) {
            cost += Math.min(excess.get(i), 2L * minElement);
        }

        return cost;
    }
}
