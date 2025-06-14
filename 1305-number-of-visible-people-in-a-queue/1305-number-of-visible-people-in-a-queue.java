class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[heights.length];

        for(int i=heights.length-1;i>=0;i--) {
            int cnt = 0;
            while(!st.isEmpty() && st.peek() < heights[i]) {
                st.pop();
                cnt++;
            }
            if(!st.isEmpty()) {
                cnt++;
            }
            res[i] = cnt;
            st.push(heights[i]);
        }
        return res;
    }
}
