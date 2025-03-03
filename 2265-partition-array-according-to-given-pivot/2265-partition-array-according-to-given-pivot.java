class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int small = 0, big = 0, equal=0;
        for(int num:nums) {
            if(num>pivot) {
                big++;
            } else if(num<pivot) {
                small++;
            } else {
                equal++;
            }
        }

        int[] res = new int[nums.length];
        int i=0, j = small, k = j+equal;
        for(int num:nums) {
            if(num<pivot) {
                res[i++] = num;
            } else if(num>pivot) {
                res[k++] = num;
            } else {
                res[j++] = num;
            }
        }
        return res;
    }
}