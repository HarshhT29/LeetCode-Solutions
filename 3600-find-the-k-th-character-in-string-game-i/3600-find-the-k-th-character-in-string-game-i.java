class Solution {
    private char[] map = {
        'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z', 'a'
    };
    public char kthCharacter(int k) {
        return generate("a", k);
    }
    private char generate(String s, int k) {
        if(s.length()>=k) {
            return s.charAt(k-1);
        }
        StringBuilder ans = new StringBuilder(s);
        for(char ch:s.toCharArray()) {
            ans.append(map[ch-'a']);
            if(ans.length()>=k) {
                return ans.charAt(k-1);
            }
        }
        return generate(ans.toString(), k);
    }
}