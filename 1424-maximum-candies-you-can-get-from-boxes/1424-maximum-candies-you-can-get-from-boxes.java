//Editorial ka solution hai ye

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        boolean[] canOpen = new boolean[status.length];
        boolean[] hasBox = new boolean[status.length];
        boolean[] used = new boolean[status.length];

        for(int i=0;i<status.length;i++) {
            canOpen[i] = (status[i]==1);
        }
        Queue<Integer> q = new LinkedList<>();
        int maxCandies = 0;
        for(int box:initialBoxes) {
            hasBox[box] = true;
            if(canOpen[box]) {
                q.offer(box);
                used[box] = true;
                maxCandies += candies[box];
            }
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int key:keys[curr]) {
                canOpen[key] = true;
                if(!used[key] && hasBox[key]) {
                    q.offer(key);
                    used[key] = true;
                    maxCandies += candies[key];
                }
            }
            for(int box:containedBoxes[curr]) {
                hasBox[box] = true;
                if(!used[box] && canOpen[box]) {
                    q.offer(box);
                    used[box] = true;
                    maxCandies += candies[box];
                }
            }
        }
        return maxCandies;
    }
}