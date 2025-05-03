class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=6;i++) {
            res = Math.min(res, check(tops, bottoms, i));
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
    private int check(int[] tops, int[] bottoms, int target) {
        int top = 0;
        int bottom = 0;
        for(int i=0;i<tops.length;i++) {
            if(tops[i]!=target && bottoms[i]!=target) {
                return Integer.MAX_VALUE;
            }
            if(tops[i]==target && bottoms[i]==target) {
                continue;
            }
            if(tops[i]==target) {
                top++;
            }
            if(bottoms[i]==target) {
                bottom++;
            }
        }
        return Math.min(top, bottom);
    }
}