class Solution {
    public long coloredCells(long n) {
        long t1 = n*n;
        long t2 = (n-1)*(n-1);

        return t1+t2;
    }
}