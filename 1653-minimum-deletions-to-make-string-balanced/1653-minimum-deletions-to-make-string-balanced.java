class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;
        int i = 0;
        while(i<s.length()) {
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i)=='a') {
                st.pop();
                cnt++;
            } else {
                st.push(s.charAt(i));
            }
            i++;
        }  
        return cnt;
    }
}