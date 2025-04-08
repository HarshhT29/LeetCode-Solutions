class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] found = new boolean[101];
        for(int i=nums.length-1;i>=0;i--) {
            if(found[nums[i]]) {
                return (i/3)+1;
            }
            found[nums[i]] = true;
        }
        return 0;
    }
}