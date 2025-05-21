class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int num:nums) {
            if(k>pq.size()) {
                pq.offer(num);
            } else if(num>pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
}