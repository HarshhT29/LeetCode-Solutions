class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;
        int min = Integer.MAX_VALUE;
        int i=0,j=0;

        while(j<blocks.length()) {
            if(blocks.charAt(j)=='W') {
                white++;
            }
            if(j-i+1==k) {
                min = Math.min(min, white);
                if(blocks.charAt(i)=='W') {
                    white--;
                }
                i++;
            }
            j++;
        }
        return min;
    }
}