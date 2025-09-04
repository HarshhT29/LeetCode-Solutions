class Solution {
    public int findClosest(int x, int y, int z) {
        if(Math.abs(z-y)==Math.abs(z-x)) {
            return 0;
        }
        return Math.abs(z-y)>Math.abs(z-x)?1:2;
    }
}