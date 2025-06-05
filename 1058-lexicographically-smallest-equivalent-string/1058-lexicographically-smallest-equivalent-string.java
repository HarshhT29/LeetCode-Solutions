class Solution {
    public char find(char x, char[] root) {
        if (root[x-'a'] != x) {
            root[x-'a'] = find (root[x-'a'], root);
        }

        return root[x-'a'];
    }

    public void unionSet(char x, char y, char[] root) {
        char r1 = find(x, root);
        char r2 = find(y, root);
        if (r1 != r2) {
            if (r1 < r2) {
                root[r2-'a'] = r1;
            } else {
                root[r1-'a'] = r2;
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] root = new char[26];
        for (char i = 0; i < 26; i++) {
            root[i] = (char)('a' + i);
        }

        for (int i = 0; i < s1.length(); i++) {
            unionSet(s1.charAt(i), s2.charAt(i), root);
        }

        StringBuilder res = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            res.append(find(c, root));
        }

        return res.toString();
    }
}