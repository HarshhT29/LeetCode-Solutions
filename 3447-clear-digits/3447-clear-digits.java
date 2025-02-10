class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(ch>='a' && ch<='z')
                st.push(ch);
            if(!st.isEmpty() && !(ch>='a' && ch<='z'))
                st.pop();
        }
        StringBuilder str = new StringBuilder();
        for(char ch:st)
            str.append(ch);
        return str.toString();
    }
}