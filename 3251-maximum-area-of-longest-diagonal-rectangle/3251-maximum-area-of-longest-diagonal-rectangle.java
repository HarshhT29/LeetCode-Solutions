class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagonal = 0;
        for(int[] dimension:dimensions) {
            int a = dimension[0]*dimension[1];
            int d = dimension[0]*dimension[0]+dimension[1]*dimension[1];
            if(d>maxDiagonal) {
                maxDiagonal = d;
                maxArea = a;
            } else if(maxDiagonal == d) {
                maxArea = Math.max(maxArea, a);
            }
        }
        return maxArea;
    }
}