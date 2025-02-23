class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        for(int i=2*n-1;i>=0;i--) {
            while(!st.isEmpty() && nums[i%n]>=st.peek()) {
                st.pop();
            }
            if(!st.isEmpty()) {
                res[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}