class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> li = new ArrayList<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length) {
            if(nums1[i][0]==nums2[j][0]) {
                li.add(new int[] { nums1[i][0], nums1[i++][1]+nums2[j++][1] });
            } else if(nums1[i][0]>nums2[j][0]) {
                li.add(nums2[j++]);
            } else {
                li.add(nums1[i++]);
            }
        }

        while(i<nums1.length) {
            li.add(nums1[i++]);
        }
        while(j<nums2.length) {
            li.add(nums2[j++]);
        }

        i=0;
        int[][] res = new int[li.size()][2];
        for(int[] nums:li) {
            res[i++] =  nums;
        }
        
        return res;
    }
}