class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }
    private long helper(int[][] questions, int i, long[] dp) {
        if(i>=questions.length) {
            return 0L;
        }
        if(dp[i]!=-1) {
            return dp[i];
        }
        long c1 = questions[i][0] + helper(questions, i+questions[i][1]+1, dp);
        long c2 = helper(questions, i+1, dp);

        // System.out.println("c1: "+c1+" "+"c2: "+c2+" "+"i:"+i);

        return dp[i]=Math.max(c1, c2);
    }
}