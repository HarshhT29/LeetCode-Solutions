class Solution {
    private Integer[][] memo;
    private int[] nums;

    public int maxSumDivThree(int[] nums) {
        this.nums = nums;
        memo = new Integer[nums.length][3];
        return Math.max(0, dfs(0, 0));
    }

    private int dfs(int index, int rem) {
        if (index == nums.length) {
            return rem == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][rem] != null)
            return memo[index][rem];

        int num = nums[index];

        int take = dfs(index + 1, (rem + num % 3) % 3);
        if (take != Integer.MIN_VALUE)
            take += num;

        int skip = dfs(index + 1, rem);
        return memo[index][rem] = Math.max(take, skip);
    }
}
