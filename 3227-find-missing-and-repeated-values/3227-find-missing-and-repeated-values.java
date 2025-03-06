class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length*grid.length;
        boolean[] bool = new boolean[n];
        int sum = 0; 
        int duplicate = 0;
        for(int[] i:grid) {
            for(int j:i) {
                if(!bool[j-1]) {
                    sum+=j;
                    bool[j-1] = true;
                } else {
                    duplicate = j;
                }
            }
        }
        int missing = ((n*(n+1))/2)-sum;

        return new int[]{ duplicate, missing };
    }
}