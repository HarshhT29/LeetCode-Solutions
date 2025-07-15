class Solution {
    public boolean isValid(String word) {
        boolean consonant = false;
        boolean vowel = false;
        int cnt = 0;

        for(char ch : word.toCharArray()) {
            if(!Character.isLetterOrDigit(ch)) {
                return false;
            }
            if(!vowel && isVowel(ch)) {
                vowel = true;
            }
            if(!consonant && Character.isLetter(ch) && !isVowel(ch)) {
                consonant = true;
            }
            cnt++;
        }
        return cnt >= 3 && vowel && consonant;
    }

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
