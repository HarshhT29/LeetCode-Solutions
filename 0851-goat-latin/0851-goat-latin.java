class Solution {
    public String toGoatLatin(String sentence) {
        String[] sen = sentence.split(" ");
        StringBuilder str = new StringBuilder();
        String extra = "a";
        for(String s:sen) {
            if(isVowel(s.charAt(0))) {
                str.append(s);
            } else{
                int n = s.length();
                str.append(s.substring(1, n));
                str.append(s.charAt(0));
            }
            str.append("ma");
            str.append(extra);
            str.append(" ");
            extra+="a";
        }
        return str.toString().trim();
    }
    private boolean isVowel(char ch) {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
            return true;
        }
        if(ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') {
            return true;
        }
        return false;
    }
}