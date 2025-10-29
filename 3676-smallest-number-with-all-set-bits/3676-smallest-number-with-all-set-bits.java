class Solution {
    public int smallestNumber(int n) {
        int res = 1;
        while(res-1<n) {
            res<<=1;
        }
        return res-1;
    }
}