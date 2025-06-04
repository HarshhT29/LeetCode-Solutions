class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int prod = 1;
        for(int i=0;i<nums.length;i++) {
            answer[i] = prod;
            prod*=nums[i];
        }
        prod = 1;
        for(int i=nums.length-1;i>=0;i--) {
            answer[i]*=prod;
            prod*=nums[i];
        }
        return answer;
    }
}