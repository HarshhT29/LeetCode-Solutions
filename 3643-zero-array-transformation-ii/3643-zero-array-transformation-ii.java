class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length+1];
        int prefix = 0;
        int k = 0;

        for(int i=0;i<nums.length;i++) {
            while(nums[i]>prefix+diff[i]) {
                k++;
                if(k>queries.length) return -1;
                int start = queries[k-1][0];
                int end = queries[k-1][1];
                int val = queries[k-1][2];
                if(end>=i) {        
                    diff[Math.max(i, start)]+=val;
                    diff[end+1] -= val;
                }
            }
            prefix+=diff[i];
        }
        return k;
    }
}