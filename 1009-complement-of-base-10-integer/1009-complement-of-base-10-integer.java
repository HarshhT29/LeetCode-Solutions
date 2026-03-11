class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) {
            return 1;
        }
        int val = Integer.highestOneBit(n);
        return n^((val<<1)-1);
    }
}
