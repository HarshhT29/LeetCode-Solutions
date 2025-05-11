class Solution {
    public int mySqrt(int x) {
        long low = 0L;
        long high = x;
        while(low<=high) {
            long mid = low + (high-low)/2;
            if(mid*mid<=x) {
                if(mid*mid==x) {
                    return (int) mid;
                }
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return x>1?(int)low-1:x;
    }
}