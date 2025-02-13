class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int num:nums) {
            minHeap.offer(num*1L);
        }
        int cnt = 0;
        while(!minHeap.isEmpty() && minHeap.peek()<k) {
            long x = minHeap.poll();
            if(minHeap.isEmpty()) {
                break;
            }
            long y = minHeap.poll();
            long val = Math.min(x, y)*2 + Math.max(x, y);
            minHeap.offer(val);
            cnt++;
        }
        return cnt;
    }
}