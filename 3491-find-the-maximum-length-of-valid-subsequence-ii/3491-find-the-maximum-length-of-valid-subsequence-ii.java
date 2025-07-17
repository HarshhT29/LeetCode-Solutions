class Solution {
    public int maximumLength(int[] nums, int k) {
        int maxLen = 1;
        int[][] dp = new int[nums.length][k];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], 1);
            for(int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                maxLen = Math.max(maxLen, dp[i][mod]);
            }
        }
        return maxLen;
    }
}