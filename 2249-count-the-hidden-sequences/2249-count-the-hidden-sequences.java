class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, min = 0, max = 0;
        for(int diff:differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        long lowBound = lower - min;
        long highBound = upper - max;
        return (int)Math.max(0, highBound - lowBound + 1);
    }
}
