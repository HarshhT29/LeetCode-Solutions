class Solution {
    public int search(int[] nums, int target) {
        int index = -1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]>nums[i]) {
                index = i;
                break;
            }
        }
        if(index==-1) {
            index = 0;
        }
        int ans = bs(nums, 0, index-1, target);
        return ans==-1?bs(nums, index, nums.length-1, target):ans;
    }
    private int bs(int[] nums, int start, int end, int key) {
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(nums[mid]==key) {
                return mid;
            } else if(nums[mid]>key) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}