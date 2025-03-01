class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for(int num:nums1) {
            set.add(num);
        }
        for(int num:nums2) {
            if(set.contains(num)) {
                return num;
            }
        }
        return Math.min(nums1[0]*10 + nums2[0], nums2[0]*10 + nums1[0]);
    }
}