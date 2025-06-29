class Solution {
    private final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for(int i=1;i<pow2.length;i++) {
            pow2[i] = (pow2[i-1]*2)%MOD;
        }
        int cnt = 0;
        for (int i = 0;i<nums.length;i++) {
            int low = i, high = nums.length-1, valid = -1;
            while (low <= high) {
                int mid = low + (high-low)/2;
                if (nums[i]+nums[mid] <= target) {
                    valid = mid;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            if(valid != -1 && valid >= i) {
                cnt = (cnt + pow2[valid-i]) % MOD;
            }
        }
        return cnt;
    }
}
