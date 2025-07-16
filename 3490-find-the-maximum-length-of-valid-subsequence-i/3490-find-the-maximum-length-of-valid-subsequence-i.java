class Solution {
    public int maximumLength(int[] nums) {
        int even = 0, odd = 0, alternate = 0;
        int parity = -1;
        for(int num:nums) {
            if((num&1)==0) {
                even++;
                if(parity==1 || parity==-1) {
                    alternate++;
                }
            } else {
                odd++;
                if(parity==0 || parity==-1) {
                    alternate++;
                }
            }
            parity = (num&1);
        }
        return Math.max(alternate, Math.max(even, odd));
    }
}