class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-1;i>0;i--) {
            if(nums[i-1]<nums[i]) {
                index = i-1;
                break;
            }
        }
        if(index==-1) {
            reverse(nums, 0, nums.length-1);
            return ;
        }
        for(int i=nums.length-1;i>index;i--) {
            if(nums[i]>nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, index+1, nums.length-1);
    }
    private void reverse(int[] arr, int start, int end) {
        if(start==end) {
            return ;
        }
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}