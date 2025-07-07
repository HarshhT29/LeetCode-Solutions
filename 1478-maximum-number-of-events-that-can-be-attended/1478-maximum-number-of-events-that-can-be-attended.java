class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int maxDay = -1;
        for(int[] event:events) {
            maxDay = Math.max(maxDay, event[1]);
        }
        int res = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        int j = 0;
        for(int i=1;i<=maxDay;i++) {
            while(j<events.length && events[j][0] <= i) {
                pq.offer(events[j][1]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            if(!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}