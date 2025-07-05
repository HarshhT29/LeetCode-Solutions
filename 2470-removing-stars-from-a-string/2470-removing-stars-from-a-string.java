class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(!st.isEmpty() && ch=='*') {
                st.pop();
            }
            if(ch!='*') {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}