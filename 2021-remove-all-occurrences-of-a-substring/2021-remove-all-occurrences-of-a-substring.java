class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder();
        int p = part.length();

        for(char ch:s.toCharArray()) {
            str.append(ch);
            int n = str.length()-p;
            if(str.length()>=p && str.substring(n).equals(part)) {
                str.setLength(n);
            }
        }
        return str.toString();
    }
}