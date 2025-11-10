class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Map value -> list of indices
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Values to process in ascending order, ignore 0
        List<Integer> values = new ArrayList<>(pos.keySet());
        Collections.sort(values);

        // Walls initially: all indices where nums[i] == 0
        TreeSet<Integer> walls = new TreeSet<>();
        for (int i = 0; i < n; i++) if (nums[i] == 0) walls.add(i);

        int ops = 0;
        for (int v : values) {
            if (v == 0) continue;
            List<Integer> idx = pos.get(v);
            if (idx == null || idx.isEmpty()) continue;

            // idx is already in increasing index order
            int groups = 1;
            for (int k = 1; k < idx.size(); k++) {
                int left = idx.get(k - 1);
                int right = idx.get(k);
                // Is there any wall strictly between left and right?
                Integer w = walls.higher(left); // first wall > left
                if (w != null && w < right) {
                    groups++;
                }
            }
            ops += groups;

            // These positions become zeros -> new walls for larger values
            for (int p : idx) walls.add(p);
        }
        return ops;
    }
}