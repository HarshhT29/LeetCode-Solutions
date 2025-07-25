class Solution {
    public int maxSum(int[] nums) {
        int sum = Integer.MIN_VALUE;
        Set<Integer> unique = new HashSet<>();
        for(int num:nums) {
            unique.add(num>0?num:0);
            sum = Math.max(sum, num);
        }
        if(sum<=0) {
            return sum;
        }
        sum = 0;
        for(int num:unique) {
            sum+=num;
        }
        return sum;
    }
}