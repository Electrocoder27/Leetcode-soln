import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // count frequencies
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // max heap (most frequent task first)
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxheap.add(f);
            }
        }

        int time = 0;

        while (!maxheap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // number of slots in this round

            // fill cycle with tasks
            while (cycle > 0 && !maxheap.isEmpty()) {
                int curr = maxheap.poll();
                if (curr > 1) {
                    temp.add(curr - 1); // re-add with decremented freq
                }
                time++;
                cycle--;
            }

            // push remaining tasks back
            for (int t : temp) {
                maxheap.add(t);
            }

            // if heap is not empty → means CPU idle time needed
            if (!maxheap.isEmpty()) {
                time += cycle; 
            }
        }

        return time;
    }
}
