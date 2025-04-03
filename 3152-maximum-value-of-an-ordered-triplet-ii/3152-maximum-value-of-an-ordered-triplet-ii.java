    class Solution {
        public long maximumTripletValue(int[] nums) {
            int[] preMax = new int[nums.length];
            int[] suffMax = new int[nums.length];

            long max = 0L;
            for(int i=1;i<nums.length;i++) {
                preMax[i] = Math.max(preMax[i-1], nums[i-1]);
                suffMax[nums.length-i-1] = Math.max(suffMax[nums.length-i], nums[nums.length-i]);
                max = Math.max(max, 1L*(preMax[i]-nums[i])*suffMax[i]);
            }
            for(int i=1;i<nums.length-1;i++) {
                max = Math.max(max, 1L*(preMax[i]-nums[i])*suffMax[i]);
            }
            return max;
        }
    }