class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) {
            return 0;
        }
        int diff = prices[1]-prices[0];
        int minSoFar = prices[0];
        for(int i=1;i<prices.length;i++) {
            diff = Math.max(diff, prices[i]-minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return diff>0?diff:0;
    }
}