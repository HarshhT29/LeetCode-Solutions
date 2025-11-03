class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        int idx = 0;
        for(int i=1;i<neededTime.length;i++) {
            if(colors.charAt(i)==colors.charAt(idx)) {
                if(neededTime[i]>neededTime[idx]) {
                    minTime += neededTime[idx];
                    idx = i;
                } else {
                    minTime += neededTime[i];
                }
            } else {
                idx = i;
            }
        }
        return minTime;
    }
}