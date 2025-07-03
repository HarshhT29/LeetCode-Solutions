class Solution {
    private Map<Character, Character> map;
    public char kthCharacter(int k) {
        map = new HashMap<>();
        for(int i=0;i<26;i++) {
            char key = (char)(i+'a');
            char value = i!=25?((char)('a'+i+1)):'a';
            map.put(key, value);
        }
        return generate("a", k);
    }
    private char generate(String s, int k) {
        if(s.length()>=k) {
            return s.charAt(k-1);
        }
        StringBuilder ans = new StringBuilder(s);
        for(char ch:s.toCharArray()) {
            ans.append(map.get(ch));
            if(ans.length()>=k) {
                return ans.charAt(k-1);
            }
        }
        return generate(ans.toString(), k);
    }
}