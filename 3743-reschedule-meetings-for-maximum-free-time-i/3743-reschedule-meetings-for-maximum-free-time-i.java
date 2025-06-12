class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length+1];
        gaps[0] = startTime[0];
        for(int i=1;i<startTime.length;i++) {
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[gaps.length-1] = eventTime - endTime[endTime.length-1];

        int i=0, j=0;
        int currSpace = 0;
        int maxSpace = 0;

        while(j<gaps.length) {
            currSpace += gaps[j];
            while(j-i > k) {
                currSpace -= gaps[i++];
            }
            maxSpace = Math.max(maxSpace, currSpace);
            j++;
        }
        return maxSpace;
    }
}