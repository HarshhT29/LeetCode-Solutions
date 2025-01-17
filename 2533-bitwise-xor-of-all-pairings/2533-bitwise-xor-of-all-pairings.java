class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = getXor(nums1);
        int xor2 = getXor(nums2);
        
        if(nums1.length%2==0 && nums2.length%2==0) {
            return 0;
        }
        if(nums1.length%2==0 && nums2.length%2!=0) {
            return xor1;
        }
        if(nums1.length%2!=0 && nums2.length%2==0) {
            return xor2;
        }
        return xor1^xor2;
    }
    private int getXor(int[] nums) {
        int xor=0;
        for(int x:nums) {
            xor^=x;
        }
        return xor;
    }
}