class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int num:map.keySet()) {
            if(k>pq.size()) {
                pq.offer(new int[]{num, map.get(num)});
            } else if(pq.peek()[1] < map.get(num)) {
                pq.poll();
                pq.offer(new int[]{num, map.get(num)});
            }
        }
        int[] topK = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()) {
            topK[i++] = pq.poll()[0];
        }
        return topK;
    }
}