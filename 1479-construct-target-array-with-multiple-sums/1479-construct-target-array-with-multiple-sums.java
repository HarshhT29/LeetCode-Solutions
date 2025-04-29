class Solution {
    public boolean isPossible(int[] target) {
        if(target.length==1 && target[0]==1) {
            return true;
        }
        if(target.length==1 && target[0]!=1) {
            return false;
        }

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0L;
        for(int x:target) {
            maxHeap.offer(1L*x);
            sum+=x;
        }
    
        while(!maxHeap.isEmpty()) {
            long curr = maxHeap.poll();
            long diff = (sum - curr);
            if(curr==1 || diff==1) {
                return true;
            }

            long val = curr % diff;
            if(val==0 || val==curr) {
                return false;
            }
    
            maxHeap.offer(val);
            sum = (val + diff);
        }
        return true;
    }
}