class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums2NGE = getNGE(nums2);

        for(int i=0;i<nums2.length;i++) {
            map.put(nums2[i], nums2NGE[i]);
        }

        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    private int[] getNGE(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();
        for(int i = nums.length-1;i>=0;i--) {
            while(!st.isEmpty() && nums[i]>=st.peek()) {
                st.pop();
            }
            if(!st.isEmpty()) {
                res[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return res;
    }
}