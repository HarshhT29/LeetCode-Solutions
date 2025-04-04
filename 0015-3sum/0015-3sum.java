class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length-1;
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l<r && nums[l]==nums[l+1]) {
                        l++;
                    }
                    while(l<r && nums[r]==nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if(sum<target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return res;
    }
}