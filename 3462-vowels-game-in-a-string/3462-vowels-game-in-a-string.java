class Solution {
    public boolean doesAliceWin(String s) {
        for(char ch:s.toCharArray()) {
            switch(ch) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' :
                    return true;
                default:
                    break;
            }
        }
        return false;
    }
}