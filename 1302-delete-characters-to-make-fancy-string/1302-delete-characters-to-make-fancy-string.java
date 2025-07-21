class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder(s);
        for(int i=1;i<str.length()-1;i++) {
            if(str.charAt(i)==str.charAt(i-1) && str.charAt(i)==str.charAt(i+1)) {
                str.deleteCharAt(i--);
            }
        }
        return str.toString();
    }
}