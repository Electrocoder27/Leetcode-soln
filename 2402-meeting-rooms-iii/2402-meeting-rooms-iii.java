class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // sort by start time

        // rooms available to use
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.add(i);

        // {endTime, room}
        PriorityQueue<long[]> busyRooms =
            new PriorityQueue<>((a, b) -> a[0] == b[0]
                    ? Long.compare(a[1], b[1])
                    : Long.compare(a[0], b[0]));

        int[] count = new int[n]; // usage count

        for (int[] meet : meetings) {
            long start = meet[0], end = meet[1];
            long duration = end - start;

            // free rooms whose meeting has ended before this start
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // get lowest room index
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.add(new long[]{end, room});
            } else {
                // no room free → extend the earliest finishing room
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                count[room]++;
                busyRooms.add(new long[]{newEnd, room});
            }
        }

        // find room with highest usage
        int bestRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[bestRoom]) bestRoom = i;
        }
        return bestRoom;
    }
}