class Solution {
    class Node {
        int digitSum;
        int value;

        Node(int digitSum, int value) {
            this.digitSum = digitSum;
            this.value = value;
        }
    }
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer>[] pq = new PriorityQueue[82];
        for(int num:nums) {
            int ds = calDigitSum(num);
            if(pq[ds]==null) {
                pq[ds] = new PriorityQueue<>();
            }
            pq[ds].add(num);
            if(pq[ds].size()>2) {
                pq[ds].poll();
            }
        }
        int max = -1;
        for(PriorityQueue<Integer> minHeap:pq) {
            if(minHeap!=null && minHeap.size()>1) {
                int f = minHeap.poll();
                int s = minHeap.poll();
                max = Math.max(max, f+s);
            }
        }
        return max;
    }
    private int calDigitSum(int n) {
        int sum = 0;
        while(n>0) {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}