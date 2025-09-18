class TaskManager {

    // taskId -> [userId, priority]
    private Map<Integer, int[]> taskMap;
    // Max heap by priority then by taskId
    private PriorityQueue<int[]> pq;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        // PriorityQueue: higher priority first; tie-break by higher taskId
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return Integer.compare(b[0], a[0]); // priority desc
            return Integer.compare(b[1], a[1]); // taskId desc
        });

        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int priority = t.get(2);
            taskMap.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        int[] info = taskMap.get(taskId);
        info[1] = newPriority; // update priority in map
        taskMap.put(taskId, info);
        pq.offer(new int[]{newPriority, taskId}); // add updated priority to heap
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId); // mark removed
        // old entry stays in pq but will be skipped in execTop
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int priority = top[0];
            int taskId = top[1];
            if (!taskMap.containsKey(taskId)) {
                pq.poll(); // removed
                continue;
            }
            int[] info = taskMap.get(taskId);
            int currentPriority = info[1];
            if (currentPriority != priority) {
                pq.poll(); // outdated entry
                continue;
            }
            // valid
            pq.poll();
            taskMap.remove(taskId);
            return info[0]; // return userId
        }
        return -1; // no tasks
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */