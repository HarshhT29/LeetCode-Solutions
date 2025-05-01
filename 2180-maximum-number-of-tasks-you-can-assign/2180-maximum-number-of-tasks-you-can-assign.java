class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        int result = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssignKtasks(mid, tasks, workers, pills, strength)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    
    private boolean canAssignKtasks(int k, int[] tasks, int[] workers, int pills, int strength) {
        if(k==0) {
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int workerIndex = workers.length - 1;
        for(int i=k-1;i>=0;i--) {
            while(workerIndex >= workers.length - k && workers[workerIndex] + strength >= tasks[i]) {
                deque.addFirst(workers[workerIndex]);
                workerIndex--;
            }
            
            if(deque.isEmpty()) {
                return false;
            }
            
            if(deque.getLast() >= tasks[i]) {
                deque.removeLast();
            } else {
                if(pills<=0) {
                    return false;
                }
                pills--;
                deque.removeFirst();
            }
        }
        return true;
    }
}