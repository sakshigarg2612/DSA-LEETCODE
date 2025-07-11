class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
    if (a[0] != b[0]) return Long.compare(a[0], b[0]);
    return Integer.compare((int) a[1], (int) b[1]);
});

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Free up rooms that are done before current meeting
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                availableRooms.offer((int) pq.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                int room = availableRooms.poll();
                pq.offer(new long[]{end, room});
                count[room]++;
            } else {
                long[] ended = pq.poll();
                long newEnd = ended[0] + (end - start);
                int room = (int) ended[1];
                pq.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        // Find room with max meetings
        int max = 0, result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                result = i;
            }
        }

        return result;
    }
}
