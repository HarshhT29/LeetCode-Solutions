class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int index = 0;

        for(int i=1;i<=n;i++) {
            if(target[index]==i) {
                while(!st.isEmpty() && st.peek()!=target[index]) {
                    st.pop();
                    list.add("Pop");
                }
                list.add("Push");
                index++;
            } else if(target[index]>i) {
                st.push(i);
                list.add("Push");
            } else {
                st.pop();
                list.add("Pop");
            }
            if(index>=target.length) {
                return list;
            }
        }
        return list;
    }
}