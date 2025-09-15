class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for(char ch:brokenLetters.toCharArray()) {
            set.add(ch);
        }
        int cnt = 0;
        for(String t:text.split(" ")) {
            boolean flag = true;
            for(char ch:t.toCharArray()) {
                if(set.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                cnt++;
            }
        }
        return cnt;
    }
}