class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int max = 0;
        for(int i=0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum+=((j-i+1)*satisfaction[j]);
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}