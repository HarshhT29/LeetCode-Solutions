class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int num:nums) {
            ans += Math.min((3-(num%3)),(num%3));
        }
        return ans;
    }
}