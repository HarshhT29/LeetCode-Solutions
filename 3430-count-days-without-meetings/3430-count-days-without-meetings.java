class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]));

        int vacant = 0;
        int end = 0;

        for(int i=0;i<meetings.length;i++) {
            if(meetings[i][0] > end+1) {
                vacant+=meetings[i][0]-end-1;
            }
            end = Math.max(end, meetings[i][1]);
        }
        if(days-end>0) {
            vacant+=days-end;
        }
        return vacant;
    }
}