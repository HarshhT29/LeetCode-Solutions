class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        for(int i=0;i<nums.length;i++) {
            pq.offer(new int[]{nums[i], i});
            if(pq.size()>k) {
                pq.poll();
            }
        }
        List<int[]> li = new ArrayList<>();
        while(!pq.isEmpty()) {
            li.add(pq.poll());
        }
        Collections.sort(li, (a, b) -> Integer.compare(a[1], b[1]));
        int[] ans = new int[k];
        int i=0;
        for(int[] l:li) {
            ans[i++] = l[0];
        }
        return ans;
    }
}