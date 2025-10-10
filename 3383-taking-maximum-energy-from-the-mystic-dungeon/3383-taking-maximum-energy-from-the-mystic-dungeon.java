class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        for(int i=energy.length-k;i < energy.length;i++) {
            int sum = 0;
            for(int j=i;j>=0;j-=k) {
                sum += energy[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}