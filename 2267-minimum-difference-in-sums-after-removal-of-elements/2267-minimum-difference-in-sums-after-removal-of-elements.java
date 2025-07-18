class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int len = nums.length;
        long[] leftMinSum = new long[len];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long leftSum = 0;
        for(int i=0;i<len;i++) {
            maxHeap.add(nums[i]);
            leftSum += nums[i];
            if(maxHeap.size() > n) {
                leftSum -= maxHeap.poll();
            }
            if(maxHeap.size() == n) {
                leftMinSum[i] = leftSum;
            } else {
                leftMinSum[i] = Long.MAX_VALUE;
            }
        }
        long[] rightMaxSum = new long[len];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long rightSum = 0;
        for(int i=len-1;i>=0;i--) {
            minHeap.add(nums[i]);
            rightSum += nums[i];
            if(minHeap.size()>n) {
                rightSum -= minHeap.poll();
            }
            if(minHeap.size()==n) {
                rightMaxSum[i] = rightSum;
            } else {
                rightMaxSum[i] = Long.MIN_VALUE;
            }
        }
        long minDiff = Long.MAX_VALUE;
        for(int i=n-1;i<len-n;i++) {
            if(leftMinSum[i]!=Long.MAX_VALUE && rightMaxSum[i+1]!=Long.MIN_VALUE) {
                minDiff = Math.min(minDiff, leftMinSum[i]-rightMaxSum[i+1]);
            }
        }
        return minDiff;
    }
}
