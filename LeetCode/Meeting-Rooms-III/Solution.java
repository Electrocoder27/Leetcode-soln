1class Solution {
2    public int mostBooked(int n, int[][] meetings) {
3        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // sort by start time
4
5        // rooms available to use
6        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
7        for (int i = 0; i < n; i++) freeRooms.add(i);
8
9        // {endTime, room}
10        PriorityQueue<long[]> busyRooms =
11            new PriorityQueue<>((a, b) -> a[0] == b[0]
12                    ? Long.compare(a[1], b[1])
13                    : Long.compare(a[0], b[0]));
14
15        int[] count = new int[n]; // usage count
16
17        for (int[] meet : meetings) {
18            long start = meet[0], end = meet[1];
19            long duration = end - start;
20
21            // free rooms whose meeting has ended before this start
22            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
23                freeRooms.add((int) busyRooms.poll()[1]);
24            }
25
26            if (!freeRooms.isEmpty()) {
27                // get lowest room index
28                int room = freeRooms.poll();
29                count[room]++;
30                busyRooms.add(new long[]{end, room});
31            } else {
32                // no room free → extend the earliest finishing room
33                long[] earliest = busyRooms.poll();
34                long newEnd = earliest[0] + duration;
35                int room = (int) earliest[1];
36                count[room]++;
37                busyRooms.add(new long[]{newEnd, room});
38            }
39        }
40
41        // find room with highest usage
42        int bestRoom = 0;
43        for (int i = 1; i < n; i++) {
44            if (count[i] > count[bestRoom]) bestRoom = i;
45        }
46        return bestRoom;
47    }
48}