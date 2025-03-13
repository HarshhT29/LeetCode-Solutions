class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length+1];
        diff[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            diff[i] = nums[i]-nums[i-1];
        }
        // printArr(diff);
        for(int[] query:queries) {
            diff[query[0]]-=1;
            diff[query[1]+1]+=1;
        }
        // printArr(diff);
        nums[0] = diff[0];
        for(int i=1;i<nums.length;i++) {
            nums[i] = diff[i]+nums[i-1];
            if(nums[i]>0) {
                return false;
            }
        }
        // printArr(nums);
        return nums[0]<=0;
    }
    private void printArr(int[] nums) {
        for(int num:nums) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
}