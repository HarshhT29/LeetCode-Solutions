class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(char ch:s.toCharArray()) {
            st.push(ch);
            freq[ch - 'a']--;
            while(!st.isEmpty() && st.peek() <= getSmallest(freq)) {
                res.append(st.pop());
            }
        }
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
    private char getSmallest(int[] freq) {
        for(int i=0;i<26;i++) {
            if(freq[i] > 0) {
                return (char) ('a'+i);
            }
        }
        return '0';
    }
}
