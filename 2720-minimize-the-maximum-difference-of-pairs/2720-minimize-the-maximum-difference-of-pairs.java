class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1];
        int ans = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(check(nums, mid, p)) {
                ans = mid;
                high = mid-1; 
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] nums, int k, int p) {
        int cnt = 0, i=1;
        while(i<nums.length) {
            if(nums[i]-nums[i-1] > k) {
                i++;
            } else {
                cnt++;
                i+=2;
            }
        }
        return cnt >= p;
    }
}