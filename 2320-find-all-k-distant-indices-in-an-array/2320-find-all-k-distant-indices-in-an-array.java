class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums.length;j++) {
                if(nums[j]!=key || Math.abs(j-i) > k) {
                    continue;
                }
                res.add(i);
                break;
            }
        }
        return res;
    }
}