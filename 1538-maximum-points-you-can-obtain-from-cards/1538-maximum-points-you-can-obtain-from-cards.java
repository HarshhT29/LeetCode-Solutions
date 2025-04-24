class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum+=cardPoints[i];
        }
        int maxScore = sum;
        int i=k-1, j=cardPoints.length-1;
        while(i>=0) {
            sum = sum - cardPoints[i--] + cardPoints[j--];
            maxScore = Math.max(maxScore, sum);
        }
        return maxScore;
    }
}