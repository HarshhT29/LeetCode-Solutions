class Solution {
    public int maximumCount(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]>0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int x = low;
        low = 0;
        high = nums.length-1;

        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid]>=0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int y = low;
        // System.out.println(x);
        // System.out.println(y);
        return Math.max(nums.length-x, y);
    }
}