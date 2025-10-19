class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String smallest = s;
        int n = s.length();
        Set<String> seen = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        seen.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: Add 'a' to all odd indices
            char[] arr = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
            }
            String added = new String(arr);

            // Operation 2: Rotate to the right by 'b'
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);

            // Add new states if unseen
            if (seen.add(added)) queue.offer(added);
            if (seen.add(rotated)) queue.offer(rotated);
        }

        return smallest;
    }
}